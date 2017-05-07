package com.projectina.ina.GlossaryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectina.ina.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFrag extends Fragment {


    public DeliveryFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Delivery");
        return inflater.inflate(R.layout.fragment_delivery, container, false);
    }

}
