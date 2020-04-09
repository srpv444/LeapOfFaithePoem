package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button encryptButton = findViewById( R.id.encryptButton );
        Button decryptButton = findViewById( R.id.decryptButton );

        //toolbar configuration
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.appbar);
        mActionBarToolbar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        mActionBarToolbar.setTitle("Crypto String");
        mActionBarToolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar( mActionBarToolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( false );
        getSupportActionBar().setDisplayShowTitleEnabled( false );

        //Button click for the encrypt button
        encryptButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("TAG", "onClick: inside the button encrypt" );
                Intent i = new Intent(getApplicationContext(),SplashScreenActivity.class);
                startActivity(i);
            }
        });

        //Button click for the decrypt button
        decryptButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),SplashScreenActivity.class);
                startActivity(i);
                Log.d("TAG", "onClick: inside the button decrypt" );
            }
        });
    }
}
