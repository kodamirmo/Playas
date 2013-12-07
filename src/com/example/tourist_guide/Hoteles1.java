package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hoteles1 extends Activity implements OnClickListener {

	private Button btnTipo_Hotel;
	private Button btnZona;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu6);

		initViews();

	}

	private void initViews() {
		btnTipo_Hotel = (Button) findViewById(R.id.btnTipo_Hotel);
		btnTipo_Hotel.setOnClickListener(this);
		btnZona = (Button) findViewById(R.id.btnZona);
		btnZona.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {

		case R.id.btnTipo_Hotel:
			irATipoHotel();
			break;
		case R.id.btnZona:
			irAZonaHotel();
			break;
		}

	}


	private void irATipoHotel() {
		Intent i = new Intent(this, Hoteles2.class);
		startActivity(i);
	}

	private void irAZonaHotel() {
		Intent i = new Intent(this, Playas2.class);
		i.putExtra("AMBITO", 3);
		startActivity(i);
	}
}
