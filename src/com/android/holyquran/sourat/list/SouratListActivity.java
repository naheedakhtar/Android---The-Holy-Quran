package com.android.holyquran.sourat.list;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
		
		dbAdapter.close();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, com.android.holyquran.sourat.SouratActivity.class);
		intent.putExtra("_id", souratList.get(position).get_id());
		this.startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		com.android.holyquran.menu.Menu.getMenu(menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		com.android.holyquran.menu.Menu.actionMenu(item, this);
		return super.onMenuItemSelected(featureId, item);
	}

}