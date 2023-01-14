package com.example.ddlparser.parse;

import com.example.ddlparser.domain.TableTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParserService {

    public String parse(String ddl) {
        TableTemplate tableTemplate = new TableTemplate();
        TableTemplate parse = tableTemplate.parse(ddl);;
        return parse.toString() + " parsed by service";
    }
}
