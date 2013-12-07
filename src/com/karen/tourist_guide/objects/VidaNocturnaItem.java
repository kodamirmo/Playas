package com.karen.tourist_guide.objects;

public class VidaNocturnaItem extends TouristGuideItem{

	private static final long serialVersionUID = 1L;
	
	private String urlLogo;
	private String categoria;

	public VidaNocturnaItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String urlLogo,String zona,String categoria) {
		super(nombre, informacion, latitud, longitud, urlImagen,zona);
		
		this.urlLogo=urlLogo;
		this.categoria=categoria.trim();
	}

	public String getUrlLogo() {
		return urlLogo;
	}
	
	public String getCategoria() {
		return categoria;
	}


}
