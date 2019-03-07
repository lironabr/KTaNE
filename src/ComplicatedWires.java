import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ComplicatedWires implements Defuser {

    private Scanner input;

    public ComplicatedWires() {
        input = Bomb.input;
    }

    @Override
    public void defuse() {
        boolean blue;
        boolean light;
        boolean star;
        boolean red;
        while (true) {
            red = blue = light = star = false;
            System.out.println("Enter Info (colors light star / 'nothing'    0 to Exit)");
            String wires = input.nextLine().toUpperCase();
            if (wires.equals("0")) break;
            Set<String> info = new HashSet<String>(Arrays.asList(wires.split(" ")));
            if (info.contains("RED") || info.contains("R")) red = true;
            if (info.contains("BLUE") || info.contains("B")) blue = true;
            if (info.contains("LIGHT") || info.contains("L")) light = true;
            if (info.contains("STAR") || info.contains("S")) star = true;

            if (!(red || blue || light) || (red && star && !blue && !light))
                cut();
            else if ((light && !red && !blue && !star) || (red && blue && light && star) || (blue && star && !red & !light))
                dontCut();
            else if ((blue && !(red || light || star)) || (red && !(blue || light || star)) || (blue && red && !star))
                cutPred(Bomb.lastSerialDigitIsEven());
            else if ((blue && light && !red) || (blue && red && star && !light)) cutPred(Bomb.hasParallelPort());
            else if ((red && light && !blue) || (light && star && !red && !blue)) cutPred(Bomb.getBatteries() >= 2);
            else {
                shouldNotHappen();
            }
        }
    }

    private void shouldNotHappen() {
        System.out.println("cool cool cool cool cool cool");
    }

    private void cut() {
        System.out.println("Cut it");
    }

    private void dontCut() {
        System.out.println("DO NOT cut it");
    }

    private void cutPred(boolean pred) {
        if (pred) cut();
        else dontCut();
    }
}
