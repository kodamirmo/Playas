package com.karen.tourist_guide.objects;

public class RestauranteItem extends TouristGuideItem{

	private static final long serialVersionUID = 1L;
	
	private String urlLogo;
	private String comida;

	public RestauranteItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String urlLogo,String zona,String comida) {
		super(nombre, informacion, latitud, longitud, urlImagen,zona);
		this.urlLogo=urlLogo;
		this.comida=comida;
	}

	public String getUrlLogo() {
		return urlLogo;
	}
	
	public String getComida() {
		return comida;
	}
}
