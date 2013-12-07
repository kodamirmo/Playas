package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Restaurantes1 extends Activity implements OnClickListener {

	private Button btnZona1;
	private Button btnTipoComida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu4);

		initViews();
	}

	private void initViews() {
		btnZona1 = (Button) findViewById(R.id.btnZona1);
		btnZona1.setOnClickListener(this);
		btnTipoComida = (Button) findViewById(R.id.btnTipoComida);
		btnTipoComida.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnZona1:
			irAZona();
			break;
		case R.id.btnTipoComida:
			irATipoComia();
			break;
		}

	}

	private void irAZona() {
		Intent i = new Intent(this, Playas2.class);
		i.putExtra("AMBITO", 2);
		startActivity(i);
	}

	
	private void irATipoComia() {
		Intent i = new Intent(this, Restaurantes2.class);
		startActivity(i);
	}

}
