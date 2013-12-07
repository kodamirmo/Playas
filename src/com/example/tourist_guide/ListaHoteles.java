package com.example.tourist_guide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.adapters.HotelAdapter;
import com.karen.tourist_guide.cache.HotelCache;
import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.objects.HotelItem;
import com.karen.tourist_guide.webservices.DownloadImage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListaHoteles extends Activity implements OnItemClickListener{

	private ListView listaHoteles;
	private ArrayList<HotelItem> listItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_hoteles);

		initViews();	
		new AsyncTaskList(this).execute();
	}

	private void initViews() {
		listaHoteles = (ListView) findViewById(R.id.listViewHoteles);
		listaHoteles.setOnItemClickListener(this);
		String ambito = getIntent().getStringExtra("AMBITO");
		
		if (ambito.equals("ZONA")) {
			String zona = getIntent().getStringExtra("ZONA");
			listItems = HotelCache.getItemsZona(zona);
		} else if (ambito.equals("ESTRELLAS")) {
			String estrellas = getIntent().getStringExtra("ESTRELLAS");
			listItems = HotelCache.getItemsEstrellas(estrellas);
		}
	}
	
	private HotelAdapter fillList() {
		return new HotelAdapter(this, listItems);
	}

	private class AsyncTaskList extends AsyncTask<Void, Void, HotelAdapter> {

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
		protected HotelAdapter doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
			
			Iterator<HotelItem> iterator=listItems.iterator();
			while(iterator.hasNext()){
				HotelItem  item=iterator.next();
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
		
		protected void onPostExecute(final HotelAdapter result) {
			runOnUiThread( new Runnable() {
				public void run() {
					listaHoteles.setAdapter(result);
				}
			});
			dialogo.cancel();
		}
		
	}// Termina AsyncTask
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("TAG","click");
		HotelItem item=listItems.get(position);
		
		ItemChache.hotelItem=item;
		
		Intent i=new Intent(this, DetalleHotel.class);
		startActivity(i);	
		
	}

}
