package com.projectina.projectina;

/**
 * Created by zrs on 11/13/16.
 * Basic RecyclerView Adapter needed to set up the recyclerview
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GlossaryAdapter extends RecyclerView.Adapter<GlossaryAdapter.ViewHolder> {

    private List<GlossaryTerm> glossaryList;
    private android.support.v4.app.FragmentManager mFragmentManager;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    // Store the context for easy access
    public Context mContext;


    // Pass in the contact array into the constructor
    public GlossaryAdapter(Context context, FragmentManager fragmentManager, List<GlossaryTerm> list) {
        glossaryList = list;
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        final View contactView = inflater.inflate(R.layout.glossary_term_row, parent, false);
        //Holder instance to be returned
        final ViewHolder viewHolder = new ViewHolder(contactView);


        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final int position = viewHolder.getAdapterPosition();
                GlossaryTerm term = glossaryList.get(position);

                String fragTitle = term.getTitle();
                Fragment fragment = PDFViewerFrag.newInstance(fragTitle);
                mFragmentManager.beginTransaction()
                        .replace(R.id.glossary_frame_layout, fragment).addToBackStack(null).commit();
            }
        });

        // Return a new holder instance
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        GlossaryTerm term = glossaryList.get(position);
        holder.title.setText(term.getTitle());

        //int textColor = R.color.colorText;
        //holder.title.setTextColor(term.getColor());
    }

    @Override
    public int getItemCount() {
        return glossaryList.size();
    }
}
