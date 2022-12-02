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


        //----------------------------------------------------ANSWER CHALLENGE 1
        int totalScore = 0;

        for (String s : input) {
            String[] play = s.split(" ");
            String elfChoice = play[0];
            String myChoice = play[1];

            switch (myChoice) {
                case "X":  //Rock = 1
                    switch (elfChoice) {
                        case "A":   //Rock = draw = 3
                            totalScore = totalScore + 3 + 1;
                            break;
                        case "B":  //Paper = lost = 0
                            totalScore = totalScore + 1;
                            break;
                        case "C":  // Scissors = win = 6
                            totalScore = totalScore + 6 + 1;
                            break;
                    }
                    break;
                case "Y":  // Paper = 2
                    switch (elfChoice) {
                        case "A":   //Rock = win = 6
                            totalScore = totalScore + 6 + 2;
                            break;
                        case "B":  //Paper = draw = 3
                            totalScore = totalScore + 3 + 2;
                            break;
                        case "C":  // Scissors = lost = 0
                            totalScore = totalScore + 2;
                            break;
                    }
                    break;
                case "Z":  // Scissors = 3
                    switch (elfChoice) {
                        case "A":   //Rock = lost = 0
                            totalScore = totalScore + 3;
                            break;
                        case "B":  //Paper = win = 6
                            totalScore = totalScore + 6 + 3;
                            break;
                        case "C":  // Scissors = draw = 3
                            totalScore = totalScore + 3 + 3;
                            break;
                    }
                    break;
            }
        }

        System.out.println(totalScore);




        //----------------------------------------------------ANSWER CHALLENGE 2

        int totalScore2 = 0;
        for (String s : input) {
            String[] play = s.split(" ");
            String elfChoice = play[0];
            String myChoice = play[1];

            switch (elfChoice) {
                case "A":   //Rock
                    switch (myChoice) {
                        case "X":  // need to lose = scissor
                            totalScore2 = totalScore2 + 3;
                            break;
                        case "Y":  // need to draw = rock
                            totalScore2 = totalScore2 + 3 + 1;
                            break;
                        case "Z":  // need to win = paper
                            totalScore2 = totalScore2 + 6 + 2;
                            break;
                    }
                    break;
                case "B":  //Paper
                    switch (myChoice) {
                        case "X":  // need to lose = rock
                            totalScore2 = totalScore2 + 1;
                            break;
                        case "Y":  // need to draw = paper
                            totalScore2 = totalScore2 + 3 + 2;
                            break;
                        case "Z":  // need to win = scissor
                            totalScore2 = totalScore2 + 6 + 3;
                            break;
                    }
                    break;
                case "C":  // Scissors
                    switch (myChoice) {
                        case "X":  // need to lose = paper
                            totalScore2 = totalScore2 + 2;
                            break;
                        case "Y":  // need to draw = scissors
                            totalScore2 = totalScore2 + 3 + 3;
                            break;
                        case "Z":  // need to win = rock
                            totalScore2 = totalScore2 + 6 + 1;
                            break;
                    }
                    break;
            }

        }

        System.out.println(totalScore2);

    }
}
