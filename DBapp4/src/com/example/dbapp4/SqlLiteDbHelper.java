package com.example.dbapp4;

import com.example.dbapp4.table.ContactTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class SqlLiteDbHelper extends SQLiteOpenHelper{
	
	
	
	public static final String DATABASE_NAME = "contact.db";
	
	public SqlLiteDbHelper(Context context, int DBVersion) {
		super(context, DATABASE_NAME, null, DBVersion);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
			
		db.execSQL(ContactTable.CREATE_TABLE_SQL);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// delete old Table
		db.execSQL(ContactTable.DELETE_TABLE_SQL);
		// Create new Table
		onCreate(db);
		
	}

	
	
}
