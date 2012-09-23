package com.amikomgamedev.bubblefish;

import java.io.IOException;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.Debug;

import com.amikomgamedev.bubblefish.Data;
import com.amikomgamedev.bubblefish.state.StateGameplay;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;


public class Game implements Data, Data_Support, Define{

	// font resource
	public static Font FntSmall;
	public static Font FntMedium;
	public static Font FntBig;

	public static Texture TexFontSmall;
	public static Texture TexFontMedium;
	public static Texture TexFontBig;
	
	//pause
	
		public static TiledTextureRegion regBtnRestart;
		public static TiledTextureRegion regBtnBackMenu;
		public static Sprite spBgGamePause;
		public static AnimatedSprite spBtnRestart;
		public static AnimatedSprite spBtnBackMenu;	
		
		public static TextureRegion regGamePause;
		public static TiledTextureRegion regBtnPause;
		public static TiledTextureRegion regBtnResume;
		public static AnimatedSprite spBtnPause;
		public static AnimatedSprite spBtnResume;
	
	private static Texture textureGamePause;
	public static Texture txtr_btnRestart;
	public static Texture txtr_btnBackMenu;
	private static Texture txtr_btnPause;
	private static Texture txtr_btnResume;
	
	
	// gameplay background
	public static Texture TexImgGameplayBackground;
	public static TextureRegion TreImgGameplayBackground;
	public static Sprite SprImgGameplayBackground;
	
	public static Texture TexImgGameHighScore;
	public static TextureRegion TreImgGameHighScore;
	
	// gameplay button
	public static Texture TexImgGameplayButton;
	public static TiledTextureRegion TreImgGameplayButtonUp;
	
	//img Game Score
	public static Texture TexImgScore;
	public static TextureRegion TreImgScore;
	
	//Img GameOver
	public static Texture TexImgGameOver;
	public static TextureRegion TreImgGameOver;
	// mainchar
	public static Texture TexSprMainchar;
	public static TiledTextureRegion TleSprMainchar;
	public static AnimatedSprite AspSprMainchar;
	//Enemy
	public static Texture TexSprEnemy;
	public static TiledTextureRegion TleSprEnemy;
	public static AnimatedSprite AspSprEnemy;
	
	// obstacles
	public static Texture[] TexImgObstacle;
	public static TiledTextureRegion[] TreImgObstacle;
	
	// Jalan
	public static Texture TexImgJalan;
	public static TextureRegion TreImgJalan;
	//Siluet
	public static Texture TexImgSiluet;
	public static TextureRegion TreImgSiluet;
	//awan
	public static Texture TexImgAwan;
	public static TextureRegion TreImgAwan;
		
	//music
	public static Music bgm_Menu, bgm_Gameplay,  bgm_gelembung_pecah;
	
	
	private static BaseGameActivity activity;
	private static Context context;
	
	
	public static void setContext(Context _context)
	{
		context		= _context;
		activity	= (BaseGameActivity)_context;
	}
	
	public static void loadFontSmall()
	{
		TexFontSmall =
			new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		FntSmall =
			FontFactory.createFromAsset(TexFontSmall,
				StateGameplay._instance, Data.FONT_FILE_LOCATION,
				FONT_SIZE_SMALL, true, Color.BLACK);
		StateGameplay._instance.getEngine().getFontManager()
			.loadFont(FntSmall);
		StateGameplay._instance.getEngine().getTextureManager()
			.loadTexture(TexFontSmall);
	}

	public static void loadFontMedium()
	{
		//if(TexFontMedium!=null)
			//return;
		TexFontMedium =
			new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		FntMedium =
			FontFactory.createFromAsset(TexFontMedium,
				StateGameplay._instance, Data.FONT_FILE_LOCATION,
				FONT_SIZE_MEDIUM, true, Color.WHITE);
		StateGameplay._instance.getEngine().getFontManager()
			.loadFont(FntMedium);
		StateGameplay._instance.getEngine().getTextureManager()
			.loadTexture(TexFontMedium);
	}

	public static void loadFontBig()
	{
		//if(TexFontBig!=null)
			//return;
		TexFontBig =
			new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		FntBig =
			FontFactory.createFromAsset(TexFontBig,
				StateGameplay._instance, Data.FONT_FILE_LOCATION,
				FONT_SIZE_BIG, true, Color.WHITE);
		StateGameplay._instance.getEngine().getFontManager()
			.loadFont(FntBig);
		StateGameplay._instance.getEngine().getTextureManager()
			.loadTexture(TexFontBig);
	}
	
	public static void loadGameplayBackground()
	{
		//if(TexImgGameplayBackground!=null)
			//return;
		
		TexImgGameplayBackground = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgGameplayBackground = TextureRegionFactory.createFromAsset(TexImgGameplayBackground, StateGameplay._instance
						, IMG_MAP_GAMEPLAY, 0, 0);
		
		StateGameplay._instance.getEngine().getTextureManager().loadTexture(TexImgGameplayBackground);
		SprImgGameplayBackground = new Sprite(0, 0, TreImgGameplayBackground);
		
		
		
	}
	
	public static void loadGameHighScore()
	{
		//if(TexImgGameplayBackground!=null)
			//return;
		
		TexImgGameHighScore = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgGameHighScore = TextureRegionFactory.createFromAsset(TexImgGameHighScore, StateGameplay._instance
						, IMG_GAMEPLAY_SCORE, 0, 0);
		
		StateGameplay._instance.getEngine().getTextureManager().loadTexture(TexImgGameHighScore);
		
		
		
	}

	public static void loadGameplayObstacle()
	{
		//if(TexImgObstacle!=null)
			//return;
		//TexImgObstacle = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TexImgObstacle = new Texture [IMG_GAMEPLAY_OBSTACLE.length];
		TreImgObstacle = new TiledTextureRegion [IMG_GAMEPLAY_OBSTACLE.length];
		
		for(int i = 0; i < IMG_GAMEPLAY_OBSTACLE.length; i++)
		{
			TexImgObstacle [i] = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);	
			TreImgObstacle [i] = TextureRegionFactory.createTiledFromAsset(
						TexImgObstacle[i]
						, StateGameplay._instance
						, IMG_GAMEPLAY_OBSTACLE[i]
						, 0, 0, 1, 1);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexImgObstacle[i]);
		}
	}
	 	
	public static void loadGameJalan()
	{
		TexImgJalan = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgJalan = TextureRegionFactory
				.createFromAsset(
						TexImgJalan
						, StateGameplay._instance
						, IMG_GAMEPLAY_ROAD
						, 0, 0);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexImgJalan);
		
		
		
	}
	
	public static void loadGameSiluet()
	{
		TexImgSiluet = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgSiluet = TextureRegionFactory
				.createFromAsset(
						TexImgSiluet
						, StateGameplay._instance
						, IMG_GAMEPLAY_SILUET
						, 0, 0);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexImgSiluet);
		
		
		
	}
	public static void loadMainchar()
	{
		//if(TexSprMainchar!=null)
			//return;
		TexSprMainchar = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TleSprMainchar = TextureRegionFactory
				.createTiledFromAsset(
						TexSprMainchar
						, StateGameplay._instance
						, SPR_MAIN_CHAR
						, 0, 0
						, SPR_MAIN_CHAR_COL, SPR_MAIN_CHAR_ROW);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexSprMainchar);
		AspSprMainchar = new AnimatedSprite(0, 0, TleSprMainchar);
	}
	
	
	
	public static void loadGameButton()
	{
		
		//if(TexImgGameplayButton!=null)
			//return;
		TexImgGameplayButton = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgGameplayButtonUp = TextureRegionFactory
				.createTiledFromAsset(
						TexImgGameplayButton
						, StateGameplay._instance
						, IMG_GAMEPLAY_BUTTON_UP
						, 0, 0, 3, 1);
		StateGameplay._instance.getEngine().getTextureManager().loadTexture(TexImgGameplayButton);
		
		// Biar nggk ribet naruhnya di sini
		TexImgScore = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgScore = TextureRegionFactory
				.createFromAsset(
						TexImgScore
						, StateGameplay._instance
						, SPR_SCORE
						, 0, 0);
		StateGameplay._instance.getEngine().getTextureManager().loadTexture(TexImgScore);
		
		
	}
	//mulai edit
	public static void loadGameAwan()
	{
		TexImgAwan = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgAwan = TextureRegionFactory
				.createFromAsset(
						TexImgAwan
						, StateGameplay._instance
						, IMG_GAMEPLAY_AWAN
						, 0, 0);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexImgAwan);
		
		
		
	}
	
	public static void loadGameOver()
	{
		
		//if(TexImgGameplayButton!=null)
			//return;
		TexImgGameOver = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TreImgGameOver = TextureRegionFactory
				.createFromAsset(
						TexImgGameOver
						, StateGameplay._instance
						, IMG_GAMEOVER
						, 0, 0);
		StateGameplay._instance.getEngine().getTextureManager().loadTexture(TexImgGameOver);
	}
	
	public static void loadSoundGamePlay()
	{
		try {
			bgm_Gameplay = MusicFactory.createMusicFromAsset(activity.getMusicManager(), activity, Data.BGM_GAME_GAMEPLAY);
			bgm_Gameplay.setLooping(true);
			
			bgm_gelembung_pecah = MusicFactory.createMusicFromAsset(activity.getMusicManager(), activity, Data.BGM_GAME_PECAH);
			bgm_gelembung_pecah.setLooping(false);
			
		} catch (final IOException e) {
			Debug.e(e);
		}
	}

	
	public static void loadSoundGamePlay2()
	{
		try {
			bgm_Menu = MusicFactory.createMusicFromAsset(activity.getMusicManager(), activity, Data.BGM_GAME_GAMEPLAY2);
			bgm_Menu.setLooping(true);
		} catch (final IOException e) {
			Debug.e(e);
		}
	}
	
	public static void loadEnemy()
	{
		//if(TexSprEnemy!=null)
			//return;
		TexSprEnemy = new Texture(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TleSprEnemy = TextureRegionFactory
				.createTiledFromAsset(
						TexSprEnemy
						, StateGameplay._instance
						, SPR_ENEMY
						, 0, 0
						, 4, 1);
		StateGameplay._instance
		.getEngine()
		.getTextureManager()
		.loadTexture(TexSprEnemy);
		//AspSprEnemy = new AnimatedSprite(0, 0, TleSprEnemy);
	}
	
	
	public static void loadPause(){
		
		textureGamePause = new Texture(512,1024);
		regGamePause = TextureRegionFactory.createFromAsset(textureGamePause, 
				StateGameplay._instance, Data.IMG_POP_UP_PAUSE,0,0);
		spBgGamePause = new Sprite(0, 0, regGamePause);
		
		txtr_btnPause = new Texture(512, 512);
		regBtnPause = TextureRegionFactory.createTiledFromAsset(txtr_btnPause,
				StateGameplay._instance, Data.SPR_BTN_PAUSEMENU, 0, 0, 3, 1);
		spBtnPause = new AnimatedSprite(GAME_SCREEN_WIDTH - 50, 0, 50, 50,
				regBtnPause);
		
		txtr_btnRestart = new Texture(512, 512);
		regBtnRestart = TextureRegionFactory.createTiledFromAsset(
				txtr_btnRestart, StateGameplay._instance, Data.SPR_BTN_RESTART, 0, 0, 3, 1);
		spBtnRestart = new AnimatedSprite((GAME_SCREEN_WIDTH >> 1) + 70,
				GAME_SCREEN_HEIGHT - 120, regBtnRestart); 

		
		txtr_btnBackMenu = new Texture(512, 512);
		regBtnBackMenu = TextureRegionFactory.createTiledFromAsset(
				txtr_btnBackMenu, StateGameplay._instance, Data.SPR_BTN_BACKMENU, 0, 0, 3, 1);
		spBtnBackMenu = new AnimatedSprite((GAME_SCREEN_WIDTH >> 1) - 30,
							GAME_SCREEN_HEIGHT - 120, regBtnBackMenu);
					
		txtr_btnResume = new Texture(512,512);
		regBtnResume = TextureRegionFactory.createTiledFromAsset(txtr_btnResume, 
				StateGameplay._instance, Data.SPR_BTN_RESUME , 0 , 0 , 3 , 1);
		spBtnResume = new AnimatedSprite((GAME_SCREEN_WIDTH >> 1) + 70,
							GAME_SCREEN_HEIGHT - 120, regBtnResume);										
				
		StateGameplay._instance.getEngine().getTextureManager().loadTextures
		(
			textureGamePause,
			txtr_btnRestart,
			txtr_btnBackMenu, 
			txtr_btnResume,
			txtr_btnPause
		);
	}
	
	
	

}

