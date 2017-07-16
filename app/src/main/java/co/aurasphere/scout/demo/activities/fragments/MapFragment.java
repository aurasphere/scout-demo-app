/*
 * MIT License
 *
 * Copyright (c) 2017 Donato Rimenti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package co.aurasphere.scout.demo.activities.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import co.aurasphere.scout.demo.R;

/**
 * A fragment which contains a map. Interest points can be loaded from a Server (using a REST Web Service for example). For demo purposes, a fake marker is added.
 *
 * @author Donato Rimenti
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    /**
     * Tag used for logging.
     */
    private static final String TAG = "MapFragment";

    /**
     * This map view.
     */
    private MapView mMapView;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_fragment, container,
                false);

        // Initializes the map.
        MapsInitializer.initialize(getActivity());
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        // Needed to get the map to display immediately.
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            Log.e(TAG, "Error while initializing the map", e);
        }

        // Gets the map asynchronously. When it is ready, the method onMapReady will be called and a fake marker will be added, for demo purposes.
        mMapView.getMapAsync(this);

        return v;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Creates a fake marker for demo purposes.
        LatLng coordinates = new LatLng(41.7693629, 12.6581574);
        MarkerOptions marker = new MarkerOptions().position(
                coordinates).title("Scouts headquarter");

        // Changing marker icon. hsv[0] is Hue.
        float[] hsv = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.colorPrimary), hsv);
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(hsv[0]));

        // Adds the marker.
        Marker actualMarker = googleMap.addMarker(marker);

        // Always show the title.
        actualMarker.showInfoWindow();

        // Sets the map camera.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinates).zoom(16).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }
}