package com.android.holyquran.sourat.list;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.holyquran.database.DBAdapter;
import com.android.holyquran.domain.Sourat;

public class SouratListActivity extends ListActivity {

	private DBAdapter dbAdapter;
	private List<Sourat> souratList;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dbAdapter = new DBAdapter(this);
		dbAdapter.open();
		souratList = dbAdapter.souratList();
		setListAdapter(new SouratListAdapter(this, souratList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		System.out.println(souratList.get(position).getName());
	}

}