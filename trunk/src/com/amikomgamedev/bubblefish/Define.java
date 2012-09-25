package com.amikomgamedev.BubbleFish;

public interface Define {
	// ratio screen width
	public static final int GAME_RATIO_SCREEN_WIDTH		= 480;
	public static final int GAME_RATIO_SCREEN_HEIGHT 	= 320;
	
	
	public static final int GAME_SCREEN_WIDTH_SMALL 	= 320;
	public static final int GAME_SCREEN_HEIGHT_SMALL 	= 240;
	
	public static final int GAME_SCREEN_WIDTH_NORMAL 	= 480;
	public static final int GAME_SCREEN_HEIGHT_NORMAL 	= 320;
	
	public static final int GAME_SCREEN_WIDTH_LARGE 	= 800;
	public static final int GAME_SCREEN_HEIGHT_LARGE 	= 480;

	public static final int GAME_SCREEN_WIDTH_XLARGE 	= 1280;
	public static final int GAME_SCREEN_HEIGHT_XLARGE 	= 800;
	
	// nentuin ukuran screen berdasar setting yg ada di config
	public static final int GAME_SCREEN_WIDTH 			= 
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_SMALL)?GAME_SCREEN_WIDTH_SMALL:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_NORMAL)?GAME_SCREEN_WIDTH_NORMAL:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_LARGE)?GAME_SCREEN_WIDTH_LARGE:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_XLARGE)?GAME_SCREEN_WIDTH_XLARGE:
				GAME_SCREEN_WIDTH_NORMAL;		
	public static final int GAME_SCREEN_HEIGHT 			= 
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_SMALL)?GAME_SCREEN_HEIGHT_SMALL:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_NORMAL)?GAME_SCREEN_HEIGHT_NORMAL:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_LARGE)?GAME_SCREEN_HEIGHT_LARGE:
				(Config.SCREEN_TYPE_USE==Config.SCREEN_TYPE_XLARGE)?GAME_SCREEN_HEIGHT_XLARGE:
				GAME_SCREEN_HEIGHT_NORMAL;		
// state buat entity mc
	public static final int MC_STATE_IDLE = 0;
	public static final int MC_STATE_FLY = 1;
	public static final int MC_STATE_DIE = 2;

// gameplay hud
	public static final int[] TXT_SCORE_POS = 
		{
			Utils.getRatioW(5)
			, Utils.getRatioH(5)
		};
	
	public static final int[] BUTTON_UP_POS = 
		{
			Utils.getRatioW(390)
			, Utils.getRatioH(230)
		};
	
// entity mc setting
	public static final int[] MC_MOVE_FAR = 
		{
		Utils.getRatioW(1)		// jarak gerak x	
		,Utils.getRatioH(1)	// jarak gerak y	
		
		};

// gameplay
	public static final int[] OBSTACLE_FAR_MIN_MAX = 
		{
			Utils.getRatioW(250)	// jarak minimal obstacle
			, Utils.getRatioH(300)	// jarak maksimal obstacle
		};
	public static final int[] OBSTACLE_POS_Y_MIN_MAX =
		{
			Utils.getRatioW(100)	// jarak random y minimal
			, Utils.getRatioH(220)	// jarak random y maksimal
		};
	
	
	
}
