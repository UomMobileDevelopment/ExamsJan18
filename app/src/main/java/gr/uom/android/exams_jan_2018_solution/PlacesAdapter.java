package gr.uom.android.exams_jan_2018_solution;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends ArrayAdapter<Place> {

    private List<Place> places;

    public PlacesAdapter(Context context, ArrayList<Place> places) {
        super(context,0, places);
        this.places = places;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;

        Place place = places.get(position);

        if(rowView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rowView = inflater.inflate(R.layout.place_item, parent, false);
            viewHolder = new ViewHolder(rowView);
            rowView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)rowView.getTag();
        }

        viewHolder.placeAddress.setText(place.getFullAddress());
        viewHolder.placeName.setText(place.getName());
        viewHolder.placeRating.setText(place.getRating() + " stars");
        viewHolder.placeOpenNow.setText(place.getOpenNowDescr());

        return  rowView;
    }

    static class ViewHolder {
        public final TextView placeName;
        public final TextView placeRating;
        public final TextView placeAddress;
        public final TextView placeOpenNow;

        public ViewHolder(View view){
             placeName = view.findViewById(R.id.titleTxt);
            placeAddress = view.findViewById(R.id.adrTxt);
            placeRating = view.findViewById(R.id.ratingTxt);
            placeOpenNow = view.findViewById(R.id.openTxt);
        }
    }
}