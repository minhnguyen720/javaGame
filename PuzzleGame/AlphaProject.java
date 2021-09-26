package com.willie.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.willie.game.audio.GameMusic;
import com.willie.game.scene.GameScreen;
import com.willie.game.scene.LoadingScreen;
import com.willie.game.scene.MainMenuScreen;
import com.willie.game.scene.SplashScreen;


public class AlphaProject extends Game {
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static float VERSION = 1.0f;
	public static String TITLE = "Project Alpha";

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public AssetManager assetManager;
	public BitmapFont font;

	public LoadingScreen loadingScreen;
	public SplashScreen splashScreen;
	public MainMenuScreen mainMenuScreen;
	public GameScreen gameScreen;
	public GameMusic gameMusic;

	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		font = new BitmapFont();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,WIDTH,HEIGHT);

		loadingScreen = new LoadingScreen(this);
		splashScreen = new SplashScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		gameMusic =  new GameMusic();

		this.setScreen(loadingScreen);

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
		loadingScreen.dispose();
		splashScreen.dispose();
		mainMenuScreen.dispose();
		gameScreen.dispose();
		this.getScreen().dispose();
		gameMusic.dispose();
	}
}
