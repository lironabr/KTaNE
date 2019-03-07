import java.util.*;

public class Keypad implements Defuser {

    private Scanner input;
    private String[] row_a_arr;
    private String[] row_b_arr;
    private String[] row_c_arr;
    private String[] row_d_arr;
    private String[] row_e_arr;
    private String[] row_f_arr;

    private final String BALLOON = "BALLOON";
    private final String A = "A";
    private final String L = "L";
    private final String LIGHTNING = "LIGHTNING";
    private final String ALIEN = "ALIEN";
    private final String H = "H";
    private final String CAF = "CAF";
    private final String E = "E";
    private final String AT = "@";
    private final String STAR = "STAR";
    private final String FULL = "FULL";
    private final String QM = "?";
    private final String COPY = "COPY";
    private final String W = "W";
    private final String K = "K";
    private final String DALED = "DALED";
    private final String SIX = "6";
    private final String Q = "Q";
    private final String B = "B";
    private final String SMILEY = "SMILEY";
    private final String PSI = "PSI";
    private final String C = "C";
    private final String THREE = "3";
    private final String WEIGHT = "WEIGHT";
    private final String AE = "AE";
    private final String N = "N";
    private final String OMEGA = "OMEGA";


    public Keypad() {
        input = Bomb.input;
    }

    @Override
    public void defuse() {
        String[] input_symbols_arr = new String[4];

        initRows();
        String[][] rows = new String[][]{row_a_arr, row_b_arr, row_c_arr, row_d_arr, row_e_arr, row_f_arr};

        System.out.println("Enter 4 symbols");
        for (int i = 0; i < 4; i++) {
            input_symbols_arr[i] = input.next().toUpperCase();
        }
        boolean found = false;
        int arr_index = -1;
        for (int i = 0; i < rows.length && !found; i++) {
            if (isSubArr(rows[i], input_symbols_arr)) {
                found = true;
                arr_index = i;
            }
        }
        ArrayList<String> input_symbols_list = new ArrayList<String>(Arrays.asList(input_symbols_arr));
        ArrayList<String> matching_row_list = new ArrayList<String>(Arrays.asList(rows[arr_index]));
        input_symbols_list.sort(new SortByRowIndex(matching_row_list));
        System.out.println(input_symbols_list.toString());
//        for (int i = 0; i < 4; i++) {
//            System.out.println(input_symbols_list.get(i));
//        }
    }

    private boolean isSubArr(String[] row, String[] input_symbols_arr) {
        boolean result = true;
        ArrayList<String> row_as_list = new ArrayList<String>(Arrays.asList(row));
        for (int i = 0; i < 4 && result; i++) {
            if (!row_as_list.contains(input_symbols_arr[i])) result = false;
        }
        return result;
    }

    private void initRows() {
        row_a_arr = new String[]{BALLOON, A, L, LIGHTNING, ALIEN, H, CAF};
        row_b_arr = new String[]{E, BALLOON, CAF, AT, STAR, H, QM};
        row_c_arr = new String[]{COPY, W, AT, K, DALED, L, STAR};
        row_d_arr = new String[]{SIX, Q, B, ALIEN, K, QM, SMILEY};
        row_e_arr = new String[]{PSI, SMILEY, B, C, Q, THREE, FULL};
        row_f_arr = new String[]{SIX, E, WEIGHT, AE, PSI, N, OMEGA};
    }

}

class SortByRowIndex implements Comparator<String> {

    private ArrayList<String> order;

    public SortByRowIndex(ArrayList<String> order) {
        this.order = order;
    }

    @Override
    public int compare(String s1, String s2) {
        return order.indexOf(s1) - order.indexOf(s2);
    }
}