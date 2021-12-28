package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map  extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static double l,g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_check);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));




        GPSTracker gg =new GPSTracker(Map.this);

        int strokeColor = 0xffff0000;
        int shadeColor = 0x44ff0000;
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(gg.getLatitude(), gg.getLongitude()))
                .radius(200)
                .strokeColor(strokeColor)
                .fillColor(shadeColor));

        BitmapDescriptor bitmapDescriptor
                = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_GREEN);

        LatLng h = new LatLng(gg.getLatitude(), gg.getLongitude());
        mMap.addMarker(new MarkerOptions().position(h).title("Marker in your location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(h,16));




        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng pp) {
                mMap.clear();
                l=pp.latitude;
                g=pp.longitude;
                LatLng h = new LatLng(l,g);
                mMap.addMarker(new MarkerOptions().position(h).title("Set Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(h,16));
                //    Toast.makeText(MapsActivity.this, l+"/n"+g, Toast.LENGTH_SHORT).show();


            }
        });





    }
}
