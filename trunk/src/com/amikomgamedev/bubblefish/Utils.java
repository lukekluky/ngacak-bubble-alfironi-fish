package com.amikomgamedev.bubblefish;

import java.util.Random;

import org.anddev.andengine.entity.primitive.Rectangle;


public class Utils implements Config, Define {
	public static void TRACE(String arg)
	{
		if (_DEBUG)
		{
			System.out.println(arg);
		}
	}

	public static void TRACE(Exception arg)
	{
		if (_DEBUG)
		{
			arg.printStackTrace();
		}
	}
	public static int getRatioW(int def)
	{
		return (int) (((float) def/GAME_RATIO_SCREEN_WIDTH) * GAME_SCREEN_WIDTH);
	}

	public static int getRatioH(int def)
	{
		return (int) (((float )def/GAME_RATIO_SCREEN_HEIGHT) * GAME_SCREEN_HEIGHT);
	}

	public static boolean isInRect(float x, float y, float rectX, float rectY,
									float w, float h)
	{
		if ((x > rectX && x < rectX + w) && (y > rectY && y < rectY + h))
		{
			return true;
		}

		return false;
	}

	public static boolean isInRect(float x, float y, Rectangle rect)
	{
		if ((x > rect.getX() && x < rect.getX() + rect.getWidth())
			&& (y > rect.getY() && y < rect.getY() + rect.getHeight()))
		{
			return true;
		}

		return false;

	}

	public static int getRandomValue(int maxValue)
	{
		return (int) getRandomValue(0, maxValue, new Random());
	}
	
	public static int getRandomValue(int minValue, int maxValue)
	{
		return getRandomValue(minValue, maxValue, new Random());
	}

	public static int getRandomValue(int aStart, int aEnd, Random aRandom)
	{
		if (aStart > aEnd)
		{
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}
}
