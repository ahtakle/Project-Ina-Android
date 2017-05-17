package com.projectina.ina;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class PDFViewerFrag extends Fragment implements OnPageChangeListener, OnLoadCompleteListener {

    private static String fragTitle;

    public PDFViewerFrag() {
        // Required empty public constructor
    }

    public static PDFViewerFrag newInstance(String title) {
        PDFViewerFrag fragment = new PDFViewerFrag();
        fragTitle = title;
        return fragment;
    }

    private static final String TAG = Glossary.class.getSimpleName();
    private String GLOSSARY_FILE;
    private PDFView pdfView;
    private Integer pageNumber = 0;
    private String pdfFileName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);

        //Get the parameters from glossaryList
        //String title = "test3";
        GLOSSARY_FILE = fragTitle + ".pdf";

        pdfView = (PDFView) rootview.findViewById(R.id.pdfView);
        displayFromAsset(GLOSSARY_FILE);

        return rootview;
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(GLOSSARY_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(getContext()))
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        String activityTitle = pdfFileName.substring(0, pdfFileName.length() - 4);
        getActivity().setTitle(String.format(activityTitle));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

}
