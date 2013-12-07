package com.example.tourist_guide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.karen.tourist_guide.adapters.VidaNocturnaAdapter;
import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.cache.VidaNocturnaChache;
import com.karen.tourist_guide.objects.PlayaItem;
import com.karen.tourist_guide.objects.VidaNocturnaItem;
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

public class ListaVidaNocturna extends Activity implements OnItemClickListener{
	
	private ListView listaVidaNocturna;
	private ArrayList<VidaNocturnaItem> listItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_vida_nocturna);

		initViews();
		new AsyncTaskList(this).execute();
	}

	private void initViews() {
		listaVidaNocturna = (ListView) findViewById(R.id.listViewVidaNocturna);
		listaVidaNocturna.setOnItemClickListener(this);
		
		String ambito = getIntent().getStringExtra("AMBITO");

		if (ambito.equals("ZONA")) {
			String zona = getIntent().getStringExtra("ZONA");
			listItems = VidaNocturnaChache.getItemsZona(zona);
		} else if (ambito.equals("CATEGORIA")) {
			String categoria = getIntent().getStringExtra("CATEGORIA");
			listItems = VidaNocturnaChache.getItemsCategoria(categoria);
		}

	}
	
	private VidaNocturnaAdapter fillList() {
		return new VidaNocturnaAdapter(this, listItems);
	}
	
	private class AsyncTaskList extends AsyncTask<Void, Void,VidaNocturnaAdapter> {

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
		protected VidaNocturnaAdapter doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
			
			Iterator<VidaNocturnaItem> iterator=listItems.iterator();
			while(iterator.hasNext()){
				VidaNocturnaItem  item=iterator.next();
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
		
		protected void onPostExecute(final VidaNocturnaAdapter result) {
			Log.i("TAG", "On post");
			runOnUiThread( new Runnable() {
				public void run() {
					listaVidaNocturna.setAdapter(result);
				}
			});
			dialogo.cancel();
		}
		
	}// Termina AsyncTask
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("TAG","click");
		VidaNocturnaItem item=listItems.get(position);
		
		ItemChache.vidaItem=item;
		
		Intent i=new Intent(this, DetailVidaNocturna.class);
		startActivity(i);	
		
	}

}
