package edu.yu.cs.intro.ga;

import java.util.Arrays;

public class GoogleAnalytics {

    Resource[] resources = new Resource[5];
    public void setResources(){
        //custom method
        this.resources[0] = new Resource("456.html");
        this.resources[1] = new Resource("789.html");
        this.resources[2] = new Resource("123.html");
        this.resources[3] = new Resource("mjedh.mp3");
        this.resources[4] = new Resource("562.html");
    }

    /**
     * @param path the path whose resource is being requested
     * @return the resource for the given path, or null if there is none
     */
    public Resource getResourceForPath(String path){
        //given a path, see if there is a Resource path that matches this path
        for(Resource resource: resources){
            if(resource != null && path.equals(resource.getPath())){
                return resource;
            }
        }
        return null;
    }

    /**
     * @return All the resources, sorted (lowest to highest) by path. The Array which is
    returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByPath(){
        int counter = 0;
        for(Resource resource : resources) {
            if (resource != null){
                counter++;
            }
        }
        Resource[] newResources = new Resource[counter];
        for(int i =0; i < newResources.length; i++ ){
            if(resources[i] != null) {
                newResources[i] = resources[i];
            }
        }
        for(Resource resource: newResources){
            //System.out.println(resource.getPath());
        }
        System.out.println(counter);
        for (int i = 0; i < newResources.length - 1; i++) {
            for (int j = 0; j < newResources.length - 1; j++) {
                String path1 = newResources[j].getPath();
                String path2 = newResources[j + 1].getPath();
                if (path1.compareTo(path2) > 0) {
                    Resource temp = newResources[j];
                    newResources[j] = newResources[j + 1];
                    newResources[j + 1] = temp;
                }
            }
        }
        for(Resource resource: newResources){
            System.out.println(resource.getPath());
        }
        return newResources;
    }
    /**
     * @return All the resources, sorted (lowest to highest) by total duration per resource.
    The Array which is returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByTotalDuration(){
        int index = 0;
        while (index < resources.length && resources[index] != null){
            index++;
        }
        Resource[] newResources = new Resource[index];
        for(int i = 0; i < index; i++){
            newResources[i] = resources[i];
        }
        for (int i = 0; i < newResources.length-1; i++){
            for(int j = 0; j < newResources.length-1; j++){
                int resource1 = newResources[j].getTotalDuration();
                int resource2 = newResources[j+1].getTotalDuration();
                if(resource1 > resource2){
                    Resource temp = newResources[j];
                    newResources[j] = newResources[j+1];
                    newResources[j+1] = temp;
                }
            }
        }
        for(Resource resource: newResources){
            System.out.println(resource.getTotalDuration());
        }
        return newResources;
    }
    /**
     * @return All the resources, sorted (lowest to highest) by total conversion value per
    resource. The Array which is returned must not contain any null elements.
     */
    public Resource[] getResourcesSortedByTotalConversion(){
        int index = 0;
        while (index < resources.length && resources[index] != null){
            index++;
        }
        Resource[] newResources = new Resource[index];
        for(int i = 0; i < index; i++){
            newResources[i] = resources[i];
        }
        for (int i = 0; i < newResources.length-1; i++){
            for(int j = 0; j < newResources.length-1; j++){
                double resource1 = newResources[j].getTotalConversion();
                double resource2 = newResources[j+1].getTotalConversion();
                if(resource1 > resource2){
                    Resource temp = newResources[j];
                    newResources[j] = newResources[j+1];
                    newResources[j+1] = temp;
                }
            }
        }
        return newResources;
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
        int index = 0;
        while (index < resources.length && resources[index] != null){
            index++;
        }
        System.out.println(index);
        System.out.println(resources[0].getPath());
        Resource[] newResources = new Resource[index];
        for(int i = 0; i < index; i++){
            newResources[i] = resources[i];
        }
        int[] totalAcquisitions = {0,0,0};
        for (int i = 0; i < index; i++){
           int[] resourceAcquisitions = newResources[i].getTotalAcquisitionCounts();
           totalAcquisitions[0] += resourceAcquisitions[0];
           totalAcquisitions[1] += resourceAcquisitions[1];
           totalAcquisitions[2] += resourceAcquisitions[2];
        }
        System.out.println(Arrays.toString(totalAcquisitions));
        return totalAcquisitions;
    }
    /**
     * @throws IllegalArgumentException if path or acquisition are invalid, or if duration or
    conversion are negative
     * @see Event#Event(String, int, double, String)
     */
    public void addEvent(String path, int duration, double conversion, String acquisition){
        if ((!(Validators.isValidPath(path))) || (!(Validators.isValidAcquisition(acquisition))) || duration < 0 || conversion < 0){
            throw new IllegalArgumentException();
        }
        addEvent(new Event(path, duration, conversion, acquisition));
    }
    /**
     * @throws IllegalArgumentException if e is null
     * @param e
     */
    public void addEvent(Event e){
        if(e == null){
            throw new IllegalArgumentException();
        }
        Resource resource = getResourceForPath(e.getPath());
        if(resource == null){
            resource = new Resource(e.getPath());
            int index = 0;
            while (index < resources.length && resources[index] != null) {
                index++;
            }
            if(index == resources.length){
                Resource[] newResources = new Resource[resources.length*2];
                for(int i = 0; i < resources.length; i++){
                    newResources[i] = resources[i];
                }
                resources = newResources;
            }
            resources[index] = resource;
        }
        resource.addEvent(e);
    }
}
