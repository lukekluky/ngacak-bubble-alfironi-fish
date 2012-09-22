package com.amikomgamedev.prototypetraining.state;

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
import android.view.KeyEvent;

import com.amikomgamedev.prototypetraining.state.StateSplashscreen;
import com.amikomgamedev.prototypetraining.state.StateGameplay;
import com.amikomgamedev.prototypetraining.Utils;
import com.amikomgamedev.prototypetraining.Data;
import com.amikomgamedev.prototypetraining.Define;

public class StateSplashscreen extends BaseGameActivity implements Data, Define {
	
	protected Camera m_Camera;

	protected Scene m_MainScene;
	public static final int SCREEN_WIDTH = 320;
	public static final int SCREEN_HEIGHT = 480;
	public static Texture txt_Logo;
	public static TextureRegion txtr_Logo;
	private Sprite spr_logo;

	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

	public Engine onLoadEngine() {
		m_Camera = new Camera(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		Engine en =
			new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT,
				new RatioResolutionPolicy(SCREEN_WIDTH, SCREEN_HEIGHT),
				m_Camera));
		return en;
	}

	public void onLoadResources() {
		txt_Logo =
				new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			try
			{
				txtr_Logo =
					TextureRegionFactory.createFromAsset(txt_Logo, this,
						Data.IMG_AGD_LOGO_PATH, 0, 0);
			}
			catch (Exception e)
			{
				Utils.TRACE(e);
			}
			mEngine.getTextureManager().loadTexture(txt_Logo);
	}

	public Scene onLoadScene() {

		this.mEngine.registerUpdateHandler(new FPSLogger());

		m_MainScene = new Scene(1);
		m_MainScene.setBackground(new ColorBackground(0xff, 0xff, 0xff));
		
		int centerX = (SCREEN_WIDTH >> 1) - (txtr_Logo.getWidth() >> 1);
		int centerY = (SCREEN_HEIGHT >> 1) - (txtr_Logo.getHeight() >> 1);
		spr_logo = new Sprite(centerX, centerY, txtr_Logo);
		m_MainScene.getLastChild().attachChild(spr_logo);

		this.mEngine.registerUpdateHandler(new TimerHandler(3 ,
			new ITimerCallback()
			{

				
				public void onTimePassed(TimerHandler arg0)
				{
					// TODO Auto-generated method stub
					FadeOutModifier prFadeOutModifier =
						new FadeOutModifier(0.5f, new IEntityModifierListener()
						{
							
							public
										void
										onModifierFinished(	IModifier<IEntity> pModifier,
															IEntity pItem)
							{

								Intent intent =
									new Intent(StateSplashscreen.this,
										State_IntroMenu.class);
								startActivity(intent);
								finish();

							}
						}, EaseLinear.getInstance());
					spr_logo.setBlendFunction(GL10.GL_SRC_ALPHA,
						GL10.GL_ONE_MINUS_SRC_ALPHA);
					spr_logo.registerEntityModifier(prFadeOutModifier);
				}
			}));
		
		

		return m_MainScene;
	
	}
	
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent)
	{
		if (pKeyCode == KeyEvent.KEYCODE_BACK)
		{
			// If back is pressed than nothing happens
			return true;
		}
		else
		{
			return super.onKeyDown(pKeyCode, pEvent);
		}
	}
	

}
