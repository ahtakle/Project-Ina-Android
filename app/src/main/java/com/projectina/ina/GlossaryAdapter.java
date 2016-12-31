package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 * Basic RecyclerView Adapter needed to set up the recyclerview
 */


        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

public class GlossaryAdapter extends RecyclerView.Adapter<GlossaryAdapter.MyViewHolder> {

    private List<GlossaryTerm> glossaryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public GlossaryAdapter(List<GlossaryTerm> glossaryList) {
        this.glossaryList = glossaryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.glossary_term_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GlossaryTerm term = glossaryList.get(position);
        holder.title.setText(term.getTitle());
        holder.genre.setText(term.getGenre());
        holder.year.setText(term.getYear());
    }

    @Override
    public int getItemCount() {
        return glossaryList.size();
    }
}
