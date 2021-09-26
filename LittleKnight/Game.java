package srcGame.beginGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import srcGame.beginGame.states.GameOverState;
import srcGame.beginGame.states.GameState;
import srcGame.beginGame.states.MenuState;
import srcGame.beginGame.states.States;
import srcGame.beginGame.states.TutorialState;
import srcGame.beginGame.display.Display;
import srcGame.beginGame.gfx.Assets;
import srcGame.beginGame.gfx.GameCamera;
import srcGame.beginGame.input.KeyManager;
import srcGame.beginGame.input.MouseManager;

public class Game implements Runnable {
	private Display display;
	private int width, height;
	public String title;

	private boolean RUNNING_STATUS = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// STATES
	public States gameState;
	public States menuState;
	public States tutorialState;
	public States GameOverState;

	// INPUT
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// CAMERA
	private GameCamera gameCamera;

	// HANDLER
	private Handler handler;

	// SETTING
	private GameSetting settings;

	// CONSTRUCTOR
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		settings = new GameSetting();
	}

	// INIT SESSION
	private void init() {
		display = new Display(title, width, height);

		display.getFrame().addKeyListener(keyManager);

		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		tutorialState = new TutorialState(handler);
		GameOverState = new GameOverState(handler);
		States.setCurrentState(handler.getGame().setMenuState(States.getCurrentState()));
	}

	private void tick() {
		keyManager.tick();

		if (States.getCurrentState() != null)
			States.getCurrentState().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// không có cái này thì sẽ để lại hình thừa nếu asset chạy
		g.clearRect(0, 0, width, height);

		// draw here
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(Assets.background, 0, 0, 640,480,null);

		if (States.getCurrentState() != null)
			States.getCurrentState().render(g);
		// end here
		
		bs.show();
		g.dispose();
	}

	// GAME LOOP
	public void run() {
		init();

		int FPS = 60;
		// 1B in a second, we use nanosecond for precision
		int NANO_SECOND_PER_SECOND = 1_000_000_000;

		// maximum time to achieve 60 fps
		double timePerTick = NANO_SECOND_PER_SECOND / FPS;

		// amount of time we have ultil we call tick and render method again
		double delta = 0;

		long now;
		long lastTime = System.nanoTime(); // trả về giờ của máy tính theo nanosecond
		long timer = 0;
		int ticks = 0;

		// Game Loop
		while (RUNNING_STATUS) {
			now = System.nanoTime();
			// how much time we have until we call tick and render method
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			// use delta as a trigger to call tick and render method
			if (delta >= 1) {
				tick();
				render();
				// count how many time we call tick
				ticks++;
				delta--;
			}

			if (timer > NANO_SECOND_PER_SECOND) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0; // reset value
				timer = 0;
			}
		}
		stop();
	}

	// GETTERS
	// method that return a private variable that other class can access it
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public GameSetting getSettings() {
		return settings;
	}

	public States setMenuState(States state) {
		return state = new MenuState(handler);
	}

	public States setGameOverState(States state) {
		return state = new GameOverState(handler);
	}

	public States setGameState(States state) {
		return state = new GameState(handler);
	}

	public States setTutorialState(States state) {
		return state = new TutorialState(handler);
	}

	public synchronized void start() {
		if (RUNNING_STATUS)
			return;
		RUNNING_STATUS = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!RUNNING_STATUS)
			return;
		RUNNING_STATUS = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
