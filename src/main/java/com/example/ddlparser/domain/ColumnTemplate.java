package com.example.ddlparser.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Getter
@Setter
public class ColumnTemplate {
    private String columnName;
    private String columnType;
    private int ColumnSize;
    private String columnComment;
    private String columnKey;
    private String extra;
    private String columnDefault;
    private String isNullable;

    public ColumnTemplate parse(String s) {
        s = s.trim();
        String[] ColumLine = s.split(" ");
        this.columnName = ColumLine[0];
        Pattern p = Pattern.compile("\\(.*\\)");
        Matcher m = p.matcher(ColumLine[1]);
        if (m.find()) {
            this.ColumnSize = Integer.parseInt(m.group().substring(1, m.group().length() - 1));
        }
        this.columnType = ColumLine[1];
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName).append(" ").append(this.columnType);
        return sb.toString();
    }

    public String makeTestData() {
        Random r = new Random();
        switch (this.columnType) {
            case "int":
                return String.valueOf(r.nextInt(100));
            case "varchar":
                return String.valueOf(r.nextInt(100));
            case "char":
                return String.valueOf(r.nextInt(100));
            case "text":
                return String.valueOf(r.nextInt(100));
            case "date":
                return String.valueOf(r.nextInt(100));
            case "datetime":
                return String.valueOf(r.nextInt(100));
            case "timestamp":
                return String.valueOf(r.nextInt(100));
            case "time":
                return String.valueOf(r.nextInt(100));
            case "year":
                return String.valueOf(r.nextInt(100));
            case "tinyint":
                return String.valueOf(r.nextInt(100));
            case "smallint":
                return String.valueOf(r.nextInt(100));
            case "mediumint":
                return String.valueOf(r.nextInt(100));
            case "bigint":
                return String.valueOf(r.nextInt(100));
            case "float":
                return String.valueOf(r.nextInt(100));
            case "double":
                return String.valueOf(r.nextInt(100));
            case "decimal":
                return String.valueOf(r.nextInt(100));
            case "bit":
                return String.valueOf(r.nextInt(100));
            case "binary":
                return String.valueOf(r.nextInt(100));
            case "varbinary":
                return String.valueOf(r.nextInt(100));
            case "tinyblob":
                return String.valueOf(r.nextInt(100));
            case "blob":
                return String.valueOf(r.nextInt(100));
            case "mediumblob":
                return String.valueOf(r.nextInt(100));
            case "longblob":
                return String.valueOf(r.nextInt(100));
            case "tinytext":
                return String.valueOf(r.nextInt(100));
            case "mediumtext":
                return String.valueOf(r.nextInt(100));
            case "longtext":
                return String.valueOf(r.nextInt(100));
            case "enum":
                return String.valueOf(r.nextInt(100));
            case "set":
                return String.valueOf(r.nextInt(100));
            default:
                return String.valueOf(r.nextInt(100));
        }
    }
}
