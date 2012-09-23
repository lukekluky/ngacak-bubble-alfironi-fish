package com.amikomgamedev.bubblefish.entity;

import javax.sql.DataSource;

import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.sprite.AnimatedSprite;

import android.R.color;

import com.amikomgamedev.bubblefish.Data;
import com.amikomgamedev.bubblefish.Data_Support;
import com.amikomgamedev.bubblefish.Define;
import com.amikomgamedev.bubblefish.Game;
import com.amikomgamedev.bubblefish.Utils;
import com.amikomgamedev.bubblefish.state.StateGameplay;

public class EntityMc implements Define, Data, Data_Support{
	// untuk menyimpan kondisi mc terkini
	private int McStateCurrent = -1;
	
	// setting koordinat x dan y karakter
	private float CurX;
	private float CurY;
	private float DestX;
	private float DestY;
	private float MapX;
	
	AnimatedSprite AspMc;
	public Rectangle RctMc;
	
	private boolean IsMcFlyUp = false;

	public EntityMc(AnimatedSprite spr
					, float CurX
					, float CurY
					, float MapX)
	{
		this.AspMc = spr;
		this.CurX = CurX;
		this.CurY = CurY;
		
		// letakkan rectangle collision di kanan bawah 
		RctMc = new Rectangle(AspMc.getWidth()/2, 
				AspMc.getHeight()/2, 
				(AspMc.getWidth()/2)-10, 
				(AspMc.getHeight()/2)-10);
		RctMc.setVisible(false);
		
		//RctMc.setColor(color.black, color.background_light, 250);
		AspMc.attachChild(RctMc);
		McStateCurrent = MC_STATE_IDLE;
	}
	
	public void mcUpdate()
	{
		switch(McStateCurrent)
		{
			case MC_STATE_IDLE:
			break;
			case MC_STATE_FLY:
				if(!StateGameplay._instance.isMapMove)
				{
					CurX += MC_MOVE_FAR[0];
				}
				
				//if()
				
				// ngecek butuh dinaikin apa turun
				if(IsMcFlyUp)
				{
				 if(Game.AspSprMainchar.getX()< 130)
				 {
					 CurX += (MC_MOVE_FAR[0]/2);
				 }
					CurY-=(MC_MOVE_FAR[1]);
					//CurX += MC_MOVE_FAR[0];
				}
				
				else
					
				{
					CurY+=(MC_MOVE_FAR[1]);
				}
				
				// ngecek apa karakter jatuh atau kelewat batas atas
				if(CurY+RctMc.getY() > 300 || CurY+RctMc.getY() < 0)
				{
					switchMcState(MC_STATE_DIE);
				}
			break;
			case MC_STATE_DIE:
				if(!AspMc.isAnimationRunning())
				{
					StateGameplay._instance.switchState(StateGameplay.STATE_GAMEPLAY_GAMEOVER);
				}
			break;
		}
		AspMc.setPosition(CurX, CurY);
	}
	
	public void setMcFlyUp(boolean up)
	{
		IsMcFlyUp = up;
	}
	
	public void switchMcState(int NewState)
	{
		McStateCurrent = NewState;
		switch(McStateCurrent)
		{
			case MC_STATE_IDLE:
				setAnim(MC_STATE_IDLE, true);
			break;
			case MC_STATE_FLY:
				setAnim(MC_STATE_FLY, true);
			break;
			case MC_STATE_DIE:
				setAnim(MC_STATE_DIE, false);
			break;
		}
	}
	
	public void setPosition(float X, float Y)
	{
		CurX = X;
		CurY = Y;
	}
	
	public void setMapX(float X)
	{
		MapX = X;
	}
	
	public void setAnim(int anim)
	{
		setAnim(anim, false);
	}
	
	public void setAnim(int anim, boolean loop)
	{
		AspMc.animate(SPR_MAIN_CHAR_SPEED[anim]
				, SPR_MAIN_CHAR_FRAME[anim][0]
				, SPR_MAIN_CHAR_FRAME[anim][1]
				, loop);
	}

	public int getMcStateCurrent() {
		return McStateCurrent;
	}

	public void setMcStateCurrent(int mcStateCurrent) {
		McStateCurrent = mcStateCurrent;
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public float getDestX() {
		return DestX;
	}

	public void setDestX(float destX) {
		DestX = destX;
	}

	public float getDestY() {
		return DestY;
	}

	public void setDestY(float destY) {
		DestY = destY;
	}

	public float getMapX() {
		return MapX;
	}

	public AnimatedSprite getAspMc() {
		return AspMc;
	}

	public void setAspMc(AnimatedSprite aspMc) {
		AspMc = aspMc;
	}

	public Rectangle getRctMc() {
		return RctMc;
	}

	public void setRctMc(Rectangle rctMc) {
		RctMc = rctMc;
	}

	public boolean isIsMcFlyUp() {
		return IsMcFlyUp;
	}

	public void setIsMcFlyUp(boolean isMcFlyUp) {
		IsMcFlyUp = isMcFlyUp;
	}
	
	
	

}
