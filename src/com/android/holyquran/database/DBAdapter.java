package com.android.holyquran.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.holyquran.domain.Sourat;

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

	public List<Sourat> souratList() {
		Cursor c = db.query("sourat", new String[] { "_id", "name", "content",
				"numAyats" }, null, null, null, null, null);
		List<Sourat> list = new ArrayList<Sourat>();
		if (c.moveToFirst()) {
			Sourat sourat = new Sourat(c.getInt(0), c.getString(1), c
					.getString(2), c.getInt(3));
			list.add(sourat);
		}
		while (c.moveToNext()) {
			Sourat sourat = new Sourat(c.getInt(0), c.getString(1), c
					.getString(2), c.getInt(3));
			list.add(sourat);
		}
		return list;
	}

}
