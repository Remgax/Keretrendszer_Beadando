package beadando.m5apwk.controller;

import beadando.m5apwk.exceptions.DiakLetezik;
import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import beadando.m5apwk.service.DiakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.DigestInputStream;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class DiakController {

    @Autowired
    @Qualifier("DiakService")
    DiakService service;


    @ModelAttribute(value = "diak")
    public Diak createDiak(){
        return new Diak();
    }

    @GetMapping(value = "/diakok")
    public String getDiakok(Model model){
        model.addAttribute("diakok", service.getAllDiak());
        return "diakokList";
    }

    @GetMapping("/diak/{id}")
    public String getDiakById(@PathVariable String id, Model model) throws DiakNemTalalhato {
        model.addAttribute("diak", service.getDiakById(id));
        return "diakDetails";
    }

    @GetMapping(value = "addDiak")
    public String addDiakFrom(Model model){
        model.addAttribute("osztalyok", Osztaly.values());
        return "diakForm";
    }

    @PostMapping(value = "addDiak")
    public String addDiak(@ModelAttribute("diak") Diak diak,Model model) throws DiakLetezik{
        System.out.println(diak);
        service.addDiak(diak);
        return "redirect:/diak/"+diak.getId();
    }
    /*@PostMapping(value = "/update")
    public String update(@ModelAttribute("newDiak"),Diak diak) throws DiakLetezik{
        try{
            service.updateDiak(diak);
        }
        catch (DiakNemTalalhato diakNemTalalhato){
            diakNemTalalhato.printStackTrace();
        }
        return "redirect:diak/" + diak.getId();
    }*/
    @PostMapping(value = "/diakId")
    public ModelAndView searchById(String id) throws DiakNemTalalhato{
        Diak result = service.getDiakById(id);
        Collection<Diak> resultList = new ArrayList<Diak>();
        resultList.add(result);

        ModelAndView mav = new ModelAndView("diakList");
        mav.addObject("diak",resultList);
        return mav;
    }

}
