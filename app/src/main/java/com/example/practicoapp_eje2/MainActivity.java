package com.example.practicoapp_eje2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acceder();
    }

    private void acceder(){

            Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver contenedor = getContentResolver();
        Cursor cursor = contenedor.query(llamadas,null,null,null,null);

        String nro=null;
        String tiempo=null;
        String nombre = null;
        String apellido = null;
        String mensaje = null;

        if(cursor.getCount()>0){
            while(cursor.moveToNext()){

                nro= cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                tiempo= cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
          //      nombre= cursor.getString(cursor.getColumnIndex(Contacts.));
                apellido= cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NUMBER_LABEL));
                mensaje= cursor.getString(cursor.getColumnIndex(CallLog.Calls.FEATURES));

                Log.d("nro ", nro);
                Log.d("tiempo ", tiempo);
                Log.d("apellido ", apellido);
                Log.d("mensaje ", mensaje);

            }
        }
    }
}