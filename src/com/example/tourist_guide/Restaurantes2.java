package com.example.tourist_guide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Restaurantes2 extends Activity implements OnClickListener{
	
	private Button btnComidaMexicana;
	private Button btnComidaJaponesa;
	private Button btnComidaCarnesyCortes;
	private Button btnComidaItaliana;
	private Button btnComidaCarnesyLangosta;
	private Button btnComidaInternacional;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu5);
		
		initViews();
	}

	private void initViews(){
		btnComidaMexicana=(Button)findViewById(R.id.btnComidaMexicana);
		btnComidaMexicana.setOnClickListener(this);
		btnComidaJaponesa=(Button)findViewById(R.id.btnComidaJaponesa);
		btnComidaJaponesa.setOnClickListener(this);
		btnComidaCarnesyCortes=(Button)findViewById(R.id.btnComidaCarnesyCortes);
		btnComidaCarnesyCortes.setOnClickListener(this);
		btnComidaItaliana=(Button)findViewById(R.id.btnComidaItaliana);
		btnComidaItaliana.setOnClickListener(this);
		btnComidaCarnesyLangosta=(Button)findViewById(R.id.btnComidaCarnesyLangostas);
		btnComidaCarnesyLangosta.setOnClickListener(this);
		btnComidaInternacional=(Button)findViewById(R.id.btnComidaInternacional);
		btnComidaInternacional.setOnClickListener(this);
		

	}
	
	
	@Override
	public void onClick(View v) {
		int id=v.getId();
		
		switch(id){
			case R.id.btnComidaMexicana:
				mostrarRestaurantesTipo("mexicana");
				break;
			case R.id.btnComidaJaponesa:
				mostrarRestaurantesTipo("japonesa");
				break;
			case R.id.btnComidaCarnesyCortes:
				mostrarRestaurantesTipo("cortes");
				break;
			case R.id.btnComidaItaliana:
				mostrarRestaurantesTipo("italiana");
				break;
			case R.id.btnComidaCarnesyLangostas:
				mostrarRestaurantesTipo("langosta");
				break;
			case R.id.btnComidaInternacional:
				mostrarRestaurantesTipo("internacional");
				break;
		}	
	}
	
	private void mostrarRestaurantesTipo(String tipo){
		Intent i=new Intent(this, ListaRestaurantes.class);
		i.putExtra("AMBITO", "TIPO");
		i.putExtra("TIPO", tipo);
		startActivity(i);
		
	}

}
