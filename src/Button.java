import java.util.Scanner;

public class Button implements Defuser {
    private Scanner input;
    private String color;
    private String text;

    public Button() {
        input = Bomb.input;
    }

    @Override
    public void defuse() {
        initButton();
        if (color.equals("BLUE") && text.equals("ABORT")) {
            holdButton();
            return;
        }
        if (Bomb.getBatteries() > 1 && text.equals("DETONATE")) {
            pressAndRelease();
            return;
        }
        if (color.equals("WHITE") && Bomb.getLit_indicator().equals("CAR")) {
            holdButton();
            return;
        }
        if (Bomb.getBatteries() > 2 && Bomb.getLit_indicator().equals("FRK")) {
            pressAndRelease();
            return;
        }
        if (color.equals("YELLOW")) {
            holdButton();
            return;
        }
        if (color.equals("RED") && text.equals("HOLD")) {
            pressAndRelease();
            return;
        }
        holdButton();
    }

    private void holdButton() {
        System.out.println("HOLD the button");
        System.out.println("Blue strip: release when the countdown timer has a 4 in any position.\n" +
                "White strip: release when the countdown timer has a 1 in any position.\n" +
                "Yellow strip: release when the countdown timer has a 5 in any position.\n" +
                "Any other color strip: release when the countdown timer has a 1 in any position.");
    }

    private void pressAndRelease() {
        System.out.println("Press and immediately release the button");
    }

    private void initButton() {
        System.out.println("What is the button color?");
        color = input.next().toUpperCase();
        System.out.println("What is the text?");
        text = input.next().toUpperCase();
    }
}
