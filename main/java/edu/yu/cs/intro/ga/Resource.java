package edu.yu.cs.intro.ga;

public class Resource {
    private String path;
    /**
     * @throws IllegalArgumentException if the path is invalid
     * @param path the path which this resource represents
     * @see Validators#isValidPath(String)
     */
    public Resource(String path){
        if(Validators.isValidPath(path)){
            this.path = path;
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

    }
    /**
     * @return the events in the order in which they were added to the Resource. The array
    should not contain any extra/null entries. Must return a COPY of the event array, not the
    array which is Resource's instance variable.
     */
    public Event[] getEventsInChronologicalOrder(){
        Event[] resources = new Event[1];
        return new Event[1];
    }
    /**
     * @return the duration of all the events on this resource combined
     */
    public int getTotalDuration(){
        return 1;
    }
    /**
     * @return the conversion value of all the events on this resource combined
     */
    public double getTotalConversion(){
        return 1;
    }
    /**
     * @return an array of length 3, in which [0] holds the count of events acquired via
    search, [1] holds the total for direct, [2] holds the total for referral
     * @see Validators#A_SEARCH
     * @see Validators#A_DIRECT
     * @see Validators#A_REFERRAL
     */
    public int[] getTotalAcquisitionCounts(){
        return new int[1];
    }

}
