package cz.simek.codelib.imageresizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping
    public String initial() {
        return "index";
    }
}
