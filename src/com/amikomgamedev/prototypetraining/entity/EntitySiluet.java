package com.amikomgamedev.prototypetraining.entity;

import org.anddev.andengine.entity.sprite.Sprite;

public class EntitySiluet {
	private float CurX;
	private float CurY;
	Sprite AspSiluet;

	public EntitySiluet(Sprite sprSiluet
			, float CurX
			, float CurY) {
		this.AspSiluet = sprSiluet;
		this.CurX = CurX;
		this.CurY = CurY;
	}
	
	public void updateBlock()
	{
		AspSiluet.setPosition(CurX, CurY);
	}
	
	public void removeSprite()
	{
		AspSiluet = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspSiluet.setPosition(CurX, CurY);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspSiluet.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public Sprite getAspSiluet() {
		return AspSiluet;
	}

	public void setAspSiluet(Sprite aspSiluet) {
		AspSiluet = aspSiluet;
	}





}
