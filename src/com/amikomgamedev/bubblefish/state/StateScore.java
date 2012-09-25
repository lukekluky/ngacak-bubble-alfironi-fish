package com.amikomgamedev.BubbleFish.state;

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
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.EditText;



import com.amikomgamedev.BubbleFish.Config;
import com.amikomgamedev.BubbleFish.Data;
import com.amikomgamedev.BubbleFish.Define;
import com.amikomgamedev.BubbleFish.Game;
import com.amikomgamedev.BubbleFish.Loading;
import com.amikomgamedev.BubbleFish.ScoreDb;
import com.amikomgamedev.BubbleFish.Utils;

public class StateScore extends BaseGameActivity implements Data, IUpdateHandler, Config,
Define
{
	public static BaseGameActivity _instance;
	public static SmoothCamera SmcMainCamera;
	private Sprite mBG;
	public static AnimatedSprite spBtnRestart;
	public static AnimatedSprite spBtnBackMenu;	
	ChangeableText  highScore,TxtHighScore,high;
	private  ScoreDb scoreDb;
	private EditText editText;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	private String mValue;
	
	public void onLoadComplete() {
		
		
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
	
	this.mEngine.getTextureManager().loadTextures(Game.TexImgGameHighScore, Game.txtr_btnBackMenu, Game.txtr_btnRestart);
	
	//Game.loadFontMedium();
	//Game.loadFontBig();
	mEngine.getTextureManager().loadTextures(Game.TexFontMedium, Game.TexFontBig);
	mEngine.getFontManager().loadFont(Game.FntMedium);
	mEngine.getFontManager().loadFont(Game.FntBig);
	scoreDb = new ScoreDb(this);
	scoreDb.CreateTable();
	Game.loadSoundGamePlay();
	}

	public Scene onLoadScene() {
		final Scene scene = new Scene(2);
		mBG = new Sprite(0, 0, Game.TreImgGameHighScore);
		scene.setBackground(new SpriteBackground(mBG));
		mEngine.registerUpdateHandler(this);
		editText = new EditText(this);
		builder = new AlertDialog.Builder(this);
		if(scoreDb.isHighScore((int)StateGameplay.GameScore)){
			submit();
		}
		
		spBtnRestart = new AnimatedSprite(SmcMainCamera.getCenterX()+15, SmcMainCamera.getCenterY()+25, Game.regBtnRestart)
								{
								public boolean onAreaTouched(TouchEvent pSceneTouchArea,
														float pTouchLocalAreaX,
														float pTouchLocalAreaY)
									{
									//Game.bgm_Gameplay.stop();
									spBtnRestart.animate(new long[]
										{80, 80}, 1, 2, false);
												if (pSceneTouchArea.isActionUp())
												{
													Intent start = new Intent(StateScore.this, StateGameplay.class);
													startActivity(start);
								
													finish();
													spBtnRestart.animate(new long[]
															{80, 80}, 2, 3, false);
												}
												return true;
											}
										};
										
		spBtnBackMenu =new AnimatedSprite(SmcMainCamera.getCenterX()+84, SmcMainCamera.getCenterY()+25 ,Game.regBtnBackMenu)
								{
					public boolean onAreaTouched(TouchEvent pSceneTouchArea,
										float pTouchLocalAreaX,
										float pTouchLocalAreaY)
										{
						spBtnBackMenu.animate(new long[]
											{80, 80}, 1, 2, false);
										if (pSceneTouchArea.isActionUp())
											{
										Intent start = new Intent(StateScore.this, StateMenumain.class);
										startActivity(start);
										
										finish();
										spBtnBackMenu.animate(new long[]
										{80, 80}, 2, 3, false);
										}
								return true;
														}
					
								};

		TxtHighScore = new ChangeableText((GAME_SCREEN_WIDTH>>1)+10, (GAME_SCREEN_HEIGHT>>1)-45, Game.FntBig, " " + StateGameplay.GameScore);
		high = new ChangeableText((GAME_SCREEN_WIDTH>>1)-20,10, Game.FntMedium, "HighScore");
		highScore = new ChangeableText((GAME_SCREEN_WIDTH>>1)+120, 10, Game.FntMedium, " "+ scoreDb.getLatestScore());
		
		scene.getFirstChild().attachChild(TxtHighScore);
		scene.getFirstChild().attachChild(high);
		scene.getFirstChild().attachChild(highScore);					
		scene.getFirstChild().attachChild(spBtnRestart);
		scene.getFirstChild().attachChild(spBtnBackMenu);
		scene.setTouchAreaBindingEnabled(true);

		scene.registerTouchArea(spBtnRestart);
		scene.registerTouchArea(spBtnBackMenu);
		
		
		return scene;
		
		
	}

	public void onUpdate(float arg0) {

		
	}

	public void reset() {
		
		
	}

	void submit(){
		editText.setTextSize(20f);
		editText.setText(StateScore.this.mValue);
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
		                scoreDb.insertScore((int)StateGameplay.GameScore);
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
