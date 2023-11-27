package edu.yu.cs.intro.ga;

public class Resource {
    Event[] events = new Event[5];
    private String path;

    public Resource(String path){
        if((Validators.isValidPath(path))){
            this.path = path;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getPath(){
        return this.path;
    }
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
                for (int k = 0; k < newEvents.length;k++) {
                    if (newEvents[k] == null) {
                        newEvents[k] = e;
                        events = newEvents;
                        return;
                    }
                }
            }
        }
    }
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
        }
        return newEvents;
    }
    public int getTotalDuration(){
        int totalDuration = 0;
        for (Event event: events) {
            if(event != null) {
                totalDuration += event.getDuration();
            }
        }
        return totalDuration;
    }
    public double getTotalConversion(){
        double totalConversion = 0;
        for (Event event: events) {
            if(event != null) {
                totalConversion += event.getConversion();
            }
        }
        return totalConversion;
    }
    public int[] getTotalAcquisitionCounts(){
        int[] acquisitionArray = new int[3];
        int totalSearch = 0;
        int totalDirect = 0;
        int totalReferral = 0;
        for (Event event: events) {
            if(event != null) {
                if (event.getAcquisition().matches("search")) {
                    totalSearch++;
                } else if (event.getAcquisition().matches("direct")) {
                    totalDirect++;
                } else if (event.getAcquisition().matches("referral")) {
                    totalReferral++;
                }
            }
        }
        acquisitionArray[0] = totalSearch;
        acquisitionArray[1] = totalDirect;
        acquisitionArray[2] = totalReferral;
        return acquisitionArray;
    }
}