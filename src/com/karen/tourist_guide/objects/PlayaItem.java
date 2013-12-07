package com.karen.tourist_guide.objects;

public class PlayaItem extends TouristGuideItem{

	private static final long serialVersionUID = 1L;
	
	private String tipoPlaya;
	
	public PlayaItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String zona,String tipoPlaya) {
		super(nombre, informacion, latitud, longitud, urlImagen,zona);
		this.tipoPlaya=tipoPlaya;
		
	}
	
	public String getTipoPlaya(){
		return tipoPlaya;
	}

}
