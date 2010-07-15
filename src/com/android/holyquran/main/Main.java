package com.android.holyquran.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.android.holyquran.main.R;

public class Main extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent intent = new Intent(this,
				com.android.holyquran.sourat.list.SouratList.class);
		this.startActivity(intent);
	}

}