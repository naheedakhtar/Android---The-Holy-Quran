package com.android.holyquran.main;

import com.android.holyquran.database.DBAdapter;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class Main extends ListActivity {

	DBAdapter dbAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dbAdapter = new DBAdapter(this);
		dbAdapter.open();
		DataBind();
	}

	public void DataBind() {
		Cursor c = dbAdapter.souratList();
		startManagingCursor(c);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.list_sourat, c,
				new String[] { "name", "_id", "numAyats" }, new int[] {
						R.id.name, R.id.num,
						R.id.numAyats });
		setListAdapter(adapter);
	}

}