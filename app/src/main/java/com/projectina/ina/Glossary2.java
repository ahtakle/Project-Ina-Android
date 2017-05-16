package com.projectina.ina;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Glossary2 extends AppCompatActivity {

//    ArrayList<GlossaryTerm> list;
//    RecyclerView rvGlossaryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glossary2Fragment f = Glossary2Fragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.glossary_frame_layout, f).commit();

//        pdfView= (PDFView)findViewById(R.id.pdfView);
//        displayFromAsset(SAMPLE_FILE);
//        // Lookup the recyclerview in activity layout
//        rvGlossaryList = (RecyclerView) findViewById(R.id.recycler_view);
//        // Initialize bucketlist
//        list = GlossaryTerm.prepareGlossaryList();
//        // Create adapter passing in the sample user data
//        GlossaryAdapter adapter = new GlossaryAdapter(this, list);
//        // Attach the adapter to the recyclerview to populate items
//        rvGlossaryList.setAdapter(adapter);
//        // Set layout manager to position the items
//        rvGlossaryList.setLayoutManager(new LinearLayoutManager(this));
    }


}
