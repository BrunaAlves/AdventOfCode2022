package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8Puzzle2 {
    public static int isVisibleUp(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(x>0){
            total++;
            if( currentValue>trees.get(x-1).get(y)){
                return isVisibleUp(trees, currentValue, x-1, y, total);
            }
        }
        return total;
    }

    public static int isVisibleDown(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(x < trees.size()-1){
            total ++;
            if( currentValue>trees.get(x+1).get(y)){
                return isVisibleDown(trees, currentValue, x+1, y, total);
            }
        }
        return total;
    }

    public static int isVisibleLeft(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(y>0){
            if(currentValue>trees.get(x).get(y-1)){
                total ++;
            }else{
                total ++;
                return total;
            }
            return isVisibleLeft(trees, currentValue, x, y-1, total);
        }
        return total;
    }

    public static int isVisibleRight(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(y+1 < trees.get(x).size()){
            if( currentValue>trees.get(x).get(y+1)){

                total ++;
            }else{
                total ++;
                return total;
            }
            return isVisibleRight(trees, currentValue, x, y+1, total);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day8/Day8.txt"));
        List<List<Integer>> trees = new ArrayList<>();

        for (String s : input) {
            trees.add(Arrays.stream(s.split("")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        int highestTree = 0;


        for (int i = 1; i < trees.size()-1; i++) {


            for (int j = 1; j < trees.get(i).size()-1; j++) {
                int currentValue = trees.get(i).get(j);

                System.out.println("current value: " + currentValue);
                System.out.println("up " + isVisibleUp(trees,currentValue, i,j, 0));
                System.out.println("down " + isVisibleDown(trees,currentValue, i,j, 0));
                System.out.println("left " + isVisibleLeft(trees, currentValue, i,j, 0));
                System.out.println("right " + isVisibleRight(trees,currentValue, i,j, 0));

                int totalOfVisibility = isVisibleUp(trees,currentValue, i,j, 0) *
                        isVisibleDown(trees,currentValue, i,j, 0) *
                        isVisibleLeft(trees, currentValue, i,j, 0) *
                        isVisibleRight(trees,currentValue, i,j, 0);

                if(totalOfVisibility>highestTree) highestTree = totalOfVisibility;

               System.out.println("total visible: " + totalOfVisibility);
               System.out.println(" ");

            }

            System.out.println("-------------------------------" );
        }

        System.out.println(highestTree);

    }
}
