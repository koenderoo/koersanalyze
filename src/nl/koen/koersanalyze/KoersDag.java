package nl.koen.koersanalyze;

import java.util.Date;

public class KoersDag {

    private String isin;
    private String mic;
    private Date datum;
    private Double open;
    private Double hoog;
    private Double laag;
    private Double close;
    private Double numberOfShares;
    private Double numberOfTrades;
    private Double turnover;
    private String valuta;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHoog() {
        return hoog;
    }

    public void setHoog(Double hoog) {
        this.hoog = hoog;
    }

    public Double getLaag() {
        return laag;
    }

    public void setLaag(Double laag) {
        this.laag = laag;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(Double numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }
}
