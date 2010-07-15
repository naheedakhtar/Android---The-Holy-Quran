package com.android.holyquran.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.holyquran.main.R;

public class Main extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent intent = new Intent(this,
				com.android.holyquran.sourat.list.SouratListActivity.class);
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