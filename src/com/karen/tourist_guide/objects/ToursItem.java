package com.karen.tourist_guide.objects;

public class ToursItem extends TouristGuideItem{

	private static final long serialVersionUID = 1L;
	
	private String urlLogo;
	private String tour;

	public ToursItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String urlLogo,String zona,String tour) {
		super(nombre, informacion, latitud, longitud, urlImagen,zona);
		
		this.urlLogo=urlLogo;
		this.tour=tour;
	}

	public String getUrlLogo() {
		return urlLogo;
	}
	
	public String getTour(){
		return tour;
	}
	
}
