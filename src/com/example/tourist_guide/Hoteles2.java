package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hoteles2 extends Activity implements OnClickListener {

	private Button btn2Estrellas;
	private Button btn3Estrellas;
	private Button btn4Estrellas;
	private Button btn5Estrellas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu7);

		initViews();
	}

	private void initViews() {
		btn2Estrellas = (Button) findViewById(R.id.btnTipoEstrellas2);
		btn3Estrellas = (Button) findViewById(R.id.btnTipoEstrellas3);
		btn4Estrellas = (Button) findViewById(R.id.btnTipoEstrellas4);
		btn5Estrellas = (Button) findViewById(R.id.btnTipoEstrellas5);

		btn2Estrellas.setOnClickListener(this);
		btn3Estrellas.setOnClickListener(this);
		btn4Estrellas.setOnClickListener(this);
		btn5Estrellas.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnTipoEstrellas2:
			mostrarHotelesTipo("2");
			break;
		case R.id.btnTipoEstrellas3:
			mostrarHotelesTipo("3");
			break;
		case R.id.btnTipoEstrellas4:
			mostrarHotelesTipo("4");
			break;
		case R.id.btnTipoEstrellas5:
			mostrarHotelesTipo("5");
			break;
		}

	}
	
	private void mostrarHotelesTipo(String numero){
		Intent i=new Intent(this, ListaHoteles.class);
		i.putExtra("AMBITO", "ESTRELLAS");
		i.putExtra("ESTRELLAS", numero);
		startActivity(i);
		
	}
}
