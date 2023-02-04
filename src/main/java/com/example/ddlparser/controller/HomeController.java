package com.example.ddlparser.controller;

import com.example.ddlparser.domain.TableTemplate;
import com.example.ddlparser.parse.DDLForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        log.info("home controller");
        model.addAttribute("form", new DDLForm());
        model.addAttribute("table", new TableTemplate());
        return "home";
    }
}
