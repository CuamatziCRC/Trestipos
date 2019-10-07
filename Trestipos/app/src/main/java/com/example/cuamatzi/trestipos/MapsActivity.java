package com.example.cuamatzi.trestipos;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button mTypeBoton,mTypeBoton2,mTypeBoton3,mTypeBoton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


      //Satelital
        mTypeBoton = findViewById(R.id.btnsatelite);

        mTypeBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            }
        });

        //Hibrido
        mTypeBoton2 =findViewById(R.id.btnHibrido);
        mTypeBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        //Mixto
        mTypeBoton3 = findViewById(R.id.btnMixto);
        mTypeBoton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        //Callejero
        mTypeBoton4 = findViewById(R.id.btnCallejero);
        mTypeBoton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Puntos(googleMap);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public  void Puntos(GoogleMap googleMap){

        mMap = googleMap;

        //FCC BUAP
        final LatLng punto1=new LatLng(19.0052097,-98.2045009);
        final LatLng punto2=new LatLng(19.231418,-98.03203);

        mMap.addMarker(new MarkerOptions().position(punto1).title("Posicion FCC-BUAP").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(punto2).title("Mi casa").icon((BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))));
    }
}
