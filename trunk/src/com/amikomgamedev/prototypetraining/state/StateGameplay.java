package com.amikomgamedev.prototypetraining.state;


import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.SmoothCamera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.EditText;

//import com.amikomgamedev.SoundManager;



import com.amikomgamedev.prototypetraining.Data;
import com.amikomgamedev.prototypetraining.Config;
import com.amikomgamedev.prototypetraining.Data_Support;
import com.amikomgamedev.prototypetraining.Define;
import com.amikomgamedev.prototypetraining.Game;
import com.amikomgamedev.prototypetraining.Loading;
import com.amikomgamedev.prototypetraining.Utils;
import com.amikomgamedev.prototypetraining.entity.EntityMc;
import com.amikomgamedev.prototypetraining.entity.EntityObstacle;
import com.amikomgamedev.prototypetraining.entity.EntityEnemy;
import com.amikomgamedev.prototypetraining.entity.EntityOther;
import com.amikomgamedev.prototypetraining.entity.EntitySiluet;
import com.amikomgamedev.prototypetraining.entity.EntityAwan;
import com.amikomgamedev.prototypetraining.ScoreDb;
import com.amikomgamedev.prototypetraining.state.State_IntroMenu;


public class StateGameplay extends BaseGameActivity implements
													Config,
													Define,
													IUpdateHandler,
													IOnSceneTouchListener,Data_Support
													{
	
	// inisialisasi kebutuhan state
	public static final int STATE_GAMEPLAY_INGAME = 0;
	public static final int STATE_GAMEPLAY_LOADING = 1;
	public static final int STATE_GAMEPLAY_INGAMEMENU = 2;
	public static final int STATE_GAMEPLAY_GAMEOVER = 3;
	public static int StateCurrent = -1;
	public static int b = Utils.getRandomValue(0,13);
	

	// instance gameplay
	public static StateGameplay _instance;
	
	// kebutuhan sistem
	public static SmoothCamera SmcMainCamera;
	public Scene SceMainScene;
	public HUD HudMainHud;
	
	
	
	// kebutuhan game
	static int GameScore = 0;
	int LastObstaclePosX = 0;
	int LastObstaclePosY = 0;
	int LastEnemyPosX = 0;
	int LastEnemyPosY = 0;
	//trainjalan
	int LastRoadPosX = 0;
	int LastRoadPosY = 0;
	
	int LastSiluetPosX = 0;
	int LastSiluetPosY = 0;
	
	boolean LastObstaclePosUp = false;
	private EditText editText;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	public static boolean Button_up = true;
	

	String mValue;
	public static boolean isMapMove = false;
	EntityMc entityMc;
	EntityEnemy entityEnemy;
	EntityOther entityOther;
	EntitySiluet entitySiluet;
	EntityAwan entityAwan;
	private  ScoreDb scoreDb;
	boolean isNewEnterHere = true;
	int CenterPoinPos;
	
	
	// state used object
	ChangeableText TxtLoading;
	
	ChangeableText TxtScore, highScore, score, TxtHighScore,high;
	AnimatedSprite SprImgGameplayButtonUp;
	Sprite SprGameover;
	Sprite SprGameScore;
	Sprite sprBgHeighScore;
	
	//loading
	private static Texture txt_loading;
	private static TextureRegion txtr_loading;
	private static Sprite spr_loading;
	

	
	// kebutuhan gameplay
	List<EntitySiluet> entitySiluetList = new ArrayList<EntitySiluet>();
	List<EntityObstacle> entityObstacleList = new ArrayList<EntityObstacle>();
	List<EntityOther> entityOtherList = new ArrayList<EntityOther>();
	List<EntityEnemy> entityenemy = new ArrayList<EntityEnemy>();
	List<EntityAwan> entityAwanList = new ArrayList<EntityAwan>();
	
	private float SPEED = 100;
	
	public void onLoadComplete() {
	}

	public Engine onLoadEngine() {
		
	
		_instance = this;
		
		//camera = new Camera(0, 0, Config.GAME_SCREEN_WIDTH, Config.GAME_SCREEN_HEIGHT);
		SmcMainCamera =
				new SmoothCamera(0, 0, GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT,
						GAME_SCREEN_WIDTH / 3, GAME_SCREEN_HEIGHT, 30);
		
		//SmcMainCamera = (SmoothCamera) new Camera(0, 0, GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT);
			
			Engine en =
				new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
					new RatioResolutionPolicy(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT),
					SmcMainCamera).setNeedsSound(true).setNeedsMusic(true));
			return en;
	}

	public void onLoadResources(){
		
		//HudMainHud		= new HUD();
		//SmcMainCamera.setHUD(HudMainHud);
		Game.loadFontMedium();
		//TxtLoading = new ChangeableText(0, 0, Game.FntMedium, "Loading...");
		//TxtLoading.setPosition((GAME_SCREEN_WIDTH-TxtLoading.getWidth())/2
		//		, GAME_SCREEN_HEIGHT>>1);
		//HudMainHud.getFirstChild().attachChild(Game.SprImgGameplayBackground);
		//HudMainHud.getFirstChild().attachChild(TxtLoading);
		//coba
		Game.setContext(this);
		loadLoading();
		mEngine.getTextureManager().loadTexture(txt_loading);
		scoreDb = new ScoreDb(this);
		scoreDb.CreateTable();
		//txt_loading.
		
		
		
	}

	public Scene onLoadScene(){
		// TODO Auto-generated method stub
		HudMainHud		= new HUD();
		SmcMainCamera.setHUD(HudMainHud);
				
		//BATAS
		SceMainScene = new Scene(2);
		SceMainScene.setOnSceneTouchListener(this);
		editText = new EditText(this);
		builder = new AlertDialog.Builder(this);
		
		mEngine.registerUpdateHandler(this);
		switchState(STATE_GAMEPLAY_LOADING);
		SceMainScene.setTouchAreaBindingEnabled(true);
		
		return SceMainScene;
	}	
	
	public boolean onSceneTouchEvent(Scene arg0, final TouchEvent TchEvt) {
		switch(StateCurrent)
		{
			case STATE_GAMEPLAY_LOADING:
			break;
			case STATE_GAMEPLAY_INGAME:
				if(Utils.isInRect(TchEvt.getX(), TchEvt.getY()
						//, SprImgGameplayButtonUp.getX()
						//, SprImgGameplayButtonUp.getY()
						, SmcMainCamera.getMaxX()-SprImgGameplayButtonUp.getWidth()
						, SmcMainCamera.getMaxY()-SprImgGameplayButtonUp.getHeight()
						, SprImgGameplayButtonUp.getWidth()
						, SprImgGameplayButtonUp.getHeight()))
				{
					SprImgGameplayButtonUp.animate(new long[]{200, 200, 200}, 1, 3, true);
					
					if(entityMc.getMcStateCurrent()==MC_STATE_IDLE)
					entityMc.switchMcState(MC_STATE_FLY);
					entityMc.setMcFlyUp(true);
					
					}
				if(TchEvt.getAction()==TchEvt.ACTION_UP)
				{
					entityMc.setMcFlyUp(false);
					SprImgGameplayButtonUp.animate(new long[]
							{
								200, 200, 200
							}, 1, 3, false);
					
				}
				
				
				
				if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
						SmcMainCamera.getMaxX()-Game.spBtnPause.getWidth(), 
						Game.spBtnPause.getY(), 
						Game.spBtnPause.getWidth(),
						Game.spBtnPause.getHeight()))
				{
						Game.spBtnPause.animate(new long[] { 80, 80 }, 0, 1, false);
						switchState(STATE_GAMEPLAY_INGAMEMENU);
						Game.spBtnPause.animate(new long[] { 80, 80 }, 1, 2, false);
				}
				
				
			break;
			case STATE_GAMEPLAY_INGAMEMENU:
				if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
						Game.spBtnResume.getX(), 
						Game.spBtnResume.getY(), 
						Game.spBtnResume.getWidth(),
						Game.spBtnResume.getHeight()))
		{
					Game.spBtnResume.animate(new long[] { 80, 80 }, 0, 1, false);
					switchState(STATE_GAMEPLAY_INGAME);
					showIngameMenu(false);
					if(StateMenumain.isSoundEnable){
					Game.bgm_Gameplay.resume();
					}
					Game.spBtnResume.animate(new long[] { 80, 80 }, 1, 2, false);
		}
				
				if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
						Game.spBtnRestart.getX(), 
						Game.spBtnRestart.getY(), 
						Game.spBtnRestart.getWidth(),
						Game.spBtnRestart.getHeight()))
				{
					Game.bgm_Gameplay.stop();
					Game.spBtnRestart.animate(new long[] { 80, 80 }, 0, 1, false);
					
					Intent start = new Intent(StateGameplay.this, StateGameplay.class);
					startActivity(start);

					finish();
					Game.spBtnRestart.animate(new long[] { 80, 80 }, 1, 2, false);
					
				}

				if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
						Game.spBtnBackMenu.getX(), 
						Game.spBtnBackMenu.getY(), 
						Game.spBtnBackMenu.getWidth(),
						Game.spBtnBackMenu.getHeight()))
				{
					Game.spBtnBackMenu.animate(new long[] { 80, 80 }, 0, 1, false);
					Intent start = new Intent(StateGameplay.this, StateMenumain.class);
					startActivity(start);

					finish();

					Game.spBtnBackMenu.animate(new long[] { 80, 80 }, 1, 2, false);
					
				}
			break;
			case STATE_GAMEPLAY_GAMEOVER:
				
				Intent start = new Intent(StateGameplay.this, StateScore.class);
				startActivity(start);

				finish();
				
				/*
	
				//GameScore = 0;
				if(TchEvt.getAction()==TchEvt.ACTION_DOWN)
				if(newGameOver)
				{
					TxtHighScore = new ChangeableText((GAME_SCREEN_WIDTH>>1)+10
							, (GAME_SCREEN_HEIGHT>>1)-45
							, Game.FntBig, " " + GameScore);
					HudMainHud.getFirstChild().attachChild(TxtHighScore);
				//burhan
				
						//highScore = new ChangeableText((GAME_SCREEN_WIDTH>>1)+120, 
							//	10, 
								//Game.FntMedium, scoreDb.getLatestScore());
					
					high = new ChangeableText((GAME_SCREEN_WIDTH>>1)-20,10, Game.FntMedium, "HighScore");
					

					HudMainHud.attachChild(highScore);
					HudMainHud.attachChild(high);
					//-------------
					sprBgHeighScore.setVisible(true);
					Detach();
					if(HighScore){
						
						
							//submitScore();	
						
						
						}
					
					newGameOver = false;
					//submitScore();
				}
				else
				{
					if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
							Game.spBtnRestart.getX(), 
							Game.spBtnRestart.getY(), 
							Game.spBtnRestart.getWidth(),
							Game.spBtnRestart.getHeight()))
					{
						Game.bgm_Gameplay.stop();
						Game.spBtnRestart.animate(new long[] { 80, 80 }, 0, 1, false);
						
						Intent start = new Intent(StateGameplay.this, StateGameplay.class);
						startActivity(start);
	
						finish();
						Game.spBtnRestart.animate(new long[] { 80, 80 }, 1, 2, false);
						
					}
	
					else if(Utils.isInRect(TchEvt.getX(), TchEvt.getY(), 
							Game.spBtnBackMenu.getX(), 
							Game.spBtnBackMenu.getY(), 
							Game.spBtnBackMenu.getWidth(),
							Game.spBtnBackMenu.getHeight()))
					{
	
						Game.spBtnBackMenu.animate(new long[] { 80, 80 }, 0, 1, false);
						Intent start = new Intent(StateGameplay.this, StateMenumain.class);
						startActivity(start);
	
						finish();
	
						Game.spBtnBackMenu.animate(new long[] { 80, 80 }, 1, 2, false);
						
					}
				}
				
				*/
				
			break;
		}
		return true;
	
	}
	

	public void onUpdate(float arg0) {
		switch(StateCurrent)
		{
			case STATE_GAMEPLAY_LOADING:
				if(Loading.isLoadingActive())
				{
					Loading.updateLoading();
				}
				else
				{
				
					//initGame();
					//HudMainHud.getFirstChild().detachChild(Game.SprImgGameplayBackground);
					//SceMainScene.getFirstChild().detachChild(Game.AspSprMainchar);
					//HudMainHud.getFirstChild().detachChild(TxtLoading);
					switchState(STATE_GAMEPLAY_INGAME);
				}
				
			break;
			case STATE_GAMEPLAY_INGAME:
				Game.spBtnPause.setVisible(true);
				SprImgGameplayButtonUp.setVisible(true);
				Game.spBtnPause.setPosition((SmcMainCamera.getMaxX()-50), 0);  
				/*if(Game.SprImgGameplayBackground.getX() < (SmcMainCamera.getMinX()-Game.SprImgGameplayBackground.getWidth()))
				{
					Game.SprImgGameplayBackground.setPosition(
							(Game.SprImgGameplayBackground2.getX()+ Game.SprImgGameplayBackground.getWidth())-10, 
							Game.SprImgGameplayBackground.getY());
				}

				// nge-loop bg2 kembali keatas bg1 ketika sudah tak terlihat kamera
				if((SmcMainCamera.getMinX()-Game.SprImgGameplayBackground2.getWidth()) > Game.SprImgGameplayBackground2.getX())
				{
					Game.SprImgGameplayBackground2.setPosition(
							(Game.SprImgGameplayBackground.getX()+ Game.SprImgGameplayBackground2.getWidth())-10,
							Game.SprImgGameplayBackground2.getY());
					
				}
				*/
				
				//coba atas
				
				/*if(entityenemy.size() == 0){
					for(int a=0; a<entityenemy.size(); a++){
					if(entityEnemy.getCurX()< -100){
						entityEnemy.removeSprite();
						
					}}
					}
					*/
				if(Game.AspSprMainchar.getX()> 130)
				
				{
					
					isMapMove = true;
					
				}
				
				if(entityMc.getMcStateCurrent()==MC_STATE_FLY)
				{
					GameScore++;
				}
				if(entityMc.getMcStateCurrent()==MC_STATE_DIE){
					//Game.SprImgGameplayBackground.setPosition(0, 0);
				}
				TxtScore.setText(" " + GameScore);
				entityMc.mcUpdate();
				if(isMapMove)
				{
					if(entityObstacleList.size()>0){
					for(int i = 0; i < entityObstacleList.size(); i++)
					{
						float LastX = entityObstacleList.get(i).getCurX();
						float LastY = entityObstacleList.get(i).getCurY();
						float MapX = entityObstacleList.get(i).getMapX();
						LastX = LastX - SPEED * arg0;
						entityObstacleList.get(i).setPosition(LastX, LastY);
					}
					
					}
					for(int i = 0; i < entitySiluetList.size(); i++)
					{
						float LastX = entitySiluetList.get(i).getCurX();
						float LastY = entitySiluetList.get(i).getCurY();
						LastX = LastX - (SPEED/2) * arg0;
						entitySiluetList.get(i).setPosition(LastX, LastY);
					}
					
					for (int i = 0; i < entityObstacleList.size(); i++)
					{	
						if(entityMc.getMcStateCurrent()==MC_STATE_FLY)
						
							if(entityMc.getRctMc().collidesWith(entityObstacleList.get(i).getRctA())
								|| entityMc.getRctMc().collidesWith(entityObstacleList.get(i).getRctB()))
						{
							entityMc.switchMcState(MC_STATE_DIE);
							if(StateMenumain.isSoundEnable){
								Game.bgm_gelembung_pecah.play();
								}
						}
						
					
					}
					for (int i = 0; i < entityenemy.size(); i++)
					{	
						if(entityMc.getMcStateCurrent()==MC_STATE_FLY)
						
							if(entityMc.getRctMc().collidesWith(entityenemy.get(i).getRctEnemy()))
							{
								entityMc.switchMcState(MC_STATE_DIE);
								if(StateMenumain.isSoundEnable){
									Game.bgm_gelembung_pecah.play();
									}
							}
						
					
					}
					
					
						for(int i = 0; i < entityOtherList.size(); i++)
						{
							float LastX = entityOtherList.get(i).getCurX();
							float LastY = entityOtherList.get(i).getCurY();
							float MapX = entityOtherList.get(i).getMapX();
//							LastX -= MC_MOVE_FAR[0]+1;
							LastX = LastX - SPEED * arg0* 2.5f;
							entityOtherList.get(i).setPosition(LastX, LastY);
						}
						
						for(int i = 0; i < entityAwanList.size(); i++)
						{
							float LastX = entityAwanList.get(i).getCurX();
							float LastY = entityAwanList.get(i).getCurY();
//							LastX += MC_MOVE_FAR[0];
							LastX = LastX + (SPEED/4) * arg0;
							entityAwanList.get(i).setPosition(LastX, LastY);
						}
						
						
						if(entityenemy.size()>0)
							for(int i = 0; i < entityenemy.size(); i++)
							{
								float LastX = entityenemy.get(i).getCurX();
								float LastY = entityenemy.get(i).getCurY();
								float MapX = entityenemy.get(i).getMapX();
								if(entityenemy.get(i).getCurX() < -100){
									LastX = LastX - SPEED * arg0 * 0.5f;
//									LastX = -200;
								}else{
									LastX = LastX - SPEED * arg0 * 2f;
//									LastX -= MC_MOVE_FAR[0]+(1/2);
									}
								//LastY += MC_MOVE_FAR[1];
								//LastX += MC_MOVE_FAR[1] + Utils.getRandomValue(-3, 10);
								entityenemy.get(i).setPosition(LastX, LastY);
							}
						
				}
					
					//SmcMainCamera.setCenter(
						//	SmcMainCamera.getCenterX()+ (arg0 * 10), 
						//SmcMainCamera.getCenterY());
				
				
				
				if(getHigherAwan()>=0){
					newAwan();
				}
				// Check if Mc collide with obstacle
				
				
				
				
				int UnUsedObstacleId = -1;
				for(int i = 0; i < entityOtherList.size(); i++)
				{
					if(entityOtherList.get(i).getCurX()==-200)
					{
						UnUsedObstacleId = i;
					}
					if(UnUsedObstacleId>20)
					{
						entityOtherList.clear();
					}
				}
				
				
				//if(getHigherSiluet()>= 0){
					//newSiluet();
				//}
				
				if(getHigherSiluet()<GAME_SCREEN_WIDTH){
					newSiluet();
				}
				
				
				
				if(gethigherroad()<GAME_SCREEN_WIDTH){
					newRoad();
				}
				if(getHigherCurXofObstacle()<SmcMainCamera.getMaxX()){
					generateNewObstacle();
					}
				
				//
			break;
			case STATE_GAMEPLAY_INGAMEMENU:
				Game.spBtnBackMenu.setPosition(SmcMainCamera.getCenterX()-90, SmcMainCamera.getCenterY()-17);
				Game.spBtnRestart.setPosition(SmcMainCamera.getCenterX()-29, SmcMainCamera.getCenterY()-17);
				Game.spBtnResume.setPosition(SmcMainCamera.getCenterX()+34, SmcMainCamera.getCenterY()-17);
				Game.spBtnPause.setVisible(false);
				Game.spBgGamePause.setPosition(0, 0);
				SprImgGameplayButtonUp.setVisible(false);
				if(StateMenumain.isSoundEnable){
				Game.bgm_Gameplay.pause();
				}
				
			break;
			case STATE_GAMEPLAY_GAMEOVER:
				//Game.spBtnBackMenu.setPosition(SmcMainCamera.getCenterX()+84, SmcMainCamera.getCenterY()+25);
				//Game.spBtnRestart.setPosition(SmcMainCamera.getCenterX()+15, SmcMainCamera.getCenterY()+25);
				//Game.spBtnResume.setPosition(SmcMainCamera.getCenterX()-50, SmcMainCamera.getCenterY()+25);
				
			break;
		}
	}
	
	
	int getHigherCurXofObstacle()
	{
		int HigherValue = 0;
		for(int i = 0; i < entityObstacleList.size(); i++)
		{
			if(HigherValue< entityObstacleList.get(i).getCurX() || HigherValue > getHigherEnemy())
			{
				HigherValue = (int) entityObstacleList.get(i).getCurX();	
				} else{
					HigherValue = getHigherEnemy();
				}
		}
		return HigherValue;
	}
	
	int gethigherroad(){
		int roadhigher = 0;
		for(int i = 0; i < entityOtherList.size(); i++)
		{
			if(roadhigher< entityOtherList.get(i).getCurX())
			{
				roadhigher = (int) entityOtherList.get(i).getCurX();
			}
		}
		
		return roadhigher;
	}
	
	int getHigherEnemy(){
		int enemyHigher = 0;
		for(int i = 0; i < entityenemy.size(); i++){
			if(enemyHigher < entityenemy.get(i).getCurX()){
				enemyHigher = (int) entityenemy.get(i).getCurX();
			}
			
		}
			return enemyHigher;	
	}
	
	int getHigherAwan(){
		int AwanHigher = 0;
		for(int i = 0; i < entityAwanList.size(); i++){
			if(AwanHigher > entityAwanList.get(i).getCurX()){
				AwanHigher = (int) entityAwanList.get(i).getCurX();
			}
			
		}
			return AwanHigher;	
	}
	
	int getHigherSiluet(){
		int SiluetHigher = 0;
		for(int i = 0; i < entitySiluetList.size(); i++){
			if(SiluetHigher < entitySiluetList.get(i).getCurX()){
				SiluetHigher = (int) entitySiluetList.get(i).getCurX();
			}
			
		}
			return SiluetHigher;	
		
	}
	
	void Detach(){
	//HudMainHud.getLastChild().detachChild(SprGameover);
	//HudMainHud.getLastChild().detachChild(SprImgGameplayButtonUp);
		SprGameover.setVisible(false);
		SprImgGameplayButtonUp.setVisible(false);
		Game.spBtnPause.setVisible(false);
		//TxtHighScore.setText(" " + GameScore);
		//TxtHighScore.setVisible(true);
		
		HudMainHud.getFirstChild().attachChild(Game.spBtnRestart);
		HudMainHud.getFirstChild().attachChild(Game.spBtnBackMenu);
	}
	
	void newEnemy(){
		
		int newX = Utils.getRandomValue(350, 400);
		//int newY = Utils.getRandomValue(OBSTACLE_POS_Y_MIN_MAX[0], OBSTACLE_POS_Y_MIN_MAX[1]);
		int newY = Utils.getRandomValue(5, 40);
		float lastScenePosX = 0;
		// generate position up or down
		
		// Dapatin nilai x terbesar dari data enemy
		if(entityenemy.size()>0)
			lastScenePosX = getHigherCurXofObstacle();

		if(LastObstaclePosX==0)
			newX += 300;
		else
			newX +=lastScenePosX;
		
		LastEnemyPosX = newX;
		LastEnemyPosY = newY;
		
		
		
			AnimatedSprite SprEnemy = new AnimatedSprite(newX, newY, Game.TleSprEnemy);
			SceMainScene.getFirstChild().attachChild(SprEnemy);
			EntityEnemy entityEnemy = new EntityEnemy(SprEnemy, newX, newY, GameScore);
			entityenemy.add(entityEnemy);
			entityEnemy.setAnim();
			
		
		
	}
	
	void newRoad(){
		int newX = 480;
		int newY = 300;
		float lastScenePosX = 0;
		
		// Dapatin nilai x terbesar dari data obstacle
		if(entityOtherList.size()>= 0){
			lastScenePosX = gethigherroad();
		}
		if(LastObstaclePosX==0)
			newX = 0;
		else
			newX +=lastScenePosX;
		
		LastRoadPosX = newX;
		LastRoadPosY = newY;

		// ngecek apa ada obstacle yang udah kelewat batas
		int UnUsedObstacleId = -1;
		for(int i = 0; i < entityOtherList.size(); i++)
		{
			if(entityOtherList.get(i).getCurX()<-320)
			{
				UnUsedObstacleId = i;
			}
		}
		if(UnUsedObstacleId>-1)
		{
			entityOtherList.get(UnUsedObstacleId).setPosition(newX, newY);
		}
		else
		{
			Sprite SprRoad = new Sprite(newX, newY, Game.TreImgJalan.clone());
			SceMainScene.getLastChild().attachChild(SprRoad);
			EntityOther entityOther = new EntityOther(SprRoad, newX, newY, GameScore);
			entityOtherList.add(entityOther);
		}

		
	}
	
	void newAwan(){
		int newX = -480;
		int newY = 5;
		float lastScenePosX = 0;
		
		// Dapatin nilai x terbesar dari data obstacle
		if(entityAwanList.size()> 0){
			lastScenePosX = getHigherAwan();
		}
		if(LastObstaclePosX == 0){
			newX = 0;
		}else{
			newX -=lastScenePosX;}
		
		LastSiluetPosX = newX;
		LastSiluetPosY = newY;

		// ngecek apa ada obstacle yang udah kelewat batas
		int UnUsedObstacleId = -1;
		for(int i = 0; i < entityAwanList.size(); i++)
		{
			if(entityAwanList.get(i).getCurX() > 700)
			{
				UnUsedObstacleId = i;
			}
		}
		if(UnUsedObstacleId>-1)
		{
			entityAwanList.get(UnUsedObstacleId).setPosition(newX, newY);
		}
		else
		{
			Sprite SprAwan = new Sprite(newX, newY, Game.TreImgAwan.clone());
			SceMainScene.getFirstChild().attachChild(SprAwan);
			EntityAwan entityAwan = new EntityAwan(SprAwan, newX, newY);
			entityAwanList.add(entityAwan);
		}	
		
	
	}
	
	void generateNewObstacle()

	{
		int newX = Utils.getRandomValue(OBSTACLE_FAR_MIN_MAX[0], OBSTACLE_FAR_MIN_MAX[1]);
		//int newY = Utils.getRandomValue(OBSTACLE_POS_Y_MIN_MAX[0], OBSTACLE_POS_Y_MIN_MAX[1]);
		int newY = GAME_SCREEN_HEIGHT-20;
		float lastScenePosX = 0;
		// generate position up or down
		//boolean newObstaclePosUp = (Utils.getRandomValue(0, 1)==0)?true : false;

			//newY *= -1; // memindah objek obstacle ke atas
		
		// Dapatin nilai x terbesar dari data obstacle
		if(entityObstacleList.size()>0)
			lastScenePosX = getHigherCurXofObstacle();

		if(LastObstaclePosX==0)
			newX += CenterPoinPos;
		else
			newX +=lastScenePosX;
		
		LastObstaclePosX = newX;
		LastObstaclePosY = newY;

		// ngecek apa ada obstacle yang udah kelewat batas
		
		//if (!newObstaclePosUp){
			//newEnemy();
		//}else{
		int UnUsedObstacleId = -1;
		for(int i = 0; i < entityObstacleList.size(); i++)
		{
			if(entityObstacleList.get(i).getCurX()<-1000)
			{
				UnUsedObstacleId = i;
			}
		}
		if(UnUsedObstacleId>-1)
		{
			entityObstacleList.get(UnUsedObstacleId).setPosition(newX, newY-TINGGI_OBSTACLE[entityObstacleList.get(UnUsedObstacleId).getRectX()]);
			entityObstacleList.get(UnUsedObstacleId).setMapX(GameScore);
		}
		else
		{
			int a = Utils.getRandomValue(0, 13);
			AnimatedSprite SprObstacle = new AnimatedSprite(newX, newY-TINGGI_OBSTACLE[a], Game.TreImgObstacle[a].clone());
			SceMainScene.getLastChild().attachChild(SprObstacle);
			EntityObstacle entityObstacle = new EntityObstacle(SprObstacle, newX, newY-TINGGI_OBSTACLE[a], GameScore, a);
			entityObstacleList.add(entityObstacle);
			newEnemy();
			
		}
		for(int i = 0; i < entityObstacleList.size(); i++)
		{
			Utils.TRACE("Ini " + i + " CurX " + entityObstacleList.get(i).getCurY());
		}
		}
		
	

	void newSiluet(){
		
		int newX = 480;
		int newY = 142;
		float lastScenePosX = 0;
		
		// Dapatin nilai x terbesar dari data obstacle
		if(entitySiluetList.size()> 0){
			lastScenePosX = getHigherSiluet();
		}
		if(LastObstaclePosX == 0){
			newX = 0;
		}else{
			newX +=lastScenePosX;}
		
		LastSiluetPosX = newX;
		LastSiluetPosY = newY;

		// ngecek apa ada obstacle yang udah kelewat batas
		int UnUsedObstacleId = -1;
		for(int i = 0; i < entitySiluetList.size(); i++)
		{
			if(entitySiluetList.get(i).getCurX() < - 500)
			{
				UnUsedObstacleId = i;
			}
		}
		if(UnUsedObstacleId>-1)
		{
			entitySiluetList.get(UnUsedObstacleId).setPosition(newX, newY);
		}
		else
		{
			Sprite SprSiluet = new Sprite(newX, newY, Game.TreImgSiluet.clone());
			SceMainScene.getFirstChild().attachChild(SprSiluet);
			EntitySiluet entitySiluet = new EntitySiluet(SprSiluet, newX, newY);
			entitySiluetList.add(entitySiluet);
		}
	}
	
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	void initGame()
	{
		
		
		if(SprGameScore==null)
		{
			SprGameScore = new Sprite(TXT_SCORE_POS[0]
					, TXT_SCORE_POS[1]
					, Game.TreImgScore);
			HudMainHud.getFirstChild().attachChild(SprGameScore);
		}
		SprGameScore.setVisible(true);
		
		if(TxtScore==null)
		{
			TxtScore = new ChangeableText(TXT_SCORE_POS[0]+15
					, TXT_SCORE_POS[1]+24
					, Game.FntSmall, "     ");
			HudMainHud.getFirstChild().attachChild(TxtScore);
		}
		
		if(sprBgHeighScore==null){
		sprBgHeighScore = new Sprite(0, 0, Game.TreImgGameHighScore);
		HudMainHud.getLastChild().attachChild(sprBgHeighScore);
		}
		sprBgHeighScore.setVisible(false);
		// inisialisasi gameover
		if(SprGameover==null)
		{
			SprGameover = new Sprite(SmcMainCamera.getCenterX()-204
					, 10
					, Game.TreImgGameOver);
			HudMainHud.getFirstChild().attachChild(SprGameover);
		}
		SprGameover.setVisible(false);
		if(entityMc==null)
		{
			entityMc = new EntityMc(Game.AspSprMainchar
					, 0, GAME_SCREEN_HEIGHT>>1
					, 0);
			SceMainScene.getLastChild().attachChild(Game.AspSprMainchar);
			
		}
		
		
		//New training
		//if(entityMc==null)
		//{
			//entityMc = new EntityMc(Game.AspSprMainchar
			//		, 0, GAME_SCREEN_HEIGHT>>1
			//		, 0);
			//SceMainScene.getLastChild().attachChild(Game.AspSprMainchar);
			
		//}
		
		
		//entityMc.setPosition(Game.SprImgGameplayBackground.getX(), GAME_SCREEN_HEIGHT>>1);
		entityMc.setMapX(0);
		entityMc.switchMcState(MC_STATE_IDLE);
		
		
		isMapMove = false;
		CenterPoinPos	= (int) ((GAME_SCREEN_WIDTH>>1)-entityMc.getAspMc().getWidth());
		if(isNewEnterHere)
		{
			GameScore = 0;
			isNewEnterHere = false;
			SprImgGameplayButtonUp = new AnimatedSprite(BUTTON_UP_POS[0]
					, BUTTON_UP_POS[1]
					, Game.TreImgGameplayButtonUp);
			HudMainHud.getFirstChild().attachChild(SprImgGameplayButtonUp);
			SceMainScene.getFirstChild().attachChild(Game.SprImgGameplayBackground);
			//SceMainScene.getFirstChild().attachChild(Game.SprImgGameplayBackground2);
			HudMainHud.getFirstChild().attachChild(Game.spBtnPause);
			//SceMainScene.getFirstChild().attachChild(Game.AspSprEnemy);
		
		}
		
		
		
		//Terhapus
	/*
		for(int i = 0; i < entityObstacleList.size(); i++)
		{
			if(entityObstacleList.get(i).getCurX()<CenterPoinPos)
				entityObstacleList.get(i).setCurX(-100);
		}
		
		*/
	}
	boolean newGameOver = false;
	boolean HighScore = false;
	public void switchState(int NewState)
	{
		StateCurrent = NewState;
		switch(StateCurrent)
		{
			case STATE_GAMEPLAY_LOADING:
				SceMainScene.getLastChild().attachChild(spr_loading);
				Game.loadFontMedium();
				TxtLoading = new ChangeableText(0, 0, Game.FntMedium, "Loading...");
				TxtLoading.setPosition(400
						, 300);
				HudMainHud.getLastChild().attachChild(TxtLoading);
				Loading.setLoadingType(Loading.LOADING_TYPE_GAMEPLAY);
			break;
			case STATE_GAMEPLAY_INGAME:
				initGame();
				HudMainHud.getLastChild().detachChild(TxtLoading);
				SceMainScene.getLastChild().detachChild(spr_loading);
				TxtLoading.setVisible(false);
				if(StateMenumain.isSoundEnable)
				{
					Game.bgm_Gameplay.play();												
				}
				//SceMainScene.getFirstChild().attachChild(Game.spBtnPause);
			break;
			case STATE_GAMEPLAY_INGAMEMENU:
				SceMainScene.getLastChild().attachChild(Game.spBgGamePause);
				SceMainScene.getLastChild().attachChild(Game.spBtnResume);
				SceMainScene.getLastChild().attachChild(Game.spBtnRestart);
				SceMainScene.getLastChild().attachChild(Game.spBtnBackMenu);
				
				//SprImgGameplayButtonUp.setVisible(false);
			break;
			case STATE_GAMEPLAY_GAMEOVER:
				//teruskan 
				
				SprImgGameplayButtonUp.setVisible(false);
				Game.spBtnPause.setVisible(false);
				//newGameOver = true;
				Game.bgm_Gameplay.stop();
				SprGameover.setVisible(true);
				//if(scoreDb.isHighScore((int)GameScore)){

					//SceMainScene.getLastChild().attachChild(Game.spBtnBackMenu);
				//	HighScore = true; 
				//}

				
			break;
		}
	}
	public void loadLoading()
	{
		txt_loading = new Texture(512, 512);
		txtr_loading = TextureRegionFactory.createFromAsset(txt_loading, this, 
				Data.IMG_LOADING, 0, 0);
		spr_loading = new Sprite(0, 0, txtr_loading);
		
	}
	
	
	public void submitScore(){
		editText.setTextSize(20f);
        editText.setText(_instance.mValue);
        editText.setGravity(Gravity.CENTER_HORIZONTAL);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
		builder.setTitle("SUBMIT SCORE")
				.setMessage("Input Your Name :")
		       .setCancelable(false)
		       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {

		           }
		       })
		       .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   
		        	   mValue = editText.getText().toString();
		        	   
		                dialog.cancel();
		                //score offline
		                scoreDb.insertScore((int)GameScore);
		                scoreDb.insertNama(mValue);
		                
		                
		               // Intent score =
								//new Intent(StateGameplay.this,
								//	State_IntroMenu.class);
							//startActivity(score);
							//StateGameplay.this.finish();
		           }
		       });
		
        builder.setView(editText);
       
		alert = builder.create();
		
		alert.show();
		
		
		
	}
		
	void showIngameMenu(boolean onGamePlay)
	{
		Utils.TRACE("Burhan :: dafuq");
		if(onGamePlay)
		{

		}
		else
		{
			SceMainScene.getLastChild().detachChild(Game.spBgGamePause);
			SceMainScene.getLastChild().detachChild(Game.spBtnResume);
			SceMainScene.getLastChild().detachChild(Game.spBtnRestart);
			SceMainScene.getLastChild().detachChild(Game.spBtnBackMenu);
			SceMainScene.unregisterTouchArea(Game.spBtnRestart);
			SceMainScene.unregisterTouchArea(Game.spBtnBackMenu);
			SceMainScene.unregisterTouchArea(Game.spBtnResume);
			
		}
	}
		
		//burhan untuk load sound
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == event.KEYCODE_BACK)
		{
			Intent intent = new Intent(
					this,
					StateMenumain.class);
			startActivity(intent);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
}
