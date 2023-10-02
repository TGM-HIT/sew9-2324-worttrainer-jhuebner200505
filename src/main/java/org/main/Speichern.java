package org.main;

import top.jfunc.json.impl.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse ist für das Speichern der Daten in einem JSON-File da
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Speichern {
    private int insgesamtSpeichern = 0;
    private int richtigSpeichern = 0;
    private int falschSpeichern = 0;
    private int levelAusgewähltSpeichern = 0;
    private String pfad;
    public Speichern() {
        this.pfad = "C:\\Users\\janhu\\Documents\\TGM 9 Semester\\SEW" +
                "\\[GK] 9a.1 Worttrainer Reloaded\\Worttainer 5 Semester\\Worttrainer_Reloaded\\src\\main\\Speichern\\speichern.json";
    }

    /**
     * Speichert die aktuellen Daten in einem JSON-File
     * @return ob es erfolgreich war
     */
    public boolean abspeichern() {
        JSONObject json = new JSONObject();
        json.put("insgesamt", insgesamtSpeichern).put("richtig", richtigSpeichern)
                .put("falsch", falschSpeichern).put("level", levelAusgewähltSpeichern);

        System.out.println(json);

        FileWriter writer = null;
        try {
            writer = new FileWriter(pfad);
            writer.write(json.toString());
            writer.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Settet den insgesamten Wert zum Speichern
     * @param insgesamtSpeichern den insgesamten Wert
     */
    public void setInsgesamtSpeichern(int insgesamtSpeichern) {
        this.insgesamtSpeichern = insgesamtSpeichern;
    }

    /**
     * Settet die richtigen Werte zum Speichern
     * @param richtigSpeichern die richtigen Werte
     */
    public void setRichtigSpeichern(int richtigSpeichern) {
        this.richtigSpeichern = richtigSpeichern;
    }

    /**
     * Settet die falschen Werte zum Speichern
     * @param falschSpeichern die falschen Werte
     */
    public void setFalschSpeichern(int falschSpeichern) {
        this.falschSpeichern = falschSpeichern;
    }

}
