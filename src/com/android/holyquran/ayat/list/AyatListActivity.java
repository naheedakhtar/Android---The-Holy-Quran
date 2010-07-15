package com.android.holyquran.ayat.list;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.holyquran.database.DBAdapter;
import com.android.holyquran.domain.Ayat;

public class AyatListActivity extends ListActivity {

	private DBAdapter dbAdapter;
	private List<Ayat> ayatList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String term = this.getIntent().getExtras().getString("term");
		Integer numSourat = this.getIntent().getExtras().getInt("numSourat");
		Integer numAyat = this.getIntent().getExtras().getInt("numAyat");

		dbAdapter = new DBAdapter(this);
		dbAdapter.open();

		if (numSourat != null && numAyat != null) {
			ayatList = dbAdapter.searchAyat(numSourat,
					numAyat);
		} else {
			ayatList = dbAdapter.searchAyatsByTerm(term);
		}

		setListAdapter(new AyatListAdapter(this, ayatList));
		dbAdapter.close();
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
