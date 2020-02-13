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

import org.w3c.dom.Text;


public class EncryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        Button decryptButton = findViewById(R.id.decryptButton);
        final EditText encryptedEdtTxt = findViewById(R.id.encryptedEdtTxt);
        final TextView decryptedTxt = findViewById(R.id.decryptedTxt);
        //toolbar configuration
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.appbar);
        mActionBarToolbar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        mActionBarToolbar.setTitle("Encryption");
        toolbarTitle.setText("Encryption");
        mActionBarToolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Decrypt Button Click
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (encryptedEdtTxt.getText() == null || encryptedEdtTxt.getText().toString().equals("")) {
                    encryptedEdtTxt.setError("Please Enter a Valid Encryption Message");
                } else {
                    String encryptionString = encryptedEdtTxt.getText().toString();
                    decryptedTxt.setText( Encrypt( encryptionString ) );
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


    private static String Encrypt( String encryptedMsg ){

        String prevChar = null;
        String encryptedString = new String();

        Integer charCount = 0;

        for( int i=0; i < encryptedMsg.length() ; i++ ){


            if( prevChar == null ){
                prevChar = encryptedMsg.charAt(i)+"";
                charCount++;
            } else {
                if( prevChar.equalsIgnoreCase ( encryptedMsg.charAt(i)+"" ) ){
                    charCount++;
                } else {
                    String appendString = prevChar + charCount.toString() ;
                    encryptedString = encryptedString.concat( appendString );
                    charCount = 1;
                    prevChar = encryptedMsg.charAt(i)+"";
                }//Check for the prevChar is equal to encryptedMsg
            }//Check for the prevChar to be null or not

            //To add the final character into the encrypted message
            if( i == encryptedMsg.length()-1 ){
                String appendString = prevChar + charCount.toString() ;
                encryptedString = encryptedString.concat( appendString );
            }
        }
        return encryptedString;

    }

}