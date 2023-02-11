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
        String method = st.nextToken();
        String table = st.nextToken();
        if (!method.equalsIgnoreCase("CREATE") || !table.equalsIgnoreCase("TABLE")) {
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
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tableName == null) {
            return "";
        }
        sb.append("CREATE TABLE ").append(this.tableName).append(" (");
        for (int i = 0; i < this.columns.length; i++) {
            sb.append(this.columns[i].toString());
            if (i != this.columns.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String makeDml() {
        StringBuilder sb = new StringBuilder();
        makeDmlSingleLine(sb);
        return sb.toString();
    }

    private void makeDmlSingleLine(StringBuilder sb) {
        sb.append("INSERT INTO ").append(this.tableName).append(" (");
        for (int i = 0; i < this.columns.length; i++) {
            sb.append(this.columns[i].getColumnName());
            if (i != this.columns.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(") VALUES (");
        for (int i = 0; i < this.columns.length; i++) {
            sb.append("?");
            if (i != this.columns.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(");");
    }
}
