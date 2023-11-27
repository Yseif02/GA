package edu.yu.cs.intro.ga;

public class Event {
    private String path;
    private int duration;
    private double conversion;
    private String acquisition;
    public Event(String path, int duration, double conversion, String acquisition){
        if(Validators.isValidPath(path)){
            this.path = path;
        }else {
            throw new IllegalArgumentException();
        }
        if(Validators.isValidAcquisition(acquisition)){
            this.acquisition = acquisition;
        }else {
            throw new IllegalArgumentException();
        }
        if(duration > 0 || conversion > 0){
            this.duration = duration;
            this.conversion = conversion;
        }else {
            throw new IllegalArgumentException();
        }
    }
    public String getPath(){
        return this.path;
    }
    public String getAcquisition(){
        return this.acquisition;
    }
    public int getDuration(){
        return this.duration;
    }
    public double getConversion(){
        return this.conversion;
    }
}