package hcoe.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class CrimeFragment extends Fragment {
    private CrimeModel crimeModel;
    private EditText crimeTitleTextBox;
    private Button dateButton;
    private CheckBox crimeSolved;

    public CrimeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        crimeModel  = new CrimeModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        crimeTitleTextBox = view.findViewById(R.id.crimeTitleTextBox);
        dateButton=view.findViewById(R.id.dateButton);
        crimeSolved=view.findViewById(R.id.crimeSolved);

        dateButton.setEnabled(false);
        dateButton.setText(crimeModel.getCrimeDate().toString());




        crimeTitleTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                crimeModel.setTitle(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        crimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                crimeModel.setSolved(b);
            }
        });
        return view;
    }
}