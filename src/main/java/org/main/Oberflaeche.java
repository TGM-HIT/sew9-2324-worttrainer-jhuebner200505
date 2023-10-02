package org.main;

import javax.swing.*;

/**
 * Diese Klasse generiert die "Oberfläche" mit JOptionPane
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Oberflaeche {
    private Rechtschreibtrainer rst;
    private Statistik st;
    private Speichern sp;
    public Oberflaeche(Rechtschreibtrainer rst, Statistik st,Speichern sp) {
        this.rst = rst;
        this.st = st;
        this.sp = sp;
        JOptionPane.showMessageDialog(null, "HALLO! Willkommen zu deinem Worttrainer. Klicke auf OK um zu beginnen");
        if(!spielen()) {
            JOptionPane.showMessageDialog(null, "Die Anwendung wurde aufgrund eines Fehlers unerwartet beednet.");
        }
    }

    /**
     * Stellt den Ablauf einer Runde da
     * @return Gibt zurück ob der Rundenverlauf erfolgreich wars
     */
    public boolean spielen() {
        while(true) {
            String message = JOptionPane.showInputDialog(null, "Derzeit sind "+ rst.getRaetselSammlung().size() + " Wort/Woerter in der Datenbank! " +
                    "\n schreibe den Index des Wortes, das du haben willst, " +
                    "oder 'z', um ein zufaelliges zu waehlen" +
                    "\n oder 'zurueck', damit dein Spielstand zurueckgesetzt wird und das Programm beendet wird" +
                    "\n Schreibe ENDE um zu beeden, dein Fortschritt wird gespeichert!");

            if(message == null) {
                JOptionPane.showMessageDialog(null, "Das Programm wird abgebrochen, dein Fortschritt wurde nicht gespeichert!");
                return true;
            }

            if(message.equals("zurueck")) {
                sp.setInsgesamtSpeichern(0);
                sp.setRichtigSpeichern(0);
                sp.setFalschSpeichern(0);
                if(sp.abspeichern()) {
                    JOptionPane.showMessageDialog(null, "Das Programm wird beendet und dein Fortschritt wurde zurueckgesetzt");
                } else {
                    JOptionPane.showMessageDialog(null, "Das Programm wird beendet, aber ein Fehler ist aufgetreten " +
                            "und dein Fortschritt wurde nicht zurueckgesetzt");
                }
                return true;
            }

            if(message.equals("ENDE")) {
                sp.setInsgesamtSpeichern(st.getInsgesamt());
                sp.setRichtigSpeichern(st.getRichtig());
                sp.setFalschSpeichern(st.getFalsch());
                if(sp.abspeichern()) {
                    JOptionPane.showMessageDialog(null, "Das Programm wird beendet und dein Fortschritt wurde gespeichert!");
                } else {
                    JOptionPane.showMessageDialog(null, "Das Programm wird beendet, aber ein Fehler ist aufgetreten " +
                            "und dein Fortschritt wurde nicht gespeichert!");
                }
                return true;
            }

            int index = 0;
            if(message.equals("z")) {
                index = (int) (Math.random() * ((rst.getRaetselSammlung().size() - 1) + 1)); // https://mixable.blog/java-zufallszahlen-in-einem-bestimmten-bereich-erstellen/
            } else {
                try {
                    index = Integer.parseInt(message);
                } catch(NumberFormatException e) {
                    return false;
                }
            }

            Raetsel r;
            if(index < rst.getRaetselSammlung().size()) {
                r = rst.getRaetselSammlung().get(index);
                level(r);

            } else {
                JOptionPane.showMessageDialog(null, "Dieser Index kann nicht erreicht werden!");
            }
        }
    }

    /**
     * Ladet das einzelne Level
     * @param r Das Raestel zum laden
     */
    public void level(Raetsel r) {
        String antwort = JOptionPane.showInputDialog(null, new ImageIcon(r.getImage()));

        st.setInsgesamt(st.getInsgesamt() + 1);

        if(antwort.equals(r.getWort())) {
            st.setRichtig(st.getRichtig() + 1);
            JOptionPane.showMessageDialog(null, "SUPER! Das war die richtige Antwort!" +
                    "\n Aktuelle Statistik:" +
                    "\n insgesamt: " + st.getInsgesamt() +
                    "\n Richtig: " + st.getRichtig() +
                    "\n Falsch: " + st.getFalsch());
        } else {
            st.setFalsch(st.getFalsch() + 1);
            JOptionPane.showMessageDialog(null, "Leider Falsch! Versuch es erneut!" +
                    "\n Aktuelle Statistik:" +
                    "\n insgesamt: " + st.getInsgesamt() +
                    "\n Richtig: " + st.getRichtig() +
                    "\n Falsch: " + st.getFalsch());
            level(r);
        }
    }
}
