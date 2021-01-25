package beadando.m5apwk.service.impl;

import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.exceptions.DiakLetezik;
import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import beadando.m5apwk.service.DiakService;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;

public class DiakServiceImpl implements DiakService {
    Logger logger = Logger.getLogger(this.getClass());
    private DiakDAO dao;

    public DiakServiceImpl(DiakDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addDiak(Diak diak) {
        try {
            dao.createDiak(diak);
        } catch (DiakLetezik diakLetezik) {
            diakLetezik.printStackTrace();
        }
    }

    @Override
    public Collection<Diak> getAllDiak() {
        Collection<Diak> result = dao.readAllDiak();
        logger.info("Az adatbázisban "+ result.size()+ " diák van felvéve.");
        return result;
    }

    @Override
    public Diak getDiakById(String id) throws DiakNemTalalhato {
        return dao.readDiak(id);
    }

    @Override
    public void updateDiak(Diak diak) {
        dao.updateDiak(diak);
    }

    @Override
    public void removeDiak(Diak diak) throws DiakNemTalalhato {
        dao.readDiak(diak.getId());
    }

    @Override
    public Collection<Diak> readAllDolgozoOfOsztaly(Osztaly osztaly) {
        return null;
    }

    @Override
    public double atlagSzamitas() {
        Collection<Diak> diakok = getAllDiak();
        return diakok.stream().mapToDouble(d -> d.getAtlag()).average().getAsDouble();
    }

    @Override
    public Map<Osztaly, Double> atlagSzamitasOsztalyonkent() {
        return null;
    }
}
