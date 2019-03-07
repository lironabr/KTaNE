import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WhosOnFirst implements Defuser {

    private Scanner input;
    private Map<String, Integer> words_to_number;
    private Map<String, String> words_to_words;

    public WhosOnFirst() {
        input =Bomb.input;
        initWordsToNumbers();
        initWordsToWords();
    }

    private void initWordsToNumbers() {
        words_to_number = new HashMap<>();
        words_to_number.clear();

        words_to_number.put("YES", 3);
        words_to_number.put("FIRST", 2);
        words_to_number.put("DISPLAY", 6);
        words_to_number.put("OKAY", 2);
        words_to_number.put("SAYS", 6);
        words_to_number.put("NOTHING", 3);
        words_to_number.put("", 5);
        words_to_number.put("BLANK", 4);
        words_to_number.put("NO", 6);
        words_to_number.put("LED", 3);
        words_to_number.put("LEAD", 6);
        words_to_number.put("READ", 4);
        words_to_number.put("RED", 4);
        words_to_number.put("REED", 5);
        words_to_number.put("LEED", 5);
        words_to_number.put("HOLD ON", 6);
        words_to_number.put("YOU", 4);
        words_to_number.put("YOU ARE", 6);
        words_to_number.put("YOUR", 4);
        words_to_number.put("YOU'RE", 4);
        words_to_number.put("UR", 1);
        words_to_number.put("THERE", 6);
        words_to_number.put("THEY'RE", 5);
        words_to_number.put("THEIR", 4);
        words_to_number.put("THEY ARE", 4);
        words_to_number.put("SEE", 6);
        words_to_number.put("C", 2);
        words_to_number.put("CEE", 6);
    }

    private void initWordsToWords() {
        words_to_words = new HashMap<>();
        words_to_words.clear();

        words_to_words.put("READY", "YES, OKAY, WHAT, MIDDLE, LEFT, PRESS, RIGHT, BLANK, READY, NO, FIRST, UHHH, NOTHING, WAIT");
        words_to_words.put("FIRST", "LEFT, OKAY, YES, MIDDLE, NO, RIGHT, NOTHING, UHHH, WAIT, READY, BLANK, WHAT, PRESS, FIRST");
        words_to_words.put("NO", "BLANK, UHHH, WAIT, FIRST, WHAT, READY, RIGHT, YES, NOTHING, LEFT, PRESS, OKAY, NO, MIDDLE");
        words_to_words.put("BLANK", "WAIT, RIGHT, OKAY, MIDDLE, BLANK, PRESS, READY, NOTHING, NO, WHAT, LEFT, UHHH, YES, FIRST");
        words_to_words.put("NOTHING", "UHHH, RIGHT, OKAY, MIDDLE, YES, BLANK, NO, PRESS, LEFT, WHAT, WAIT, FIRST, NOTHING, READY");
        words_to_words.put("YES", "OKAY, RIGHT, UHHH, MIDDLE, FIRST, WHAT, PRESS, READY, NOTHING, YES, LEFT, BLANK, NO, WAIT");
        words_to_words.put("WHAT", "UHHH, WHAT, LEFT, NOTHING, READY, BLANK, MIDDLE, NO, OKAY, FIRST, WAIT, YES, PRESS, RIGHT");
        words_to_words.put("UHHH", "READY, NOTHING, LEFT, WHAT, OKAY, YES, RIGHT, NO, PRESS, BLANK, UHHH, MIDDLE, WAIT, FIRST");
        words_to_words.put("LEFT", "RIGHT, LEFT, FIRST, NO, MIDDLE, YES, BLANK, WHAT, UHHH, WAIT, PRESS, READY, OKAY, NOTHING");
        words_to_words.put("RIGHT", "YES, NOTHING, READY, PRESS, NO, WAIT, WHAT, RIGHT, MIDDLE, LEFT, UHHH, BLANK, OKAY, FIRST");
        words_to_words.put("MIDDLE", "BLANK, READY, OKAY, WHAT, NOTHING, PRESS, NO, WAIT, LEFT, MIDDLE, RIGHT, FIRST, UHHH, YES");
        words_to_words.put("OKAY", "MIDDLE, NO, FIRST, YES, UHHH, NOTHING, WAIT, OKAY, LEFT, READY, BLANK, PRESS, WHAT, RIGHT");
        words_to_words.put("WAIT", "UHHH, NO, BLANK, OKAY, YES, LEFT, FIRST, PRESS, WHAT, WAIT, NOTHING, READY, RIGHT, MIDDLE");
        words_to_words.put("PRESS", "RIGHT, MIDDLE, YES, READY, PRESS, OKAY, NOTHING, UHHH, BLANK, LEFT, FIRST, WHAT, NO, WAIT");
        words_to_words.put("YOU", "SURE, YOU ARE, YOUR, YOU'RE, NEXT, UH HUH, UR, HOLD, WHAT?, YOU, UH UH, LIKE, DONE, U");
        words_to_words.put("YOU ARE", "YOUR, NEXT, LIKE, UH HUH, WHAT?, DONE, UH UH, HOLD, YOU, U, YOU'RE, SURE, UR, YOU ARE");
        words_to_words.put("YOUR", "UH UH, YOU ARE, UH HUH, YOUR, NEXT, UR, SURE, U, YOU'RE, YOU, WHAT?, HOLD, LIKE, DONE");
        words_to_words.put("YOU'RE", "YOU, YOU'RE, UR, NEXT, UH UH, YOU ARE, U, YOUR, WHAT?, UH HUH, SURE, DONE, LIKE, HOLD");
        words_to_words.put("UR", "DONE, U, UR, UH HUH, WHAT?, SURE, YOUR, HOLD, YOU'RE, LIKE, NEXT, UH UH, YOU ARE, YOU");
        words_to_words.put("U", "UH HUH, SURE, NEXT, WHAT?, YOU'RE, UR, UH UH, DONE, U, YOU, LIKE, HOLD, YOU ARE, YOUR");
        words_to_words.put("UH HUH", "UH HUH, YOUR, YOU ARE, YOU, DONE, HOLD, UH UH, NEXT, SURE, LIKE, YOU'RE, UR, U, WHAT?");
        words_to_words.put("UH UH", "UR, U, YOU ARE, YOU'RE, NEXT, UH UH, DONE, YOU, UH HUH, LIKE, YOUR, SURE, HOLD, WHAT?");
        words_to_words.put("WHAT?", "YOU, HOLD, YOU'RE, YOUR, U, DONE, UH UH, LIKE, YOU ARE, UH HUH, UR, NEXT, WHAT?, SURE");
        words_to_words.put("DONE", "SURE, UH HUH, NEXT, WHAT?, YOUR, UR, YOU'RE, HOLD, LIKE, YOU, U, YOU ARE, UH UH, DONE");
        words_to_words.put("NEXT", "WHAT?, UH HUH, UH UH, YOUR, HOLD, SURE, NEXT, LIKE, DONE, YOU ARE, UR, YOU'RE, U, YOU");
        words_to_words.put("HOLD", "YOU ARE, U, DONE, UH UH, YOU, UR, SURE, WHAT?, YOU'RE, NEXT, HOLD, UH HUH, YOUR, LIKE");
        words_to_words.put("SURE", "YOU ARE, DONE, LIKE, YOU'RE, YOU, HOLD, UH HUH, UR, SURE, U, WHAT?, NEXT, YOUR, UH UH");
        words_to_words.put("LIKE", "YOU'RE, NEXT, U, UR, HOLD, DONE, UH UH, WHAT?, UH HUH, YOU, LIKE, SURE, YOU ARE, YOUR");


    }

    @Override
    //Maybe i can ask for the 6 words he has but might take a little longer to spell those.
    public void defuse() {
        while (true) {
            System.out.println("Enter the word on top    0 to Exit");
            String word = input.next().toUpperCase();
            if (word.equals("0")) break;
            System.out.println("Enter the word in the " + words_to_number.get(word) + " position");
            word = input.next().toUpperCase();
            System.out.println(words_to_words.get(word));
        }
    }
}
