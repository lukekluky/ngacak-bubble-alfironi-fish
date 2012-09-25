package com.amikomgamedev.BubbleFish.state;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.FadeOutModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.ease.EaseLinear;
import android.content.Intent;
import android.graphics.Color;

import com.amikomgamedev.BubbleFish.Data;
import com.amikomgamedev.BubbleFish.Define;


public class State_IntroMenu extends BaseGameActivity implements 
IUpdateHandler, Define, Data {
	
	private int count = 0;
	private int x = 0;
	public static final int moveLen = 20;
	public int moveDelay = GAME_SCREEN_WIDTH/10;
	private Texture texture_Slide;
	private TextureRegion reg_Bg1 = null, reg_Bg2 = null, reg_Bg3 = null,
				reg_Bg4 = null;
	private Sprite spr_Bg1, spr_Bg2, spr_Bg3, spr_Bg4;
	private Scene scene;

	private HUD hud;
	private Camera camera;
	private Texture texture_font;
	private Font font;
	private ChangeableText text;

	public void onLoadComplete() {
		
		
	}

	public Engine onLoadEngine() {
		camera = new Camera(0, 0, GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT);
		final EngineOptions engineOptions =
			new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new FillResolutionPolicy(), camera).setNeedsSound(true);
		engineOptions.getTouchOptions().setRunOnUpdateThread(true);
		return new Engine(engineOptions);
	}

	public void onLoadResources() {
		texture_Slide =
			new Texture(2048, 2048, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			TextureRegionFactory.setAssetBasePath(Data.IMG_MENU_FOLDER_PATH);
			reg_Bg1 =
				TextureRegionFactory.createFromAsset(texture_Slide, this, "1.png",
					0, 0);
			texture_font = new Texture(256, 256);
			font =
				FontFactory.createFromAsset(texture_font, this,
					"fnt/ActionMan.ttf", 20, true, Color.WHITE);
			mEngine.getTextureManager().loadTextures(texture_Slide, texture_font);
			mEngine.getFontManager().loadFont(font);
			hud = new HUD();
			camera.setHUD(hud);
			text = new ChangeableText(400, 300, font, "SKIP")
			{

				public boolean onAreaTouched(TouchEvent pSceneTouchArea,
												float pTouchLocalAreaX,
												float pTouchLocalAreaY)
				{

					if (pSceneTouchArea.isActionUp())
					{

						Intent start =
							new Intent(State_IntroMenu.this, StateMenumain.class);
						startActivity(start);
						finish();
					}
					return true;
				}
			};
			hud.attachChild(text);
			hud.registerTouchArea(text);
			hud.setTouchAreaBindingEnabled(true);
	}

	public Scene onLoadScene() {
		scene = new Scene(1);
		mEngine.registerUpdateHandler(this);
		spr_Bg1 = new Sprite(0, 0, reg_Bg1);
		scene.getLastChild().attachChild(spr_Bg1);
		x = GAME_SCREEN_WIDTH;
		return scene;
	}

	public void onUpdate(float arg0) {
		if (count == 0)
		{
			spr_Bg1.setPosition(0, 0);
			if (reg_Bg2 == null)
			{
				reg_Bg2 =
					TextureRegionFactory.createFromAsset(texture_Slide, this,
						"2.png", 480, 0);
				spr_Bg2 = new Sprite(GAME_SCREEN_WIDTH, 0, reg_Bg2);
				scene.getLastChild().attachChild(spr_Bg2);
			}

		}
		else if (count == 1)
		{
			spr_Bg1.setPosition(x - GAME_SCREEN_WIDTH, 0);
			spr_Bg2.setPosition(x, 0);
			if (reg_Bg3 == null)
				
			{
				reg_Bg3 =
					TextureRegionFactory.createFromAsset(texture_Slide, this,
						"3.png", 0, 480);
				spr_Bg3 = new Sprite(GAME_SCREEN_WIDTH, 0, reg_Bg3);
				scene.getLastChild().attachChild(spr_Bg3);
			}
		}
		else if (count == 2)
		{
			spr_Bg2.setPosition(x - GAME_SCREEN_WIDTH, 0);
			spr_Bg3.setPosition(x, 0);
			if (reg_Bg4 == null)
			{
				reg_Bg4 =
					TextureRegionFactory.createFromAsset(texture_Slide, this,
						"4.png", 640, 480);
				spr_Bg4 = new Sprite(GAME_SCREEN_WIDTH, 0, reg_Bg4);
				scene.getLastChild().attachChild(spr_Bg4);
			}
		}
		else if (count == 3)
		{
			spr_Bg3.setPosition(x - GAME_SCREEN_WIDTH, 0);
			spr_Bg4.setPosition(x, 0);
			
		}
		else if (count == 5)
		{
			spr_Bg4.setPosition(0, 0);
			FadeOutModifier fadeOutModifier =
				new FadeOutModifier(0.5f, new IEntityModifierListener()
				{
					public
								void
								onModifierFinished(	IModifier<IEntity> pModifier,
													IEntity pItem)
					{

						Intent intent =
							new Intent(State_IntroMenu.this,
								StateMenumain.class);
						startActivity(intent);
						finish();

					}
				}, EaseLinear.getInstance());
			spr_Bg4.setBlendFunction(GL10.GL_SRC_ALPHA,
				GL10.GL_ONE_MINUS_SRC_ALPHA);
			spr_Bg4.registerEntityModifier(fadeOutModifier);

		}

		x -= moveLen;
		if (x <= 0)
		{
			x = 0;
			moveDelay--;
			if (moveDelay <= 0)
			{
				moveDelay = GAME_SCREEN_WIDTH / 15;
				x = GAME_SCREEN_WIDTH;
				count++;
			}
		}

	}
		
	

	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
