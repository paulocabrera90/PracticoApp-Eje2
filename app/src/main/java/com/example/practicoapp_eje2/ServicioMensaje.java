package com.example.practicoapp_eje2;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.CallLog;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServicioMensaje extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver contenedor = getContentResolver();
        Cursor cursor = contenedor.query(llamadas,null,null,null,null);

        String nro=null;
        String tiempo=null;
        String nombre = null;
        String contacto = null;
        String mensaje = null;

        if(cursor.getCount()>0){
            while(cursor.moveToNext()){

                nro= cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                tiempo= cursor.getString(cursor.getColumnIndex(CallLog.Calls.POST_DIAL_DIGITS));
                //      nombre= cursor.getString(cursor.getColumnIndex(Contacts.));
                contacto= cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));

                Log.d("nro ", nro);
                Log.d("Contacto ", contacto);

            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
