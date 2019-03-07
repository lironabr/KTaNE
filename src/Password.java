import java.util.*;

public class Password implements Defuser {

    private Set<String> words;
    private Scanner input;

    public Password() {
        input = Bomb.input;
    }

    @Override
    public void defuse() {
        Set<String> filtered = new HashSet<String>();
        initWords();
        int i = 0;
        String input_chars;
        Iterator<String> iter;
        while (words.size() > 1) {
            filtered.clear();
            iter = words.iterator();
            System.out.println("Enter the next series of characters w/o spaces");
            input_chars = input.next().toUpperCase();
            String word;
            while (iter.hasNext()) {
                word = iter.next();
                if (input_chars.contains(Character.toString(word.charAt(i)))) {
                    filtered.add(word);
                }
            }
            i++;
            words = new HashSet<String>(filtered);
        }
        System.out.println(words.iterator().next());

    }

    private void initWords() {
        words = new HashSet<String>(Arrays.asList("ABOUT", "AFTER", "AGAIN", "BELOW", "COULD"
                , "EVERY", "FIRST", "FOUND", "GREAT", "HOUSE"
                , "LARGE", "LEARN", "NEVER", "OTHER", "PLACE"
                , "PLANT", "POINT", "RIGHT", "SMALL", "SOUND"
                , "SPELL", "STILL", "STUDY", "THEIR", "THERE"
                , "THESE", "THING", "THINK", "THREE", "WATER"
                , "WHERE", "WHICH", "WORLD", "WOULD", "WRITE"));
    }
}
