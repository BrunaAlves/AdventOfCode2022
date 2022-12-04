package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day4/Day4.txt"));
        int sumPairFullyContainTheOther = 0;
        int sumPairRangesOverlap = 0;

        for (String s : input) {
            String[] splitSections = s.split(","); //first split the String in two section. ex: 20-45,13-44
            String firstSection = splitSections[0]; //first position ex: 20-45
            String secondSection = splitSections[1]; //second position ex: 13-44

            String[] splitFirstSection = firstSection.split("-"); // split again the firstSection ex. [20,45]
            String[] splitSecondSection = secondSection.split("-"); //split again the secondSection ex. [13,44]

            Set<Integer> firstSectionList = new HashSet<>();
            Set<Integer> secondSectionList = new HashSet<>();
            Set<Integer> containFirstAndSecondSectionList = new HashSet<>();

            for(int i=Integer.parseInt(splitFirstSection[0]);i<=Integer.parseInt(splitFirstSection[1]);i++){ //find all the numbers between the range ex. 20 to 45
                firstSectionList.add(i);
                containFirstAndSecondSectionList.add(i);
            }

            for(int i=Integer.parseInt(splitSecondSection[0]);i<=Integer.parseInt(splitSecondSection[1]);i++){ //find all the numbers between the range ex. 13 to 44
                secondSectionList.add(i);
            }
            containFirstAndSecondSectionList.retainAll(secondSectionList); // find all the numbers contained in the first and second session

            if(containFirstAndSecondSectionList.size()==firstSectionList.size() ||
                    containFirstAndSecondSectionList.size()==secondSectionList.size()){ //if the list number is the same size of one of the sessions, it means it fully contain one of them
                sumPairFullyContainTheOther ++;
            }

            if(containFirstAndSecondSectionList.size() > 0) sumPairRangesOverlap++; //if the list size is > 0, means the section is overlapping

        }

        System.out.println(sumPairFullyContainTheOther); //Challenge answer 1
        System.out.println(sumPairRangesOverlap); // Challenge answer 2
    }
}
