import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WireSequence implements Defuser {

    private Scanner input;
    private Map<String, String[]> color_to_arr;
    private Map<String, Integer> color_to_num;

    public WireSequence() {
        input = Bomb.input;

    }

    @Override
    public void defuse() {
        initColorToNum();
        initColorToArr();
        String color;
        String connection;
        while (true) {
            System.out.println("Enter color followed by A/B/C    0 to Exit");
            color = input.next().toUpperCase();
            if (color.equals("0")) break;
            if (color.equals("RED")) updateColorNumMap("RED");
            if (color.equals("BLUE")) updateColorNumMap("BLUE");
            if (color.equals("BLACK")) updateColorNumMap("BLACK");
            connection = input.next().toUpperCase();
            if (color_to_arr.get(color)[color_to_num.get(color)].contains(connection)) System.out.println("Cut it");
            else System.out.println("DO NOT cut it");

        }

    }

    private void updateColorNumMap(String color) {
        color_to_num.put(color, color_to_num.get(color) + 1);
    }

    private void initColorToNum() {
        color_to_num = new HashMap<String, Integer>();
        color_to_num.clear();
        color_to_num.put("RED", -1);
        color_to_num.put("BLUE", -1);
        color_to_num.put("BLACK", -1);
    }

    private void initColorToArr() {
        color_to_arr = new HashMap<String, String[]>();
        color_to_arr.clear();
        color_to_arr.put("RED", new String[]{"C", "B", "A", "AC", "B", "AC", "ABC", "AB", "B"});
        color_to_arr.put("BLUE", new String[]{"B", "AC", "B", "A", "B", "BC", "C", "AC", "A"});
        color_to_arr.put("BLACK", new String[]{"ABC", "AC", "B", "AC", "B", "BC", "AB", "C", "C"});
    }


}
