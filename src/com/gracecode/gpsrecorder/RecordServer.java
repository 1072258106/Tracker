package com.gracecode.gpsrecorder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;
import com.gracecode.gpsrecorder.Util.LocationListener;

public class RecordServer extends Service {

    private final String TAG = RecordServer.class.getName();

    LocationManager locManager;
    LocationListener locListener;

    @Override
    public void onCreate() {
        super.onCreate();
        bindLocationListener();
    }

    public void bindLocationListener() {

        locManager =
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locListener = new LocationListener(this.getApplicationContext());

        Log.i(TAG, "Start location listener");
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        locManager.removeUpdates(locListener);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}