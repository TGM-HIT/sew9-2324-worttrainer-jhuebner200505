package org.main;

/**
 * Die Mian Methode die alles aufruft
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Main {
    public static void main(String[] args) {
        Statistik st = new Statistik();
        Laden l = new Laden(st);
        Rechtschreibtrainer rst = new Rechtschreibtrainer();
        Speichern sp = new Speichern();
        Oberflaeche o = new Oberflaeche(rst, st, sp);
    }
}