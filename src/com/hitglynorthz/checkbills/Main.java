package com.hitglynorthz.checkbills;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	/* CICLO DE VIDA */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		
		TextView tv = (TextView) findViewById(R.id.dateHoy);
		String ct = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(new Date());
		tv.setText("Hoy es: " + ct);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		
	}
	@Override
	protected void onPause() {
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		super.onPause();
		
	}
	@Override
	protected void onStop() {
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		super.onStop();
		
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		
	}
	@Override
	protected void onDestroy() {
		//Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		super.onDestroy();
		
	}

	
	/* MENU */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	/* LANZADORES */
	public void lanzarGastos(View view){
        Intent i = new Intent(this, Gastos.class);
        startActivity(i);
    }
	
	public void lanzarIngresos(View view){
        Intent i = new Intent(this, Ingresos.class);
        startActivity(i);
    }

}
