package com.appnucleus.custommenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity implements OnMenuItemClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonClickAndContextMenu= (Button) findViewById(R.id.btn_click);

        buttonClickAndContextMenu.setOnClickListener(new View.OnClickListener()         //Popup Menu Trigger
        {
            @Override
            public void onClick(View view)
            {
                PopupMenu popupMenu = new PopupMenu(ActivityMain.this, view);
                popupMenu.setOnMenuItemClickListener(ActivityMain.this);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.show();
            }
        });

        registerForContextMenu(buttonClickAndContextMenu);                              //Register Context Menu
    }

    /////////////////////////////////////////////////////////////Context menu Actions
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuinfo)
    {
        super.onCreateContextMenu(menu, view, menuinfo);
        menu.setHeaderTitle("Set as");
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.delete_item:
                Toast.makeText(this, "Delete from Context Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.edit_item:
                Toast.makeText(this, "Edit from Context Menu !!!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
    /////////////////////////////////////////////////////////////Context menu Actions - END

    @Override
    public boolean onMenuItemClick(MenuItem item)                                       //Popup Menu Action
    {
        switch (item.getItemId())
        {
            case R.id.item_comedy:
                Toast.makeText(this, "Comedy Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_movies:
                Toast.makeText(this, "Movies Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_music:
                Toast.makeText(this, "Music Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////////////////For Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Single menu item is selected do something
        // Ex: launching new activity/screen or show alert message
        switch (item.getItemId())
        {
            case R.id.menu_bookmark:
                Toast.makeText(getApplicationContext(), "Bookmark is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_save:
                Toast.makeText(getApplicationContext(), "Save is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(getApplicationContext(), "Search is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_share:
                Toast.makeText(getApplicationContext(), "Share is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(), "Delete is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_preferences:
                Toast.makeText(getApplicationContext(), "Preferences is Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////Option Menu End
}
