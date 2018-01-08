package nl.koen.koersanalyze;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *  Leest koersinformatie in volgens het format dat te downloaden is bij aex.nl
 *  Comma delimited (.csv)
 *  Vertical layout
 *  Decimal separator: "."
 *  Datumformaat: day/month/year
 */

public class KoersInlezer {

    List<KoersDag> koersdagen;
    DateFormat format;

    public KoersInlezer() {
        koersdagen = new ArrayList<KoersDag>();
        format = new SimpleDateFormat("dd/MM/yyyy");
    }

    public List<KoersDag> leesKoersDagenIn(){
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        File[] f = fd.getFiles();
        if (f.length > 0) {
            // alleen de eerste van een selectie wordt bekeken
            String csvFile = f[0].getPath();
            String line = "";
            String csvSplitBy = ",";


            try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))  {
                int rijteller = 0;
                while ((line = br.readLine()) != null) {
                    rijteller++;
                    if(rijteller > 4) {
                        String[] dagKoers = line.replace("\"", "").split(csvSplitBy);
                        KoersDag kd = new KoersDag();
                        kd.setIsin(dagKoers[0]);
                        kd.setMic(dagKoers[1]);
                        kd.setDatum(format.parse(dagKoers[2]));
                        kd.setOpen(Double.parseDouble(dagKoers[3]));
                        kd.setHoog(Double.parseDouble(dagKoers[4]));
                        kd.setLaag(Double.parseDouble(dagKoers[5]));
                        kd.setClose(Double.parseDouble(dagKoers[6]));
                        kd.setNumberOfShares(Double.parseDouble(dagKoers[7]));
                        kd.setNumberOfTrades(Double.parseDouble(dagKoers[8]));
                        kd.setTurnover(Double.parseDouble(dagKoers[9]));
                        kd.setValuta(dagKoers[10]);
                        koersdagen.add(kd);
                    }
                 }

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return koersdagen;
    }

}
