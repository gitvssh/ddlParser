package com.example.ddlparser.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class TableTemplate {
    private String tableName;
    private String tableComment;
    private ColumnTemplate[] columns;

    public TableTemplate parse(String ddl) {
        StringTokenizer st = new StringTokenizer(ddl, " ");
        if (!st.nextToken().equalsIgnoreCase("CREATE")) {
            throw new IllegalArgumentException("CREATE TABLE 이 아닙니다.");
        }
        if (!st.nextToken().equalsIgnoreCase("TABLE")) {
            throw new IllegalArgumentException("CREATE TABLE 이 아닙니다.");
        }
        this.tableName = st.nextToken();

        Pattern p = Pattern.compile("\\(.*\\)");
        Matcher m = p.matcher(ddl);

        if (m.find()) {
            String columnString = m.group();
            columnString = columnString.substring(1, columnString.length() - 1);
            String[] columnArray = columnString.split(",");
            this.columns = new ColumnTemplate[columnArray.length];
            for (int i = 0; i < columnArray.length; i++) {
                this.columns[i] = new ColumnTemplate().parse(columnArray[i]);
                this.columns[i] = new ColumnTemplate();
            }
        }
        return this;
    }
}
