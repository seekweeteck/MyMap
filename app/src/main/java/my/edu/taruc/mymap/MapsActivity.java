package my.edu.taruc.mymap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Kuala Lumpur and move the camera
        LatLng kul = new LatLng(3.1390, 101.6869);
        mMap.addMarker(new MarkerOptions().position(kul).title("Marker in Kuala Lumpur"));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        /*
        1: World
        5: Landmass/continent
        10: City
        15: Streets
        20: Buildings*/
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kul, 15));
    }
}
