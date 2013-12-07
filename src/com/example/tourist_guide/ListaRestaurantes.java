package com.example.tourist_guide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.adapters.RestaurantAdapter;
import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.cache.RestaurantCache;
import com.karen.tourist_guide.objects.RestauranteItem;
import com.karen.tourist_guide.webservices.DownloadImage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListaRestaurantes extends Activity implements OnItemClickListener{

	private ListView listaRestaurantes;
	private ArrayList<RestauranteItem> listItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_restaurantes);
		
		initViews();
		new AsyncTaskList(this).execute();
	}
	
	private void initViews(){
		listaRestaurantes=(ListView)findViewById(R.id.listViewRestaurantes);
		listaRestaurantes.setOnItemClickListener(this);
		
		String ambito =getIntent().getStringExtra("AMBITO");
		Log.i("TAG", "Ambito " + ambito);
		
		 if(ambito.equals("ZONA")){
			String zona =getIntent().getStringExtra("ZONA");
			Log.i("TAG", "Zona " + zona);
			listItems=RestaurantCache.getItemsZona(zona);
		}
		else if(ambito.equals("TIPO")){
			String tipo =getIntent().getStringExtra("TIPO");
			Log.i("TAG", "Tipo " + tipo);
			listItems=RestaurantCache.getItemsComida(tipo);
		}

	}
	
	private RestaurantAdapter fillList() {
		return new RestaurantAdapter(this, listItems);
	}
	
	private class AsyncTaskList extends AsyncTask<Void, Void, RestaurantAdapter> {

		protected ProgressDialog dialogo;
		private Activity act;
		
		public AsyncTaskList(Activity actividad) {
			act = actividad;
			Log.i("TAG", "En constructor de consultando");
		}
	
		protected void onPreExecute() {
			Log.i("TAG", "En preExectute");
			dialogo = new ProgressDialog(act);
			dialogo.setIndeterminate(true);
			String mensaje = "Downloading";
			dialogo.setMessage(mensaje);
			dialogo.setTitle("Tourist Guide");
			dialogo.setCancelable(false);
			dialogo.show();
		}

		@Override
		protected RestaurantAdapter doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
			
			Iterator<RestauranteItem> iterator=listItems.iterator();
			while(iterator.hasNext()){
				RestauranteItem  item=iterator.next();
				if(item.getImagenIcono()==null){
					if(!item.getUrlImagen().trim().equals("")){
						try {
							item.setImagenIcono(DownloadImage.getBitmapFromURL(item.getUrlLogo()));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			return fillList();
		}
		
		protected void onPostExecute(final RestaurantAdapter result) {
			Log.i("TAG", "On post");
			runOnUiThread( new Runnable() {
				public void run() {
					listaRestaurantes.setAdapter(result);
				}
			});
			dialogo.cancel();
		}
		
	}// Termina AsyncTask


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("TAG","click");
		RestauranteItem item=listItems.get(position);
		
		ItemChache.restaurantItem=item;
		
		Intent i=new Intent(this, DetalleRestaurant.class);
		startActivity(i);	
		
	}

}
