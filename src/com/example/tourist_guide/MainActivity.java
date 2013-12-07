package com.example.tourist_guide;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener{
	
	private RelativeLayout btnPlayas;
	private RelativeLayout btnRestaurantes;
	private RelativeLayout btnHoteles;
	private RelativeLayout btnVida_Nocturna;
	private RelativeLayout btnTours;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
	}

	private void initViews(){
		btnPlayas=(RelativeLayout)findViewById(R.id.btnMenuPlayas);
		btnPlayas.setOnClickListener(this);
		btnRestaurantes=(RelativeLayout)findViewById(R.id.btnMenuRestaurantes);
		btnRestaurantes.setOnClickListener(this);
		btnHoteles=(RelativeLayout)findViewById(R.id.btnMenuHoteles);
		btnHoteles.setOnClickListener(this);
		btnVida_Nocturna=(RelativeLayout)findViewById(R.id.btnMenuVida_Nocturna);
		btnVida_Nocturna.setOnClickListener(this);
		btnTours=(RelativeLayout)findViewById(R.id.btnMenuTours);
		btnTours.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		int id=v.getId();
		// hacer todo esto en las demas pantallas para ir a menus
		switch(id){
			case R.id.btnMenuPlayas:
				irAPlayas();
				break;
			case R.id.btnMenuRestaurantes:
				irARestaurantes();
				break;
			case R.id.btnMenuHoteles:
				irAHoteles();
				break;
			case R.id.btnMenuVida_Nocturna:
				irAVida_Nocturna();
			    break;
			case R.id.btnMenuTours:
				irATours1();
				break;
		}	
	}
	
	private void irAPlayas(){
		Intent i=new Intent(this,Playas1.class);
		startActivity(i);
	}
	
	private void irARestaurantes(){
		Intent i=new Intent(this,Restaurantes1.class);
		startActivity(i);
		
	}
	
	private void irAHoteles(){
		Intent i=new Intent(this,Hoteles1.class);
		startActivity(i);
	}

	private void irAVida_Nocturna(){
		Intent i=new Intent (this,Vida_Nocturna1.class);
		startActivity(i);
		
	}
	
	private void irATours1(){
		Intent i=new Intent(this,Tours1.class);
		startActivity(i);
	}
}
