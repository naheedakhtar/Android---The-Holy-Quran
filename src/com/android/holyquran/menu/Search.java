package com.android.holyquran.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.holyquran.main.R;

public class Search extends Activity implements OnClickListener {

	private EditText editText;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		editText = (EditText) this.findViewById(R.idSearch.searchEditText);
		button = (Button) this.findViewById(R.idSearch.ButtonSearch);

		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this,
				com.android.holyquran.ayat.list.AyatListActivity.class);
		intent.putExtra("term", editText.getText().toString());
		this.startActivity(intent);
	}
}
