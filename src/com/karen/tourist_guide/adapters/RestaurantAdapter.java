package com.karen.tourist_guide.adapters;

import java.io.IOException;
import java.util.ArrayList;

import com.example.tourist_guide.R;
import com.karen.tourist_guide.objects.HotelItem;
import com.karen.tourist_guide.objects.RestauranteItem;
import com.karen.tourist_guide.webservices.DownloadImage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantAdapter extends BaseAdapter{

	private ArrayList<RestauranteItem> listVideos;
	private static LayoutInflater inflater;
	
	public RestaurantAdapter(Activity activity,ArrayList<RestauranteItem> listVideos){
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
		
		RestauranteItem item=listVideos.get(position);
		
		ImageView image=(ImageView)view.findViewById(R.id.imageViewIconItem);
		Bitmap bitmap=item.getImagenIcono();
		if(bitmap!=null){
			image.setImageBitmap(bitmap);
		}
		
		TextView tvNombre=(TextView)view.findViewById(R.id.tvNameItem);
		tvNombre.setText(item.getNombre());
		
		return view;
	}
}
