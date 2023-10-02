package org.main;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.*;

/**
 * Diese Klasse ist für das Laden von Daten in einem JSON-File da
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Laden {
    private Statistik st;
    private String pfad;
    public Laden(Statistik st) {
        this.st = st;
        this.pfad = "C:\\Users\\janhu\\Documents\\TGM 9 Semester\\SEW" +
                "\\[GK] 9a.1 Worttrainer Reloaded\\Worttainer 5 Semester\\Worttrainer_Reloaded\\src\\main\\Speichern\\speichern.json";
        if(!datenLaden()) {
            JOptionPane.showMessageDialog(null, "Daten konnte nicht richtig geladen werden! Die Statistk wird zurueckgesetzt!");
            st.setInsgesamt(0);
            st.setRichtig(0);
            st.setFalsch(0);
        }
    }

    /**
     * Ladet die Daten aus dem JSON-File
     * @return ob es erfolgreich war
     */
    public boolean datenLaden() {
        InputStream is = null;
        try {
            is = new FileInputStream(pfad);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JsonElement obj;
        try {
           obj = new JsonParser().parse(new FileReader(pfad));
        } catch (FileNotFoundException e) {
            return false;
        }


        JsonObject jo = obj.getAsJsonObject(); //https://howtodoinjava.com/gson/gson-jsonparser/

        int insgesamtGespeichert = Integer.parseInt(String.valueOf(jo.get("insgesamt")));
        int richtigGespeichert = Integer.parseInt(String.valueOf(jo.get("richtig")));
        int falschGespeichert = Integer.parseInt(String.valueOf(jo.get("falsch")));

        st.setInsgesamt(insgesamtGespeichert);
        st.setRichtig(richtigGespeichert);
        st.setFalsch(falschGespeichert);

        return true;
    }
}
