package com.projectina.ina.TrimesterFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projectina.ina.GlossaryFragments.NextStepsFrag;
import com.projectina.ina.R;


public class Weeks1to4 extends Fragment {

    //private OnFragmentInteractionListener mListener;


    public Weeks1to4() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_weeks1to4, container, false);
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
                    //Intent intent = new Intent(getActivity(), Glossary.class);
                    //startActivity(intent);
                    Fragment fragment = new NextStepsFrag();
                    getFragmentManager().beginTransaction().replace(R.id.weeks1to4, fragment).commit();
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

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onButtonPressed(Fragment fragment);
    }*/
}
