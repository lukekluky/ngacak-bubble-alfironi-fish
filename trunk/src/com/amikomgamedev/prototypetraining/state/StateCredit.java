package com.amikomgamedev.prototypetraining.state;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;

import com.amikomgamedev.prototypetraining.Config;
import com.amikomgamedev.prototypetraining.Data;
import com.amikomgamedev.prototypetraining.Data_teks;
import com.amikomgamedev.prototypetraining.Game;
import com.amikomgamedev.prototypetraining.Utils;
import com.amikomgamedev.prototypetraining.entity.EntityGelembung;



public class StateCredit extends BaseGameActivity implements IUpdateHandler,IOnSceneTouchListener, Config, Data, Data_teks{
	private HUD hudMenu;
	private Scene scene;
	private Font font;
	private Texture textureFont;
	private Camera camera;
	private Text txt,txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,
					txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,
					txt19,txt20,txt21,txt22,txt23,txt24,txt25,txt26,txt27,
					txt28,txt29,txt30,txt31,txt32,txt33,txt34,txt35,txt36,txt37,
					txt38,txt39,txt40,txt41,txt42;
	private float y;
	private Texture textureLogo, texGel1,texGel2,texGel3,texGel4;
	private TextureRegion regAgd,regBubbleFish, regAmikom, regGel1,regGel2,regGel3,regGel4;
	private Sprite spAgd,spBubbleFish,spAmikom,spGel1;
	private Texture textureBg;
	private TextureRegion regBg;
	private Sprite spBG;
	
	
	//untuk TouchEvent
	private boolean teken=false;
	private float firstPosText = 0;
	private float firstTouch = 0;
	
	

	
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

	public Engine onLoadEngine() {
		camera = new Camera(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE,
												new FillResolutionPolicy(), camera).setNeedsSound(true);
		engineOptions.getTouchOptions().setRunOnUpdateThread(true);
		return new Engine(engineOptions);
	}

	public void onLoadResources() {
		// TODO Auto-generated method stub
				textureBg = new Texture(2048, 2048, TextureOptions.BILINEAR);
				regBg = TextureRegionFactory.createFromAsset
								(textureBg, this, "gfx/mainmenu/credit.png",0, 0);
				textureFont = new Texture(512, 512);
				font = FontFactory.createFromAsset(textureFont, this,"fnt/SHOWG.TTF",20, true, Color.WHITE);
				
				
				mEngine.getTextureManager().loadTexture(textureFont);
				mEngine.getFontManager().loadFont(font);
				
				int lastY=50;
				
				txt =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_2012)/2, 
						1370, font, TEXT_2012);
				txt1 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_COPYRIGHT)/2, 
						1350, font,TEXT_COPYRIGHT);
				
				txt2 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PROJECT_MANAGER)/2, 
						40+lastY, font,TEXT_PROJECT_MANAGER);
				txt3 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_AGOES)/2, 
						60+lastY, font,TEXT_AGOES);
				
				txt4 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PRODUCER)/2, 
						100+lastY, font,TEXT_PRODUCER);
				txt5 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_OLIV)/2, 
						120+lastY, font,TEXT_OLIV);
				
				txt6 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PROGRAMMER)/2, 
						160+lastY, font,TEXT_PROGRAMMER);
				txt7 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_BURHAN)/2, 
						180+lastY, font,TEXT_BURHAN);
				txt8 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_LUKY)/2, 
						200+lastY, font, TEXT_LUKY);
				
				txt9 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_GAME_DESAINER)/2, 
						240+lastY, font,TEXT_GAME_DESAINER);
				txt10 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_RAKIN)/2, 
						260+lastY, font, TEXT_RAKIN);
				txt11 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_BUDI)/2, 
						280+lastY, font, TEXT_BUDI);
				
				txt12 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_2D_ART)/2, 
						320+lastY, font, TEXT_2D_ART);
				txt13=new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_ARDI)/2, 
						340+lastY, font, TEXT_ARDI);
				txt14 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_AHMAD)/2, 
						360+lastY, font, TEXT_AHMAD);
				txt42 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_BOMBOM)/2, 
						380+lastY, font, TEXT_BOMBOM);
				
				txt15 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_SOUND_ENGINERING)/2, 
						420+lastY, font, TEXT_SOUND_ENGINERING);
				txt16 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_IRVAN)/2, 
						440+lastY, font, TEXT_IRVAN);
				txt17 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_MOHAMMAD)/2, 
						460+lastY, font, TEXT_MOHAMMAD);
				
				txt18 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_DEDICATED)/2, 
						500+lastY, font, TEXT_DEDICATED);
				txt19 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_GRUP)/2, 
						520+lastY, font, TEXT_GRUP);
								
				txt20 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PRODUSER)/2, 
						560+lastY, font, TEXT_PRODUSER);
				txt21 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_AYU)/2, 
						580+lastY, font, TEXT_AYU);
				txt22=new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PUPUT)/2, 
						600+lastY, font,TEXT_PUPUT);
				
				txt23 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_GDT)/2, 
						640+lastY, font, TEXT_GDT);
				txt24 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_FAUZI)/2, 
						660+lastY, font, TEXT_FAUZI);
				txt25 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_MUTIA)/2, 
						680+lastY, font, TEXT_MUTIA);
				txt26 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_ADAM)/2, 
						700+lastY, font, TEXT_ADAM);
				
				txt27 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PT)/2, 
						740+lastY, font, TEXT_PT);
				txt28 =new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_SIGIT)/2, 
						760+lastY, font, TEXT_SIGIT);
				txt29 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_ACINTYA)/2, 
						780+lastY, font, TEXT_ACINTYA);
				txt30 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_DWI)/2, 
						800+lastY, font, TEXT_DWI);
				txt31 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_PRATAMA)/2, 
						820+lastY, font, TEXT_PRATAMA);
				
				txt32 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_ARTIST)/2, 
						860+lastY, font, TEXT_ARTIST);
				txt33 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_FERIKO)/2, 
						880+lastY, font, TEXT_FERIKO);
				txt34 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_AMIRUL)/2, 
						900+lastY, font, TEXT_AMIRUL);
								
				txt35 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_OTHER)/2, 
						940+lastY, font, TEXT_OTHER);
				txt36 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_BINTANG)/2, 
						960+lastY, font, TEXT_BINTANG);
				txt37 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_RORO)/2, 
						980+lastY, font, TEXT_RORO);
				txt38 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_RAHA)/2, 
						1000+lastY, font, TEXT_RAHA);
				
				txt39 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_SUPPORT)/2, 
						1040+lastY, font, TEXT_SUPPORT);
				txt40 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_GIT)/2, 
						1060+lastY, font, TEXT_GIT);
				txt41 = new Text((SCREEN_WIDTH >> 1)-font.getStringWidth(TEXT_AMIKOM)/2, 
						1080+lastY, font, TEXT_AMIKOM);
				
				txt2.setColor(1, 0, 0); //project manager
				txt4.setColor(1, 0, 0);	//produser
				txt6.setColor(1, 0, 0); //programmer
				txt9.setColor(1, 0, 0); //game desainer
				txt12.setColor(1, 0, 0); //2d artis
				txt15.setColor(1, 0, 0); //sound engginer
				txt18.setColor(1, 0, 0); //Dedicated to
				txt20.setColor(1, 0, 0); //Producer Trainer
				txt23.setColor(1, 0, 0); //Game Designer Trainer
				txt27.setColor(1, 0, 0); //Programmer Trainer
				txt32.setColor(1, 0, 0); //Artist Trainer
				txt35.setColor(1, 0, 0); //Other supported crew
				txt39.setColor(1, 0, 0); //Supported By
				
				txt1.setColor(0, 0, 0);
				txt3.setColor(0, 0, 0);
				txt5.setColor(0, 0, 0);
				txt7.setColor(0, 0, 0);
				txt8.setColor(0, 0, 0);
				txt10.setColor(0, 0, 0);
				txt11.setColor(0, 0, 0);
				txt13.setColor(0, 0, 0);
				txt14.setColor(0, 0, 0);
				txt16.setColor(0, 0, 0);
				txt17.setColor(0, 0, 0);
				txt19.setColor(0, 0, 0);
				txt21.setColor(0, 0, 0);
				txt22.setColor(0, 0, 0);
				txt24.setColor(0, 0, 0);
				txt25.setColor(0, 0, 0);
				txt26.setColor(0, 0, 0);
				txt28.setColor(0, 0, 0);
				txt29.setColor(0, 0, 0);
				txt30.setColor(0, 0, 0);
				txt31.setColor(0, 0, 0);
				txt33.setColor(0, 0, 0);
				txt34.setColor(0, 0, 0);
				txt36.setColor(0, 0, 0);
				txt37.setColor(0, 0, 0);
				txt38.setColor(0, 0, 0);
				txt40.setColor(0, 0, 0);
				txt41.setColor(0, 0, 0);
				txt42.setColor(0, 0, 0);
				txt.setColor(0, 0, 0);
				
				TextureRegionFactory.setAssetBasePath(Data.IMG_MENU_FOLDER_PATH);
				
				textureLogo = new Texture(512, 2048);
				texGel1 = new Texture(512, 2048);
				texGel2 = new Texture(512, 2048);
				texGel3 = new Texture(512, 2048);
				texGel4 = new Texture(512, 2048);
				regAgd = TextureRegionFactory.
								createFromAsset(textureLogo, this, "logo2.png", 0, 0);
				regAmikom =  TextureRegionFactory.
								createFromAsset(textureLogo, this, "amikom.jpg", 0, 100);
				regBubbleFish =  TextureRegionFactory.
								createFromAsset(textureLogo, this, "TittleCredit.png", 0, 150);
				
				
				mEngine.getTextureManager().loadTextures(textureLogo,textureBg,texGel1,texGel2,texGel3,texGel4);
				
				spAgd 	= 	new Sprite((SCREEN_WIDTH>>1)-(regAgd.getWidth()/2), 1170,regAgd);
				spAmikom = 	new Sprite((SCREEN_WIDTH >>1)-(regAmikom.getWidth()/2),1260,regAmikom);
				spBubbleFish = 	new Sprite((SCREEN_WIDTH >>1)-(regBubbleFish.getWidth()/2), 0,regBubbleFish);
				
				hudMenu = new HUD(1);
				camera.setHUD(hudMenu);
				int a = 0;
				for(int i=90; i<=2000; i++){
					int pilih = Utils.getRandomValue(1, 4);
					if(i%30==0){
						a += 80; 
						switch (pilih) {
						case 1:
							regGel1 = TextureRegionFactory.
									createFromAsset(texGel1, this, "Gel1.png", 0, 80);
							spGel1 = new Sprite(Utils.getRandomValue(20,400), a,regGel1);
							hudMenu.attachChild(spGel1);
							break;
						case 2 :
							regGel2 = TextureRegionFactory.
								createFromAsset(texGel2, this, "Gel2.png", 0, 60);
							spGel1 = new Sprite(Utils.getRandomValue(20,400), a,regGel2);
							hudMenu.attachChild(spGel1);
							break;
						case 3 :
							regGel3 = TextureRegionFactory.
								createFromAsset(texGel3, this, "Gel3.png", 0, 40);
							spGel1 = new Sprite(Utils.getRandomValue(20,400), a,regGel3);
							hudMenu.attachChild(spGel1);
							break;
						default:
							regGel4 = TextureRegionFactory.
								createFromAsset(texGel4, this, "Gel4.png", 0, 20);
							spGel1 = new Sprite(Utils.getRandomValue(20,400), a,regGel4);
							hudMenu.attachChild(spGel1);
							break;
						}
						
					}
				}
				
				
				hudMenu.attachChild(txt);
				hudMenu.attachChild(txt1);
				hudMenu.attachChild(txt2);
				hudMenu.attachChild(txt3);
				hudMenu.attachChild(txt4);
				hudMenu.attachChild(txt5);
				hudMenu.attachChild(txt6);
				hudMenu.attachChild(txt7);
				hudMenu.attachChild(txt8);
				hudMenu.attachChild(txt9);
				hudMenu.attachChild(txt10);
				hudMenu.attachChild(txt11);
				hudMenu.attachChild(txt12);
				hudMenu.attachChild(txt13);
				hudMenu.attachChild(txt14);
				hudMenu.attachChild(txt15);
				hudMenu.attachChild(txt16);
				hudMenu.attachChild(txt17);
				hudMenu.attachChild(txt18);
				hudMenu.attachChild(txt19);
				hudMenu.attachChild(txt20);
				hudMenu.attachChild(txt21);
				hudMenu.attachChild(txt22);
				hudMenu.attachChild(txt23);
				hudMenu.attachChild(txt24);
				hudMenu.attachChild(txt25);		
				hudMenu.attachChild(txt26);	
				hudMenu.attachChild(txt27);	
				hudMenu.attachChild(txt28);	
				hudMenu.attachChild(txt29);	
				hudMenu.attachChild(txt30);
				hudMenu.attachChild(txt31);
				hudMenu.attachChild(txt32);
				hudMenu.attachChild(txt33);
				hudMenu.attachChild(txt34);
				hudMenu.attachChild(txt35);
				hudMenu.attachChild(txt36);
				hudMenu.attachChild(txt37);
				hudMenu.attachChild(txt38);
				hudMenu.attachChild(txt39);
				hudMenu.attachChild(txt40);
				hudMenu.attachChild(txt41);
				hudMenu.attachChild(txt42);
				hudMenu.attachChild(spAgd);
				hudMenu.attachChild(spAmikom);
				hudMenu.attachChild(spBubbleFish);
				
				
				mEngine.registerUpdateHandler(this);
		
	}

	public Scene onLoadScene() {
		mEngine.registerUpdateHandler(new FPSLogger());
		scene = new Scene(1);
		spBG = new Sprite(0, 0, regBg);
		scene.getFirstChild().attachChild(spBG);
		scene.setOnSceneTouchListener(this);
		scene.setTouchAreaBindingEnabled(true);
		//mEngine.registerUpdateHandler(this);
		hudMenu.setPosition(hudMenu.getScaleCenterX()/2, SCREEN_HEIGHT);
		y = SCREEN_HEIGHT;
	
		return scene;
	}

	public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pEvent) {	
		this.runOnUpdateThread(new Runnable() {	
			public void run() 
			{
				if(pEvent.getAction() == TouchEvent.ACTION_DOWN)
				{
					teken=true;
					firstPosText = y;
					firstTouch = pEvent.getY();
				}
			
				if(pEvent.getAction() == TouchEvent.ACTION_UP)
				{
					teken=false;
				}
					if(teken==true)
					{
						y=firstPosText + (pEvent.getY()-firstTouch);
						mEngine.clearUpdateHandlers();
					}
					if(teken==false){
						mEngine.registerUpdateHandler(StateCredit.this);
					}
				
			}
		});
		
		return false;
		
	}

	public void onUpdate(float arg0) {
		
		
		
		
		
		hudMenu.setPosition(hudMenu.getScaleCenterX()/2, y);
		if(y<-SCREEN_HEIGHT*6)
			y=SCREEN_HEIGHT;
		
		hudMenu.setPosition(hudMenu.getScaleCenterX()/2, y);

		y--;
		
		
	
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
