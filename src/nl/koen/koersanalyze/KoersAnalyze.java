package nl.koen.koersanalyze;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KoersAnalyze {

    private static final Integer aantalDagenBinnenHoogLaag = 1095;
    private Date stopDate;

    public static void main(String[] args) {
        KoersAnalyze ka = new KoersAnalyze();
        ka.start();

    }

    private void start() {
        KoersInlezer ki = new KoersInlezer();
        List<KoersDag> kds = ki.leesKoersDagenIn();
        int i = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(kds.get(kds.size() -1).getDatum());
        cal.add(Calendar.DATE, (aantalDagenBinnenHoogLaag * -1));
        stopDate = cal.getTime();
        System.out.println(stopDate);
        while (i < kds.size() && kds.get(i).getDatum().before(stopDate)) {
            Date current = kds.get(i).getDatum();
            Calendar c = Calendar.getInstance();
            c.setTime(current);
            c.add(Calendar.DATE, aantalDagenBinnenHoogLaag);
            Date datumTot = c.getTime();
            Double hoog = hoogOpClose(current, datumTot, kds);
            Double laag = laagOpClose(current, datumTot, kds);
            System.out.println(current + ": " + hoog + " - " + laag + " verschil: " + (hoog - laag));
            kds.get(i).setMinLaagOverPeriode(laag);
            kds.get(i).setMaxHoogOverPeriode(hoog);
            i++;
        }
    }

    private Double hoogOpClose(Date datumVanaf, Date datumTot, List<KoersDag> kds) {
        List<KoersDag> hocList = new ArrayList<>(kds);
        Double hoog = 0.0;
        for (KoersDag kd : hocList) {

            if (kd.getDatum().after(datumVanaf)
                    && kd.getDatum().before(datumTot)
                    && kd.getClose() > hoog) {
                hoog = kd.getClose();
            }
        }
        // System.out.println("datum: " + datumVanaf + " - " + hoog);
        return hoog;
    }

    private Double laagOpClose(Date datumVanaf, Date datumTot, List<KoersDag> kds) {
        List<KoersDag> locList = new ArrayList<>(kds);
        Double laag = 1000000.0;
        for (KoersDag kd : locList) {
            if (kd.getDatum().after(datumVanaf)
                    && kd.getDatum().before(datumTot)
                    && kd.getClose() < laag) {
                laag = kd.getClose();
            }
        }
        // System.out.println("datum: " + datumVanaf + " - " + laag);
        return laag;
    }
}
