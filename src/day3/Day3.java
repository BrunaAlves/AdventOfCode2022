package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day3/Day3.txt"));

        
       // ------------------------------------------------------ CHALLENGE 1

        List<String> totalWrongItems = new ArrayList<>();

        for (String s : input) {
            String[] sArray = s.split(""); // make a array of string

            String[] firstCompartment = Arrays.copyOfRange(sArray, 0, sArray.length/2); //split the array first compartment
            String[] secondCompartment = Arrays.copyOfRange(sArray, sArray.length/2, sArray.length); //split the array second compartment

            Set<String> firstSet = new HashSet<>(Arrays.asList(firstCompartment)); // make it a set so it is not duplicated value
            Set<String> secondSet = new HashSet<>(Arrays.asList(secondCompartment)); // make it a set so it is not duplicated value
            firstSet.retainAll(secondSet); // keep only the values that contains on both set

            totalWrongItems.addAll(firstSet);
            
        }

        String[] alphabet = Files.readString(Paths.get("./src/day3/Alphabet.txt")).split(", ");
        int sumWrongItems = 0;
        for (int i = 0; i < alphabet.length; i++) { //counting alphabet values
            int finalI = i;
            List<String> compare = totalWrongItems
                    .stream()
                    .filter(t -> t.equals(alphabet[finalI]))
                    .collect(Collectors.toList()); //find similarities between the i letter and the list ofd wrong items

            int value = compare.size() * (i+1);
            sumWrongItems += value;
        }

        System.out.println(sumWrongItems);


        // ------------------------------------------------------ CHALLENGE 2
        
        List<String> totalBadges = new ArrayList<>();

        for (int i = 0; i < input.size(); i += 3) {

            Set<String> Elf1Backpack = new HashSet<>(Arrays.asList( input.get(i).split(""))); // make it a set so it is not duplicated
            Set<String> Elf2Backpack = new HashSet<>(Arrays.asList( input.get(i+1).split(""))); // make it a set so it is not duplicated
            Set<String> Elf3Backpack = new HashSet<>(Arrays.asList( input.get(i+2).split(""))); // make it a set so it is not duplicated

            Elf1Backpack.retainAll(Elf2Backpack); // keep only the values that contains on 3 packpacks
            Elf1Backpack.retainAll(Elf3Backpack);
            totalBadges.addAll(Elf1Backpack);
        }

        int sumBadges = 0;
        for (int i = 0; i < alphabet.length; i++) { //counting alphabet values
            int finalI = i;
            List<String> compare = totalBadges
                    .stream()
                    .filter(t -> t.equals(alphabet[finalI]))
                    .collect(Collectors.toList()); //find similarities between the i letter and the list ofd wrong items

            int value = compare.size() * (i+1);
            sumBadges += value;
        }

        System.out.println(sumBadges);
    }
}

