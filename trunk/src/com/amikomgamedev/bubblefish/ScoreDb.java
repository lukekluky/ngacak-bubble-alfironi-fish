package com.amikomgamedev.bubblefish;

import java.util.Date;



import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.format.DateFormat;
import android.util.Log;


public class ScoreDb extends SQLiteOpenHelper{
	private static final String DBNAME 				= "jhfhtc";
	private static final String SCORE_TABLE_NAME	= "scoreTb";
	
	private ScoreDb			MyDbHelper;
	private SQLiteDatabase	MyDb;
	private final Context MyContext;

	public ScoreDb(Context context)
	{
		super(context, DBNAME, null, 2);
		this.MyContext = context;
	}
	
	public ScoreDb CreateTable() throws SQLException
	{
		MyDbHelper	= new ScoreDb(MyContext);
		MyDb		= MyDbHelper.getWritableDatabase();
//		MyDb.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE_NAME);
		MyDb.execSQL("CREATE TABLE IF NOT EXISTS " + SCORE_TABLE_NAME +
					"(score INTEGER, " +
					"nama VARCHAR(20)" +
					")");
		MyDb.close();
		return this;		
	}
	
	public boolean isHighScore(int score)
	{
		MyDbHelper	= new ScoreDb(MyContext);
		MyDb		= MyDbHelper.getReadableDatabase();
		Cursor cur	= MyDb.rawQuery("SELECT score FROM "+SCORE_TABLE_NAME+" " +
									"WHERE score > " + score, null);
		//Log.v("Query", "SELECT score FROM "+SCORE_TABLE_NAME+" WHERE score > " + score);
		while(cur.moveToNext())
		{
			//Log.v("Ini isinya om", ""+cur.getLong(0));
			MyDb.close();	
			return false;
		}
		MyDb.close();	
		return true;
	}
	
	public boolean isContent()
	{
		MyDbHelper	= new ScoreDb(MyContext);
		MyDb		= MyDbHelper.getReadableDatabase();
		Cursor cur	= MyDb.rawQuery("SELECT score FROM "+SCORE_TABLE_NAME, null);
		while(cur.moveToNext())
		{
			MyDb.close();	
			return true;
		}
		MyDb.close();	
		return false;
	}

	public String getLatestScore()
	{
		MyDbHelper	= new ScoreDb(MyContext);
		MyDb		= MyDbHelper.getReadableDatabase();
		Cursor cur	= MyDb.rawQuery("SELECT score FROM "+SCORE_TABLE_NAME, null);
		while(cur.moveToNext())
		{
			
			MyDb.close();	
			return cur.getString(0);
		}
		MyDb.close();	
		return "0";
		
	}

	public String getLatestName()
	{
		MyDbHelper	= new ScoreDb(MyContext);
		MyDb		= MyDbHelper.getReadableDatabase();
		Cursor cur	= MyDb.rawQuery("SELECT nama FROM "+SCORE_TABLE_NAME, null);
		while(cur.moveToNext())
		{
			MyDb.close();	
			return cur.getString(0);
		}
		MyDb.close();	
		return "0";
		
	}
	
	public ScoreDb insertNama(String nama)
	{
		if(isContent())
		{
			MyDbHelper	= new ScoreDb(MyContext);
			MyDb		= MyDbHelper.getReadableDatabase();
			SQLiteStatement	sqlInsert;
			String	sql		= "UPDATE " + SCORE_TABLE_NAME +
					" SET nama='"+nama+"'";
			sqlInsert = MyDb.compileStatement(sql);
//			sqlInsert.bindString(0, nama);
			sqlInsert.executeInsert();
			MyDb.close();
		}
		else
		{
			MyDbHelper	= new ScoreDb(MyContext);
			MyDb		= MyDbHelper.getReadableDatabase();
			SQLiteStatement	sqlInsert;
			String	sql		= "INSERT INTO " + SCORE_TABLE_NAME +
					" (nama) VALUES ('"+nama+"')";
			sqlInsert = MyDb.compileStatement(sql);
//			sqlInsert.bindString(0, nama);
			sqlInsert.executeInsert();
			MyDb.close();
		}
		return this;
	}
	
	public ScoreDb insertScore(int score)
	{
		if(isContent())
		{
			MyDbHelper	= new ScoreDb(MyContext);
			MyDb		= MyDbHelper.getReadableDatabase();
			SQLiteStatement	sqlInsert;
			String	sql		= "UPDATE " + SCORE_TABLE_NAME +
					" SET score='"+score+"'";
			sqlInsert = MyDb.compileStatement(sql);
			sqlInsert.executeInsert();
			MyDb.close();
		}
		else
		{
			MyDbHelper	= new ScoreDb(MyContext);
			MyDb		= MyDbHelper.getReadableDatabase();
			SQLiteStatement	sqlInsert;
			String	sql		= "INSERT INTO " + SCORE_TABLE_NAME +
					" (score) VALUES ('"+score+"')";
			sqlInsert = MyDb.compileStatement(sql);
			sqlInsert.executeInsert();
			MyDb.close();
		}
		return this;
	}
		
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		//MyDb.close();
		
	}
}
