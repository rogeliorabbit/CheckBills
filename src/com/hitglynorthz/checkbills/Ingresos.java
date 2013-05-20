package com.hitglynorthz.checkbills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Ingresos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingresos);
        getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	// MENU
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.menu_ingresos, menu);
			return true;
		}
			
		@Override 
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case android.R.id.home:
				Intent intent = new Intent(this, Main.class);
			    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			    startActivity(intent);
			    break;
			case R.id.AddIngreso:
			    lanzarAñadir(null);
			    break;
			case R.id.About:
			    //lanzarAbout(null);
			    break;
			}
			return true; /** true -> consumimos el item, no se propaga*/
		}
		
		/* LANZADORES */
		public void lanzarAñadir(View view){
	        Intent i = new Intent(this, AddIngreso.class);
	        startActivity(i);
	    }

}
