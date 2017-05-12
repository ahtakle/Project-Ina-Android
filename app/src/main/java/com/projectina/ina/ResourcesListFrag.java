package com.projectina.ina;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanditakannapadi on 5/6/17.
 */

public class ResourcesListFrag extends Fragment {

    private List<ResourceCard> persons;


    public static ResourcesListFrag newInstance() {
        ResourcesListFrag fragment = new ResourcesListFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View rootview = inflater.inflate(R.layout.cardview_list_fragment, container, false);

        initializeData();

        RecyclerView rv = (RecyclerView)rootview.findViewById(R.id.my_recycler_view);
        ResourcesAdapter adapter = new ResourcesAdapter(persons, getFragmentManager());

        LinearLayoutManager llm = new GridLayoutManager(this.getContext(), 2);
        rv.setLayoutManager(llm);
        rv.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);


        return rootview;
    }


    // This method creates an ArrayList that has three Person objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new ResourceCard("Coteau", "Coteau Clinic", R.mipmap.coteau));
        persons.add(new ResourceCard("GPTCHB", "Northern Plains Healthy Start", R.mipmap.gptchb));
        persons.add(new ResourceCard("NESD", "Community Health WIC", R.mipmap.nesd));
        persons.add(new ResourceCard("Roberts", "Short description", R.mipmap.roberts));
        persons.add(new ResourceCard("SD Breastfeeding", "Breastfeeding Peer Counsel", R.mipmap.sd_breastfeeding));
        persons.add(new ResourceCard("SD Home Visiting", "Health Bright Start", R.mipmap.sd_homevisiting));
        persons.add(new ResourceCard("SD Social", "Department of Social Services", R.mipmap.sd_socialservices));
        persons.add(new ResourceCard("Sisseton Clinic", "IHS Clinic", R.mipmap.sisseton_clinic));
        persons.add(new ResourceCard("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
        persons.add(new ResourceCard("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
        persons.add(new ResourceCard("Sisseton School", "School District SPED", R.mipmap.sisseton_school));
        persons.add(new ResourceCard("SWO Benefits", "Benefits Coordinator", R.mipmap.swo_benefits));
        persons.add(new ResourceCard("SWO Cavity", "Cavity Free", R.mipmap.swo_cavity));
        persons.add(new ResourceCard("SWO Child", "Child Protection", R.mipmap.swo_child));
        persons.add(new ResourceCard("SWO Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
        persons.add(new ResourceCard("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
        persons.add(new ResourceCard("SWO Pride", "Dakota Pride Center", R.mipmap.swo_pride));
        persons.add(new ResourceCard("SWO Intervention", "Early Child Intervention", R.mipmap.swo_intervention));
        persons.add(new ResourceCard("SWO Education", "Education Advice", R.mipmap.swo_education));
        persons.add(new ResourceCard("SWO Food", "Food Pantry", R.mipmap.swo_food));
        persons.add(new ResourceCard("SWO EHS", "Head Start", R.mipmap.swo_ehs));
        persons.add(new ResourceCard("SWO Daycare", "Little Steps Daycare", R.mipmap.swo_daycare));
        persons.add(new ResourceCard("SWO MCH", "Maternal and Child Health", R.mipmap.swo_mch));
        persons.add(new ResourceCard("Finances", "Financial Advice", R.mipmap.finances));

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displaymetrics));
    }
}
