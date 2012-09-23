package com.amikomgamedev.bubblefish.state;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.R.string;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;

import com.amikomgamedev.bubblefish.Config;
import com.amikomgamedev.bubblefish.Data;
import com.amikomgamedev.bubblefish.Define;
import com.amikomgamedev.bubblefish.ScoreDb;

//import com.amikomgamedev.ScoreDb;
//import com.amikomgamedev.ScoreSvc;
//import com.amikomgamedev.prototypetraining.Define;

public class StateHighscore extends BaseGameActivity implements Config, Define, Data {
	
	private Font font;
	private Texture textureFont;
	private Camera camera;
//	private ChangeableText [] highNama = new ChangeableText[10];
//	private ChangeableText [] highScore = new ChangeableText[10];
	private ChangeableText nama1,nama2,nama3,nama4,nama5,score1,score2,score3,score4,score5;
	private HUD hud;
	private Scene scene;
	private Texture textureBg;
	private TextureRegion reg_Bg;
	private Sprite spr_Bg;
	private ChangeableText nama, score;
	private String NAMA = "NAMA";
	private String SCORE = "SCORE";
	
	private ScoreDb scoreDb;
	private ChangeableText namaOffline, scoreOffline, highScoreOffline;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	
	
	//entityHighScore data = new entityHighScore();
	
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		camera = new Camera(0, 0, GAME_RATIO_SCREEN_WIDTH, GAME_RATIO_SCREEN_HEIGHT);
		final EngineOptions engineOptions =
			new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new FillResolutionPolicy(), camera).setNeedsSound(true);
		engineOptions.getTouchOptions().setRunOnUpdateThread(true);
		return new Engine(engineOptions);
	}

	public void onLoadResources() {
		// TODO Auto-generated method stub
		textureBg = new Texture(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		reg_Bg = TextureRegionFactory.createFromAsset(textureBg, this, 
				IMG_HIGHSCORE, 0, 0);
		
		textureFont = new Texture(512, 512);
		font = FontFactory.createFromAsset(textureFont, this,
				"fnt/ActionMan.ttf", 20, true, Color.WHITE);
		mEngine.getTextureManager().loadTextures(textureFont,textureBg);
		mEngine.getFontManager().loadFont(font);
		hud = new HUD();
		camera.setHUD(hud);
		
		builder = new AlertDialog.Builder(this);

		builder.setMessage("NO INTERNET CONNECTION")
		       .setCancelable(false)
		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   dialog.cancel();
		           }
		       });
		       
		alert = builder.create();
//try {
//	for(int i =0; i<5;i++){
//		System.out.println(namaHigh[i]);
//		System.out.println(scoreHigh[i]);
//	}
//} catch (Exception e) {
//	System.out.println(e.getMessage());
//}
		
		scoreDb = new ScoreDb(this);
		scoreDb.CreateTable();
		nama=new ChangeableText(220, 170, font, NAMA);
		namaOffline = new ChangeableText(210, 200, font, scoreDb.getLatestName());
		score=new ChangeableText(215, 225, font, SCORE);
		scoreOffline = new ChangeableText(230, 255, font, scoreDb.getLatestScore());
		highScoreOffline = new ChangeableText(160,140, font, "High Score Offline");
		hud.attachChild(highScoreOffline);
		highScoreOffline.setColor(0, 0, 0);
		nama.setColor(0, 0, 0);
		score.setColor(0, 0, 0);
		hud.attachChild(namaOffline);
		hud.attachChild(scoreOffline);
		hud.attachChild(nama);
		hud.attachChild(score);
		
//		nama1=new ChangeableText(110, 140, font, "nama1");
//		nama2=new ChangeableText(110, 170, font, "nama2");
//		nama3=new ChangeableText(110, 195, font, "nama3");
//		nama4=new ChangeableText(110, 225, font, "nama4");
//		nama5=new ChangeableText(110, 255, font, "nama5");
//		score1=new ChangeableText(300, 140, font, "score1");
//		score2=new ChangeableText(300, 170, font, "score2");
//		score3=new ChangeableText(300, 195, font, "score3");
//		score4=new ChangeableText(300, 225, font, "score4");
//		score5=new ChangeableText(300, 255, font, "score5");
		
//		nama1=new ChangeableText(80, 100, font, namaHigh[0]);
//		nama2=new ChangeableText(80, 110, font, namaHigh[1]);
//		nama3=new ChangeableText(80, 120, font, namaHigh[2]);
//		nama4=new ChangeableText(80, 130, font, namaHigh[3]);
//		nama5=new ChangeableText(80, 140, font, namaHigh[4]);
//		score1=new ChangeableText(180, 100, font, scoreHigh[0]);
//		score2=new ChangeableText(180, 110, font, scoreHigh[1]);
//		score3=new ChangeableText(180, 120, font, scoreHigh[2]);
//		score4=new ChangeableText(180, 130, font, scoreHigh[3]);
//		score5=new ChangeableText(180, 140, font, scoreHigh[4]);
//		hud.attachChild(nama1);
//		hud.attachChild(nama2);
//		hud.attachChild(nama3);
//		hud.attachChild(nama4);
//		hud.attachChild(nama5);
//		hud.attachChild(score1);
//		hud.attachChild(score2);
//		hud.attachChild(score3);
//		hud.attachChild(score4);
//		hud.attachChild(score5);
//		nama1.setColor(1, 0, 1);
//		nama2.setColor(1, 0, 1);
//		nama3.setColor(1, 0, 1);
//		nama4.setColor(1, 0, 1);
//		nama5.setColor(1, 0, 1);
//		score1.setColor(1, 0, 1);
//		score2.setColor(1, 0, 1);
//		score3.setColor(1, 0, 1);
//		score4.setColor(1, 0, 1);
//		score5.setColor(1, 0, 1);
//		nama1=new ChangeableText(80, 100, font, "NAMA");
//		score1=new ChangeableText(180, 90, font, "SCORE");
//		hud.attachChild(nama1);
//		hud.attachChild(score1);
//		nama1.setColor(1, 0, 1);
//		score1.setColor(1, 0, 1);
		
		
		// END-->
		
		//Score Offline
		
//			scoreDb = new ScoreDb(this);
//			scoreDb.CreateTable();
//			namaOffline = new ChangeableText(80, 450, font, scoreDb.getLatestName());
//			scoreOffline = new ChangeableText(180, 450, font, scoreDb.getLatestScore());
//			
//			highScoreOffline = new ChangeableText(80, 425, font, "High Score Offline");
//			hud.attachChild(highScoreOffline);
//			highScoreOffline.setColor(1, 0, 1);
//			hud.attachChild(namaOffline);
//			hud.attachChild(scoreOffline);
		
		
	}

	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		scene = new Scene(1);
		
		spr_Bg = new Sprite(0, 0, reg_Bg);
		scene.setBackground(new SpriteBackground(spr_Bg));
		
		
		return scene;
	}

}