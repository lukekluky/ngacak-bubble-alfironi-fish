package com.amikomgamedev.bubblefish.state;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.SmoothCamera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.content.Intent;
import android.view.KeyEvent;


import com.amikomgamedev.bubblefish.Config;
import com.amikomgamedev.bubblefish.Data;
import com.amikomgamedev.bubblefish.Define;
import com.amikomgamedev.bubblefish.Game;

public class StateMenumain extends BaseGameActivity implements Data, IUpdateHandler, Config,
Define {
	
	public static BaseGameActivity _instance;
	private Texture mBackground;
	private TextureRegion mBackgroundTextureRegion;
	public static SmoothCamera SmcMainCamera;
	



	// animated sprite
	
	private TiledTextureRegion regBtnCredit, regBtnStart, regBtnScore,regBtnSetting, regBtnHelp;
	private Texture textureBtn;
	private AnimatedSprite spBtnStart, spBtnCredit, spBtnScore, spBtnSetting, spBtnHelp;
	private float y;
	private Sprite mBG;
	public static boolean isSoundEnable = true;
	
	public void onLoadComplete() {
		// TODO Auto-generated metho stub
		
	}

	public Engine onLoadEngine() {
		SmcMainCamera =
				new SmoothCamera(0, 0, GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT,
						GAME_SCREEN_WIDTH / 3, GAME_SCREEN_HEIGHT, 30);
		
			
			Engine en =
				new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
					new RatioResolutionPolicy(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT),
					SmcMainCamera).setNeedsSound(true).setNeedsMusic(true));
			return en;
	}

	public void onLoadResources() {
		Game.setContext(this);
		Game.loadSoundGamePlay2();
		mBackground =
				new Texture(1024, 2048, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		TextureRegionFactory.setAssetBasePath(Data.IMG_MENU_FOLDER_PATH);
		
		mBackgroundTextureRegion =
				TextureRegionFactory.createFromAsset(mBackground, this,
					"menubg.png", 0, 0);
		textureBtn = new Texture(512, 512);
		
		
		regBtnStart =
			TextureRegionFactory.createTiledFromAsset(textureBtn, this,
				"btn_spPlay.png", 0, 0, 3, 1);

		regBtnCredit =
			TextureRegionFactory.createTiledFromAsset(textureBtn, this,
				"btn_spCredit.png", 0, 120, 3, 1);

		regBtnScore =
			TextureRegionFactory.createTiledFromAsset(textureBtn, this,
				"btn_spScore.png", 0, 200, 3, 1);
		
		regBtnHelp =
				TextureRegionFactory.createTiledFromAsset(textureBtn, this,
					"btn_spHelp.png", 0, 300, 3, 1);
		
		regBtnSetting =
				TextureRegionFactory.createTiledFromAsset(textureBtn, this,
					"btn_spSetting.png", 0, 400, 5, 1);
		
		this.mEngine.getTextureManager().loadTextures(mBackground, textureBtn);
		
	}

	public Scene onLoadScene() {

		if(StateMenumain.isSoundEnable)
		{
				
				Game.bgm_Menu.play();												
		}
		final Scene scene = new Scene(2);
		mBG = new Sprite(0, 0, mBackgroundTextureRegion);
		scene.setBackground(new SpriteBackground(mBG));
		
		mEngine.registerUpdateHandler(this);
		
		spBtnStart =
				new AnimatedSprite(
						((GAME_SCREEN_WIDTH>>1) - (regBtnStart.getTileWidth()>>1)), (GAME_SCREEN_HEIGHT>>1) + 10,
					regBtnStart)
				{
					public boolean onAreaTouched(TouchEvent pSceneTouchArea,
													float pTouchLocalAreaX,
													float pTouchLocalAreaY)
					{
						if(pSceneTouchArea.isActionDown())
						{
						spBtnStart.animate(new long[]
							{
								250, 250
							}, 1, 2, false);
						}
						if (pSceneTouchArea.isActionUp())
						{
							spBtnStart.animate(new long[]
									{
										250, 250
									}, 2, 3, false);
							Intent start =
								new Intent(StateMenumain.this,
									StateGameplay.class);
							startActivity(start);
							finish();
							
						}
						return true;
					}
				};
				
				
		spBtnCredit =
				new AnimatedSprite(((GAME_SCREEN_WIDTH >> 1)+120), (GAME_SCREEN_HEIGHT>>1) + 20,
							regBtnCredit)
						{
							public boolean onAreaTouched(TouchEvent pSceneTouchArea,
															float pTouchLocalAreaX,
															float pTouchLocalAreaY)
							{

								spBtnCredit.animate(new long[]
									{
										80, 80
									}, 1, 2, false);

								if (pSceneTouchArea.isActionUp())
								{
									Intent credit =
										new Intent(StateMenumain.this,
											StateCredit.class);
									startActivity(credit);
									finish();
									spBtnCredit.animate(new long[]
											{
												80, 80
											}, 2, 3, false);
								}
								return true;
							}
						};
	
		spBtnScore =
		new AnimatedSprite((GAME_SCREEN_WIDTH - (GAME_SCREEN_WIDTH - 100)) - regBtnStart.getHeight() / 2, (GAME_SCREEN_HEIGHT>>1) + 20, regBtnScore)
								{
									public boolean onAreaTouched(TouchEvent pSceneTouchArea,
																	float pTouchLocalAreaX,
																	float pTouchLocalAreaY)
									{
										spBtnScore.animate(new long[]
											{
												80, 80
											}, 1, 2, false);
										if (pSceneTouchArea.isActionUp())
										{
											Intent score =
												new Intent(StateMenumain.this,
													StateHighscore.class);
											startActivity(score);
											finish();
											spBtnScore.animate(new long[]
													{
														80, 80
													}, 2, 3, false);

										}

										return true;
									}
								};
								
	
		spBtnHelp = new AnimatedSprite(
				(regBtnStart.getTileWidth()>>1)
				, (GAME_SCREEN_HEIGHT>>1) - 80, regBtnHelp)
								{
								public boolean onAreaTouched(TouchEvent pSceneTouchArea,
														float pTouchLocalAreaX,
														float pTouchLocalAreaY)
									{
									spBtnHelp.animate(new long[]
										{80, 80}, 1, 2, false);
												if (pSceneTouchArea.isActionUp())
												{
													Intent start =
														new Intent(StateMenumain.this,
															StateHelp.class);
													startActivity(start);
													finish();
													spBtnHelp.animate(new long[]
															{80, 80}, 2, 3, false);
												}
												return true;
											}
										};
										
		spBtnSetting =new AnimatedSprite(((GAME_SCREEN_WIDTH >> 1)+100),(GAME_SCREEN_HEIGHT>>1) - 80,
							regBtnSetting)
								{
					public boolean onAreaTouched(TouchEvent pSceneTouchArea,
										float pTouchLocalAreaX,
										float pTouchLocalAreaY)
										{
						
						//if(isSoundEnable = false){
							//spBtnSetting.animate(new long[]
								//	{250, 250}, 1, 2, false);
						//}
						
										if (pSceneTouchArea.isActionUp())
														{
											
												if(isSoundEnable)
												{
													isSoundEnable = false;
													Game.bgm_Menu.pause();
													Game.bgm_Menu.seekTo(0);
													spBtnSetting.animate(new long[]
															{250, 250}, 1, 2, false);
												}
												else
												{
													isSoundEnable = true;
													Game.bgm_Menu.play();
													spBtnSetting.animate(new long[]
															{250, 250, 250}, 3, 5, false);
												}		
																											}
															return true;
														}};
	
		scene.getLastChild().attachChild(spBtnStart);
		scene.getFirstChild().attachChild(spBtnCredit);
		scene.getFirstChild().attachChild(spBtnScore);
		scene.getFirstChild().attachChild(spBtnHelp);
		scene.getFirstChild().attachChild(spBtnSetting);
		
		scene.setTouchAreaBindingEnabled(true);
		
		scene.registerTouchArea(spBtnStart);
		scene.registerTouchArea(spBtnCredit);
		scene.registerTouchArea(spBtnScore);
		scene.registerTouchArea(spBtnHelp);
		scene.registerTouchArea(spBtnSetting);
		
		return scene;
								
	}

	public void onUpdate(float arg0) {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == event.KEYCODE_BACK)
		{
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
