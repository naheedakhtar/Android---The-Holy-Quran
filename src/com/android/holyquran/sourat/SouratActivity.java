package com.android.holyquran.sourat;

import com.android.holyquran.database.DBAdapter;
import com.android.holyquran.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SouratActivity extends Activity{

	TextView title;
	TextView content;
	private DBAdapter dbAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.sourat);
		content = (TextView) this.findViewById(R.idSourat.content);
		title = (TextView) this.findViewById(R.idSourat.title);
		
		dbAdapter = new DBAdapter(this);
		dbAdapter.open();
		
		Integer _id = (Integer) this.getIntent().getExtras().get("_id");
		title.setText(dbAdapter.searchSouratById(_id).getName());
		content.setText(dbAdapter.searchSouratById(_id).getAyats());
		
		dbAdapter.close();
	}

}
