package pwo.app;

/**
 * Klasa poczatkowa, od ktorej zaczyna sie wykonywac program, w zaleznosci
 * od trybu dzialania wynik jest zapisywany do pliku lub wypisywany na stdout.
 * 
 * @version 1.0.0
 * @author gman
 */
public class Sequence {

    
    public static void main(String[] args) {

        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}
