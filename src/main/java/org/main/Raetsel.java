package org.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Stellt eine Bild-Wort Kombination dar
 * @author Jan Huebner
 * @version 2023-10-01
 */
public class Raetsel {
    private URL url;
    private String wort;

    private BufferedImage image;
    private BufferedImage resizedImage;

    /**
     * Erstellt das Raestel
     * Zwingt das Bild ein ein bestimmtes Format
     * @param wort das Wort
     * @param url die URL
     */
    public Raetsel(String wort, URL url) {
        this.wort = wort;
        this.url = url;

        try {
            this.image = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int generalsize = 200;

        this.resizedImage = new BufferedImage(generalsize, generalsize, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = this.resizedImage.createGraphics();
        graphics2D.drawImage(this.image, 0, 0, generalsize, generalsize, null);
        graphics2D.dispose();
    }

    /**
     * Gibt das Image zurück
     * @return das Image
     */
    public Image getImage() {
        return resizedImage;
    }

    /**
     * Gibt das Wort zurück
     * @return das Wort
     */
    public String getWort() {
        return wort;
    }
}
