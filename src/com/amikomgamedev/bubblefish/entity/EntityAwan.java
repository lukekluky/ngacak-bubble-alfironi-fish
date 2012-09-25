package com.amikomgamedev.BubbleFish.entity;

import org.anddev.andengine.entity.sprite.Sprite;

public class EntityAwan {
	private float CurX;
	private float CurY;
	Sprite AspAwan;

	public EntityAwan(Sprite sprAwan
			, float CurX
			, float CurY) {
		this.AspAwan = sprAwan;
		this.CurX = CurX;
		this.CurY = CurY;
	}
	
	public void updateBlock()
	{
		AspAwan.setPosition(CurX, CurY);
	}
	
	public void removeSprite()
	{
		AspAwan = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspAwan.setPosition(CurX, CurY);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspAwan.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public Sprite getAspAwan() {
		return AspAwan;
	}

	public void setAspAwan(Sprite aspAwan) {
		AspAwan = aspAwan;
	}





}
