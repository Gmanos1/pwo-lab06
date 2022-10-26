package pwo.app;

/**
 * Klasa zapisujaca wygenerowany ciag do pliku
 * 
 * @version 1.0.0
 * @author gman
 */
import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

class SeqToFileApp {

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;
    
    /**
     * Metoda pobierajaca argumenty wejsciowe
     * i je parsujaca
     * 
     * @param args seqType - typ ciagu {@link SeqType}, from, to - zakres generowania ciagu, fileName - nazwa pliku wyjsciowego
     * @return 
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }
        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda zapisujaca wygenerowany ciag do pliku
     * 
     * @return true jezeli zapis sie powiodl, false jezeli nie
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    /**
    * Metoda poczatkowa, sprawdzajaca 
    * czy argumenty zostaly poprawnie przekazane
    * 
    * @param args argumenty wywolania programu
    */ 
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }
        if (!wirteSeq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }
        System.out.println("Results write to " + fileName);
    }
}
