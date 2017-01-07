package com.archfiery.andriod.commonhash;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayLicense extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupEditWindow();

        setContentView(R.layout.license);

        final TextView license = (TextView) findViewById(R.id.license_text);
        try {
            final String licenseFile = "LICENSE";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(licenseFile)));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                line += "\n";
                sb.append(line);
                line = reader.readLine();
            }
            license.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            license.setText(R.string.license_load_issue);
        }
    }

    public void setupEditWindow() {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.9f;
        params.dimAmount = 0f;
        getWindow().setAttributes(params);
    }
}
