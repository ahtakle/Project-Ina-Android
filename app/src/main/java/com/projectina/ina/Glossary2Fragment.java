package com.projectina.ina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class Glossary2Fragment extends Fragment {

    public Glossary2Fragment() {
    }

    public static Glossary2Fragment newInstance() {
        Glossary2Fragment fragment = new Glossary2Fragment();
        return fragment;
    }


    ArrayList<GlossaryTerm> list;
    RecyclerView rvGlossaryList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_glossary_list, container, false);

        // Lookup the recyclerview in activity layout
        rvGlossaryList = (RecyclerView) rootview.findViewById(R.id.recycler_view);
        // Initialize bucketlist
        list = GlossaryTerm.prepareGlossaryList();
        // Create adapter passing in the sample user data
        GlossaryAdapter adapter = new GlossaryAdapter(getContext(), getFragmentManager(), list);
        // Attach the adapter to the recyclerview to populate items
        rvGlossaryList.setAdapter(adapter);
        // Set layout manager to position the items
        rvGlossaryList.setLayoutManager(new LinearLayoutManager(getActivity()));


        return rootview;
    }
}
