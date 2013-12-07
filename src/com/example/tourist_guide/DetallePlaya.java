package com.example.tourist_guide;

import java.io.IOException;

import com.karen.tourist_guide.cache.ItemChache;
import com.karen.tourist_guide.objects.PlayaItem;
import com.karen.tourist_guide.webservices.DownloadImage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetallePlaya extends Activity {

	private PlayaItem item;
	private RelativeLayout imageContainer;
	private TextView tvNombre;
	private TextView tvInformacion;
	private TextView tvZona;
	private TextView tvTipo;
	
	private Button btnMapa;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_playa);
		
		item=ItemChache.playaItem;
		initViews();
		new AsyncTaskDownload(this).execute();
	}
	
	private void initViews(){
		imageContainer=(RelativeLayout)findViewById(R.id.containerPlayaImage);
		tvNombre=(TextView)findViewById(R.id.tvNombrePlaya);
		tvInformacion=(TextView)findViewById(R.id.tvInfoPlaya);
		tvZona=(TextView)findViewById(R.id.tvZonaPlaya);
		tvTipo=(TextView)findViewById(R.id.tvTipoPlaya);
		btnMapa=(Button)findViewById(R.id.btnMapRestaurante);
		btnMapa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getBaseContext(), MapScreen.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				i.putExtra("LATITUD",item.getLatitud());
				i.putExtra("LONGITUD", item.getLongitud());
				i.putExtra("NOMBRE",item.getNombre());
				i.putExtra("TIPO", "Restaurante");
				getBaseContext().startActivity(i);
			}
		});
		
		tvNombre.setText(item.getNombre());
		tvInformacion.setText(item.getInformacion());
		tvZona.setText(item.getZona());
		tvTipo.setText(item.getTipoPlaya());
	}

	private class AsyncTaskDownload extends AsyncTask<Void, Void, Bitmap> {

		protected ProgressDialog dialogo;
		private Activity act;
		
		public AsyncTaskDownload(Activity actividad) {
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
		protected Bitmap doInBackground(Void... params) {
			Log.i("TAG", "En backgroud Login");
		
			try {
				return DownloadImage.getBitmapFromURL(item.getUrlImagen());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		protected void onPostExecute(final Bitmap result) {
			Log.i("TAG", "On post");
			runOnUiThread( new Runnable() {
				public void run() {
					if(result!=null){
						BitmapDrawable background = new BitmapDrawable(result);
						imageContainer.setBackgroundDrawable(background);
					}
				}
			});
			dialogo.cancel();
		}
		
	}// Termina AsyncTask

}
