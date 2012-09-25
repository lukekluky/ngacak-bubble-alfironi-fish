package com.amikomgamedev.BubbleFish.entity;

import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.sprite.Sprite;

public class EntityOther {
	private float CurX;
	private float CurY;
	private float MapX;
	Sprite AspJalan;

	public EntityOther(Sprite sprJalan
			, float CurX
			, float CurY
			, float MapX) {
		this.AspJalan = sprJalan;
		this.CurX = CurX;
		this.CurY = CurY;
		this.MapX = MapX;
	}
	
	public void updateBlock()
	{
		AspJalan.setPosition(CurX, CurY);
	}
	
	public void removeSprite()
	{
		AspJalan = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspJalan.setPosition(CurX, CurY);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspJalan.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public void setCurY(float curY) {
		CurY = curY;
	}

	public Sprite getAspObstace() {
		return AspJalan;
	}

	public void setAspObstace(Sprite aspJalan) {
		AspJalan = aspJalan;
	}


	public float getMapX() {
		return MapX;
	}

	public void setMapX(float mapX) {
		MapX = mapX;
	}	


}
