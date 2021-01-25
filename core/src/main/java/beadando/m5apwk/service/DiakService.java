package beadando.m5apwk.service;

import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;

import java.util.Collection;
import java.util.Map;

public interface DiakService {
    void addDiak(Diak diak);
    Collection<Diak> getAllDiak();
    Diak getDiakById(String id);
    void updateDiak(Diak diak);
    void removeDiak(Diak diak);
    Collection<Diak> readAllDolgozoOfOsztaly(Osztaly osztaly);
    double atlagSzamitas();
    Map<Osztaly, Double> atlagSzamitasOsztalyonkent();
}
