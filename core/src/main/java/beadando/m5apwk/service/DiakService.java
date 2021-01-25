package beadando.m5apwk.service;

import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;

import java.util.Collection;
import java.util.Map;

public interface DiakService {
    void addDiak(Diak diak);
    Collection<Diak> getAllDiak();
    Diak getDiakById(String id) throws DiakNemTalalhato;
    void updateDiak(Diak diak);
    void removeDiak(Diak diak) throws DiakNemTalalhato;
    Collection<Diak> readAllDolgozoOfOsztaly(Osztaly osztaly);
    double atlagSzamitas();
    Map<Osztaly, Double> atlagSzamitasOsztalyonkent();
}
