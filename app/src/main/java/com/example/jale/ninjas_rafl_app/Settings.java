package com.example.jale.ninjas_rafl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class Settings extends Activity implements View.OnClickListener{
RadioButton random1,random2,random3,random4;
    Button btnPlay;
    EditText setMinutes,setSeconds;
    boolean isTimeSet,specificTime;
    long timeSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opsaetning);
        random1 = (RadioButton) findViewById(R.id.btnRandom1);
        random1.setOnClickListener(this);
        random2 = (RadioButton) findViewById(R.id.btnRandom2);
        random2.setOnClickListener(this);
        random3 = (RadioButton) findViewById(R.id.btnRandom3);
        random3.setOnClickListener(this);
        random4 = (RadioButton) findViewById(R.id.btnRandom4);
        random4.setOnClickListener(this);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
        setMinutes = (EditText) findViewById(R.id.editText);
        setMinutes.setOnClickListener(this);
        setSeconds = (EditText) findViewById(R.id.editText2);
        setSeconds.setOnClickListener(this);
        timeSet = 0;
        isTimeSet = false;
        specificTime = false;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opsaetning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if(v == btnPlay){
            if(specificTime){
                if(!setMinutes.equals("")||!setSeconds.equals("")){
                    timeSet = (long) ((Integer.parseInt(setMinutes.getText().toString())*1000*60)+
                            (Integer.parseInt(setSeconds.getText().toString())*1000));
                    isTimeSet =true;
                }
            }
            if(isTimeSet){
                Intent i = new Intent(this,RafleSpil.class);
                i.putExtra("timeSet",timeSet);
                startActivity(i );
            }
        }
        if(v == random1){
            long randomTime = (long) (Math.random()*1000*60*5);
            timeSet = randomTime+(1000*60*5);
            specificTime = false;
        }
        if(v == random2){
            long randomTime = (long) (Math.random()*1000*60*5);
            timeSet = randomTime+(1000*60*10);
            specificTime = false;
        }
        if(v == random3){
            long randomTime = (long) (Math.random()*1000*60*5);
            timeSet = randomTime+(1000*60*15);
            specificTime = false;
        }
        if(v == random4){
            long randomTime = (long) (Math.random()*1000*60*5);
            timeSet = randomTime+(1000*60*20);
            specificTime = false;
        }
        if(v == setMinutes || v == setSeconds){
            specificTime = true;
        }
    }
}
