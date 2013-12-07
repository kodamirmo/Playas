package com.example.tourist_guide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.adapters.TourAdapter;
import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.cache.TourCache;
import com.karen.tourist_guide.objects.ToursItem;
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

public class ListaTours extends Activity implements OnItemClickListener{

	private ListView listaTours;
	private ArrayList<ToursItem> listItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_tours);

		initViews();
		new AsyncTaskList(this).execute();
	}

	private void initViews() {
		listaTours = (ListView) findViewById(R.id.listViewTours);
		listaTours.setOnItemClickListener(this);
		String ambito = getIntent().getStringExtra("AMBITO");

		if (ambito.equals("ZONA")) {
			String zona = getIntent().getStringExtra("ZONA");
			listItems = TourCache.getItemsZona(zona);
		} else if (ambito.equals("TIPO")) {
			String tipo = getIntent().getStringExtra("TIPO");
			listItems = TourCache.getItemsTour(tipo);
		}
	}

	private TourAdapter fillList() {
		return new TourAdapter(this, listItems);
	}

	private class AsyncTaskList extends AsyncTask<Void, Void, TourAdapter> {

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
		protected TourAdapter doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");

			Iterator<ToursItem> iterator = listItems.iterator();
			while (iterator.hasNext()) {
				ToursItem item = iterator.next();
				if (item.getImagenIcono() == null) {
					if (!item.getUrlImagen().trim().equals("")) {
						try {
							item.setImagenIcono(DownloadImage
									.getBitmapFromURL(item.getUrlLogo()));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			return fillList();
		}

		protected void onPostExecute(final TourAdapter result) {
			runOnUiThread(new Runnable() {
				public void run() {
					listaTours.setAdapter(result);
				}
			});
			dialogo.cancel();
		}

	}// Termina AsyncTask
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("TAG","click");
		ToursItem item=listItems.get(position);
		
		ItemChache.tourItem=item;
		
		Intent i=new Intent(this, DetalleTour.class);
		startActivity(i);	
		
	}

}
