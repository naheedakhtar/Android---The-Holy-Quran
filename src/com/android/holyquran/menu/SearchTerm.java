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

import com.android.holyquran.main.R;

public class SearchTerm extends Activity implements OnClickListener, OnKeyListener {

	private EditText editText;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_term);

		editText = (EditText) this.findViewById(R.idSearchTerm.searchEditText);
		editText.setOnKeyListener(this);

		button = (Button) this.findViewById(R.idSearchTerm.ButtonSearch);
		button.setOnClickListener(this);
	}

	private void search() {
		Intent intent = new Intent(this,
				com.android.holyquran.ayat.list.AyatListActivity.class);
		intent.putExtra("term", editText.getText().toString());
		this.startActivity(intent);
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
