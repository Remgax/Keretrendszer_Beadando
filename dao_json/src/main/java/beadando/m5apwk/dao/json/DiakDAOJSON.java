package beadando.m5apwk.dao.json;

import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.exceptions.DiakLetezik;
import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DiakDAOJSON implements DiakDAO {

    File jsonFile;
    ObjectMapper mapper;

    public DiakDAOJSON(String jsonFilePath) throws IOException {
        jsonFile = new File(jsonFilePath);
        if (!jsonFile.exists()){
            jsonFile.createNewFile();
            FileWriter fw = new FileWriter(jsonFile);
            fw.write("[]");
            fw.flush();
            fw.close();
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void createDiak(Diak diak) throws DiakLetezik {
        Collection<Diak> diakok = readAllDiak();
        Diak result = null;
        try{
            result = readDiak(diak.getId());
        }catch (DiakNemTalalhato diakNotFound)
        {
            try{
                mapper.writeValue(jsonFile,diakok);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(result != null) {throw  new DiakLetezik(diak.getId());}
    }

    @Override
    public Collection<Diak> readAllDiak() {
        Object diakok = new ArrayList<Diak>();
        TypeReference tipus = new TypeReference<ArrayList<Diak>>() {};
        try {
            diakok = mapper.readValue(jsonFile,tipus);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Collection<Diak>) diakok;
    }

    @Override
    public Diak readDiak(String id) throws DiakNemTalalhato {
        Collection<Diak> diakok = readAllDiak();
        for(Diak d: diakok){
            if(d.getId().equalsIgnoreCase(id)){
                return d;
            }
        }
        throw  new DiakNemTalalhato(id);
    }

    @Override
    public void updateDiak(Diak diak) {
        try{
            Diak diakResult = readDiak(diak.getId());
            diakResult = diak;
        }catch (DiakNemTalalhato diakNemTalalhato) {
            diakNemTalalhato.printStackTrace();
        }
    }

    @Override
    public void deleteDiak(Diak diak) {
       Collection<Diak> diakok = readAllDiak();
       diakok.remove(diak);
    }

    @Override
    public Collection<Diak> readAllDiakOfOsztaly(Osztaly osztaly) {
        return null;
    }
}
