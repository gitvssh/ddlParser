package com.example.ddlparser.parse;

import com.example.ddlparser.domain.TableTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParserService {

    public TableTemplate parse(String ddl) {
        return new TableTemplate().parse(ddl);
    }
}
