package com.karen.tourist_guide.objects;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.text.Html;

public abstract class TouristGuideItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String informacion;
	private String latitud;
	private String longitud;
	private String urlImagen;
	private String zona;
	private Bitmap imagenIcono;
	private Bitmap imagen;
	
	public TouristGuideItem(String nombre, String informacion, String latitud,
			String longitud, String urlImagen,String zona) {
		this.nombre = nombre;
		this.informacion = informacion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.urlImagen = urlImagen;
		this.zona=zona;
	}
	
	public String getNombre() {
		return Html.fromHtml(nombre).toString();
	}
	public String getInformacion() {
		return Html.fromHtml(informacion).toString();
	}
	public String getLatitud() {
		return latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	
	public String getZona() {
		return zona;
	}
	
	public Bitmap getImagenIcono() {
		return imagenIcono;
	}

	public void setImagenIcono(Bitmap imagenIcono) {
		this.imagenIcono = imagenIcono;
	}

	public Bitmap getImagen() {
		return imagen;
	}

	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}

}
