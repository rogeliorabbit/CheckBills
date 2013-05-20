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

public class AddIngreso extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addingreso);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //escribirXML();
    }
	
	// MENU
			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				MenuInflater inflater = getMenuInflater();
				inflater.inflate(R.menu.menu_addingreso, menu);
				return true;
			}
				
			@Override 
			public boolean onOptionsItemSelected(MenuItem item) {
				switch (item.getItemId()) {
				case android.R.id.home:
					Intent intent = new Intent(this, Ingresos.class);
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
		escribirIngreso();
    }
	
	// ESCRIBIR INGRESOS
    private void escribirIngreso() {
    	//Abrimos la base de datos
    	IngresosSQLite usdbh = new IngresosSQLite(this, "DBCheckBills", null, 1);
    	SQLiteDatabase db = usdbh.getWritableDatabase();
    	// leer del editText
    	final EditText nomIngreso = (EditText)findViewById(R.id.NomIngreso);
		String NomIngreso = nomIngreso.getText().toString();
		final EditText cantIngreso = (EditText)findViewById(R.id.CantIngreso);
		int CantIngreso = Integer.valueOf(cantIngreso.getText().toString());
 
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Ingresos (codigo, nombre) " + "VALUES (" + CantIngreso + ", '" + NomIngreso +"')");
            Toast.makeText(this, "Ingreso " + NomIngreso + " introducido", Toast.LENGTH_SHORT).show();
 
            //Cerramos la base de datos
            db.close();
        }
    }

}
