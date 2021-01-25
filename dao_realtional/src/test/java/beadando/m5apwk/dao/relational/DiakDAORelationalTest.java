package beadando.m5apwk.dao.relational;

import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.exceptions.AtlagHataronTul;
import beadando.m5apwk.exceptions.AtlagNegativ;
import beadando.m5apwk.exceptions.NevNemLehetUres;
import beadando.m5apwk.exceptions.RosszSzuletesiDatum;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import beadando.m5apwk.model.Tantargyak;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiakDAORelationalTest {
    @Test
    public void test() throws NevNemLehetUres, RosszSzuletesiDatum, AtlagNegativ, AtlagHataronTul {
        DiakDAO dao = new DiakDAORelational();
        Diak diak = new Diak();
        diak.setNev("Kormány Milán");
        diak.setAtlag(5);
        diak.setOsztaly(Osztaly.A);
        diak.setSzuletesiDatum(LocalDate.of(1993,9,28));
        Tantargyak tantar1 = new Tantargyak("Magyar", "5");
        Tantargyak tantar2 = new Tantargyak("Angol", "3");
        List tantargyak = new ArrayList<>();
        tantargyak.add(tantar1);
        tantargyak.add(tantar2);
        diak.setTantargyakList(tantargyak);
        //dao.createDiak(diak);

        //System.out.println(dao.readAllDiak());
        System.out.println(dao.readAllDiakOfOsztaly(Osztaly.A));
    }
}