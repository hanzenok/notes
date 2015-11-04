package org.ganza.aanotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHandler extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "notes.db";
	private static final String TABLE_NAME = "notes";
	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_TEXT = "text";
	
	public NotesDBHandler(Context context, String name, CursorFactory factory, int version) {
		
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String query = "CREATE TABLE " + TABLE_NAME + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY, " +
				COLUMN_TEXT + " TEXT " +
				");";
		
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
		db.close();
	}
	
	public void addNote(Note note){
		
		SQLiteDatabase db = getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID, note.getId());
		values.put(COLUMN_TEXT, note.getText());
		
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	
	public void deleteNote(int id){
		
		SQLiteDatabase db = getWritableDatabase();
		
		db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + 
				"=\"" + id + "\";");
		
	}
	
	public Note getNote(int id){
		
		SQLiteDatabase db = getReadableDatabase();
		String query = "SELECT " + COLUMN_TEXT + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "=\"" + id + "\";";
		Cursor c = db.rawQuery(query, null);
		
		Note note = new Note();
		
		if(c.moveToFirst()){
			
			note.setText(c.getString(c.getColumnIndex(COLUMN_TEXT)));
		}
		
		note.setId(id);
		c.close();
		db.close();
		
		return note;
	}
}
