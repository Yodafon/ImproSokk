package org.improsokk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment {
    private static final int BERLETI_DIJ_ORANKENT = 2000;


    public Calculator() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Register Add Channel Button handler

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button szamol = getView().findViewById(R.id.szamol);
        szamol.setEnabled(true);
        szamol.setOnClickListener(this::onClick);

    }

    public void calculate(int kilencigMaradok, int osszletszam) {
        TextView kilencigmaradokOsszeg = getView().findViewById(R.id.kilencigosszeg);
        TextView tobbiekOsszeg = getView().findViewById(R.id.tobbiekosszeg);
        double kilencigOsszeg = Math.ceil((2 * BERLETI_DIJ_ORANKENT) / (double) osszletszam);
        double tobbiek = Math.ceil(BERLETI_DIJ_ORANKENT / ((double) (osszletszam - kilencigMaradok))) + kilencigOsszeg;
        kilencigmaradokOsszeg.setText(String.valueOf(kilencigOsszeg));
        tobbiekOsszeg.setText(String.valueOf(tobbiek));

    }

    public void onClick(View view) {
        String osszletszamText = ((EditText) getView().findViewById(R.id.osszletszam)).getText().toString();
        String kilencigmaradokText = ((EditText) getView().findViewById(R.id.kilencigmaradok)).getText().toString();

        if (!kilencigmaradokText.isEmpty() && !osszletszamText.isEmpty()) {
            int kilencigMaradok = Integer.parseInt(kilencigmaradokText);
            int osszletszam = Integer.parseInt(osszletszamText);
            calculate(kilencigMaradok, osszletszam);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }
}
