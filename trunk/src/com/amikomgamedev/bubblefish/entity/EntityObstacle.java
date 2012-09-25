package com.amikomgamedev.BubbleFish.entity;

import java.security.PublicKey;

import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;

import android.R.string;

import com.amikomgamedev.BubbleFish.Data;
import com.amikomgamedev.BubbleFish.Data_Support;
import com.amikomgamedev.BubbleFish.Utils;
import com.amikomgamedev.BubbleFish.state.StateGameplay;

public class EntityObstacle implements Data_Support {
	private int RctCurrent = -1;
	private float CurX;
	private float CurY;
	private float MapX;
	private int RectX;
	
	AnimatedSprite AspObstace;
	public Rectangle RectA ;
	public Rectangle RectB ;
	

	public EntityObstacle(AnimatedSprite sprObstacle
					, float CurX
					, float CurY
					, float MapX
					, int RectX )
	{
		this.AspObstace = sprObstacle;
		this.CurX = CurX;
		this.CurY = CurY;
		this.MapX = MapX;
		this.RectX = RectX;
		rectangle();
		
	}
	
	public void rectangle(){
		switch (RectX) {
		case 0:
			RectA = new Rectangle(RECT_OBSTACLE[0][0][0], RECT_OBSTACLE[0][0][1], RECT_OBSTACLE[0][0][2], RECT_OBSTACLE[0][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[0][1][0], RECT_OBSTACLE[0][1][1], RECT_OBSTACLE[0][1][2], RECT_OBSTACLE[0][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;

		case 1:
			RectA = new Rectangle(RECT_OBSTACLE[1][0][0], RECT_OBSTACLE[1][0][1], RECT_OBSTACLE[1][0][2], RECT_OBSTACLE[1][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[1][1][0], RECT_OBSTACLE[1][1][1], RECT_OBSTACLE[1][1][2], RECT_OBSTACLE[1][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 2:
			RectA = new Rectangle(RECT_OBSTACLE[2][0][0], RECT_OBSTACLE[2][0][1], RECT_OBSTACLE[2][0][2], RECT_OBSTACLE[2][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[2][1][0], RECT_OBSTACLE[2][1][1], RECT_OBSTACLE[2][1][2], RECT_OBSTACLE[2][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 3:
			RectA = new Rectangle(RECT_OBSTACLE[3][0][0], RECT_OBSTACLE[3][0][1], RECT_OBSTACLE[3][0][2], RECT_OBSTACLE[3][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[3][1][0], RECT_OBSTACLE[3][1][1], RECT_OBSTACLE[3][1][2], RECT_OBSTACLE[3][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);	
			break;
		case 4:
			RectA = new Rectangle(RECT_OBSTACLE[4][0][0], RECT_OBSTACLE[4][0][1], RECT_OBSTACLE[4][0][2], RECT_OBSTACLE[4][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[4][1][0], RECT_OBSTACLE[4][1][1], RECT_OBSTACLE[4][1][2], RECT_OBSTACLE[4][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 5:
			RectA = new Rectangle(RECT_OBSTACLE[5][0][0], RECT_OBSTACLE[5][0][1], RECT_OBSTACLE[5][0][2], RECT_OBSTACLE[5][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[5][1][0], RECT_OBSTACLE[5][1][1], RECT_OBSTACLE[5][1][2], RECT_OBSTACLE[5][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 6:
			RectA = new Rectangle(RECT_OBSTACLE[6][0][0], RECT_OBSTACLE[6][0][1], RECT_OBSTACLE[6][0][2], RECT_OBSTACLE[6][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[6][1][0], RECT_OBSTACLE[6][1][1], RECT_OBSTACLE[6][1][2], RECT_OBSTACLE[6][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 7:
			RectA = new Rectangle(RECT_OBSTACLE[7][0][0], RECT_OBSTACLE[7][0][1], RECT_OBSTACLE[7][0][2], RECT_OBSTACLE[7][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[7][1][0], RECT_OBSTACLE[7][1][1], RECT_OBSTACLE[7][1][2], RECT_OBSTACLE[7][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 8:
			RectA = new Rectangle(RECT_OBSTACLE[8][0][0], RECT_OBSTACLE[8][0][1], RECT_OBSTACLE[8][0][2], RECT_OBSTACLE[8][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[8][1][0], RECT_OBSTACLE[8][1][1], RECT_OBSTACLE[8][1][2], RECT_OBSTACLE[8][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 9:
			RectA = new Rectangle(RECT_OBSTACLE[9][0][0], RECT_OBSTACLE[9][0][1], RECT_OBSTACLE[9][0][2], RECT_OBSTACLE[9][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[9][1][0], RECT_OBSTACLE[9][1][1], RECT_OBSTACLE[9][1][2], RECT_OBSTACLE[9][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 10:
			RectA = new Rectangle(RECT_OBSTACLE[10][0][0], RECT_OBSTACLE[10][0][1], RECT_OBSTACLE[10][0][2], RECT_OBSTACLE[10][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[10][1][0], RECT_OBSTACLE[10][1][1], RECT_OBSTACLE[10][1][2], RECT_OBSTACLE[10][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 11:
			RectA = new Rectangle(RECT_OBSTACLE[11][0][0], RECT_OBSTACLE[11][0][1], RECT_OBSTACLE[11][0][2], RECT_OBSTACLE[11][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[11][1][0], RECT_OBSTACLE[11][1][1], RECT_OBSTACLE[11][1][2], RECT_OBSTACLE[11][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 12:
			RectA = new Rectangle(RECT_OBSTACLE[12][0][0], RECT_OBSTACLE[12][0][1], RECT_OBSTACLE[12][0][2], RECT_OBSTACLE[12][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[12][1][0], RECT_OBSTACLE[12][1][1], RECT_OBSTACLE[12][1][2], RECT_OBSTACLE[12][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		case 13:
			RectA = new Rectangle(RECT_OBSTACLE[13][0][0], RECT_OBSTACLE[13][0][1], RECT_OBSTACLE[13][0][2], RECT_OBSTACLE[13][0][3]);
			RectA.setVisible(false);
			AspObstace.attachChild(RectA);
			
			RectB = new Rectangle(RECT_OBSTACLE[13][1][1], RECT_OBSTACLE[13][1][1], RECT_OBSTACLE[13][1][2], RECT_OBSTACLE[13][1][3]);
			RectB.setVisible(false);
			AspObstace.attachChild(RectB);
			break;
		}
			
			
		}
		
	

	
	public void updateBlock()
	{
		AspObstace.setPosition(CurX, CurY);
	}
	
	public void removeSprite()
	{
		AspObstace = null;
	}
	
	public void setPosition(float NewX, float NewY)
	{
		CurX = NewX;
		CurY = NewY;
		AspObstace.setPosition(CurX, CurY);
	}

	public float getCurX() {
		return CurX;
	}

	public void setCurX(float curX) {
		CurX = curX;
		AspObstace.setPosition(CurX, CurY);
	}

	public float getCurY() {
		return CurY;
	}

	public int getRectX(){
		return RectX;
	}
	public void setRectX(int rectX) {
		RectX = rectX;
	}
	public void setCurY(float curY) {
		CurY = curY;
	}

	public AnimatedSprite getAspObstace() {
		return AspObstace;
	}

	public void setAspObstace(AnimatedSprite aspObstace) {
		AspObstace = aspObstace;
	}

	public Rectangle getRctA(){
				return  RectA;
		
			}

	public void setRctA(Rectangle rctObstacle) {
		RectA = rctObstacle;
	}

	public Rectangle getRctB(){
			return  RectB;
	
		}

public void setRctB(Rectangle rctObstacleB) {
	RectB = rctObstacleB;
}
	public float getMapX() {
		return MapX;
	}

	public void setMapX(float mapX) {
		MapX = mapX;
	}
	
	

}


