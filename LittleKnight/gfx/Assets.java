package srcGame.beginGame.gfx;

import java.awt.image.BufferedImage;
import java.awt.Font;

public class Assets {
	private static final int DEFAULT__WIDTH = 48, DEFAULT_HEIGHT = 48;
	private static final int DEFAULT_DIRT_WIDTH = 24, DEFAULT_DIRT_HEIGHT = 24;
	private static final int DEFAULT_SPIKE_WIDTH = 16, DEFAULT_SPIKE_HEIGHT = 16;
	private static final int DEFAULT_PLAYER_WIDTH = 16, DEFAULT_PLAYER_HEIGHT = 16;
	private static final int DEFAULT_PLAYER_ATK_WIDTH = 64, DEFAULT_PLAYER_ATK_HEIGHT = 32;
	private static final int BUTTON_WIDTH = 200, BUTTON_HEIGHT = 100;

	private static final int TRAP_WIDTH = 112, TRAP_HEIGHT = 64;

	private static final int DEFAULT_GOBLIN_ATK_WIDTH = 24, DEFAULT_GOBLIN_ATK_HEIGHT = 16;

	public static Font font28, font15, font10;

	public static BufferedImage GRASS_TILE, STONE, GROUND, LEFT_CORNER, RIGHT_CORNER, MIDDLE, BACKGROUND_TILE,
			LEFT_SIDE, RIGHT_SIDE, BOTTOM, RIGHT_DOWN_CORNER, LEFT_DOWN_CORNER, spike, spikeLeft, spikeRight, flag,
			spikeReverse, background, tutorial;

	public static BufferedImage[] playerRunRight, playerRunLeft, playerIdle, playerDeath, playerIdleReverse, playerJump,
			playerAttackLeft, playerAttackRight, beforeJump, playerGotHitted, startButton, againButton, quitButton;

	public static BufferedImage[] goblinRunRight, goblinRunLeft, goblinDeath, goblinGotHitted, goblinAttackLeft,
			goblinAttackRight, trap;

	public static void init() {
		int ORIGINAL_X_COORDINATE = 0;
		int ORIGINAL_Y_COORDINATE = 0;

		// FONT
		font28 = FontLoader.loadFont("/LittleKnight/Workspace/MyGame/res/font/LVDCGO.ttf", 28);
		font15 = FontLoader.loadFont("/LittleKnight/Workspace/MyGame/res/font/LVDCGO.ttf", 15);
		font10 = FontLoader.loadFont("/LittleKnight/Workspace/MyGame/res/font/LVDCGO.ttf", 10);

		// BACKGROUND
		SpriteSheet Background = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/game_background_3.1.png"));

		// TUTORIAL
		SpriteSheet TUTORIAL = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/tutorial/eurkey.png"));

		// UI
		SpriteSheet START_BUTTON = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/EmptyButton.png"));
		SpriteSheet START_BUTTON_ON_MOUSE = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/EmptyButtonOnMouse.png"));

		SpriteSheet AGAIN_BUTTON = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/LargeEmptyButton.png"));
		SpriteSheet AGAIN_BUTTON_ON_MOUSE = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/LargeEmptyButtonOnMouse.png"));

		SpriteSheet QUIT_BUTTON = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/EmptyButton.png"));
		SpriteSheet QUIT_BUTTON_ON_MOUSE = new SpriteSheet(
				ImageLoader.loadImage("/LittleKnight/Workspace/MyGame/res/ui/EmptyButtonOnMouse.png"));

		// PLAYER MODEL
		SpriteSheet RUN_RIGHT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_run_anim_strip_6.png"));
		SpriteSheet RUN_LEFT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_run_anim_strip_left.png"));

		SpriteSheet IDLE_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_idle_anim_strip_4.png"));
		SpriteSheet IDLE_REVERSE_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_idle_anim_strip_reverse.png"));

		SpriteSheet GOT_HIT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_hit_anim_strip_3.png"));
		SpriteSheet DEATH_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_death_anim_strip_8.png"));

		SpriteSheet BEFORE_JUMP_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_before_or_after_jump_srip_2.png"));
		SpriteSheet JUMP_UP_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_jump_up_anim_strip_3.png"));

		SpriteSheet ATTACK_ANIMATION_RIGHT = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_sword_attack_anim_strip_4.png"));
		SpriteSheet ATTACK_ANIMATION_LEFT = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/herochar_sprites/herochar_sword_attack_anim_strip_left.png"));

		// GOBLIN MODEL
		SpriteSheet GOBLIN_RUN_RIGHT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_run_anim_strip_6.png"));
		SpriteSheet GOBLIN_RUN_LEFT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_run_anim_strip_6_reverse.png"));

		SpriteSheet GOBLIN_DEATH_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_death_anim_strip_6.png"));
		SpriteSheet GOBLIN_GOT_HIT_ANIMATION = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_hit_anim_strip_3.png"));

		SpriteSheet GOBLIN_ATTACK_ANIMATION_LEFT = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_attack_anim_strip_4_reverse.png"));
		SpriteSheet GOBLIN_ATTACK_ANIMATION_RIGHT = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/enemies_sprites/goblin/goblin_attack_anim_strip_4.png"));

		// OBJECTS MODEL
		SpriteSheet spikeTrap = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/spikes.png"));
		SpriteSheet spikeTrapLeft = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/spikes_trap_left.png"));
		SpriteSheet spikeTrapRight = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/spikes_trap_right.png"));
		SpriteSheet spikeTrapBottom = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/spikes_trap.png"));

		SpriteSheet trapObject = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/trap_suspended_anim_strip_18.png"));
		SpriteSheet checkpointFlag = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/miscellaneous_sprites/Flag.png"));

		// PLATFORM MODEL
		// ground
		SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/dirtTile.png"));
		// left corner
		SpriteSheet leftCorner = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/dirtTileLeftCorner.png"));
		// right corner
		SpriteSheet rightCorner = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/dirtTileRightCorner.png"));
		// middle
		SpriteSheet middle = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/middleDirtTile.png"));
		// left side
		SpriteSheet leftSide = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/leftSide.png"));
		// right side
		SpriteSheet rightSide = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/rightSide.png"));
		// bottom
		SpriteSheet bottom = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/bottomGrassTile.png"));
		// background
		SpriteSheet backgroundTile = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/empty.png"));
		// right down corner
		SpriteSheet rightDownCorner = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/dirtTileDownRightCorner.png"));
		// left down corner
		SpriteSheet leftDownCorner = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/dirtTileDownLeftCorner.png"));
		// stone
		SpriteSheet stone = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/stone.png"));
		SpriteSheet grassTile = new SpriteSheet(ImageLoader.loadImage(
				"/LittleKnight/Workspace/MyGame/res/textures/metroidvania/tiles_and_background_foreground/grassTile.png"));
		// UI
		// START BUTTON
		startButton = new BufferedImage[2];

		startButton[0] = START_BUTTON.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, BUTTON_WIDTH, BUTTON_HEIGHT);
		startButton[1] = START_BUTTON_ON_MOUSE.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		// PLAY AGAIN BUTTON
		againButton = new BufferedImage[2];

		againButton[0] = AGAIN_BUTTON.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, 1200, BUTTON_HEIGHT);
		againButton[1] = AGAIN_BUTTON_ON_MOUSE.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, 1200, BUTTON_HEIGHT);

		// QUIT BUTTON
		quitButton = new BufferedImage[2];

		quitButton[0] = QUIT_BUTTON.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, BUTTON_WIDTH, BUTTON_HEIGHT);
		quitButton[1] = QUIT_BUTTON_ON_MOUSE.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		// PLAYER ANIMATION
		// IDLE
		playerIdle = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			playerIdle[frames] = IDLE_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// IDLE REVERSE
		playerIdleReverse = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			playerIdleReverse[frames] = IDLE_REVERSE_ANIMATION.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames, ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH,
					DEFAULT_PLAYER_HEIGHT);
		}

		// RUN RIGHT
		playerRunRight = new BufferedImage[6];
		for (int frames = 0; frames < 6; frames++) {
			playerRunRight[frames] = RUN_RIGHT_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// RUN LEFT
		playerRunLeft = new BufferedImage[6];
		for (int frames = 0; frames < 6; frames++) {
			playerRunLeft[frames] = RUN_LEFT_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// DEATH
		playerDeath = new BufferedImage[8];

		for (int frames = 0; frames < 8; frames++) {
			playerDeath[frames] = DEATH_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// GOT HITTED
		playerGotHitted = new BufferedImage[3];

		for (int frames = 0; frames < 3; frames++) {
			playerGotHitted[frames] = GOT_HIT_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// JUMP
		playerJump = new BufferedImage[5];

		playerJump[0] = BEFORE_JUMP_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * 0,
				ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		playerJump[1] = BEFORE_JUMP_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * 1,
				ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);

		for (int frames = 0; frames < 3; frames++) {
			playerJump[frames] = JUMP_UP_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}

		// ATTACK
		playerAttackRight = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			playerAttackRight[frames] = ATTACK_ANIMATION_RIGHT.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_ATK_WIDTH * frames, ORIGINAL_Y_COORDINATE,
					DEFAULT_PLAYER_ATK_WIDTH, DEFAULT_PLAYER_ATK_HEIGHT);
		}

		playerAttackLeft = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			playerAttackLeft[frames] = ATTACK_ANIMATION_LEFT.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_ATK_WIDTH * frames, ORIGINAL_Y_COORDINATE,
					DEFAULT_PLAYER_ATK_WIDTH, DEFAULT_PLAYER_ATK_HEIGHT);
		}

		// GOBLIN ANIMATION
		// RUN RIGHT
		goblinRunRight = new BufferedImage[6];

		for (int frames = 0; frames < 6; frames++) {
			goblinRunRight[frames] = GOBLIN_RUN_RIGHT_ANIMATION.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames, ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH,
					DEFAULT_PLAYER_HEIGHT);
		}
		// RUN LEFT
		goblinRunLeft = new BufferedImage[6];

		for (int frames = 0; frames < 6; frames++) {
			goblinRunLeft[frames] = GOBLIN_RUN_LEFT_ANIMATION.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames, ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH,
					DEFAULT_PLAYER_HEIGHT);
		}
		// DEATH
		goblinDeath = new BufferedImage[6];

		for (int frames = 0; frames < 6; frames++) {
			goblinDeath[frames] = GOBLIN_DEATH_ANIMATION.crop(ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames,
					ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		}
		// GOT HIT
		goblinGotHitted = new BufferedImage[3];

		for (int frames = 0; frames < 3; frames++) {
			goblinGotHitted[frames] = GOBLIN_GOT_HIT_ANIMATION.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_PLAYER_WIDTH * frames, ORIGINAL_Y_COORDINATE, DEFAULT_PLAYER_WIDTH,
					DEFAULT_PLAYER_HEIGHT);
		}
		// ATTACK
		goblinAttackRight = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			goblinAttackRight[frames] = GOBLIN_ATTACK_ANIMATION_RIGHT.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_GOBLIN_ATK_WIDTH * frames, ORIGINAL_Y_COORDINATE,
					DEFAULT_GOBLIN_ATK_WIDTH, DEFAULT_GOBLIN_ATK_HEIGHT);
		}

		goblinAttackLeft = new BufferedImage[4];

		for (int frames = 0; frames < 4; frames++) {
			goblinAttackLeft[frames] = GOBLIN_ATTACK_ANIMATION_LEFT.crop(
					ORIGINAL_X_COORDINATE + DEFAULT_GOBLIN_ATK_WIDTH * frames, ORIGINAL_Y_COORDINATE,
					DEFAULT_GOBLIN_ATK_WIDTH, DEFAULT_GOBLIN_ATK_HEIGHT);
		}

		// TRAP
		trap = new BufferedImage[18];

		for (int frames = 0; frames < 18; frames++) {
			trap[frames] = trapObject.crop(ORIGINAL_X_COORDINATE + TRAP_WIDTH * frames, ORIGINAL_Y_COORDINATE,
					TRAP_WIDTH, TRAP_HEIGHT);
		}

		// PLATFORM
		GROUND = ground.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH, DEFAULT_DIRT_HEIGHT);
		LEFT_CORNER = leftCorner.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		RIGHT_CORNER = rightCorner.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		MIDDLE = middle.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH, DEFAULT_DIRT_HEIGHT);
		BACKGROUND_TILE = backgroundTile.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		LEFT_SIDE = leftSide.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		RIGHT_SIDE = rightSide.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		BOTTOM = bottom.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH, DEFAULT_DIRT_HEIGHT);
		RIGHT_DOWN_CORNER = rightDownCorner.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		LEFT_DOWN_CORNER = leftDownCorner.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_DIRT_WIDTH,
				DEFAULT_DIRT_HEIGHT);
		STONE = stone.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT__WIDTH, DEFAULT_HEIGHT);
		GRASS_TILE = grassTile.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT__WIDTH, DEFAULT_HEIGHT);
		
		// BACKGROUND
		background = Background.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, 1920, 1080);

		// TUTORIAL
		tutorial = TUTORIAL.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, 1260, 578);

		// STATIC OBJECTS
		spike = spikeTrap.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_SPIKE_WIDTH, DEFAULT_SPIKE_HEIGHT);
		spikeLeft = spikeTrapLeft.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_SPIKE_WIDTH,
				DEFAULT_SPIKE_HEIGHT);
		spikeRight = spikeTrapRight.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_SPIKE_WIDTH,
				DEFAULT_SPIKE_HEIGHT);
		spikeReverse = spikeTrapBottom.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, DEFAULT_SPIKE_WIDTH,
				DEFAULT_SPIKE_HEIGHT);
		flag = checkpointFlag.crop(ORIGINAL_X_COORDINATE, ORIGINAL_Y_COORDINATE, 210, 290);
	}
}