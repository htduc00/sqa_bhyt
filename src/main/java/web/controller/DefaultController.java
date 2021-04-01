package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/nav")
    public String nav() {
        return "nav";
    }
    @GetMapping("/list")
    public String List() {
        return "list";
    }
}
