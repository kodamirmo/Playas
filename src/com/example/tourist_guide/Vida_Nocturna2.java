package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Vida_Nocturna2 extends Activity implements OnClickListener {

	private Button btnAntros;
	private Button btnResBar;
	private Button btnBares;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu9);

		initViews();
	}

	private void initViews() {
		btnAntros = (Button) findViewById(R.id.btnAntros);
		btnAntros.setOnClickListener(this);
		btnResBar = (Button) findViewById(R.id.btnResBar);
		btnResBar.setOnClickListener(this);
		btnBares = (Button) findViewById(R.id.btnBares);
		btnBares.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnAntros:
			mostrarVidaNocturna("antro");
			break;
		case R.id.btnResBar:
			mostrarVidaNocturna("restaurante");
			break;
		case R.id.btnBares:
			mostrarVidaNocturna("bares");
			break;
		}
	}
	
	private void mostrarVidaNocturna(String categoria){
		Intent i=new Intent(this, ListaVidaNocturna.class);
		i.putExtra("AMBITO", "CATEGORIA");
		i.putExtra("CATEGORIA", categoria);
		startActivity(i);
		
	}
}