package com.android.holyquran.ayat.list;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.holyquran.domain.Ayat;
import com.android.holyquran.main.R;

public class AyatListAdapter extends BaseAdapter {

	private List<Ayat> ayatList;
	private LayoutInflater myInflater;

	public AyatListAdapter(Context context, List<Ayat> ayatList) {
		this.ayatList = ayatList;
		this.myInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return ayatList.size();
	}

	public Object getItem(int position) {
		return ayatList.get(position);
	}

	public long getItemId(int position) {
		return ayatList.get(position).get_id();
	}

	public static class ViewHolder {
		TextView nameAndMore;
		TextView ayat;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.list_ayat, null);
			holder = new ViewHolder();
			holder.nameAndMore = (TextView) convertView
					.findViewById(R.idAyatList.nameAndMore);
			holder.ayat = (TextView) convertView
					.findViewById(R.idAyatList.ayat);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.nameAndMore.setText(ayatList.get(position).getSouratId()
				.toString()
				+ "." + ayatList.get(position).getAyat().toString() + " ");
		holder.ayat.setText(ayatList.get(position).getContent().toString());

		return convertView;
	}

}
