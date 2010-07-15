package com.android.holyquran.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.holyquran.domain.Ayat;
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
		dbHelper.close();
	}

	public void Truncate() {
	}

	public List<Sourat> souratList() {
		Cursor c = db.query("sourat", new String[] { "_id", "name", "content",
				"numAyats" }, null, null, null, null, null);
		
		if (c.moveToFirst()) {
			List<Sourat> list = new ArrayList<Sourat>();
			do {
				Sourat sourat = new Sourat(c.getInt(0), c.getString(1), c
						.getString(2), c.getInt(3), null);
				list.add(sourat);
			} while (c.moveToNext());
			c.close();
			return list;
		}
		
		return Collections.emptyList();
	}

	public Sourat searchSouratById(Integer id) {
		Cursor c = db.query("sourat", new String[] { "_id", "name", "content",
				"numAyats" }, "_id =" + id, null, null,
				null, null);
		
		if (c.moveToFirst()) {
			
			Cursor cAyats = db.query("ayat", new String[] { "_id", "sourat_id", "ayat",
			"content" }, "sourat_id =" + id, null, null,
			null, null);
			List<Ayat> ayatList = new ArrayList<Ayat>();
			if (cAyats.moveToFirst()) {
				do {
					Ayat ayat = new Ayat(cAyats.getInt(0), cAyats.getInt(1),cAyats.getInt(2), cAyats.getString(3));
					ayatList.add(ayat);
				} while (cAyats.moveToNext());
				cAyats.close();
			}

			Sourat sourat = new Sourat(c.getInt(0), c.getString(1), c
					.getString(2), c.getInt(3), ayatList);
			c.close();
			return sourat;
		}
		
		return null;
	}

}
