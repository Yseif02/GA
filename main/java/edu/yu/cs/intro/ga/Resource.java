package edu.yu.cs.intro.ga;

public class Resource {
    Event[] events = new Event[5];
    public void setEvents(){
        //custom method
        this.events[0] = new Event("456.html", 10, 5.5, "search");
        this.events[1] = new Event("456.html", 1, 5.5, "search");
        this.events[2] = new Event("456.html", 8, 5.5, "direct");
        this.events[3] = new Event("456.html", 7, 5.5, "search");
        this.events[4] = new Event("456.html", 13, 5.5, "referral");
    }
    private String path;
    /**
     * @throws IllegalArgumentException if the path is invalid
     * @see Validators#isValidPath(String)
     */
    public Resource(String path){
        //this.path = path;
        if((Validators.isValidPath(path))){
            this.path = path;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getPath(){
        return this.path;
    }
    /**
     * @throws IllegalArgumentException if the event is null or if the event's path doesn't
    match this resources path
     * @param e the event to add to this resource
     */
    protected void addEvent(Event e){
        if(e == null || e.getPath() != this.path){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < events.length;i++){
            if(events[i] == null){
                events[i] = e;
                return;
            }else {
                Event[] newEvents = new Event[events.length*2];
                for (int j = 0; j < events.length; j++){
                    newEvents[j] = events[j];
                }
                for (int k = 0; k < newEvents.length;i++) {
                    if (newEvents[k] == null) {
                        newEvents[k] = e;
                        events = newEvents;
                        return;
                    }
                }
            }
        }
    }
    /**
     * @return the events in the order in which they were added to the Resource. The array
    should not contain any extra/null entries. Must return a COPY of the event array, not the
    array which is Resource's instance variable.
     */
    public Event[] getEventsInChronologicalOrder(){
        int counter = 0;
        for(Event event : events) {
            if (event != null){
                counter++;
            }
        }
        Event[] newEvents = new Event[counter];
        for(int i =0; i < newEvents.length; i++ ){
            newEvents[i] = events[i];
            System.out.println(newEvents[i].getPath());
            System.out.println(newEvents[i].getDuration());
            System.out.println(newEvents[i].getConversion());
            System.out.println(newEvents[i].getAcquisition());
        }
        return newEvents;
    }
    /**
     * @return the duration of all the events on this resource combined
     */
    public int getTotalDuration(){
        int totalDuration = 0;
        for (Event event: events) {
            totalDuration += event.getDuration();
        }
        return totalDuration;
    }
    /**
     * @return the conversion value of all the events on this resource combined
     */
    public double getTotalConversion(){
        double totalConversion = 0;
        for (Event event: events) {
            totalConversion += event.getConversion();
        }
        return totalConversion;
    }
    /**
     * @return an array of length 3, in which [0] holds the count of events acquired via
    search, [1] holds the total for direct, [2] holds the total for referral
     * @see Validators#A_SEARCH
     * @see Validators#A_DIRECT
     * @see Validators#A_REFERRAL
     */
    public int[] getTotalAcquisitionCounts(){
        int[] acquisitionArray = new int[3];
        int totalSearch = 0;
        int totalDirect = 0;
        int totalReferral = 0;
        for (Event event: events) {
            if (event.getAcquisition().matches("search")){
                totalSearch++;
            } else if (event.getAcquisition().matches("direct")) {
                totalDirect++;
            } else if (event.getAcquisition().matches("referral")) {
                totalReferral++;
            }
        }
        acquisitionArray[0] = totalSearch;
        acquisitionArray[1] = totalDirect;
        acquisitionArray[2] = totalReferral;
        return acquisitionArray;
    }
}
