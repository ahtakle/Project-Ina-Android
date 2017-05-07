package com.projectina.ina.GlossaryFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectina.ina.R;

public class PrenatalFrag extends Fragment {


    public PrenatalFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Prenatal Procedures");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prenatal, container, false);
    }

}
