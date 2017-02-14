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
public class Trimester1 extends Fragment {

    public Trimester1() {
    }
    Button weeks1;
    Button weeks2;
    Button weeks3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trimester1, container, false);

        weeks1=(Button)rootView.findViewById(R.id.toWeek1);
        weeks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Weeks_1();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment).addToBackStack("")
                        .commit();
            }
        });
        weeks2=(Button)rootView.findViewById(R.id.toWeek2);
        weeks2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment).addToBackStack("")
                        .commit();
            }
        });
        weeks3=(Button)rootView.findViewById(R.id.toWeek3);
        weeks3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment();
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
