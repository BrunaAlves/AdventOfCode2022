package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

public class Day6 {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(Paths.get("./src/day6/Day6.txt"));
        String[] allLetters = input.split("");
        int totalCharactersProceedMarker = 0;
        int totalCharactersProceedMessage = 0;

        for (int i = 0; i < allLetters.length-3; i++) { //CHALLENGE 1 = marker
            int maxIndex = i+4;
            String[] checkMarker = Arrays.copyOfRange(allLetters, i, maxIndex); // get the range of 4 positions

            HashSet<String> set = new HashSet<>(Arrays.asList(checkMarker)); // make a set of it
            if(set.size()==4){ // if the size remains the same, means that the set wasn't reduce, so all characters are uniques
                totalCharactersProceedMarker = maxIndex; //the total of characters processed will be the last index checked
                break;
            }

        }

        for (int i = 0; i < allLetters.length-13; i++) { //CHALLENGE 2 = message
            int maxIndex = i+14;
            String[] checkMarker = Arrays.copyOfRange(allLetters, i, maxIndex); // get the range of 14 positions

            HashSet<String> set = new HashSet<>(Arrays.asList(checkMarker)); // make a set of it
            if(set.size()==14){ // if the size remains the same, means that the set wasn't reduce, so all characters are uniques
                totalCharactersProceedMessage = maxIndex; //the total of characters processed will be the last index checked
                break;
            }

        }

        System.out.println(totalCharactersProceedMarker); //answer challenge 1
        System.out.println(totalCharactersProceedMessage); //answer challenge 2
    }
}
