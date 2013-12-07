package com.karen.tourist_guide.cache;

import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.objects.PlayaItem;

public class PlayaCache {
	
	private static ArrayList<PlayaItem> listItems;
	
	public static void setListItems(ArrayList<PlayaItem> listItems){
		PlayaCache.listItems=listItems;
	}
	
	public static ArrayList<PlayaItem> getAllItems(){
		return listItems;
	}
	
	public static ArrayList<PlayaItem> getItemsZona(String zona){
		
		ArrayList<PlayaItem> auxList=new ArrayList<PlayaItem>();
		
		Iterator<PlayaItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			PlayaItem item=iterator.next();
			
			if(item.getZona().equals(zona))
				auxList.add(item);
		}
		
		return auxList;
	}
	
	public static ArrayList<PlayaItem> getItemsTipo(String tipoPlaya){
		ArrayList<PlayaItem> auxList=new ArrayList<PlayaItem>();
		
		Iterator<PlayaItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			PlayaItem item=iterator.next();
			
			if(item.getTipoPlaya().equals(tipoPlaya))
				auxList.add(item);
		}
		
		return auxList;	
	}

}
