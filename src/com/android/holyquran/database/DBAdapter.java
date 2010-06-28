package com.android.holyquran.database;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {

	DataBaseHelper dbHelper;
	Context context;
	SQLiteDatabase db;

	public DBAdapter(Context context) {
		this.context = context;
		dbHelper = new DataBaseHelper(context);

		try {
			dbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
	}

	public DBAdapter open() {
		dbHelper.openDataBase();
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
	}

	public void Truncate() {
	}

	public Cursor souratList() {
		return db.query("sourat", new String[] { "_id", "name", "content",
				"numAyats" }, null, null, null, null, null);
	}

}
