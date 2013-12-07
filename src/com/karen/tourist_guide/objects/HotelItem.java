package com.karen.tourist_guide.objects;

public class HotelItem extends TouristGuideItem{

	private static final long serialVersionUID = 1L;
	
	private String urlLogo;
	private String estrellas;

	public HotelItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String urlLogo,String zona,String estrellas) {
		super(nombre, informacion, latitud, longitud, urlImagen,zona);
		
		this.urlLogo=urlLogo;
		this.estrellas=estrellas;
	}

	public String getUrlLogo() {
		return urlLogo;
	}
	
	public String getEstrellas() {
		return estrellas;
	}
	
}
