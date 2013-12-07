package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Playas2 extends Activity implements OnClickListener {

	private Button btnCancun;
	private Button btnChetumal;
	private Button btnChicheniza;
	private Button btnCozumel;
	private Button btnHolbox;
	private Button btnIslasMujeres;
	private Button btnMerida;
	private Button btnPlayadelCarmen;
	private Button btnRiveraMaya;

	private ImageView coverImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu3);

		initViews();
		setCover();
	}

	private void initViews() {
		btnCancun = (Button) findViewById(R.id.btnCancun);
		btnCancun.setOnClickListener(this);
		btnChetumal = (Button) findViewById(R.id.btnChetumal);
		btnChetumal.setOnClickListener(this);
		btnChicheniza = (Button) findViewById(R.id.btnChicheniza);
		btnChicheniza.setOnClickListener(this);
		btnCozumel = (Button) findViewById(R.id.btnCozumel);
		btnCozumel.setOnClickListener(this);
		btnHolbox = (Button) findViewById(R.id.btnHolbox);
		btnHolbox.setOnClickListener(this);
		btnIslasMujeres = (Button) findViewById(R.id.btnIslasMujeres);
		btnIslasMujeres.setOnClickListener(this);
		btnMerida = (Button) findViewById(R.id.btnMerida);
		btnMerida.setOnClickListener(this);
		btnPlayadelCarmen = (Button) findViewById(R.id.btnPlayadelCarmen);
		btnPlayadelCarmen.setOnClickListener(this);
		btnRiveraMaya = (Button) findViewById(R.id.btnRiveraMaya);
		btnRiveraMaya.setOnClickListener(this);

		coverImage = (ImageView) findViewById(R.id.imageViewCoverZona);

	}

	private void setCover() {
		int ambito = getIntent().getIntExtra("AMBITO", 0);
		switch (ambito) {
		case 1:
			coverImage.setImageResource(R.drawable.banner_playas2);
			break;
		case 2:
			coverImage.setImageResource(R.drawable.banner_restaurantes2);
			break;
		case 3:
			coverImage.setImageResource(R.drawable.banner_hoteles2);
			break;
		case 4:
			coverImage.setImageResource(R.drawable.banner_vida_nocturna2);
			break;
		case 5:
			coverImage.setImageResource(R.drawable.banner_tours2);
			break;
		}

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnCancun:
			mostrarZona("cancun");
			break;
		case R.id.btnChetumal:
			mostrarZona("chetumal");
			break;
		case R.id.btnChicheniza:
			mostrarZona("chichenitza");
			break;
		case R.id.btnCozumel:
			mostrarZona("cozumel");
			break;
		case R.id.btnHolbox:
			mostrarZona("holbox");
			break;
		case R.id.btnIslasMujeres:
			mostrarZona("islas");
			break;
		case R.id.btnMerida:
			mostrarZona("merida");
			break;
		case R.id.btnPlayadelCarmen:
			mostrarZona("carmen");
			break;
		case R.id.btnRiveraMaya:
			mostrarZona("rivera");
			break;

		}
	}
	
	private Intent getIntentNextScreen(){
		int ambito = getIntent().getIntExtra("AMBITO", 0);
		
		Intent i=null;
		
		switch (ambito) {
		case 1:
			i=new Intent(this, ListaPlayas.class);
			break;
		case 2:
			i=new Intent(this, ListaRestaurantes.class);
			break;
		case 3:
			i=new Intent(this, ListaHoteles.class);
			break;
		case 4:
			i=new Intent(this, ListaVidaNocturna.class);
			break;
		case 5:
			i=new Intent(this, ListaTours.class);
			break;
		}
		
		return i;
	}
	
	private void mostrarZona(String zona){
		Intent i=getIntentNextScreen();
		i.putExtra("AMBITO", "ZONA");
		i.putExtra("ZONA", zona);
		startActivity(i);
		
	}

}
