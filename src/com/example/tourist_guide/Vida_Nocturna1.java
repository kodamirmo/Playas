package com.example.tourist_guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Vida_Nocturna1 extends Activity implements OnClickListener {

	private Button btnZona3;
	private Button btnCategoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu8);

		initViews();
	}

	private void initViews() {
		btnZona3 = (Button) findViewById(R.id.btnZona3);
		btnZona3.setOnClickListener(this);
		btnCategoria = (Button) findViewById(R.id.btnCategoria);
		btnCategoria.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();

		switch (id) {
		case R.id.btnZona3:
			irAZona();
			break;
		case R.id.btnCategoria:
			irACategoria();
			break;
		}

	}

	private void irAZona() {
		Intent i = new Intent(this, Playas2.class);
		i.putExtra("AMBITO", 4);
		startActivity(i);
	}


	private void irACategoria() {
		Intent i = new Intent(this, Vida_Nocturna2.class);
		startActivity(i);
	}
}