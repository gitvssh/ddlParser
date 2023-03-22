package com.example.ddlparser.parse;

import com.example.ddlparser.domain.ColumnTemplate;
import com.example.ddlparser.domain.TableTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ParserService {

    public TableTemplate parse(String ddl) {
        return new TableTemplate().parse(ddl);
    }

    public String makeDml(TableTemplate tableTemplate, int cnt) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<String>> testData = makeTestData(tableTemplate, cnt);
        while(cnt-- > 0) {
            ArrayList<String> strings = testData.get(cnt);
            sb.append(tableTemplate.makeDml(strings)).append("\n");
        }
        return sb.toString();
    }

    private ArrayList<ArrayList<String>> makeTestData(TableTemplate tableTemplate, int cnt) {
        ColumnTemplate[] columns = tableTemplate.getColumns();
        ArrayList<ArrayList<String>> testData = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            testData.add(new ArrayList<>());
        }
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < columns.length; j++) {
                testData.get(i).add(columns[j].makeTestData());
            }
        }
        return testData;
    }
}
