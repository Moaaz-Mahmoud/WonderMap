package com.example.wondermap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = findViewById(R.id.map_view);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Add markers for the hard-coded places
                LatLng place1 = new LatLng(37.7749, -122.4194);
                mMap.addMarker(new MarkerOptions().position(place1).title("Place 1"));

                LatLng place2 = new LatLng(51.5074, -0.1278);
                mMap.addMarker(new MarkerOptions().position(place2).title("Place 2"));

                LatLng place3 = new LatLng(-33.8679, 151.2073);
                mMap.addMarker(new MarkerOptions().position(place3).title("Place 3"));

                // Move the camera to one of the markers
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place1, 12));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}