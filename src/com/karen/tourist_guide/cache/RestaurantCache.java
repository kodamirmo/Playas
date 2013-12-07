package com.karen.tourist_guide.cache;

import java.util.ArrayList;
import java.util.Iterator;

import android.util.Log;

import com.karen.tourist_guide.objects.RestauranteItem;

public class RestaurantCache {
	
	private static ArrayList<RestauranteItem> listItems;
	
	public static void setListItems(ArrayList<RestauranteItem> listItems){
		RestaurantCache.listItems=listItems;
	}
	
	public static ArrayList<RestauranteItem> getAllItems(){
		return listItems;
	}
	
	public static ArrayList<RestauranteItem> getItemsZona(String zona){
		ArrayList<RestauranteItem> auxList=new ArrayList<RestauranteItem>();
		
		Iterator<RestauranteItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			RestauranteItem item=iterator.next();
			
			if(item.getZona().equals(zona))
				auxList.add(item);
		}
		
		return auxList;
	}
	
	public static ArrayList<RestauranteItem> getItemsComida(String tipoComida){
		ArrayList<RestauranteItem> auxList=new ArrayList<RestauranteItem>();
		
		Iterator<RestauranteItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			RestauranteItem item=iterator.next();
			Log.i("TAG","Nuevo item: --" + item.getComida() + "--");
			
			if(item.getComida().equals(tipoComida)){
				Log.i("TAG","Nuevo item: --ADD--");
				auxList.add(item);
			}
		}
		
		return auxList;
	}
}
