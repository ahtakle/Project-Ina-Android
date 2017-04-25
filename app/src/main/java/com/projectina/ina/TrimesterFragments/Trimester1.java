package com.projectina.ina.TrimesterFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projectina.ina.GlossaryFragments.NextStepsFrag;
import com.projectina.ina.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Trimester1 extends Fragment {

    public Trimester1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_weeks_1, container, false);
        Button button1 = (Button) v.findViewById(R.id.weeks1button1);
        button1.setOnClickListener(onClickListener);
        Button button2 = (Button) v.findViewById(R.id.weeks1button2);
        button2.setOnClickListener(onClickListener);
        Button button3 = (Button) v.findViewById(R.id.weeks1button3);
        button3.setOnClickListener(onClickListener);
        Button button4 = (Button) v.findViewById(R.id.weeks1button4);
        button4.setOnClickListener(onClickListener);
        Button button5 = (Button) v.findViewById(R.id.weeks1button5);
        button5.setOnClickListener(onClickListener);
        Button button6 = (Button) v.findViewById(R.id.weeks1button6);
        button6.setOnClickListener(onClickListener);
        Button button7 = (Button) v.findViewById(R.id.weeks1button7);
        button7.setOnClickListener(onClickListener);

        return v;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.weeks1button1:
                    break;
                case R.id.weeks1button2:
                    break;
                case R.id.weeks1button3:
                    break;
                case R.id.weeks1button4:
                    Fragment fragment = new NextStepsFrag();
                    getFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commit();
                    break;
                case R.id.weeks1button5:
                    break;
                case R.id.weeks1button6:
                    break;
                case R.id.weeks1button7:
                    break;
            }
        }
    };
}
