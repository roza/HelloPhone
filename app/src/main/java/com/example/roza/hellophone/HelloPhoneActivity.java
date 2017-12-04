package com.example.roza.hellophone;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HelloPhoneActivity extends Activity
        implements CompoundButton.OnCheckedChangeListener{
    /** Called when the activity is first created. */
    CheckBox cb;
    EditText ed,ed2;
    private final static int MENU_QUITTER=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_phone);
        cb=(CheckBox) findViewById(R.id.CheckBox);
        cb.setOnCheckedChangeListener(this);
        ed=(EditText) findViewById(R.id.EditText1);
        ed2=(EditText) findViewById(R.id.EditText2);

    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(buttonView==cb && isChecked) {
            cb.setText("Cette case est cochée");
            ed.setTextColor(getResources().getColor(R.color.noir));
            ed.setText((new Date()).toString());
        }
        else {
            cb.setText("cette case est decochée");
            ed.setTextColor(getResources().getColor(R.color.rouge));
            ed.setText(getResources().getString(R.string.message));
        }

    }

    public void bouton(View v){
        if (ed2.getVisibility()==View.INVISIBLE){
            ed2.setVisibility(View.VISIBLE);
            //ed2.setText("Vous avez pressez le bouton");
        }
        else ed2.setVisibility(View.INVISIBLE);

    }
    @Override
    public void onPause(){
        super.onPause()	;
        Toast.makeText(this, "Passage  OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(){
        super.onStart()	;
        Toast.makeText(this, "Passage  OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRestart(){
        super.onRestart()	;
        Toast.makeText(this, "Passage OnReStart", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume(){
        super.onResume()	;
        Toast.makeText(this, "Passage  OnResume", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStop(){
        super.onStop()	;
        Toast.makeText(this, "Passage  OnStop", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,MENU_QUITTER,Menu.NONE,"QUITTER");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case MENU_QUITTER:
                finish();
        }
        return true;
    }


}
