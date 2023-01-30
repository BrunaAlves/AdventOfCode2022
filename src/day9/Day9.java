package day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day9 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day9/Day9.txt"));
        int[][] array = new int[20][20];
        int[] tail = new int[]{10, 10};
        int[] head = new int[]{10, 10};

        for (String s : input) {
            String[] strSplit = s.split(" ");
            String direction = strSplit[0];
            int steps = Integer.valueOf(strSplit[1]);
            
            if(direction.equals("R")){
              //  head[0] = head[0] + steps;
             //   System.out.println(tail);
                for (int i = head[0]; i <= head[0]+4; i++) {
                    for (int j = head[1]; j < array.length; j++) {
                        array[i][j] = 1;
                     //   System.out.println(tail[0]);

                        System.out.println("arr[" + i + "][" + j + "] = "
                                + array[i][j]);
                    }
                }
            }


        }




    }
}
