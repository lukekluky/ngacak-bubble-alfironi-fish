package com.amikomgamedev.BubbleFish.entity;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.SmoothCamera;
import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;

import android.os.Looper;

import com.amikomgamedev.BubbleFish.Data_Support;
import com.amikomgamedev.BubbleFish.Game;
import com.amikomgamedev.BubbleFish.Utils;


public class EntityEnemy implements Data_Support {
	
	private float CurX;
	private float CurY;
	private float MapX;
	
	AnimatedSprite AspEnemy;
	public Rectangle RctEnemy;

	public EntityEnemy(AnimatedSprite sprEnemy
					, float CurX
					, float CurY
					, float MapX )
					
	{
		this.AspEnemy = sprEnemy;
		this.CurX = CurX;
		this.CurY = CurY;
		this.MapX = MapX;
		RctEnemy = new Rectangle(5, AspEnemy.getHeight()/2, AspEnemy.getWidth()-10, AspEnemy.getHeight()-10);
		RctEnemy.setVisible(false);
		AspEnemy.attachChild(RctEnemy);
		
	}
	
	public void updateBlock()
	{
		AspEnemy.setPosition(CurX, CurY);
	}
	
	public void removeSprite() 
	{
		AspEnemy = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspEnemy.setPosition(CurX, CurY);
		
	}
	
	public void setAnim()
	{
		AspEnemy.animate(SPR_ENEMY_CHAR_SPEED
				, 0
				, 3
				, true);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspEnemy.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public AnimatedSprite getAspEnemy() {
		return AspEnemy;
	}

	public void setAspEnemy(AnimatedSprite aspObstace) {
		AspEnemy = aspObstace;
	}

	public Rectangle getRctEnemy() {
		return RctEnemy;
	}

	public void setRctEnemy(Rectangle rctObstacle) {
		RctEnemy = rctObstacle;
	}

	public float getMapX() {
		return MapX;
	}

	public void setMapX(float mapX) {
		MapX = mapX;
	}
	
	
}
