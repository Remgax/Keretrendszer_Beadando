import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.dao.relational.DiakDAORelational;
import beadando.m5apwk.exceptions.AtlagHataronTul;
import beadando.m5apwk.exceptions.AtlagNegativ;
import beadando.m5apwk.exceptions.NevNemLehetUres;
import beadando.m5apwk.exceptions.RosszSzuletesiDatum;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import beadando.m5apwk.service.DiakService;
import beadando.m5apwk.service.impl.DiakServiceImpl;

import java.time.LocalDate;

public class Proba {
    public static void main(String[] args) throws AtlagNegativ, AtlagHataronTul, NevNemLehetUres, RosszSzuletesiDatum {
        DiakDAO dao = new DiakDAORelational();
        DiakService service = new DiakServiceImpl(dao);

        Diak diak = new Diak();
        diak.setNev("Nagy Imre");
        diak.setAtlag(4);
        diak.setSzuletesiDatum(LocalDate.of(1993,1,1));
        diak.setOsztaly(Osztaly.A);
        service.addDiak(diak);
        System.out.println(service.getAllDiak());
        System.out.println(service.atlagSzamitas());
    }
}
