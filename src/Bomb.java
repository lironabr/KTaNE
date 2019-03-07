
import java.util.Scanner;

public class Bomb {

    public static Scanner input;
    private static String serial;
    private static int batteries;
    private static String lit_indicator;
    private static boolean parallel_port;
    private static Defuser[] modules;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        String modules_string = "0. Exit\n1. Wires\t2. Button\t3. Simon\n4. Who's On First\t" +
                "5. Memory\t6. Complicated Wires\n7. Wire Sequences\t8. Password\t9. Morse\t10. Keypad\n11. Maze";
        int module_chosen;
        System.out.println("Welcome to Bomb Defuser");
        initBomb();
        initModules();

        while (true) {
            System.out.println("Choose Module:\n" + modules_string);
            module_chosen = input.nextInt();
            if (module_chosen == 0) break;
            modules[module_chosen - 1].defuse();
        }

        System.out.println("PHEEEEW That was a close one");
        input.close();

    }

    private static void initBomb() {
        System.out.println("Please enter the following information");
        System.out.println("What is the bomb serial?");
        serial = input.next().toUpperCase();
        System.out.println("How many batteries?");
        batteries = input.nextInt();
        System.out.println("What is the lit indicator?");
        lit_indicator = input.next().toUpperCase();
        System.out.println("Parallel port? (Y/N)");
        parallel_port = input.next().toUpperCase().equals("Y");
    }

    private static void initModules() {
        modules = new Defuser[]{new Wires(), new Button(), new Simon(), new WhosOnFirst()
                , new Memory(), new ComplicatedWires(), new WireSequence(), new Password()
                , new Morse(), new Keypad(), new Maze()};
    }

    public static String getSerial() {
        return serial;
    }

    public static int getBatteries() {
        return batteries;
    }

    public static String getLit_indicator() {
        return lit_indicator;
    }

    public static boolean hasParallelPort() {
        return parallel_port;
    }

    public static boolean lastSerialDigitIsEven() {
        return getLastDigit(serial) % 2 == 0;
    }

    public static int getLastDigit(String serial) {
        for (int i = serial.length() - 1; i >= 0; i--) {
            if (serial.charAt(i) >= '0' && serial.charAt(i) <= '9')
                return Character.getNumericValue(serial.charAt(i));
        }
        return 0;
    }
}
