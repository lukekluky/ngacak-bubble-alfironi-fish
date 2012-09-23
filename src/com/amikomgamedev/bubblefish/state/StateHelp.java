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

public class StateHelp extends BaseGameActivity implements Data, IUpdateHandler, Config,
Define {
	
	public static BaseGameActivity _instance;
	private Texture mBackground;
	private TextureRegion mBackgroundTextureRegion;
	public static SmoothCamera SmcMainCamera;

	// animated sprite
	
	//private TiledTextureRegion regBtnBack;
	//private Texture textureBtn;
	//private AnimatedSprite spBtnBack;
	private Sprite mBG;
	
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
		Game.setContext(this);
		Game.loadSoundGamePlay();
		mBackground =
				new Texture(1024, 2048, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		TextureRegionFactory.setAssetBasePath(Data.IMG_MENU_FOLDER_PATH);
		
		mBackgroundTextureRegion =
				TextureRegionFactory.createFromAsset(mBackground, this,
					"help.png", 0, 0);
		mEngine.getTextureManager().loadTexture(mBackground);
		
		
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

				
		
		
		//scene.setTouchAreaBindingEnabled(true);
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
			Intent intent = new Intent(
					this,
					StateMenumain.class);
			startActivity(intent);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}