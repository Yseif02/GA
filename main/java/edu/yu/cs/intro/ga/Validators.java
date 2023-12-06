package edu.yu.cs.intro.ga;

public class Validators {
    public static final String A_SEARCH = "search";
    public static final String A_DIRECT = "direct";
    public static final String A_REFERRAL = "referral";
    public static boolean isValidAcquisition(String acquisition){
        if(acquisition != null && (acquisition.equals(A_DIRECT) || acquisition.matches(A_REFERRAL) || acquisition.matches(A_SEARCH))){
            return true;
        }
        return false;
    }
    public static boolean isValidPath(String path){
        String lastFour = path.substring(path.length()-4);
        String lastFive = path.substring(path.length()-5);
        String beginning5 = path.substring(0, path.length()-5);
        String beginning4 = path.substring(0, path.length()-4);
        String lastFiveLowercase = lastFive.toLowerCase();
        String lastFourLowercase = lastFour.toLowerCase();
        String html = ".html";
        String mp3 = ".mp3";
        String m4a = ".m4a";
        String mp4 = ".mp4";
        if(lastFiveLowercase.matches(html)){
            for(int i = 0; i < beginning5.length(); i++){
                String currentChar = String.valueOf(beginning5.charAt(i));
                if (!currentChar.matches("[a-zA-Z1-9\\-\\/\\.\\\\]")){
                    return false;
                }
            }
            return true;
        }else if(lastFourLowercase.equals(mp3) || lastFourLowercase.equals(m4a) || lastFourLowercase.equals(mp4)){
            for(int i = 0; i < beginning4.length(); i++){
                String currentChar = String.valueOf(beginning4.charAt(i));
                if (!currentChar.matches("[a-zA-Z1-9\\-\\/\\.\\\\]")){
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}