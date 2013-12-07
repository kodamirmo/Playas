package com.example.tourist_guide;

import java.util.ArrayList;

import com.karen.tourist_guide.adapters.PlayasAdapter;
import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.cache.PlayaCache;
import com.karen.tourist_guide.objects.PlayaItem;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

public class ListaPlayas extends Activity implements OnItemClickListener{

	private ListView listaPlayas;
	private ArrayList<PlayaItem> listItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_playas);

		initViews();
		new AsyncTaskList(this).execute();
	}

	private void initViews() {
		listaPlayas = (ListView) findViewById(R.id.listViewPlayas);
		listaPlayas.setOnItemClickListener(this);
		
		String ambito = getIntent().getStringExtra("AMBITO");
		
		if (ambito.equals("TODAS"))
			listItems = PlayaCache.getAllItems();
		else if (ambito.equals("ZONA")) {
			String zona = getIntent().getStringExtra("ZONA");
			listItems = PlayaCache.getItemsZona(zona);
		} else if (ambito.equals("TIPO")) {
			String tipo = getIntent().getStringExtra("TIPO");
			listItems = PlayaCache.getItemsTipo(tipo);
		}
	}

	private PlayasAdapter fillList() {
		return new PlayasAdapter(this, listItems);
	}

	private class AsyncTaskList extends AsyncTask<Void, Void, PlayasAdapter> {

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
		protected PlayasAdapter doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
			return fillList();
		}

		protected void onPostExecute(final PlayasAdapter result) {
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					listaPlayas.setAdapter(result);		
				}
			});
			
			dialogo.cancel();
		}
	}// Termina AsyncTask
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.i("TAG","click");
		PlayaItem item=listItems.get(position);
		
		ItemChache.playaItem=item;
		
		Intent i=new Intent(this, DetallePlaya.class);
		startActivity(i);	
		
	}
}
