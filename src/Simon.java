import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simon implements Defuser {

    private String result;
    private Scanner input;
    private int strikes;
    private Map<Pair<Integer, String>, String> strikes_and_colors_vowels;
    private Map<Pair<Integer, String>, String> strikes_and_colors_no_vowels;


    public Simon() {
        input = Bomb.input;
        result = "Press";
        initMapVowels();
        initMapNoVowels();
    }

    private void initMapVowels() {
        strikes_and_colors_vowels = new HashMap<>();
        strikes_and_colors_vowels.clear();

        strikes_and_colors_vowels.put(new Pair<>(0, "R"), "BLUE");
        strikes_and_colors_vowels.put(new Pair<>(0, "B"), "RED");
        strikes_and_colors_vowels.put(new Pair<>(0, "G"), "YELLOW");
        strikes_and_colors_vowels.put(new Pair<>(0, "Y"), "GREEN");

        strikes_and_colors_vowels.put(new Pair<>(1, "R"), "YELLOW");
        strikes_and_colors_vowels.put(new Pair<>(1, "B"), "GREEN");
        strikes_and_colors_vowels.put(new Pair<>(1, "G"), "BLUE");
        strikes_and_colors_vowels.put(new Pair<>(1, "Y"), "RED");

        strikes_and_colors_vowels.put(new Pair<>(2, "R"), "GREEN");
        strikes_and_colors_vowels.put(new Pair<>(2, "B"), "RED");
        strikes_and_colors_vowels.put(new Pair<>(2, "G"), "YELLOW");
        strikes_and_colors_vowels.put(new Pair<>(2, "Y"), "BLUE");

    }

    private void initMapNoVowels() {
        strikes_and_colors_no_vowels = new HashMap<>();
        strikes_and_colors_no_vowels.clear();

        strikes_and_colors_no_vowels.put(new Pair<>(0, "R"), "BLUE");
        strikes_and_colors_no_vowels.put(new Pair<>(0, "B"), "YELLOW");
        strikes_and_colors_no_vowels.put(new Pair<>(0, "G"), "GREEN");
        strikes_and_colors_no_vowels.put(new Pair<>(0, "Y"), "RED");

        strikes_and_colors_no_vowels.put(new Pair<>(1, "R"), "RED");
        strikes_and_colors_no_vowels.put(new Pair<>(1, "B"), "BLUE");
        strikes_and_colors_no_vowels.put(new Pair<>(1, "G"), "YELLOW");
        strikes_and_colors_no_vowels.put(new Pair<>(1, "Y"), "GREEN");

        strikes_and_colors_no_vowels.put(new Pair<>(2, "R"), "YELLOW");
        strikes_and_colors_no_vowels.put(new Pair<>(2, "B"), "GREEN");
        strikes_and_colors_no_vowels.put(new Pair<>(2, "G"), "BLUE");
        strikes_and_colors_no_vowels.put(new Pair<>(2, "Y"), "RED");
    }

    @Override
    public void defuse() {
        result = "Press";
        Map<Pair<Integer, String>, String> defuseMap = strikes_and_colors_no_vowels;
        System.out.println("How many strikes so far?");
        strikes = input.nextInt();
        if (serialContainsAEIOU())
            defuseMap = strikes_and_colors_vowels;
        while (true) {
            System.out.println("Enter the next color R/B/G/Y    0 to Exit");
            String color = input.next().toUpperCase().substring(0, 1);
            if (color.equals("0")) break;
            result += " " + defuseMap.get(new Pair<>(strikes, color));
            System.out.println(result);
        }

    }


    private boolean serialContainsAEIOU() {
        String serial = Bomb.getSerial();
        boolean result = serial.contains("A") || serial.contains("E") ||
                serial.contains("I") || serial.contains("O") || serial.contains("U");
        return result;
    }
}
