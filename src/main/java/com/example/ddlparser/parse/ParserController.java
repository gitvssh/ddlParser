package com.example.ddlparser.parse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @PostMapping("/parse")
    public String parse(@ModelAttribute("form") DDLForm form, RedirectAttributes rttr) {
        System.out.println(form.getDdl());
        form.setDdl(parserService.parse(form.getDdl()));
        rttr.addFlashAttribute("form", form);
        return "redirect:/";
    }
}
