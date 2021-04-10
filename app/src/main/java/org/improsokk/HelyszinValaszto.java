package org.improsokk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.improsokk.helyszin.Helyszinek;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelyszinValaszto extends Fragment {
    Set<Helyszinek> voltMar = new HashSet<>();

    public HelyszinValaszto() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button ujHelyszin = getView().findViewById(R.id.uj_helyszin);
        ujHelyszin.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        CheckBox voltMarCheck = getView().findViewById(R.id.volt_mar);
        TextView ujHelyszin = getView().findViewById(R.id.helyszin);
        Helyszinek helyszin;
        if (voltMarCheck.isChecked()) {
            if (voltMar.size() == Helyszinek.values().length) {
                ujHelyszin.setText("Elfogytak a helyszinek!");
                return;
            } else {
                do {
                    helyszin = keresHelyszin();
                } while (voltMar.contains(helyszin));
                voltMar.add(helyszin);
            }
        } else {
            helyszin = keresHelyszin();
        }

        ujHelyszin.setText(helyszin.helyszin);
    }

    private Helyszinek keresHelyszin() {
        Helyszinek helyszin;
        int index = new Random().nextInt(Helyszinek.values().length);
        helyszin = Helyszinek.values()[index];
        return helyszin;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_helyszin_valaszto, container, false);
    }
}
