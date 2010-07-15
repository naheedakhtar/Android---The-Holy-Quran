package com.android.holyquran.menu;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

public class Menu {

	public static void getMenu(android.view.Menu menu) {
		menu.add(0, 1001, 2, "A propos");
		menu.add(0, 1002, 1, "Search");
	}

	public static void actionMenu(MenuItem item, Context context) {
		switch (item.getItemId()) {
		case 1001: {
			Intent intent = new Intent(context,
					com.android.holyquran.menu.About.class);
			context.startActivity(intent);
			break;
		}
		case 1002: {
			Intent intent = new Intent(context,
					com.android.holyquran.menu.Search.class);
			context.startActivity(intent);
			break;
		}
		default: {
		}
		}
	}

}
