package com.archfiery.andriod.commonhash;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MyCommonHash myCommonHash = new MyCommonHash();

        final TextView viewHash = (TextView) findViewById(R.id.viewHash);
        final TextView viewRawTextDisp = (TextView) findViewById(R.id.rawTextDisplay);

        final EditText edit = (EditText) findViewById(R.id.rawText);
        final Spinner algList = (Spinner) findViewById(R.id.spinner);

        final Button btnHash = (Button) findViewById(R.id.btnHash);
        final FloatingActionButton btnCopy = (FloatingActionButton) findViewById(R.id.btnCopy);
        final Button btnClear = (Button) findViewById(R.id.btnClear);

        // set clear button invisible
        btnCopy.setVisibility(View.INVISIBLE);

        algList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                btnCopy.setVisibility(View.INVISIBLE);
                viewHash.setText("");
                viewRawTextDisp.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCopy.setVisibility(View.VISIBLE);
                String rawText = edit.getText().toString();
                viewHash.setText(myCommonHash.hashText(rawText, String.valueOf(algList.getSelectedItem())));
                viewRawTextDisp.setText(getString(R.string.rawText) + ":\n" + rawText);

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Copied to clipboard", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
                String rawText = edit.getText().toString();
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("hashed result",
                        myCommonHash.hashText(rawText, String.valueOf(algList.getSelectedItem())));
                clipboard.setPrimaryClip(clip);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Cleared", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                btnCopy.setVisibility(View.INVISIBLE);
                viewHash.setText("");
                viewRawTextDisp.setText("");
                edit.setText("");
                edit.setHint(R.string.rawText);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_show_about:
                return true;
            case R.id.action_show_license:
                Intent intent = new Intent(this, DisplayLicense.class);
                getWindow().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
