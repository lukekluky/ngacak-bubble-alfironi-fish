package com.amikomgamedev.BubbleFish.entity;

import org.anddev.andengine.entity.sprite.Sprite;

public class EntityGelembung {
	private float CurX;
	private float CurY;
	Sprite AspGelembung;

	public EntityGelembung(Sprite sprGelembung
			, float CurX
			, float CurY) {
		this.AspGelembung = sprGelembung;
		this.CurX = CurX;
		this.CurY = CurY;
	}
	
	public void updateBlock()
	{
		AspGelembung.setPosition(CurX, CurY);
	}
	
	public void removeSprite()
	{
		AspGelembung = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspGelembung.setPosition(CurX, CurY);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspGelembung.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public Sprite getAspGelembung() {
		return AspGelembung;
	}

	public void setAspGelembung(Sprite AspGelembung) {
		AspGelembung = AspGelembung;
	}





}