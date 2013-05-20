package com.hitglynorthz.checkbills;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddGasto extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgasto);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
	
	// MENU
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.menu_addgasto, menu);
			return true;
		}
				
		@Override 
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case android.R.id.home:
				Intent intent = new Intent(this, Gastos.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				break;
			case R.id.AddGasto:
				 //lanzarAñadir(null);
				 break;
			case R.id.About:
				 //lanzarAbout(null);
				 break;
			}
			return true; /** true -> consumimos el item, no se propaga*/
		}
	
	
	//LANZADORES
		public void lanzarEscribir(View view){
			escribirGastos();
		}
	
	// ESCRIBIR GASTOS
	    private void escribirGastos() {
	    	//Abrimos la base de datos
	    	GastosSQLite usdbh = new GastosSQLite(this, "DBGastos", null, 1);
	    	SQLiteDatabase db = usdbh.getWritableDatabase();
	    	// leer del editText
	    	final EditText nomGasto = (EditText)findViewById(R.id.NomGasto);
    		String NomGasto = nomGasto.getText().toString();
    		final EditText cantGasto = (EditText)findViewById(R.id.CantGasto);
    		int CantGasto = Integer.valueOf(cantGasto.getText().toString());
	 
	        //Si hemos abierto correctamente la base de datos
	        if(db != null)
	        {
	        	//Insertamos los datos en la tabla Usuarios
                db.execSQL("INSERT INTO Gastos (codigo, nombre) " + "VALUES (" + CantGasto + ", '" + NomGasto +"')");
                Toast.makeText(this, "Gasto " + NomGasto + " introducido", Toast.LENGTH_SHORT).show();
	 
	            //Cerramos la base de datos
	            db.close();
	        }
	    }

}
