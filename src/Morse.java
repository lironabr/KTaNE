import java.util.*;

public class Morse implements Defuser {

    private Scanner input;
    private Map<String, String> morse_to_char;
    private Set<String> words;
    private Map<String, Integer> words_to_freqs;

    public Morse() {
        input = Bomb.input;
    }

    @Override
    public void defuse() {

        initMorseToChar();
        initWords();
        initWordsToFreq();
        Set<String> filtered = new HashSet<String>();
        Iterator<String> iter;
        int i = 0;
        String input_morse;
        String decoded_morse;
        String word;
        while (words.size() > 1) {
            filtered.clear();
            iter = words.iterator();
            System.out.println("Enter the next morse char");
            input_morse = input.next();
            decoded_morse = morse_to_char.get(input_morse);
            while (iter.hasNext()) {
                word = iter.next();
                if (Character.toString(word.charAt(i)).equals(decoded_morse))
                    filtered.add(word);
            }
            i++;
            words = new HashSet<String>(filtered);
        }
        System.out.println(words_to_freqs.get(words.iterator().next()));
    }

    private void initMorseToChar() {
        morse_to_char = new HashMap<String, String>();
        morse_to_char.clear();
        morse_to_char.put(".-", "A");
        morse_to_char.put("-...", "B");
        morse_to_char.put("-.-.", "C");
        morse_to_char.put("-..", "D");
        morse_to_char.put(".", "E");
        morse_to_char.put("..-.", "F");
        morse_to_char.put("--.", "G");
        morse_to_char.put("....", "H");
        morse_to_char.put("..", "I");
        morse_to_char.put(".---", "J");
        morse_to_char.put("-.-", "K");
        morse_to_char.put(".-..", "L");
        morse_to_char.put("--", "M");
        morse_to_char.put("-.", "N");
        morse_to_char.put("---", "O");
        morse_to_char.put(".--.", "P");
        morse_to_char.put("--.-", "Q");
        morse_to_char.put(".-.", "R");
        morse_to_char.put("...", "S");
        morse_to_char.put("-", "T");
        morse_to_char.put("..-", "U");
        morse_to_char.put("...-", "V");
        morse_to_char.put(".--", "W");
        morse_to_char.put("-..-", "X");
        morse_to_char.put("-.--", "Y");
        morse_to_char.put("--..", "Z");
    }

    private void initWords() {
        words = new HashSet<String>(Arrays.asList("SHELL", "HALLS", "SLICK", "TRICK", "BOXES"
                , "LEAKS", "STROBE", "BISTRO", "FLICK", "BOMBS"
                , "BREAK", "BRICK", "STEAK", "STING", "VECTOR"
                , "BEATS"));
    }

    private void initWordsToFreq() {
        words_to_freqs = new HashMap<String, Integer>();
        words_to_freqs.clear();
        words_to_freqs.put("SHELL", 505);
        words_to_freqs.put("HALLS", 515);
        words_to_freqs.put("SLICK", 522);
        words_to_freqs.put("TRICK", 532);
        words_to_freqs.put("BOXES", 535);
        words_to_freqs.put("LEAKS", 542);
        words_to_freqs.put("STROBE", 545);
        words_to_freqs.put("BISTRO", 552);
        words_to_freqs.put("FLICK", 555);
        words_to_freqs.put("BOMBS", 565);
        words_to_freqs.put("BREAK", 572);
        words_to_freqs.put("BRICK", 575);
        words_to_freqs.put("STEAK", 582);
        words_to_freqs.put("STING", 592);
        words_to_freqs.put("VECTOR", 595);
        words_to_freqs.put("BEATS", 600);
    }
}
