package com.karen.tourist_guide.cache;

import java.util.ArrayList;
import java.util.Iterator;

import android.util.Log;

import com.karen.tourist_guide.objects.ToursItem;

public class TourCache {
	
	private static ArrayList<ToursItem> listItems;
	
	public static void setListItems(ArrayList<ToursItem> listItems){
		TourCache.listItems=listItems;
	}
	
	public static ArrayList<ToursItem> getAllItems(){
		return listItems;
	}
	
	public static ArrayList<ToursItem> getItemsZona(String zona){
		ArrayList<ToursItem> auxList=new ArrayList<ToursItem>();
		
		Iterator<ToursItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			ToursItem item=iterator.next();
			
			if(item!=null){
				Log.i("TAG","Nuevo item: --" + item.getTour() + "--");
				
				if(item.getZona().equals(zona)){
					Log.i("TAG","Nuevo item: --ADD--");
					auxList.add(item);
				}
			}
		}
		
		return auxList;
	}
	
	public static ArrayList<ToursItem> getItemsTour(String tour){
		ArrayList<ToursItem> auxList=new ArrayList<ToursItem>();
		
		Iterator<ToursItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			ToursItem item=iterator.next();
			
			if(item!=null){
				Log.i("TAG","Nuevo item: --" + item.getTour() + "--");
				
				if(item.getTour().equals(tour)){
					Log.i("TAG","Nuevo item: --ADD--");
					auxList.add(item);
				}
			}
		}
		
		return auxList;
	}

}
