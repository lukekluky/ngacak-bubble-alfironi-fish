package com.amikomgamedev.BubbleFish;

public interface Data {
	public static final String FONT_FILE_LOCATION = "fnt/ActionMan.ttf";

	public static final String IMG_MENU_FOLDER_PATH = "gfx/mainmenu/";
	public static final String MENU_FOLDER_PATH = "gfx/snd/";
	public static final String IMG_GAMEPLAY_FOLDER_PATH = "gfx/gameplay/img/";
	public static final String SPR_GAMEPLAY_FOLDER_PATH = "gfx/gameplay/spr/";
	public static final String SND_GAME_FOLDER_LOCATION = "snd/";
	public static final String IMG_AGD_LOGO_PATH = IMG_MENU_FOLDER_PATH + "logo.png";
	public static final String IMG_BF_LOGO_PATH = IMG_MENU_FOLDER_PATH + "timeline.png";
	public static final String IMG_HIGHSCORE = IMG_MENU_FOLDER_PATH + "listscore.png";
	// ini gameplay
	public static final String IMG_MAP_GAMEPLAY = IMG_GAMEPLAY_FOLDER_PATH + "langit.png";
	public static final String[] IMG_GAMEPLAY_OBSTACLE = 
		{
		SPR_GAMEPLAY_FOLDER_PATH + "tugu.png",
		SPR_GAMEPLAY_FOLDER_PATH + "bts.png",
		SPR_GAMEPLAY_FOLDER_PATH + "amikom.png",
		SPR_GAMEPLAY_FOLDER_PATH + "borjo.png",
		SPR_GAMEPLAY_FOLDER_PATH + "monjali.png",
		SPR_GAMEPLAY_FOLDER_PATH + "tanki.png",
		SPR_GAMEPLAY_FOLDER_PATH + "vredeburg.png",
		SPR_GAMEPLAY_FOLDER_PATH + "pilkada.png",
		SPR_GAMEPLAY_FOLDER_PATH + "jogja.png",
		SPR_GAMEPLAY_FOLDER_PATH + "agd.png",
		SPR_GAMEPLAY_FOLDER_PATH + "papan.png",
		SPR_GAMEPLAY_FOLDER_PATH + "papanamikom.png",
		SPR_GAMEPLAY_FOLDER_PATH + "coklat.png",
		SPR_GAMEPLAY_FOLDER_PATH + "ijo.png"
		};
	
	public static final String IMG_GAMEPLAY_BUTTON_UP = SPR_GAMEPLAY_FOLDER_PATH + "spr_button_up.png";
	public static final String IMG_LOADING = IMG_GAMEPLAY_FOLDER_PATH + "control.png";
	public static final String IMG_GAMEPLAY_ROAD = IMG_GAMEPLAY_FOLDER_PATH + "jalan.png";
	public static final String IMG_GAMEPLAY_SILUET = IMG_GAMEPLAY_FOLDER_PATH + "siluet.png";
	public static final String IMG_GAMEPLAY_AWAN = IMG_GAMEPLAY_FOLDER_PATH + "clouds.png";
	public static final String IMG_GAMEPLAY_SCORE = IMG_GAMEPLAY_FOLDER_PATH + "bgHighScore.png";
	
	// Ini buat karakter utama
	public static final String SPR_MAIN_CHAR = SPR_GAMEPLAY_FOLDER_PATH + 
			"bubble.png";
	
	public static final String BGM_GAME_GAMEPLAY = MENU_FOLDER_PATH + "bgm3.ogg";
	public static final String BGM_GAME_GAMEPLAY2 = MENU_FOLDER_PATH + "bgm2.ogg";
	public static final String BGM_GAME_PECAH = MENU_FOLDER_PATH + "gelembung_pecah.ogg";

	
	public static final String SPR_ENEMY = SPR_GAMEPLAY_FOLDER_PATH + "bird.png";
	public static final String SPR_SCORE = SPR_GAMEPLAY_FOLDER_PATH + "score.png";

	//pause
	public static final String SPR_BTN_RESTART = SPR_GAMEPLAY_FOLDER_PATH + "restartMenu.png";
	public static final String IMG_POP_UP_PAUSE = IMG_GAMEPLAY_FOLDER_PATH + "PausePopUp.png";
	public static final String SPR_BTN_BACKMENU = SPR_GAMEPLAY_FOLDER_PATH + "btnHome.png";
	public static final String SPR_BTN_PAUSEMENU = SPR_GAMEPLAY_FOLDER_PATH + "pauseMenu.png";
	public static final String SPR_BTN_RESUME = SPR_GAMEPLAY_FOLDER_PATH + "backMenu.png";
	public static final String IMG_GAMEOVER = SPR_GAMEPLAY_FOLDER_PATH + "gameover.png";
	
	//credit
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 320;
	
	
}
