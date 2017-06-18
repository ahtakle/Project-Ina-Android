package com.projectina.projectina;

import android.view.View;

/**
 * Created by zrs on 11/13/16.
 * Basic ClickListener needed for Glossary recyclerView
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}