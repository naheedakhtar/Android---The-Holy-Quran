package com.android.holyquran.sourat;

import com.android.holyquran.database.DBAdapter;
import com.android.holyquran.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SouratActivity extends Activity{

	TextView content;
	private DBAdapter dbAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.sourat);
		content = (TextView) this.findViewById(R.id.content);
		
		dbAdapter = new DBAdapter(this);
		dbAdapter.open();
		
		Integer _id = (Integer) this.getIntent().getExtras().get("_id");
		content.setText(dbAdapter.searchSouratById(_id).getContent());
	}

}
