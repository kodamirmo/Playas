package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tours1 extends Activity implements OnClickListener {

	private Button btnZona4;
	private Button btnTipoTour;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu10);

		initViews();
	}

	private void initViews() {
		btnZona4 = (Button) findViewById(R.id.btnZona4);
		btnZona4.setOnClickListener(this);
		btnTipoTour = (Button) findViewById(R.id.btnTipoTour);
		btnTipoTour.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnZona4:
			irAZona();
			break;
		case R.id.btnTipoTour:
			irATipo();
			break;
		}

	}

	private void irAZona() {
		Intent i = new Intent(this, Playas2.class);
		i.putExtra("AMBITO", 5);
		startActivity(i);
	}

	private void irATipo() {
		Intent i = new Intent(this, Tours2.class);
		startActivity(i);
	}

}
