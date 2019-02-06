package com.example.android.activitylifecyleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int numOfButtonClicks = 0;
    Button button;
    private static final String KEY_NUMCLICKS = "numClicks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            numOfButtonClicks = savedInstanceState.getInt(KEY_NUMCLICKS);
        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfButtonClicks++;
                setButtonText();
            }
        });

        setButtonText();
    }

    private void setButtonText(){
        button.setText("Clicks: "+numOfButtonClicks);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_NUMCLICKS, numOfButtonClicks);
    }
}
