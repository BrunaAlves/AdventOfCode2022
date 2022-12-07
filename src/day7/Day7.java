package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day7 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day7/Day7.txt"));
        List<String> paths = new ArrayList<>();

        NavigableMap<String, List<Integer>> FolderList = new TreeMap<>();

        for (int i = 0; i < input.size(); i++) {
            String[] currentLineArgs = input.get(i).split(" ");

            if(currentLineArgs[0].equals("$")){
                if(currentLineArgs[1].equals("cd")){
                    if(currentLineArgs[2].equals("..")){
                        paths.remove(paths.size() -1);

                    }else{
                        paths.add(currentLineArgs[2]);
                        String pathName = String.join("_", paths);
                        if(FolderList.get(pathName) == null){
                            FolderList.put(pathName, new ArrayList<>());
                        }

                    }

                }
            }else{
                String pathName = String.join("_", paths);
                if(!currentLineArgs[0].equals("dir")){
                    FolderList.get(pathName).add(Integer.valueOf(currentLineArgs[0]));
                }
            }

        }

        Map<String, Integer> pathAndSizeList = new TreeMap<>();



        for (Map.Entry<String, List<Integer>> s : FolderList.descendingMap().entrySet()) {
            int sum = s.getValue().stream().mapToInt(Integer::intValue).sum();
            pathAndSizeList.put(s.getKey(), sum);
        }


        List<Integer> sizeList = new ArrayList<>();

        for (Map.Entry<String, Integer> s : pathAndSizeList.entrySet()) {

            for (Map.Entry<String, Integer> sj : pathAndSizeList.entrySet()) {
                if(sj.getKey().contains(s.getKey()) && !sj.getKey().equalsIgnoreCase(s.getKey())){
                    int sum = s.getValue() + sj.getValue();

                    pathAndSizeList.put(s.getKey(), sum);
                }
            }
        }

        int finalSum = 0;

        for (Map.Entry<String, Integer> s : pathAndSizeList.entrySet()) {
            sizeList.add(s.getValue());
            if (s.getValue() < 100000) {
                finalSum += s.getValue();
            }
        }

        Collections.sort(sizeList);


        int totalFreeSpace = 70000000 - sizeList.get(sizeList.size()-1);
        System.out.println(totalFreeSpace);
        System.out.println(sizeList.get(sizeList.size()-1));

        int closerNumber = 0;
        for (int i = 1; i < sizeList.size(); i++) {
            if (Math.abs(sizeList.get(i)-totalFreeSpace) <= Math.abs(sizeList.get(i-1)-totalFreeSpace) && sizeList.get(i)<totalFreeSpace) {
                closerNumber = sizeList.get(i);
            }

        }

        System.out.println(closerNumber);




    }



}
