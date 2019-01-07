package gr.uom.android.exams_jan_2018_solution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
        //    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new PlacesFragment()).commit();
        }
    }
}
