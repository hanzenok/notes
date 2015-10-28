package org.ganza.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHandler extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "notes.db";
	private static final String TABLE_NAME = "notes";
	private static final String COLUMN_WIDGETID = "_widgetid";
	private static final String COLUMN_TEXT = "text";
	
	public NotesDBHandler(Context context, String name, CursorFactory factory, int version) {
		
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String query = "CREATE TABLE " + TABLE_NAME + "(" +
				COLUMN_WIDGETID + " INTEGER PRIMARY KEY " +
				COLUMN_TEXT + " TEXT " +
				");";
		
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
	}

}
