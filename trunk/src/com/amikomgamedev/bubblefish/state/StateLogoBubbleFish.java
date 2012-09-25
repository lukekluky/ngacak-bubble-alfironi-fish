package com.amikomgamedev.BubbleFish.state;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.FadeOutModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.ease.EaseLinear;

import android.content.Intent;
import android.graphics.Color;

import com.amikomgamedev.BubbleFish.Config;
import com.amikomgamedev.BubbleFish.Data;

public class StateLogoBubbleFish extends BaseGameActivity implements Config, Data{
	private Camera mCamera;
	private Scene mMainScene;
	private static Texture txtLogo;
	private static TextureRegion txtrLogo;
	private Sprite sprLogo;
	
	public void onLoadComplete() {
		
		
	}

	public Engine onLoadEngine() {
		mCamera = new Camera(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		Engine engine = new Engine(new EngineOptions(true,
				ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(
						SCREEN_WIDTH, SCREEN_HEIGHT), mCamera));
		return engine;
	}

	public void onLoadResources() {
		txtLogo = new Texture(512, 512,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		txtrLogo = TextureRegionFactory.createFromAsset(txtLogo, this,
				Data.IMG_BF_LOGO_PATH, 0, 0);

		mEngine.getTextureManager().loadTexture(txtLogo);
		
	}

	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		mMainScene = new Scene(1);
		mMainScene.setBackground(new ColorBackground(0xff, 0xff, 0xff));

		sprLogo = new Sprite(0, 0, txtrLogo);

		mMainScene.getLastChild().attachChild(sprLogo);

		mEngine.registerUpdateHandler(new TimerHandler(LOGO_DURATION,
				new ITimerCallback() {

					public void onTimePassed(TimerHandler arg0) {
						// TODO .Auto-generated method stub
						FadeOutModifier prFadeOutModifier = new FadeOutModifier(
								0.5f, new IEntityModifierListener() {

									public void onModifierFinished(
											IModifier<IEntity> pModifier,
											IEntity pItem) {

										Intent intent = new Intent(
												StateLogoBubbleFish.this,
												State_IntroMenu.class);
										startActivity(intent);
										finish();

									}
								}, EaseLinear.getInstance());
						sprLogo.setBlendFunction(GL10.GL_SRC_ALPHA,
								GL10.GL_ONE_MINUS_SRC_ALPHA);
						sprLogo.registerEntityModifier(prFadeOutModifier);
					}
				}));

		return mMainScene;
	}

}
