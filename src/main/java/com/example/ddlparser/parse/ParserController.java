package com.example.ddlparser.parse;

import com.example.ddlparser.domain.TableTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @PostMapping("/parse")
    public String parse(@ModelAttribute("form") DDLForm form, Model model) {
        System.out.println(form.getDdl());
        model.addAttribute("table", parserService.parse(form.getDdl()));
        return "home";
    }

    @PostMapping("/makeDml")
    public String makeDml(@ModelAttribute("form") DDLForm form, Model model) {
        TableTemplate parsedTable = parserService.parse(form.getDdl());
        return "home";
    }
}
