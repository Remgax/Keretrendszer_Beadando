package beadando.m5apwk.model;

import beadando.m5apwk.exceptions.AtlagHataronTul;
import beadando.m5apwk.exceptions.AtlagNegativ;
import beadando.m5apwk.exceptions.RosszSzuletesiDatum;
import beadando.m5apwk.exceptions.NevNemLehetUres;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.DateTimeDateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;



public class Diak {
    private String nev;
    private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate szuletesiDatum;
    private Osztaly osztaly;
    private double atlag;
    public List<Tantargyak> tantargyakList;
    Logger logger = Logger.getLogger(this.getClass());

    public Diak() {
        this.id = UUID.randomUUID().toString();
        logger.info("Új dika lett létrehozva a "+ this.id + " azonosítóval.");
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws NevNemLehetUres {
        if (nev.trim().length() == 0){
            throw new NevNemLehetUres();
        }

        this.nev = nev;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum( @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate szuletesiDatum) throws RosszSzuletesiDatum {
        if(szuletesiDatum.isAfter(LocalDate.now().minusYears(6))){
            throw new RosszSzuletesiDatum("6 évnél fiatalabb nem mehet iskolába:" + szuletesiDatum);
        }
        if (szuletesiDatum.isBefore(LocalDate.now().minusYears(100))){
            throw new RosszSzuletesiDatum("100 évnél idősebb:" + szuletesiDatum);
        }

        this.szuletesiDatum = szuletesiDatum;
    }

    public Osztaly getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(Osztaly osztaly) {
        this.osztaly = osztaly;
    }

    public double getAtlag() {
        return atlag;
    }

    public void setAtlag(double atlag) throws AtlagNegativ, AtlagHataronTul {
        if (atlag < 0) {
            throw new AtlagNegativ(atlag);
        }
        if (atlag > 5) {
            throw new AtlagHataronTul(atlag);
        }
        this.atlag = atlag;
    }

    public List<Tantargyak> getTantargyakList() {
        return tantargyakList;
    }

    public void setTantargyakList(List<Tantargyak> tantargyakList) {
        this.tantargyakList = tantargyakList;
    }

    @Override
    public String toString() {
        return "Diak{" +
                "nev='" + nev + '\'' +
                ", id='" + id + '\'' +
                ", szuletesiDatum=" + szuletesiDatum +
                ", osztaly=" + osztaly +
                ", atlag=" + atlag +
                ", tantargyakList=" + tantargyakList +
                '}';
    }
}