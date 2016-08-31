package com.example.dbapp4.table;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dbapp4.SqlLiteDbHelper;
import com.example.dbapp4.model.Contact;
import com.example.dbapp4.model.Model;

public class ContactTable implements Table{
	
	public static final String TABLE_NAME = "contact";
	private Context context;
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_CREATED_AT = "created_at";
	
	public static final String CREATE_TABLE_SQL = "CREATE TABLE "+ TABLE_NAME +
			" (" + _ID +INTEGER_TYPE + PRIMARY_TYPE+COMMA_SEP + 
			COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
			COLUMN_PHONE + TEXT_TYPE + COMMA_SEP +
			COLUMN_EMAIL + TEXT_TYPE + COMMA_SEP +
			COLUMN_CREATED_AT + DATE_TYPE + ")";
	
	public static final String DELETE_TABLE_SQL = "DROP TABLE IF EXISTS  " + TABLE_NAME;
    
	public static final int DATABASE_VERSION = 1;
	
	public ContactTable(Context context){
		this.context = context;
	}
	
	
	
	@Override
	public int getCount() {
		
		return findAll().size();
	}

	@Override
	public int update(Model model) {
		int count;	
		SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(context, DATABASE_VERSION);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_EMAIL, ((Contact)model).getEmail());
		values.put(COLUMN_PHONE, ((Contact)model).getPhone());
		values.put(COLUMN_NAME, ((Contact)model).getName());
		count = db.update(TABLE_NAME, values, _ID +" =?", new String[]{String.valueOf(((Contact)model).getId())});
		return count;
	}

	@Override
	public Model find(int id) {
		SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(context, DATABASE_VERSION);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor  = db.query(TABLE_NAME, new String[]{_ID,COLUMN_NAME, COLUMN_PHONE,
				COLUMN_EMAIL,COLUMN_CREATED_AT}, _ID + "=?", new String[]{String.valueOf(id)}, 
				null, null, null);
		
		if(cursor !=null){cursor.moveToFirst();
		
		Contact contact = new Contact(
				cursor.getInt(cursor.getColumnIndexOrThrow(_ID)),
				cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
				cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)),
				cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)), 
				cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CREATED_AT)));
			db.close();
		return contact;
		}
		
		db.close();
		return null;
				
	}

	@Override
	public List<Model> findAll() {
		
		List<Model> contacts = new ArrayList<Model>();
		
		String queryString = "SELECT * FROM "+ TABLE_NAME;
		SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(context, DATABASE_VERSION);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(queryString, null);
		
		if(cursor != null){
			
			if(cursor.moveToFirst()){
				
				do{
					
					Contact contact = new Contact();
					contact.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
					contact.setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
					contact.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)));
					contact.setPhone(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)));
					contact.setCreate_at(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CREATED_AT)));
				
					contacts.add(contact);
					
				}while(cursor.moveToNext());
			}
			
			db.close();
			return contacts;
		}
		
		
		
		db.close();
		return null;
	}

	@Override
	public int delete(Model model) {
		SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(context, DATABASE_VERSION);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int count = 0;
		count = db.delete(TABLE_NAME, _ID+" =?", new String[]{String.valueOf(model.getId())});
		db.close();
		return count;
	}

	@Override
	public void add(Model model) {
		
	
		SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(context, DATABASE_VERSION);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, ((Contact)model).getName());
		values.put(COLUMN_EMAIL, ((Contact)model).getEmail());
		values.put(COLUMN_PHONE, ((Contact)model).getPhone());
		
		db.insert(TABLE_NAME, null, values);
		db.close();
		
	}





}
