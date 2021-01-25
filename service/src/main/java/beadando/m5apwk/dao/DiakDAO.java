package beadando.m5apwk.dao;

import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;

import java.util.Collection;

public interface DiakDAO {
    void createDiak(Diak diak);
    Collection<Diak> readAllDiak();
    Diak readDiak();
    void updateDiak(Diak diak);
    void deleteDiak(Diak diak);
    Collection<Diak> readAllDiakOfOsztaly(Osztaly osztaly);
}
