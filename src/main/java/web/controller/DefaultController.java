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
    @GetMapping("/config")
    public String Config() {
        return "config";
    }
    @GetMapping("/report/new_join")
    public String newJoin() {
    	return "report";
    }
    @GetMapping("/report/paid")
    public String paid() {
    	return "report1";
    }
    @GetMapping("/report/revenue")
    public String revenue() {
    	return "report2";
    }
    @GetMapping("/error")
    public String getError() {
    	return "error";
    }
}
