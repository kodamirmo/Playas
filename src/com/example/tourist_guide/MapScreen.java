package com.example.tourist_guide;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MapScreen extends FragmentActivity {

	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_screen);
		
		initViews();
	}
	
	private void initViews(){
		initMap();
	}

	private void initMap(){
		map = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.myMap)).getMap();
		
		Intent i=getIntent();
		String stringLat=i.getStringExtra("LATITUD").trim();
		String stringLong=i.getStringExtra("LONGITUD").trim();
		String title=i.getStringExtra("NOMBRE");
		String snippet=i.getStringExtra("TIPO");
		
		double latitud=Double.parseDouble(stringLat);
		double longitud=Double.parseDouble(stringLong);
		
		LatLng coordenada=new LatLng(latitud,longitud);
    	
    	CameraPosition camPos = new CameraPosition.Builder()
        .target(coordenada).zoom(16).build();
    	
    	CameraUpdate cameraUpdate =  CameraUpdateFactory.newCameraPosition(camPos);
    	
    	map.moveCamera(cameraUpdate);
    	addMarker(title, snippet, latitud, longitud);
	}
	
	private void addMarker(String title,String snippet,double corLat,double corLong){
		 LatLng coordenada = new LatLng(corLat,corLong);
   	 
   	  map.addMarker(new MarkerOptions()
         .position(coordenada)
         .title(title)
         .snippet(snippet));
	}
}
