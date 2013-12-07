package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tours2 extends Activity implements OnClickListener {

	private Button btnExcursiones;
	private Button btnAventura;
	private Button btnEcologico;
	private Button btnArqueologicos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu11);

		initViews();

	}

	private void initViews() {
		btnExcursiones = (Button) findViewById(R.id.btnExcursines);
		btnExcursiones.setOnClickListener(this);
		btnAventura = (Button) findViewById(R.id.btnAventura);
		btnAventura.setOnClickListener(this);
		btnEcologico = (Button) findViewById(R.id.btnEcologico);
		btnEcologico.setOnClickListener(this);
		btnArqueologicos = (Button) findViewById(R.id.btnArqueologicos);
		btnArqueologicos.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnExcursines:
			mostrarToursTipo("excursiones");
			break;
		case R.id.btnAventura:
			mostrarToursTipo("aventura");
			break;
		case R.id.btnEcologico:
			mostrarToursTipo("ecologico");
			break;
		case R.id.btnArqueologicos:
			mostrarToursTipo("arqueologico");
			break;
		}

	}
	
	private void mostrarToursTipo(String tipo){
		Intent i=new Intent(this, ListaTours.class);
		i.putExtra("AMBITO", "TIPO");
		i.putExtra("TIPO", tipo);
		startActivity(i);
		
	}

}
