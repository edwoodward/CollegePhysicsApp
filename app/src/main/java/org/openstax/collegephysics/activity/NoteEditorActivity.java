/**
 * Copyright (c) 2013 Rice University
 *
 * This software is subject to the provisions of the GNU Lesser General
 * Public License Version 2.1 (LGPL).  See LICENSE.txt for details.
 */
package org.openstax.collegephysics.activity;

import org.openstax.collegephysics.R;
import org.openstax.collegephysics.beans.Content;
import org.openstax.collegephysics.fragment.NoteEditorFragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Note editor.
 * Based on sample Android Notepad app: http://developer.android.com/resources/samples/NotePad/index.html
 * @author Ed Woodward
 *
 */
public class NoteEditorActivity extends AppCompatActivity
{

    private Content content;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        content = (Content)getIntent().getSerializableExtra(getString(R.string.webcontent));

        if(content == null)
        {
            Toast.makeText(NoteEditorActivity.this, "Cannot create note.  Please try again.",  Toast.LENGTH_SHORT).show();
            return;
        }

        setContentView(R.layout.activity_noteeditor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar aBar = getSupportActionBar();

        if(content == null)
        {
            aBar.setTitle("Note not created correctly.");
        }
        else
        {
            aBar.setTitle(content.getBookTitle() + " Note");
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        final NoteEditorFragment fragment = NoteEditorFragment.newInstance(content);
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();

        final AppCompatActivity activity = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fragment.saveNote();
                activity.finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        if(content == null)
        {
            return false;
        }

        menu.clear();
        inflater.inflate(R.menu.noteeditor_menu, menu);

        return true;
    }



}


