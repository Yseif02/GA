package edu.yu.cs.intro.ga;

public class GoogleAnalytics {

    /**
     * @param path the path whose resource is being requested
     * @return the resource for the given path, or null if there is none
     */
    public Resource getResourceForPath(String path){
        return null;
    }

    /**
     * @return All the resources, sorted (lowest to highest) by path. The Array which is
    returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByPath(){
        return null;
    }
    /**
     * @return All the resources, sorted (lowest to highest) by total duration per resource.
    The Array which is returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByTotalDuration(){
        return null;
    }
    /**
     * @return All the resources, sorted (lowest to highest) by total conversion value per
    resource. The Array which is returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByTotalConversion(){
        return null;
    }
    /**
     * Get acquisition totals across all resources.
     * @return an array of length 3, in which [0] holds the count of events acquired via
    search, [1] holds the total for direct, [2] holds the total for referral
     * @see Validators#A_SEARCH
     * @see Validators#A_DIRECT
     * @see Validators#A_REFERRAL
     */
    public int[] getAcquisitionTotals(){
        return null;
    }
    /**
     * @throws IllegalArgumentException if path or acquisition are invalid, or if duration or
    conversion are negative
     * @see Event#Event(String, int, double, String)
     */
    public void addEvent(String path, int duration, double conversion, String acquisition){
        Event newEvent = new Event(path, duration, conversion, acquisition);
    }
    /**
     * @throws IllegalArgumentException if e is null
     * @param e
     */
    public void addEvent(Event e){
        if(e == null){
            throw new IllegalArgumentException();
        }
        addEvent(e);
    }

}
