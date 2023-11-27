package edu.yu.cs.intro.ga;

import java.util.Arrays;

public class GoogleAnalytics {

    Resource[] resources = new Resource[5];
    public Resource getResourceForPath(String path){
        for(Resource resource: resources){
            if(resource != null && path.equals(resource.getPath())){
                return resource;
            }
        }
        return null;
    }
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
        return newResources;
    }
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
        return newResources;
    }
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
    public int[] getAcquisitionTotals(){
        int index = 0;
        while (index < resources.length && resources[index] != null){
            index++;
        }
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
        return totalAcquisitions;
    }
    public void addEvent(String path, int duration, double conversion, String acquisition){
        if ((!(Validators.isValidPath(path))) || (!(Validators.isValidAcquisition(acquisition))) || duration < 0 || conversion < 0){
            throw new IllegalArgumentException();
        }
        addEvent(new Event(path, duration, conversion, acquisition));
    }
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