package com.example.ddlparser.parse;

import com.example.ddlparser.domain.TableTemplate;
import com.example.ddlparser.domain.TestTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @Autowired
    TestTableRepository testTableRepository;

    @PostMapping("/parse")
    public String parse(@ModelAttribute("form") DDLForm form, Model model) {
        TableTemplate table = parserService.parse(form.getDdl());
        model.addAttribute("table", table);
        System.out.println("table = " + table);

        testTableRepository.findAll();
        return "home";
    }

    @PostMapping("/makeDml")
    public String makeDml(@ModelAttribute("form") DDLForm form, @ModelAttribute("size") int size, Model model) {
        TableTemplate parsedTable = parserService.parse(form.getDdl());
        model.addAttribute("table", parsedTable);
        String dml = parserService.makeDml(parsedTable, size);
        model.addAttribute("dml", dml);
        return "dml";
    }
}
