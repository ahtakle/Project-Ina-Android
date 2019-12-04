package com.projectina.projectina;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener  {

    private GoogleMap mMap;
    Button button;

    private static final LatLng HeadStart = new LatLng(45.568170, -97.061490);
    private static final LatLng TribalAdminBuilding = new LatLng(45.572700, -97.063040);
    private static final LatLng IHS = new LatLng(45.657550, -97.016550);
    private static final LatLng RCHealthNurse = new LatLng(45.667390, -97.045690);
    private static final LatLng DakotaPrideCenter = new LatLng(45.563680, -97.076940);
    private static final LatLng Coteau = new LatLng(45.657690, -97.050410);
    private static final LatLng GPTCHB = new LatLng(44.059600, -103.158790);
    private static final LatLng LittleStepsDaycare = new LatLng(45.568210, -97.066030);
    private static final LatLng WIC = new LatLng(45.660170, -97.050050);


    private Marker mHeadStart;
    private Marker mTribalAdminBuilding;
    private Marker mIHS;
    private Marker mRCHealthNurse;
    private Marker mDakotaPrideCenter;
    private Marker mCoteau;
    private Marker mGPTCHB;
    private Marker mLittleStepsDaycare;
    private Marker mWIC;

    private static final CharSequence[] MAP_TYPE_ITEMS =
            {"Road Map", "Hybrid", "Satellite", "Terrain"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button=(Button)findViewById(R.id.button);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        //Stylize the Map
//        try {
//            boolean success = googleMap.setMapStyle(
//                    MapStyleOptions.loadRawResourceStyle(
//                            this, R.raw.styles_json));
//            if (!success) {
//                Log.e("LastNightMap", "Style parsing failed.");
//            }
//        } catch (Exception e) {
//            Log.e("LastNightMap", "Can't find style. Error: ", e);
//        }

        // Add some markers to the map, and add a data object to each marker.
        //******************************************************************************************
        //NOTE: The marker titles have to be the same as the resource!!!!
        //******************************************************************************************
        //mHeadStart = mMap.addMarker(new MarkerOptions().position(HeadStart).title("Head Start").snippet("Some infor will go here, it can be a few lines?"));
        mHeadStart = mMap.addMarker(new MarkerOptions().position(HeadStart).title("Head Start"));
        mHeadStart.setTag(0);
        mTribalAdminBuilding = mMap.addMarker(new MarkerOptions().position(TribalAdminBuilding).title("SWO Early Childhood Intervention").snippet("(Tribal Administration Building)"));
        mTribalAdminBuilding.setTag(1);
        mIHS = mMap.addMarker(new MarkerOptions().position(IHS).title("IHS"));
        mIHS.setTag(2);
        mRCHealthNurse = mMap.addMarker(new MarkerOptions().position(RCHealthNurse).title("Roberts County"));
        mRCHealthNurse.setTag(3);
        mDakotaPrideCenter = mMap.addMarker(new MarkerOptions().position(DakotaPrideCenter).title("SWO Pride"));
        mDakotaPrideCenter.setTag(4);
        mCoteau = mMap.addMarker(new MarkerOptions().position(Coteau).title("Coteau"));
        mCoteau.setTag(5);
        mGPTCHB = mMap.addMarker(new MarkerOptions().position(GPTCHB).title("GPTCHB"));
        mGPTCHB.setTag(6);
        mLittleStepsDaycare = mMap.addMarker(new MarkerOptions().position(LittleStepsDaycare).title("Little Steps Daycare"));
        mLittleStepsDaycare.setTag(7);
        mWIC = mMap.addMarker(new MarkerOptions().position(WIC).title("WIC"));
        mWIC.setTag(7);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TribalAdminBuilding, 9));

        // Set a listener for info window events.
        mMap.setOnInfoWindowClickListener(this);





        //Do other setup things
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Button Things
        button.bringToFront();
        //button.getBackground().setAlpha(128);  // 50% transparent
        //button.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapTypeSelectorDialog();

            }
        });
    }

    /**  Called when the user clicks an info window
     *   We will bring them to the resource page for the specific resource
     */
    @Override
    public void onInfoWindowClick(Marker marker) {
        //Go to glossary intent passing the marker's title to go to the specific resource
        Intent goToResource = new Intent(getBaseContext(), Resources.class);
        goToResource.putExtra("GO_TO_SPECIFIC_RESOURCE", marker.getTitle());
        startActivity(goToResource);
    }



    private void showMapTypeSelectorDialog() {
        // Prepare the dialog by setting up a Builder.
        final String fDialogTitle = "Select Map Type";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(fDialogTitle);

        // Find the current map type to pre-check the item representing the current state.
        int checkItem = mMap.getMapType() - 1;

        // Add an OnClickListener to the dialog, so that the selection will be handled.
        builder.setSingleChoiceItems(
                MAP_TYPE_ITEMS,
                checkItem,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        // Locally create a finalised object.

                        // Perform an action depending on which item was selected.
                        switch (item) {
                            case 1:
                                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                                break;
                            case 2:
                                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                                break;
                            case 3:
                                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                break;
                            default:
                                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        }
                        dialog.dismiss();
                    }
                }
        );

        // Build the dialog and show it.
        AlertDialog fMapTypeDialog = builder.create();
        fMapTypeDialog.setCanceledOnTouchOutside(true);
        fMapTypeDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //popUpWindow = new PopupWindow(this);

        if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_tutorial) {
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
