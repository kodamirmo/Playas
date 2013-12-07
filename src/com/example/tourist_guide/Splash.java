package com.example.tourist_guide;

import com.karen.tourist_guide.cache.HotelCache;
import com.karen.tourist_guide.cache.PlayaCache;
import com.karen.tourist_guide.cache.RestaurantCache;
import com.karen.tourist_guide.cache.TourCache;
import com.karen.tourist_guide.cache.VidaNocturnaChache;
import com.karen.tourist_guide.webservices.WebServiceDownloadData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;

public class Splash extends Activity {
	
	private Activity act;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		act=this;
		new AsyncTaskWStraductor(this).execute();
	}

	private class AsyncTaskWStraductor extends AsyncTask<Void, Void, String> {

		protected ProgressDialog dialogo;
		private Activity act;

		public AsyncTaskWStraductor(Activity actividad) {
			act = actividad;	
			Log.i("TAG", "En constructor de consultando");
		}

		protected void onPreExecute() {
			Log.i("TAG", "En preExectute");
			dialogo = new ProgressDialog(act);
			dialogo.setIndeterminate(true);
			String mensaje ="Downloading";
			dialogo.setMessage(mensaje);
			dialogo.setTitle("Tourist Guide");
			dialogo.setCancelable(false);
			//dialogo.show();
		}

		@Override
		protected String doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
			WebServiceDownloadData download=new WebServiceDownloadData();
			PlayaCache.setListItems(download.consultarPlayas());
			HotelCache.setListItems(download.consultarHoteles());
			RestaurantCache.setListItems(download.consultarRestaurantes());
			VidaNocturnaChache.setListItems(download.consultarVida());
			TourCache.setListItems(download.consultarTours());
			return null;
		}

		protected void onPostExecute(final String result) {
			//dialogo.cancel();
			goToMain();
		}
		
		private void goToMain(){
			Intent i=new Intent(getBaseContext(),MainActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			getBaseContext().startActivity(i);
			act.finish();
		}

	}// Termina AsyncTask
}
