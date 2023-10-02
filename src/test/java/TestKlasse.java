import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.main.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet die Raetselsammlung
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class TestKlasse {
    /**
     * Checkt, ob die Überprüfung der URL funktioniert
     */
    @Test
    void checkURLHinzufuegen() {
        Rechtschreibtrainer rst = new Rechtschreibtrainer();
        assertEquals(false, rst.raetselHinzufuegen("test","test"),
                "Checkt, ob es einen Fehler wirft wenn man keinen Link eingibt");
        assertEquals(false, rst.raetselHinzufuegen("Youtube","youtube.com"),
                "Checkt, ob es einen Fehler wirft wenn man keinen image Link eingibt");
        assertEquals(true, rst.raetselHinzufuegen("Stein","https://www.testedich.de/quiz48/picture/pic_1496776200_1.jpg"),
                "Checkt, ob es keinen Fehler wirft, wenn ein wirklicher image Link eingegeben wird");
    }
}
