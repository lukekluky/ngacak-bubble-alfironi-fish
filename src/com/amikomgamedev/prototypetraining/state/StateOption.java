package com.amikomgamedev.prototypetraining.state;

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

import com.amikomgamedev.prototypetraining.Config;
import com.amikomgamedev.prototypetraining.Data;
import com.amikomgamedev.prototypetraining.Define;
import com.amikomgamedev.prototypetraining.Game;

public class StateOption extends BaseGameActivity implements Data, IUpdateHandler, Config,
Define {
	
	public static BaseGameActivity _instance;
	private Texture mBackground;
	private TextureRegion mBackgroundTextureRegion;
	public static SmoothCamera SmcMainCamera;
	
	
	private TiledTextureRegion regBtnVib, regBtnSound;
	private Texture textureBtn;
	private AnimatedSprite spBtnVib, spBtnSound;
	private Sprite mBG;
	
	public static boolean isSoundEnable = true;
	
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
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
		mBackground =
				new Texture(1024, 2048, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		TextureRegionFactory.setAssetBasePath(Data.IMG_MENU_FOLDER_PATH);
		
		mBackgroundTextureRegion =
				TextureRegionFactory.createFromAsset(mBackground, this,
					"menubg.png", 0, 0);
		textureBtn = new Texture(256, 512);
		
		regBtnSound =
				TextureRegionFactory.createTiledFromAsset(textureBtn, this,
					"spritebtsound.png", 0, 0, 3, 1);
		
		regBtnVib =
				TextureRegionFactory.createTiledFromAsset(textureBtn, this,
					"spritebtvib.png", 0, 90, 3, 1);
		
		this.mEngine.getTextureManager().loadTextures(mBackground, textureBtn);
		
	}

	public Scene onLoadScene() {
		final Scene scene = new Scene(2);
		mBG = new Sprite(0, 0, mBackgroundTextureRegion);
		scene.setBackground(new SpriteBackground(mBG));
		
		mEngine.registerUpdateHandler(this);

		spBtnSound = new AnimatedSprite(
				((GAME_SCREEN_WIDTH >> 1)-100)
				, ((GAME_SCREEN_HEIGHT>>1)), regBtnSound)
								{
								public boolean onAreaTouched(TouchEvent pSceneTouchArea,
														float pTouchLocalAreaX,
														float pTouchLocalAreaY)
									{
									spBtnSound.animate(new long[]
										{80, 80}, 1, 2, false);
												if (pSceneTouchArea.isActionUp())
												{
//													Intent start =
//														new Intent(StateOption.this,
//															StateOption.class);
//													startActivity(start);
													if(isSoundEnable)
													{
														isSoundEnable = false;
														Game.bgm_Gameplay.pause();
														Game.bgm_Gameplay.seekTo(0);
													}
													else
													{
														isSoundEnable = true;
														Game.bgm_Gameplay.play();
													}
													
													
													spBtnSound.animate(new long[]
															{80, 80}, 2, 3, false);
												}
												return true;
											}
										};
										
										spBtnVib =new AnimatedSprite(((GAME_SCREEN_WIDTH >> 1)+20),(GAME_SCREEN_HEIGHT>>1) ,
				regBtnVib)
								{
					public boolean onAreaTouched(TouchEvent pSceneTouchArea,
										float pTouchLocalAreaX,
										float pTouchLocalAreaY)
										{
						spBtnVib.animate(new long[]
											{80, 80}, 1, 2, false);
										if (pSceneTouchArea.isActionUp())
														{
														Intent start =
																		new Intent(StateOption.this,
																		StateOption.class);
																	startActivity(start);
																	spBtnVib.animate(new long[]
																	{80, 80}, 2, 3, false);
																	}
															return true;
														}};

		scene.getFirstChild().attachChild(spBtnSound);
		scene.getFirstChild().attachChild(spBtnVib);
		
		scene.setTouchAreaBindingEnabled(true);

		scene.registerTouchArea(spBtnSound);
		scene.registerTouchArea(spBtnVib);
		
		return scene;
								
	}

	public void onUpdate(float arg0) {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

}