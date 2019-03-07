import javafx.util.Pair;

import java.util.Scanner;

public class Memory implements Defuser {
    private Scanner input;

    private int top;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private Pair<Integer, Integer> stage_one_p;
    private Pair<Integer, Integer> stage_two_p;
    private Pair<Integer, Integer> stage_three_p;
    private Pair<Integer, Integer> stage_four_p;
    private Pair<Integer, Integer> stage_five_p;

    public Memory() {
        input = Bomb.input;
        top = first = second = third = fourth = 0;
        initPairs();
    }

    @Override
    public void defuse() {
        initPairs();
        stageOne();
        System.out.println("Press label " + stage_one_p.getValue());
        stageTwo();
        System.out.println("Press label " + stage_two_p.getValue());
        stageThree();
        System.out.println("Press label " + stage_three_p.getValue());
        stageFour();
        System.out.println("Press label " + stage_four_p.getValue());
        stageFive();
        System.out.println("Press label " + stage_five_p.getValue());

    }

    private void initPairs() {
        //Pair is (Position, Label)
        stage_one_p = new Pair<>(0, 0);
        stage_two_p = new Pair<>(0, 0);
        stage_three_p = new Pair<>(0, 0);
        stage_four_p = new Pair<>(0, 0);
        stage_five_p = new Pair<>(0, 0);
    }

    private void stageOne() {
        getTop();
        getButtons();
        if (top == 1 || top == 2) {
            stage_one_p = new Pair<>(2, second);
            return;
        }
        if (top == 3) {
            stage_one_p = new Pair<>(3, third);
            return;
        }
        if (top == 4) {
            stage_one_p = new Pair<>(4, fourth);
            return;
        }
    }

    private void stageTwo() {
        getTop();
        getButtons();
        if (top == 1) {
            stage_two_p = new Pair<>(positionOfLabel(4), 4);
            return;
        }
        if (top == 2 || top == 4) {
            stage_two_p = new Pair<>(labelAt(stage_one_p.getKey()), 4);
            return;
        }
        if (top == 3) {
            stage_two_p = new Pair<>(1, labelAt(1));
            return;
        }
    }

    private void stageThree() {
        getTop();
        getButtons();
        if (top == 1) {
            stage_three_p = new Pair<>(positionOfLabel(stage_two_p.getValue()), stage_two_p.getValue());
            return;
        }
        if (top == 2) {
            stage_three_p = new Pair<>(positionOfLabel(stage_one_p.getValue()), stage_one_p.getValue());
            return;
        }
        if (top == 3) {
            stage_three_p = new Pair<>(3, third);
            return;
        }
        if (top == 4) {
            stage_three_p = new Pair<>(positionOfLabel(4), 4);
            return;
        }
    }

    private void stageFour() {
        getTop();
        getButtons();
        if (top == 1) {
            stage_four_p = new Pair<>(stage_one_p.getKey(), labelAt(stage_one_p.getKey()));
            return;
        }
        if (top == 2) {
            stage_four_p = new Pair<>(1, first);
            return;
        }
        if (top == 3 || top == 4) {
            stage_four_p = new Pair<>(stage_two_p.getKey(), labelAt(stage_two_p.getKey()));
            return;
        }
    }

    private void stageFive() {
        getTop();
        getButtons();
        if (top == 1) {
            stage_five_p = new Pair<>(positionOfLabel(stage_one_p.getValue()), stage_one_p.getValue());
            return;
        }
        if (top == 2) {
            stage_five_p = new Pair<>(positionOfLabel(stage_two_p.getValue()), stage_two_p.getValue());
            return;
        }
        if (top == 3) {
            stage_five_p = new Pair<>(positionOfLabel(stage_four_p.getValue()), stage_four_p.getValue());
            return;
        }
        if (top == 4) {
            stage_five_p = new Pair<>(positionOfLabel(stage_three_p.getValue()), stage_three_p.getValue());
            return;
        }
    }

    private int positionOfLabel(int label) {
        if (first == label) return 1;
        if (second == label) return 2;
        if (third == label) return 3;
        if (fourth == label) return 4;
        return 0;
    }

    private int labelAt(int position) {
        if (position == 1) return first;
        if (position == 2) return second;
        if (position == 3) return third;
        if (position == 4) return fourth;
        return 0;
    }

    private void getTop() {
        System.out.println("Enter number on top");
        top = input.nextInt();
    }

    private void getButtons() {
        System.out.println("Enter buttons number combined (E.g 1234)");
        int num = input.nextInt();
        fourth = num % 10;
        num /= 10;
        third = num % 10;
        num /= 10;
        second = num % 10;
        first = num / 10;
    }
}
