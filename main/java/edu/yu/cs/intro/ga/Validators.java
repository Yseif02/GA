package edu.yu.cs.intro.ga;

public class Validators {
    public static final String A_SEARCH = "search";
    public static final String A_DIRECT = "direct";
    public static final String A_REFERRAL = "referral";
    /**
     * @param acquisition
     * @return If acquisition is null, return false. If acquisition is one of search, direct,
    or referral, return true. Otherwise, return false.
     */
    public static boolean isValidAcquisition(String acquisition){
        if(acquisition != null && (acquisition.equals(A_DIRECT) || acquisition.matches(A_REFERRAL) || acquisition.matches(A_SEARCH))){
            return true;
        }
        return false;
    }
    /**
     * If the path is null, return false.
     * See below for valid path contents and endings. If path doesn't have a valid ending or
     has disallowed characters, return false.
     * @param path path to file. May contain letters, dashes, periods and slashes; anything
    else is invalid. Must end in one of: ".html", ".mp3", ".m4a", or ".mp4" (each letter of
    which can be uppercase OR lowercase).
     * @return true if the path is valid, false if it is not.
     */
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
        if(lastFiveLowercase.equals(html)){
            for(int i = 0; i < beginning5.length(); i++){
                String currentChar = String.valueOf(beginning5.charAt(i));
                if (!currentChar.matches("[a-zA-Z1-9\\-\\/\\.\\\\]") /*|| currentChar.matches("\\/")*/){
                    return false;
                }
                return true;
            }
        }else if(lastFourLowercase.equals(html) || lastFourLowercase.equals(mp3) || lastFourLowercase.equals(m4a) || lastFourLowercase.equals(mp4)){
            for(int i = 0; i < beginning4.length(); i++){
                String currentChar = String.valueOf(beginning4.charAt(i));
                if (!currentChar.matches("[a-zA-Z1-9\\-\\/\\.\\\\]") /*|| currentChar.matches("\\/")*/){
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
