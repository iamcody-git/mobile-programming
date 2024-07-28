package hcoe.com;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
            Fragment crimeFragment = fm.findFragmentById(R.id.crime_fragment_container);

            if (crimeFragment == null){
                crimeFragment = new CrimeFragment();
                fm.beginTransaction().add(R.id.crime_fragment_container,crimeFragment).commit();

            }
    }
}