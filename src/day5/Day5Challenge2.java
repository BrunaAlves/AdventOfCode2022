package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day5Challenge2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("./src/day5/Day5.txt"));
        Map<Integer,List<String>> crates = new HashMap<>();
        List<String> onlyCratesValues = new ArrayList<>();

        for (String s : input) {
            if(!s.equals("")) onlyCratesValues.add(s);
            else break;
        }

        for (int i = onlyCratesValues.size() - 2; i >= 0; i--) {
            String[] values = onlyCratesValues.get(i).substring(1).split("(?<=\\G.{" + 4 + "})");

            for (int j = 0; j < values.length; j++) {

                String value = values[j].replaceAll("[^A-Za-z0-9]","");
                List<String> list = new ArrayList<>();
                if(crates.get(j + 1) != null) list.addAll(crates.get(j + 1));
                list.add(value);
                list.removeAll(Arrays.asList("", null));
                crates.put(j+1, list);
            }

        }

        for (int i = 10; i < input.size(); i++) {
            String[] moves = input.get(i).split(" ");
            int quantityOfCratesToBeMove = Integer.parseInt(moves[1]);
            int fromPosition = Integer.parseInt(moves[3]);
            int toPosition = Integer.parseInt(moves[5]);

            List<String> listFrom = new ArrayList<>(crates.get(fromPosition));
            List<String> listTo = new ArrayList<>(crates.get(toPosition));


            List<String> sublist = listFrom.subList(listFrom.size()-quantityOfCratesToBeMove, listFrom.size());
            listTo.addAll(sublist);
            listFrom = listFrom.subList(0, listFrom.size()-quantityOfCratesToBeMove);


            crates.put(fromPosition, listFrom);
            crates.put(toPosition, listTo);


        }

        for (Map.Entry<Integer, List<String>> integerListEntry : crates.entrySet()) {
            System.out.println(integerListEntry.getValue().get(integerListEntry.getValue().size()-1));
        }


    }
}
