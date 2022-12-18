package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day8Puzzle1 {

    public static int isVisibleUp(List<List<Integer>> trees, int currentValue, int x, int y, int total){
        if(x>0){
            if( currentValue>trees.get(x-1).get(y)){
                total ++;
                return isVisibleUp(trees, currentValue, x-1, y, total);
            }
        }
        return total;
    }

    public static int isVisibleDown(List<List<Integer>> trees, int currentValue, int x, int y, int total){
        if(x < trees.size()-1){
            if( currentValue>trees.get(x+1).get(y)){
                total ++;
                return isVisibleDown(trees, currentValue, x+1, y, total);
            }
        }
        return total;
    }

    public static int isVisibleLeft(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(y>0){
            if(currentValue>trees.get(x).get(y-1)){
                total ++;
            }
            return isVisibleLeft(trees, currentValue, x, y-1, total);
        }
        return total;
    }

    public static int isVisibleRight(List<List<Integer>> trees, int currentValue, int x, int y, int total){

        if(y+1 < trees.get(x).size()){
          if( currentValue>trees.get(x).get(y+1)){
                total ++;
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


        int totalOfVisibleTrees = (trees.size()*2-2) + (trees.get(0).size()*2-2);


        for (int i = 1; i < trees.size()-1; i++) {


            for (int j = 1; j < trees.get(i).size()-1; j++) {
                int currentValue = trees.get(i).get(j);

                System.out.println(currentValue);

                if(isVisibleUp(trees,currentValue, i,j, 0) == i){
                    System.out.println("IS VISIBLE UP?    " + isVisibleUp(trees,currentValue, i,j, 0) + " totalup: " + i);
                    totalOfVisibleTrees++;
                }
                else if(isVisibleDown(trees,currentValue, i,j, 0) == trees.size()-i-1){
                    System.out.println("IS VISIBLE DOWN?    " + isVisibleDown(trees,currentValue, i,j, 0) + " totaldown: " + String.valueOf(trees.size()-i-1));
                    totalOfVisibleTrees++;
                }
                else if(isVisibleLeft(trees, currentValue, i,j, 0) == j){
                    System.out.println("IS VISIBLE LEFT?    " + isVisibleLeft(trees, currentValue, i,j, 0) + " totalleft: " + String.valueOf(j));
                    totalOfVisibleTrees++;
                }
                else if(isVisibleRight(trees,currentValue, i,j, 0) == trees.size()-j-1){
                    System.out.println("IS VISIBLE RIGHT?    " + isVisibleRight(trees,currentValue, i,j, 0) + " totalright: " + String.valueOf(trees.size()-j-1));

                    totalOfVisibleTrees++;
                }

            }

            System.out.println("-------------------------------" );
        }

        System.out.println(totalOfVisibleTrees);

    }
}
