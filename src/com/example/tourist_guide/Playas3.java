package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Playas3 extends Activity implements OnClickListener {

	private Button btnPrivada;
	private Button btnPublica;
	private Button btnNudista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu12);

		initViews();

	}

	private void initViews() {
		btnPrivada = (Button) findViewById(R.id.btnPrivada);
		btnPrivada.setOnClickListener(this);
		btnPublica = (Button) findViewById(R.id.btnPublica);
		btnPublica.setOnClickListener(this);
		btnNudista = (Button) findViewById(R.id.btnNudista);
		btnNudista.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnPrivada:
			mostrarPorZona("privada");
			break;
		case R.id.btnPublica:
			mostrarPorZona("publica");
			break;
		case R.id.btnNudista:
			mostrarPorZona("nudista");
			break;

		}

	}
	
	private void mostrarPorZona(String tipo){
		Intent i = new Intent(this, ListaPlayas.class);
		i.putExtra("AMBITO", "TIPO");
		i.putExtra("TIPO", tipo);
		startActivity(i);
	}
	
}
