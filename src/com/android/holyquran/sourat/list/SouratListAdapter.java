package com.android.holyquran.sourat.list;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.holyquran.domain.Sourat;
import com.android.holyquran.main.R;

public class SouratListAdapter extends BaseAdapter {

	private List<Sourat> souratList;
	private LayoutInflater myInflater;

	public SouratListAdapter(Context context, List<Sourat> list) {
		souratList = list;
		this.myInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return souratList.size();
	}

	public Object getItem(int position) {
		return souratList.get(position);
	}

	public long getItemId(int position) {
		return souratList.get(position).get_id();
	}

	public static class ViewHolder {
		TextView name;
		TextView informations;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.list_sourat, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.idSouratList.name);
			holder.informations = (TextView) convertView
					.findViewById(R.idSouratList.informations);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		String informations = souratList.get(position).getNumAyats().toString() + " ayats" + " - Sourat n°" + souratList.get(position).get_id().toString();
		holder.name.setText(souratList.get(position).getName().toString());
		holder.informations.setText(informations);
		
		return convertView;
	}

}
