package com.amikomgamedev.bubblefish.state;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.SmoothCamera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.amikomgamedev.bubblefish.Config;
import com.amikomgamedev.bubblefish.Data;
import com.amikomgamedev.bubblefish.Define;

import android.graphics.Color;

public class StateAbout extends BaseGameActivity implements Data, Config,
Define{
	
	
	
	
	private HUD hudMenu;
	private Scene scene;
	private Font font;
	private Texture textureFont;
	private Camera camera;
	private Text txt,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,
					txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,
					txt19,txt20,txt21,txt22,txt23,txt24,txt25,txt26,txt27,txt28,txt29;
	private float y;
	private Texture textureLogo;
	private TextureRegion regAgd, regAmikom;
	private Sprite spAgd,spAmikom;
	private Texture textureBg;
	private TextureRegion regBg;
	private Sprite spBG;
	
	public static SmoothCamera SmcMainCamera;

	//untuk TouchEvent
	private boolean teken=false;
	private float firstPosText = 0;
	private float firstTouch = 0;
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
		textureBg = new Texture(1024, 1024, TextureOptions.BILINEAR);
		regBg = TextureRegionFactory.createFromAsset
						(textureBg, this, "gfx/menu/img/control.png",0, 0);
		textureFont = new Texture(512, 512);
		font = FontFactory.createFromAsset(textureFont, this,"fnt/ActionMan.ttf",20, true, Color.BLACK);
		mEngine.getTextureManager().loadTexture(textureFont);
		mEngine.getFontManager().loadFont(font);
		
	}

	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		return null;
	}


}
