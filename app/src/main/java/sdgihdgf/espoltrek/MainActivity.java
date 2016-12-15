package sdgihdgf.espoltrek;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sdgihdgf.espoltrek.models.Lugar;
import sdgihdgf.espoltrek.server.ETRest;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private GoogleMap mMap;
    private ArrayList<Lugar> arregloLugares;
    private HashMap<Marker, Lugar> hmap;
    private CoordinatorLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        root = (CoordinatorLayout) findViewById(R.id.root);
        //se recorre la base
        //por cada documento se crea un objeto lugar, con id,latitud y longitud
        //
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        checkuser();
    }

    private void checkuser() {
        if (!ETRest.get().isLoggedIn())
            return;
        invalidateOptionsMenu();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (ETRest.get().isLoggedIn()) {
            menu.getItem(0).setTitle(ETRest.get().getCurrentUser().getNickname());
            menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    ETRest.get().logout();
                    invalidateOptionsMenu();
                    return true;
                }
            });
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_login:
                startActivity(new Intent(getApplicationContext(),LoginActivity3.class));
                break;
            case R.id.action_settings:
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.styles));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        hmap = new HashMap<>();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent i = new Intent(getApplicationContext(), LugarActivity.class);
                Lugar l = hmap.get(marker);
                Log.i("nombre",l.getNombre());
                Bundle b = new Bundle();
                b.putParcelable("lugar",l);
                i.putExtras(b);

                startActivity(i);
                return true;
            }
        });
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        getData();
    }

    public void getData() {
        ETRest.get().service().getLugares().enqueue(new Callback<List<Lugar>>() {
            @Override
            public void onResponse(Call<List<Lugar>> call, Response<List<Lugar>> response) {
                Log.e(TAG, response.raw().toString());
                arregloLugares = (ArrayList<Lugar>) response.body();
                displayData();
            }

            @Override
            public void onFailure(Call<List<Lugar>> call, Throwable t) {
                Snackbar.make(root, t.getLocalizedMessage(), Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }

    private void displayData() {
        if (mMap == null)
            return;
        for (Lugar l : arregloLugares) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(l.getLat(), l.getLng());

            Marker m = mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title(l.getNombre()));
            hmap.put(m, l);
        }
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                .target(new LatLng(-2.146291d, -79.964617d)).tilt(90).zoom(19).build()));
    }
}
