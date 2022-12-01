package Day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/Day1/Day1.txt");

        List<String> input = Files.readAllLines(path);

        List<Integer> totalCaloriesPerElfList = new ArrayList<>();


        int totalCaloriesPerElf = 0;
        for (String s : input) {
            if (s.isEmpty()) {
                totalCaloriesPerElfList.add(totalCaloriesPerElf);
                totalCaloriesPerElf = 0;
            } else {
                totalCaloriesPerElf = totalCaloriesPerElf + Integer.parseInt(s);
            }

        }

        totalCaloriesPerElfList.sort(Collections.reverseOrder());

        //First puzzle:
        System.out.println(totalCaloriesPerElfList.get(0));

        //Second puzzle:
        System.out.println(totalCaloriesPerElfList.get(0) + totalCaloriesPerElfList.get(1) + totalCaloriesPerElfList.get(2));



    }
}