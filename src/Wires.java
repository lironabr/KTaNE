import java.util.Scanner;

public class Wires implements Defuser {

    private Scanner input;
    private String[] wires_colors;

    public Wires() {
        input = Bomb.input;
    }

    interface defuseAction {
        void defuseWires();
    }

    private defuseAction[] defuseActions = new defuseAction[]{
            () -> threeWires(),
            () -> fourWires(),
            () -> fiveWires(),
            () -> sixWires(),
    };

    @Override
    public void defuse() {
        System.out.println("How many wires?");
        defuseActions[input.nextInt() - 3].defuseWires();
    }


    private void threeWires() {
        getColors(3);
        if (!wiresContains("RED")) {
            System.out.println("cut SECOND wire");
            return;
        }
        if (wires_colors[2].equals("WHITE")) {
            System.out.println("Cut LAST wire");
            return;
        }
        if (wiresNumberOf("BLUE") > 1) {
            System.out.println("cut LAST BLUE wire");
            return;
        }
        System.out.println("cut LAST wire");
    }

    private void fourWires() {
        getColors(4);
        if (wiresNumberOf("RED") > 1 && !Bomb.lastSerialDigitIsEven()) {
            System.out.println("cut LAST RED wire");
            return;
        }
        if (wires_colors[3].equals("YELLOW") && !wiresContains("RED")) {
            System.out.println("cut FIRST wire");
            return;
        }
        if (wiresNumberOf("BLUE") == 1) {
            System.out.println("cut FIRST wire");
            return;
        }
        if (wiresNumberOf("YELLOW") > 1) {
            System.out.println("cut LAST wire");
            return;
        }
        System.out.println("cut SECOND wire");
    }

    private void fiveWires() {
        getColors(5);
        if (wires_colors[4].equals("BLACK") && !Bomb.lastSerialDigitIsEven()) {
            System.out.println("cut FOURTH wire");
            return;
        }
        if (wiresNumberOf("RED") == 1 && wiresNumberOf("YELLOW") > 1) {
            System.out.println("cut FIRST wire");
            return;
        }
        if (!wiresContains("BLACK")) {
            System.out.println("cut SECOND wire");
            return;
        }
        System.out.println("cut FIRST wire");
    }

    private void sixWires() {
        getColors(6);
        if (!wiresContains("YELLOW") && !Bomb.lastSerialDigitIsEven()) {
            System.out.println("cut THIRD wire");
            return;
        }
        if (wiresNumberOf("YELLOW") == 1 && wiresNumberOf("WHITE") > 1) {
            System.out.println("cut FOURTH wire");
            return;
        }
        if (!wiresContains("RED")) {
            System.out.println("cut LAST wire");
            return;
        }
        System.out.println("cut FOURTH wire");
    }

    private void getColors(int num) {
        wires_colors = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter next color:");
            wires_colors[i] = input.next().toUpperCase();
        }
        System.out.println("Calculating..");
    }

    private boolean wiresContains(String value) {
        return wiresNumberOf(value) > 0;
    }

    private int wiresNumberOf(String value) {
        int count = 0;
        for (int i = 0; i < wires_colors.length; i++) {
            if (wires_colors[i].equals(value)) count++;
        }
        return count;
    }


}
