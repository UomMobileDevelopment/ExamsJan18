package gr.uom.android.exams_jan_2018_solution;

public class Place {

    private String id;
    private String name;
    private String fullAddress;
    private double rating;
    private boolean hasOpeningHoursInfo;
    private boolean openNow;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isHasOpeningHoursInfo() {
        return hasOpeningHoursInfo;
    }

    public void setHasOpeningHoursInfo(boolean hasOpeningHoursInfo) {
        this.hasOpeningHoursInfo = hasOpeningHoursInfo;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    public String getOpenNowDescr(){
        if(openNow) return "Open Now!";
        return "Closed now";
    }

    public String getRatingDescr(){
        return "";
    }

    @Override
    public String toString() {
        String open =  (hasOpeningHoursInfo) ? ". Open Now? "+openNow : "";
        return name+" Rating: "+rating + " "+open;
    }
}
