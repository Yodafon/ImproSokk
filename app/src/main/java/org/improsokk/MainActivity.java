package org.improsokk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int BERLETI_DIJ_ORANKENT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register Add Channel Button handler
        Button button_openChannel = (Button) findViewById(R.id.szamol);
        button_openChannel.setEnabled(true);
        button_openChannel.setOnClickListener(this::onClick);
    }

    public void calculate(int kilencigMaradok, int osszletszam) {
        TextView kilencigmaradokOsszeg = (TextView) findViewById(R.id.kilencigosszeg);
        TextView tobbiekOsszeg= (TextView) findViewById(R.id.tobbiekosszeg);
        double kilencigOsszeg=Math.ceil((2*BERLETI_DIJ_ORANKENT)/(double)osszletszam);
        double tobbiek = Math.ceil(BERLETI_DIJ_ORANKENT /((double)(osszletszam-kilencigMaradok)))+kilencigOsszeg;
        kilencigmaradokOsszeg.setText(String.valueOf(kilencigOsszeg));
        tobbiekOsszeg.setText(String.valueOf(tobbiek));

    }

    public void onClick(View view) {
        EditText osszletszamText = (EditText) findViewById(R.id.osszletszam);
        EditText kilencigmaradokText = (EditText) findViewById(R.id.kilencigmaradok);
        int kilencigMaradok = Integer.parseInt(kilencigmaradokText.getText().toString());
        int osszletszam = Integer.parseInt(osszletszamText.getText().toString());

        calculate(kilencigMaradok, osszletszam);
    }
}
