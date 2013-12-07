package com.karen.tourist_guide.webservices;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.karen.tourist_guide.objects.HotelItem;
import com.karen.tourist_guide.objects.PlayaItem;
import com.karen.tourist_guide.objects.RestauranteItem;
import com.karen.tourist_guide.objects.ToursItem;
import com.karen.tourist_guide.objects.VidaNocturnaItem;

import android.util.Log;

public class WebServiceDownloadData {

	private HttpClient cliente;

	public WebServiceDownloadData() {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 5000);
		cliente = new DefaultHttpClient(params);
	}

	private JSONArray consultarWebService(int tipo, int idioma) {

		String url = "http://162.243.128.228:5000/";

		if (idioma == 1) {
			url += "espanol/";
		} else
			url += "ingles/";

		switch (tipo) {
		case 1:
			url += "playas";
			break;
		case 2:
			url += "restaurantes";
			break;
		case 3:
			url += "hoteles";
			break;
		case 4:
			url += "vida";
			break;
		case 5:
			url += "tours";
			break;

		}

		Log.i("TAG", "URL= " + url);
		HttpGet get = new HttpGet(url);

		HttpResponse respuesta = null;

		try {
			respuesta = cliente.execute(get);
		} catch (ClientProtocolException e) {
			Log.e("Tag", "Error en Protocolo en cliente");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			Log.e("Tag", "Error IO");
			e.printStackTrace();
			return null;
		}

		String response = null;

		try {
			response = EntityUtils.toString(respuesta.getEntity());
		} catch (ParseException e) {
			Log.e("Tag", "Error en parser de respuesta");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			Log.e("Tag", "Error IO en respuesta");
			e.printStackTrace();
			return null;
		}

		if (response == null) {
			Log.i("TAG", "La respuesta es null");
			return null;
		}

		// Log.i("TAG", "La respuesta de es =" + response);

		JSONArray res = null;

		try {
			res = new JSONArray(response);
		} catch (JSONException e) {
			Log.e("Tag", "Error en parser JSON");
			e.printStackTrace();
			return null;
		}

		// Log.i("TAG","RESPONSE: " + res);

		return res;
	}

	// ///////////////// PLAYAS ///////////////////////////////

	public ArrayList<PlayaItem> consultarPlayas() {
		JSONArray array = consultarWebService(1, 1);
		ArrayList<PlayaItem> list=new ArrayList<PlayaItem>();

		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject json = array.getJSONObject(i);
				Log.i("TAG", "RESPUESTA: " + json);
				list.add(parserPlayas(json));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private PlayaItem parserPlayas(JSONObject json) {
		try {

			PlayaItem playa = new PlayaItem(json.getString("nombre"),
					json.getString("informacion"), json.getString("latitud"),
					json.getString("longitud"), json.getString("url_imagen"),
					json.getString("zona"), json.getString("tipo_playa"));
			return playa;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ///////////////// HOTELES ///////////////////////////////

	public ArrayList<HotelItem> consultarHoteles() {
		JSONArray array = consultarWebService(3, 1);
		ArrayList<HotelItem> list=new ArrayList<HotelItem>();
		
		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject json = array.getJSONObject(i);
				Log.i("TAG", "RESPUESTA: " + json);
				list.add(parserHoteles(json));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private HotelItem parserHoteles(JSONObject json) {
		try {
			HotelItem hotel = new HotelItem(json.getString("nombre"),
					json.getString("informacion"), json.getString("latitud"),
					json.getString("longitud"), json.getString("url_imagen"),
					json.getString("url_logo"), json.getString("zona"),
					json.getString("estrellas"));
			
			return hotel;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ///////////////// HOTELES ///////////////////////////////

	public ArrayList<RestauranteItem> consultarRestaurantes() {
		JSONArray array = consultarWebService(2, 1);
		ArrayList<RestauranteItem> list=new ArrayList<RestauranteItem>();
		
		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject json = array.getJSONObject(i);
				Log.i("TAG", "RESPUESTA: " + json);
				list.add(parserRestaurantes(json));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private RestauranteItem parserRestaurantes(JSONObject json) {
		try {

			RestauranteItem restaurante = new RestauranteItem(
					json.getString("nombre"), json.getString("informacion"),
					json.getString("latitud"), json.getString("longitud"),
					json.getString("url_imagen"), json.getString("url_logo"),
					json.getString("zona"), json.getString("comida"));
			
			return restaurante;

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ///////////////// VIDA NOCTURNA ///////////////////////////////
	public ArrayList<VidaNocturnaItem> consultarVida() {
		JSONArray array = consultarWebService(4, 1);
		ArrayList<VidaNocturnaItem> list=new ArrayList<VidaNocturnaItem>();

		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject json = array.getJSONObject(i);
				Log.i("TAG", "RESPUESTA: " + json);
				list.add(parserVida(json));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private VidaNocturnaItem parserVida(JSONObject json) {
		try {

			VidaNocturnaItem vida=new VidaNocturnaItem(
					json.getString("nombre"), json.getString("informacion"),
					json.getString("latitud"), json.getString("longitud"),
					json.getString("url_imagen"), json.getString("url_logo"),
					json.getString("zona"), json.getString("categoria"));
			
			return vida;

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ///////////////// TOURS ///////////////////////////////
		public ArrayList<ToursItem> consultarTours() {
			JSONArray array = consultarWebService(5, 1);
			ArrayList<ToursItem> list=new ArrayList<ToursItem>();

			for (int i = 0; i < array.length(); i++) {
				try {
					JSONObject json = array.getJSONObject(i);
					Log.i("TAG", "RESPUESTA: " + json);
					list.add(parserTours(json));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}

		private ToursItem parserTours(JSONObject json) {
			try {

				ToursItem tour=new ToursItem(
						json.getString("nombre"), json.getString("informacion"),
						json.getString("latitud"), json.getString("longitud"),
						json.getString("url_imagen"), json.getString("url_logo"),
						json.getString("zona"), json.getString("tipo_tour"));
				
				return tour;

			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		}
}
