package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;


public class DecryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        Button decryptButton = findViewById( R.id.decryptButton );
        final EditText decryptEdtTxt = findViewById(R.id.decryptEdtTxt);
        final TextView decryptTxt = findViewById(R.id.decryptTxt);

        //toolbar configuration
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.appbar);
        mActionBarToolbar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        mActionBarToolbar.setTitle("Decryption");
        toolbarTitle.setText("Decryption");
        mActionBarToolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar( mActionBarToolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowTitleEnabled( false );

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decryptEdtTxt.getText() == null || decryptEdtTxt.getText().toString().equals("")) {
                    decryptEdtTxt.setError("Please Enter a Valid Encryption Message");
                } else {
                    String encryptionString = decryptEdtTxt.getText().toString();
                    decryptTxt.setText( Decrypt( encryptionString ) );
                }
            }
        });

    }
    //upper backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //lower backbutton
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }

    //
    public static String Decrypt( String decryptingString ){
        String curCharacter = "";
        StringBuilder curCharCount = new StringBuilder("0");
        StringBuilder decreptedString = new StringBuilder();

        for (char ch : decryptingString.toCharArray()) {

            if( ! Character.isDigit( ch ) ){

                decreptedString.append( StringUtils.repeat(curCharacter , Integer.parseInt( curCharCount.toString() )) );

                curCharacter = String.valueOf( ch );

                curCharCount = new StringBuilder("0");

            }else{

                curCharCount.append( String.valueOf( ch ) );

            }

        }
        decreptedString.append( StringUtils.repeat( curCharacter, Integer.parseInt(curCharCount.toString())) );
        return decreptedString.toString();
    }
}
