package org.main;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse ist zum speichern aller Raetsel da
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Rechtschreibtrainer {

    private ArrayList<Raetsel> raetselSammlung = new ArrayList<Raetsel>();

    public Rechtschreibtrainer() {
        raetselHinzufuegen("Hund", "https://images.unsplash.com/photo-1543466835-00a7907e9de1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2574&q=80");
        raetselHinzufuegen("Katze", "https://images.unsplash.com/photo-1519052537078-e6302a4968d4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2370&q=80");
        raetselHinzufuegen("Maus", "https://www.jr-farm.de/media/image/ee/44/22/Maus_23162751_M_frei_ohne_SchwanzDX94OBE1aiEDz_800x800.jpg");
    }

    /**
     * Fügt ein weiteres Raetsel hinzu.
     * @param wort das Wort für das Raestel
     * @param urlTEXT die URL für das Raetsel
     * @return gibt zurück, ob die eintragung erfolgtreich war
     */
    public boolean raetselHinzufuegen(String wort, String urlTEXT) {

        //checkt, ob es überhaupt eine URL ist
        if(!isURL(urlTEXT)) {
            return false;
        }

        URL url = null;
        try {
            url = new URL(urlTEXT);
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Der eingegebene Text ist KEINE Url!");
            throw new RuntimeException();
        }

        //checkt, ob es eine image URL ist
        try {
            ImageIO.read(url);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Der eingegebene Text ist KEINE Image-Url!");
            throw new RuntimeException();
        }

        Raetsel newReastsel = new Raetsel(wort, url);

        raetselSammlung.add(newReastsel);
        return true;
    }

    /**
     * Checkt, ob der eingegebene String eine URL ist
     * @param url die eingegebene URL
     * @return gibt zurück, ob der check erfolgreich war
     */
    public boolean isURL(String url) {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) { }
        return false;
    }

    /**
     * gibt die Raestelsammlung zurück
     * @return die Raetselsammlung
     */
    public List<Raetsel> getRaetselSammlung() {
        return raetselSammlung;
    }
}
