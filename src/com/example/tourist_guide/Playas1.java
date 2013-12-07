package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Playas1 extends Activity implements OnClickListener {

	private Button btnPlayas;
	private Button btnZona;
	private Button btnTipo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu2);

		initViews();

	}

	private void initViews() {
		btnPlayas = (Button) findViewById(R.id.btnPlayas);
		btnPlayas.setOnClickListener(this);
		btnZona = (Button) findViewById(R.id.btnZona);
		btnZona.setOnClickListener(this);
		btnTipo = (Button) findViewById(R.id.btnTipo);
		btnTipo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnPlayas:
			mostrarTodas();
			break;
		case R.id.btnZona:
			irAZona();
			break;
		case R.id.btnTipo:
			irAPlayas3();
			break;

		}

	}

	private void mostrarTodas(){
		Intent i = new Intent(this, ListaPlayas.class);
		i.putExtra("AMBITO", "TODAS");
		startActivity(i);
	}
	
	private void irAZona() {
		Intent i = new Intent(this, Playas2.class);
		i.putExtra("AMBITO", 1);
		startActivity(i);
	}

	private void irAPlayas3() {
		Intent i = new Intent(this, Playas3.class);
		startActivity(i);
	}
}
