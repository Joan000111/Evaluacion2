package cl.santos.evaluacion2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//al momento de implemetar y tal, notar que hay que tener lo demás agregado en el gradle y
//el manifest, no dejaba ingresar el modulo sin tener antes esos trozos de código

//recordar el gradle es el segundo (module:app) y en el caso, cambiar el tema de la key en el manifest
public class mapa extends AppCompatActivity implements OnMapReadyCallback {

    //añadir boton volver

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        //se llaman los valores enviados con el intent
        int lon1 = getIntent().getIntExtra("lo1",0);
        int lat1 = getIntent().getIntExtra("la1",0);

        int lon2 = getIntent().getIntExtra("lo2",0);
        int lat2 = getIntent().getIntExtra("la2",0);

        int lon3 = getIntent().getIntExtra("lo3",0);
        int lat3 = getIntent().getIntExtra("la3",0);

        //se asignan los valores a los amrcadores, tal que
        LatLng punto1 = new LatLng(lon1,lat1);
        mMap.addMarker(new MarkerOptions().position(punto1)
                .title("Primer Marcador"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto1));

        LatLng punto2 = new LatLng(lon2,lat2);
        mMap.addMarker(new MarkerOptions().position(punto2)
                .title("Segundo Marcador"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto2));

        LatLng punto3 = new LatLng(lon3,lat3);
        mMap.addMarker(new MarkerOptions().position(punto3)
                .title("Tercer Marcador"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto3));
    }
}