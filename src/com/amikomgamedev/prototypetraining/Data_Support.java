package com.amikomgamedev.prototypetraining;

public interface Data_Support {

	public static final int SPR_MAIN_CHAR_ROW = 2;
	public static final int SPR_MAIN_CHAR_COL = 12;
	public static final int[][] SPR_MAIN_CHAR_FRAME = 
	{
		{	// idle
			0,11
		},
		{	// fly
			0,11
		}, 
		{	// dy
			12,17
		}
	};
	
	public static final long[][] SPR_MAIN_CHAR_SPEED =
	{
		{	// idle
			200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200
		},
		{	// fly
			300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300
		},
		{	// die
			200, 200, 200, 200, 200, 200
		},
	};
	
	public static final long[] SPR_ENEMY_CHAR_SPEED =
			{
				200, 200, 200, 200
			};
		
	
	// font size
	public static final int FONT_SIZE_SMALL 	= Utils.getRatioH(18);
	public static final int FONT_SIZE_MEDIUM 	= Utils.getRatioH(18);
	public static final int FONT_SIZE_BIG 		= Utils.getRatioH(36);
	
	public static final int[][][] RECT_OBSTACLE = 
	{
		{//tugu
			{33,3,21,157},{67,188,50,25}
		},
		{//bts
			{12,1,26,175},{0,39,13,29}
		},
		{//amikom
			{7,24,176,124},{66,3,63,23}
		},
		{//borjo
			{5,1,74,128},{88,1,53,128}
		},
		{//monjali
			{95,1,26,37},{73,44,69,105}
		},
		{//tanki
			{8,1,25,89},{1,6,9,84}
		},
		{//vredeburg
			{7,78,271,59},{80,35,124,42}
		},
		{//pilkada
			{2,1,52,101},{15,99,26,59}
		},
		{//jogja
			{1,1,155,65},{16,68,123,101}
		},
		{//agd
			{1,1,155,65},{16,68,123,101}
		},
		{//papan
			{3,3,158,44},{64,44,31,134}
		},
		{//papanamikom
			{1,1,73,94},{1,92,72,65}
		},
		{//coklat
			{89,1,103,119},{19,14,65,103}
		},
		{//ijo
			{89,1,103,119},{19,14,65,103}
		}
		
		};
	
	public static final int[] TINGGI_OBSTACLE = {
		190,175,150,130,150,90,140,160,170,170,180,160,120,120
	};
		
	
	
}
