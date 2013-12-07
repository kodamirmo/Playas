package com.karen.tourist_guide.cache;

import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.objects.VidaNocturnaItem;

public class VidaNocturnaChache {
	
	private static ArrayList<VidaNocturnaItem> listItems;
	
	public static void setListItems(ArrayList<VidaNocturnaItem> listItems){
		VidaNocturnaChache.listItems=listItems;
	}
	
	public static ArrayList<VidaNocturnaItem> getAllItems(){
		return listItems;
	}
	
	public static ArrayList<VidaNocturnaItem> getItemsZona(String zona){
		ArrayList<VidaNocturnaItem> auxList=new ArrayList<VidaNocturnaItem>();
		
		Iterator<VidaNocturnaItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			VidaNocturnaItem item=iterator.next();
			
			if(item.getZona().equals(zona))
				auxList.add(item);
		}
		
		return auxList;
	}
	
	public static ArrayList<VidaNocturnaItem> getItemsCategoria(String categoria){
		ArrayList<VidaNocturnaItem> auxList=new ArrayList<VidaNocturnaItem>();
		
		Iterator<VidaNocturnaItem> iterator=listItems.iterator();
		
		while(iterator.hasNext()){
			VidaNocturnaItem item=iterator.next();
			
			if(item.getCategoria().equals(categoria))
				auxList.add(item);
		}
		
		return auxList;
	}

}
