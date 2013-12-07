package com.karen.tourist_guide.cache;

import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.objects.HotelItem;

public class HotelCache {
	
	private static ArrayList<HotelItem> listItems;
	
	public static void setListItems(ArrayList<HotelItem> listItems){
		HotelCache.listItems=listItems;
	}
	
	public static ArrayList<HotelItem> getAllItems(){
		return listItems;
	}
	
	public static ArrayList<HotelItem> getItemsZona(String zona){
		
		ArrayList<HotelItem> auxList=new ArrayList<HotelItem>();
		
		Iterator<HotelItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			HotelItem item=iterator.next();
			
			if(item.getZona().equals(zona))
				auxList.add(item);
		}
		
		return auxList;	
	}
	
	public static ArrayList<HotelItem> getItemsEstrellas(String estrellas){
		ArrayList<HotelItem> auxList=new ArrayList<HotelItem>();
		
		Iterator<HotelItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			HotelItem item=iterator.next();
			
			if(item.getEstrellas().equals(estrellas))
				auxList.add(item);
		}
		
		return auxList;	
	}
}
