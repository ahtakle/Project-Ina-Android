package com.projectina.ina.TrimesterFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projectina.ina.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TrimestersFragment extends Fragment {

    public TrimestersFragment() {
    }
    Button trimester1;
    Button trimester2;
    Button trimester3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trimesters, container, false);

        trimester1=(Button) rootView.findViewById(R.id.toTrimester1);
        trimester1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Trimester1();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment).addToBackStack("")
                        .commit();
            }
        });
        trimester2=(Button)rootView.findViewById(R.id.toTrimester2);
        trimester2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Trimester1();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment).addToBackStack("")
                        .commit();
            }
        });
        trimester3=(Button)rootView.findViewById(R.id.toTrimester3);
        trimester3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Trimester1();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment).addToBackStack("")
                        .commit();
            }
        });


        return rootView;
    }
}
