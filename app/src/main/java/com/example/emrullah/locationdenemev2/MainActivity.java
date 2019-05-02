package com.example.emrullah.locationdenemev2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LocationHelp{

    @BindView(R.id.tv_loc)
    TextView _loc;
    LocationBuilder locationBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        locationBuilder = new LocationBuilder(this);

    }

    @OnClick(R.id.tv_loc)
    public void buttonClick(){
            locationBuilder.stuff(this);
            locationBuilder.startLoc(getApplicationContext());
            locationBuilder.buildLocationRequest();
    }

    @Override
    public void getLocation(LocationResult locationResult) {
        for (Location result:locationResult.getLocations()){
            _loc.append(""+result.getLongitude());
            _loc.append(" "+result.getLatitude());
        }
    }
}
