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
public class TeenFrag extends Fragment {


    public static final String PREFS_NAME = "PrefsFile";

    public TeenFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teen_pregnancy, container, false);

//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        if(settings.getBoolean("YourParents")  ) {
//            setthetextbox to checked
//        }
    }

//    @Override
//    public onPause() {
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        SharedPreferences.Editor editor = settings.edit();
//        Checkbox editText = (EditText)findViewById(R.id.editText);
//        editor.putString("YourParents", editText.getCheckboxStuff);
//        // Commit the edits!
//        editor.commit();
//    }

}
