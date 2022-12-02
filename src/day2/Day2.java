package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/day2/Day2.txt");

        List<String> input = Files.readAllLines(path);

        //The elf plays: A = Rock, B = Paper, C = Scissors
        // I should play in response: X = Rock = 1, Y = Paper = 2, Z = Scissors = 3
        //Score shape you selected: 1 = Rock, 2 = Paper, 3 = Scissors (PLUS)
        //Score for the outcome of the round: 0 = lost, 3 = draw, 6 = win


        int totalScoreChallenge1 = 0;
        int totalScoreChallenge2 = 0;

        for (String s : input) {
            String[] play = s.split(" ");
            String elfChoice = play[0];
            String myChoice = play[1];

            switch (myChoice) {
                case "X":  //Rock = 1
                    switch (elfChoice) {
                        case "A":   //Rock
                            totalScoreChallenge1 += 3 + 1; //Rock = draw = 3
                            totalScoreChallenge2 += 3; // need to lose = scissor
                            break;
                        case "B":  //Paper
                            totalScoreChallenge1 += 1; //Paper = lost = 0
                            totalScoreChallenge2 +=  1; // need to lose = rock
                            break;
                        case "C":   // Scissors
                            totalScoreChallenge1 += 6 + 1; // Scissors = win = 6
                            totalScoreChallenge2 += 2; // need to lose = paper
                            break;
                    }
                    break;
                case "Y":  // Paper = 2
                    switch (elfChoice) {
                        case "A":   //Rock
                            totalScoreChallenge1 += 6 + 2; //Rock = win = 6
                            totalScoreChallenge2 += 3 + 1; // need to draw = rock
                            break;
                        case "B":  //Paper
                            totalScoreChallenge1 += 3 + 2; //Paper = draw = 3
                            totalScoreChallenge2 += 3 + 2; // need to draw = paper
                            break;
                        case "C":  // Scissors
                            totalScoreChallenge1 += 2; // Scissors = lost = 0
                            totalScoreChallenge2 += 3 + 3; // need to draw = scissors
                            break;
                    }
                    break;
                case "Z":  // Scissors = 3
                    switch (elfChoice) {
                        case "A":   //Rock
                            totalScoreChallenge1 += 3; //Rock = lost = 0
                            totalScoreChallenge2 += 6 + 2; // need to win = paper
                            break;
                        case "B":  //Paper
                            totalScoreChallenge1 += 6 + 3; //Paper = win = 6
                            totalScoreChallenge2 += 6 + 3; // need to win = scissor
                            break;
                        case "C":  // Scissors
                            totalScoreChallenge1 += 3 + 3; // Scissors = draw = 3
                            totalScoreChallenge2 += 6 + 1; // need to win = rock
                            break;
                    }
                    break;
            }
        }

        System.out.println(totalScoreChallenge1);
        System.out.println(totalScoreChallenge2);


    }
}
