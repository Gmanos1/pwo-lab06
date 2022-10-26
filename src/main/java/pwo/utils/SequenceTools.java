package pwo.utils;

/**
* Klasa narzędziowa służąca do obsługi obiektów<br>
* implementujących interfejs {@link SequenceGenerator}
*
* @author gman
* @version 1.0.0
*/
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SequenceTools {

    /**
    * Zamienia wygenerowany ciag na postac tekstowa
    * 
    * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
    * @param from Początkowy wyraz ciągu
    * @param to Końcowy wyraz ciągu
    * @param sep Separator wynikow obliczen w stringu
    * @return Wyrazy ciągu w postaci tekstu
    */
    private static String getTerms(SequenceGenerator sg,
            int from, int to, String sep) {

        int i = from, stop = to;
        boolean isReversed = from > to ? true : false;
        
        if(isReversed) {
            int temp = from;
            from = to;
            to = temp;
            i = from;
            stop = to;
        }
        ArrayList<String> terms = new ArrayList<String>();
        while (true) {
            terms.add(sg.getTerm(i).toString());
            if (i == stop) {
                if(isReversed) {
                    Collections.reverse(terms);
                }
                return String.join("\n", terms);
            }
            i += 1;
        }
    }
    /**
    * Zamienia wyrazy ciągu na tekst.<br>
    * Wyrazy ciągu tworzą kolumnę.
    *
    * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
    * @param from Początkowy wyraz ciągu
    * @param to Końcowy wyraz ciągu
    * @return Wyrazy ciągu w postaci tekstu tworzącego kolumnę
    * @see #getTermsAsLine(pwo.utils.SequenceGenerator, int, int)
    */
    public static String getTermsAsColumn(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    /**
    * Zamiania wyrazy ciągu na tekst.<br>
    * Wyrazy ciągu tworzą wiersz.
    *
    * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
    * @param from Początkowy wyraz ciągu
    * @param to Końcowy wyraz ciągu
    * @return Wyrazy ciągu w postaci tekstu tworzącego wiersz
    * @see #getTermsAsColumn(pwo.utils.SequenceGenerator, int, int)
    */
    public static String getTermsAsLine(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    /**
    * Zapisuje wyrazy ciągu do pliku w postaci kolumny.
    *
    *
    * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
    * @param from Początkowy wyraz ciągu
    * @param to Końcowy wyraz ciągu
    * @param fileName Nazwa pliku
    * @return true jeżeli udało się zapisać plik,
    * false w przeciwnym wypadku
    */
    public static boolean writeToFile(SequenceGenerator sg,
            int from, int to, String fileName) {

        try ( BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
