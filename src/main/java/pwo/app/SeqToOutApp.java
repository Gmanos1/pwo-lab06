package pwo.app;
import pwo.utils.SequenceTools;
/**
 * Klasa wypisujaca wynik wygenerowanego 
 * ciagu na standardowe wyjscie
 * 
 * @version 1.0.0
 * @author gman
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Metoda pobierajaca parametry wywolania
     * 
     * @param args      * @param args seqType - typ ciagu {@link SeqType}, from, to - zakres generowania ciagu
     * @return 
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda wypisujaca wynik na stdout
     * 
     * @return zawsze zwraca true
     */
    @Override
    protected boolean wirteSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Metoda poczatkowa, sprawdzajaca 
     * czy argumenty zostaly poprawnie przekazane
     * 
     * @param args argumenty wywolania programu
     */ 
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }
        wirteSeq();
    }
}
