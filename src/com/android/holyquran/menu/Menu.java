package com.android.holyquran.menu;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

public class Menu {

	public static void getMenu(android.view.Menu menu) {
		menu.add(0, 1001, 1, "Recherche par terme");
		menu.add(0, 1002, 2, "Recherche direct");
		menu.add(0, 1003, 3, "A propos");

	}

	public static void actionMenu(MenuItem item, Context context) {
		switch (item.getItemId()) {
		case 1003: {
			Intent intent = new Intent(context,
					com.android.holyquran.menu.About.class);
			context.startActivity(intent);
			break;
		}
		case 1001: {
			Intent intent = new Intent(context,
					com.android.holyquran.menu.SearchTerm.class);
			context.startActivity(intent);
			break;
		}
		case 1002: {
			Intent intent = new Intent(context,
					com.android.holyquran.menu.SearchAyat.class);
			context.startActivity(intent);
			break;
		}
		default: {
		}
		}
	}

}
