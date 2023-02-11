package com.example.ddlparser.parse;

import com.example.ddlparser.domain.TableTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @PostMapping("/parse")
    public String parse(@ModelAttribute("form") DDLForm form, Model model) {
        TableTemplate table = parserService.parse(form.getDdl());
        model.addAttribute("table", table);
        System.out.println("table = " + table);
        return "home";
    }

    @PostMapping("/makeDml")
    public String makeDml(@ModelAttribute("form") DDLForm form, Model model) {
        TableTemplate parsedTable = parserService.parse(form.getDdl());
        model.addAttribute("table", parsedTable);
        String dml = parserService.makeDml(parsedTable,1);
        model.addAttribute("dml", dml);
        return "dml";
    }
}
