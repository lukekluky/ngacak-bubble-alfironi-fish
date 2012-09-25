package com.amikomgamedev.BubbleFish;

import android.util.Log;

import com.amikomgamedev.BubbleFish.Game;


public class Loading {
	public static final int LOADING_TYPE_APP_OPEN 		= 0;
	public static final int LOADING_TYPE_MAIN_MENU 		= LOADING_TYPE_APP_OPEN + 1;
	public static final int LOADING_TYPE_GAMEPLAY 		= LOADING_TYPE_MAIN_MENU + 1;
	public static int Loading_Type_Current = -1;
	
	private static final int LOADING_SUB_TYPE_LOGO 					= 0;
	private static final int LOADING_SUB_TYPE_WALPAPER 				= LOADING_SUB_TYPE_LOGO + 1;
	private static final int LOADING_SUB_TYPE_MAIN_MENU_INTERFACE 	= LOADING_SUB_TYPE_WALPAPER + 1;
	private static final int LOADING_SUB_TYPE_MAIN_MENU_BUTTON 		= LOADING_SUB_TYPE_MAIN_MENU_INTERFACE + 1;
	private static final int LOADING_SUB_TYPE_FONT_SMALL 			= LOADING_SUB_TYPE_MAIN_MENU_BUTTON + 1;
	private static final int LOADING_SUB_TYPE_FONT_MEDIUM 			= LOADING_SUB_TYPE_FONT_SMALL + 1;
	private static final int LOADING_SUB_TYPE_FONT_BIG 				= LOADING_SUB_TYPE_FONT_MEDIUM + 1;
	private static final int LOADING_SUB_TYPE_LOADING_INTERFACE 	= LOADING_SUB_TYPE_FONT_BIG + 1;
	private static final int LOADING_SUB_TYPE_MC 					= LOADING_SUB_TYPE_LOADING_INTERFACE + 1;
	private static final int LOADING_SUB_TYPE_MAP_BACKGROUD 		= LOADING_SUB_TYPE_MC + 1;
	private static final int LOADING_SUB_TYPE_OBSTACLE		 		= LOADING_SUB_TYPE_MAP_BACKGROUD + 1;
	private static final int LOADING_SUB_TYPE_GAME_BUTTON			= LOADING_SUB_TYPE_OBSTACLE + 1;
	private static final int LOADING_SUB_TYPE_SOUND_GAMEPLAY		= LOADING_SUB_TYPE_GAME_BUTTON + 1;
	private static final int LOADING_SUB_TYPE_ENEMY = LOADING_SUB_TYPE_SOUND_GAMEPLAY + 1;
	
	
	public static int Loading_Max_Progress = 0;
	public static int Loading_Cur_Progress = 0;
	
	public static void setLoadingType(int loadingType)
	{
		Loading_Type_Current = loadingType;
		Loading_Cur_Progress = 0;
				switch(Loading_Type_Current)
				{
					case LOADING_TYPE_MAIN_MENU:
						Loading_Max_Progress = LOADING_TYPE_MAIN_MENU_LIST_ITEM.length;
					break;
					case LOADING_TYPE_GAMEPLAY:
						Loading_Max_Progress = LOADING_TYPE_GAMEPLAY_LIST_ITEM.length;
					break;
				}
				
	}
	
	public static boolean isLoadingActive()
	{
		return (Loading_Max_Progress>Loading_Cur_Progress)?true:false;
	}
	
	public static void updateLoading()
	{
		switch(Loading_Type_Current)
		{
			case LOADING_TYPE_MAIN_MENU:
					loadItem(LOADING_TYPE_MAIN_MENU_LIST_ITEM[Loading_Cur_Progress]);
			break;
			case LOADING_TYPE_GAMEPLAY:
					loadItem(LOADING_TYPE_GAMEPLAY_LIST_ITEM[Loading_Cur_Progress]);
			break;
		}
		Loading_Cur_Progress++;
	}
	
	static void loadItem(int itemType)
	{
		switch(itemType)
		{
			case LOADING_SUB_TYPE_LOGO:
			break;
			case LOADING_SUB_TYPE_FONT_SMALL:
				Game.loadFontSmall();
			break;
			case LOADING_SUB_TYPE_FONT_MEDIUM:
				Game.loadFontMedium();
			break;
			case LOADING_SUB_TYPE_FONT_BIG:
				Game.loadFontBig();
			break;
			case LOADING_SUB_TYPE_MC:
				Game.loadMainchar();
				Game.loadGameAwan();
			break;
			case LOADING_SUB_TYPE_MAP_BACKGROUD:
				Game.loadGameplayBackground();
				Game.loadGameSiluet();
			break;
			case LOADING_SUB_TYPE_OBSTACLE:
				Game.loadGameplayObstacle();
				Game.loadGameJalan();
			break;
			case LOADING_SUB_TYPE_GAME_BUTTON:
				Game.loadGameButton();
				Game.loadGameOver();
				break;
			case LOADING_SUB_TYPE_SOUND_GAMEPLAY:
				Game.loadSoundGamePlay();
				Game.loadSoundGamePlay2();
				Game.loadGameHighScore();
			break;
			case LOADING_SUB_TYPE_ENEMY:
				Game.loadEnemy();
				Game.loadPause();
				break;
		}
	}
	
	
	public static final int LOADING_TYPE_MAIN_MENU_LIST_ITEM[] = {
		LOADING_SUB_TYPE_MAIN_MENU_INTERFACE,
		LOADING_SUB_TYPE_MAIN_MENU_BUTTON,
		LOADING_SUB_TYPE_FONT_MEDIUM
	};
	
	public static final int LOADING_TYPE_GAMEPLAY_LIST_ITEM[] = {
		LOADING_SUB_TYPE_MC,
		LOADING_SUB_TYPE_MAP_BACKGROUD,
		LOADING_SUB_TYPE_OBSTACLE,
		LOADING_SUB_TYPE_FONT_SMALL,
		LOADING_SUB_TYPE_FONT_MEDIUM,
		LOADING_SUB_TYPE_FONT_BIG,
		LOADING_SUB_TYPE_GAME_BUTTON,
		LOADING_SUB_TYPE_SOUND_GAMEPLAY,
		LOADING_SUB_TYPE_ENEMY
	};
	
	
}
