package com.karen.tourist_guide.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourist_guide.R;
import com.karen.tourist_guide.objects.HotelItem;
import com.karen.tourist_guide.objects.PlayaItem;

public class PlayasAdapter extends BaseAdapter{

	private ArrayList<PlayaItem> listVideos;
	private static LayoutInflater inflater;
	
	public PlayasAdapter(Activity activity,ArrayList<PlayaItem> listVideos){
		this.listVideos=listVideos;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return listVideos.size();
	}

	@Override
	public Object getItem(int position) {
		return listVideos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
        
		if(convertView==null)
            view = inflater.inflate(R.layout.simple_list_icon, null);
		
		PlayaItem item=listVideos.get(position);
		
		ImageView image=(ImageView)view.findViewById(R.id.imageViewIconItem);
		image.setVisibility(View.GONE);
		
		TextView tvNombre=(TextView)view.findViewById(R.id.tvNameItem);
		tvNombre.setTextSize(20f);
		tvNombre.setText(item.getNombre());
		
		return view;
	}
}