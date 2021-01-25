package beadando.m5apwk.controller;

import beadando.m5apwk.exceptions.DiakLetezik;
import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.service.DiakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedHashMap;

@RestController
@RequestMapping(value = "/rest/")
public class RESTDiakController {
    @Autowired
    DiakService diakService;

//    @GetMapping(value = "diakok")
//    public Collection<Diak> getAllDiak(){
//        return diakService.getAllDiak();
//    }
    @GetMapping(value = "diak/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Diak getDiakById(@PathVariable(name = "id") String id) throws DiakNemTalalhato {
        return diakService.getDiakById(id);
    }
    @PostMapping(value = "diakok", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addDiak(@RequestBody Diak diak) throws DiakLetezik {
        System.out.println("Hozzáadandó: "+diak);
        diakService.addDiak(diak);
        return "Új diak került hozzáadásra a következő azonosítóval: "+diak.getId();
    }

    @ExceptionHandler(DiakLetezik.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String usedDiakId(DiakLetezik e){
        return "Diak az adott azonositoval már létezik: "+e.getMessage();
    }


}
