package com.android.holyquran.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.holyquran.main.R;

public class SearchAyat extends Activity implements OnClickListener,
		OnKeyListener {

	private EditText searchSourat;
	private EditText searchAyat;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_ayat);

		searchSourat = (EditText) this
				.findViewById(R.idSearchAyat.searchSourat);
		searchSourat.setOnKeyListener(this);

		searchAyat = (EditText) this.findViewById(R.idSearchAyat.searchAyat);
		searchAyat.setOnKeyListener(this);

		button = (Button) this.findViewById(R.idSearchAyat.ButtonSearch);
		button.setOnClickListener(this);
	}

	private void search() {
		Integer numSourat = Integer.parseInt(searchSourat.getText().toString());
		Integer numAyat = Integer.parseInt(searchAyat.getText().toString());
		System.out.println(numSourat);
		System.out.println(numAyat);
		
		if (numSourat != null && numAyat != null) {
			Intent intent = new Intent(this,
					com.android.holyquran.ayat.list.AyatListActivity.class);
			intent.putExtra("numSourat", numSourat);
			intent.putExtra("numAyat", numAyat);
			this.startActivity(intent);
		} else {
			Toast.makeText(this, "Les informations entrées sont incorrectes",
					Toast.LENGTH_SHORT);
			System.out.println("Les informations entrées sont incorrectes");
		}
	}

	@Override
	public void onClick(View v) {
		search();
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_ENTER) {
			search();
			return true;
		}
		return false;
	}
}
