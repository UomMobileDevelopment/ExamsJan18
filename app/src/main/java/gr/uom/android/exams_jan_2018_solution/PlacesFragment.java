package gr.uom.android.exams_jan_2018_solution;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    private PlacesAdapter placesAdapter;

    public PlacesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        placesAdapter = new PlacesAdapter(getContext(), new ArrayList<Place>());

        ListView placesList = rootView.findViewById(R.id.placesList);

        placesList.setAdapter(placesAdapter);

        Button clickButton = (Button) rootView.findViewById(R.id.place_search_button);
        clickButton.setOnClickListener(new
                                               View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       EditText searchField = (EditText)rootView.findViewById(R.id.place_search_text);
                                                       String searchQuery = searchField.getText().toString();
                                                       String[] queryWords = searchQuery.split(" ");
                                                       FetchPlacesTask task = new FetchPlacesTask(placesAdapter);
                                                       task.execute(queryWords);
                                                       hideKeyboard(rootView);
                                                   }
                                               });
        return rootView;
    }

    private void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    
}