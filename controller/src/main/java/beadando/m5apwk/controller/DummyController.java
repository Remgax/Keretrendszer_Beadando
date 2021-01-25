package beadando.m5apwk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class DummyController {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
