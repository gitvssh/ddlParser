package com.example.ddlparser.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ColumnTemplate {
    private String columnName;
    private String columnType;
    private String columnComment;
    private String columnKey;
    private String extra;
    private String columnDefault;
    private String isNullable;

    public ColumnTemplate parse(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        this.columnName = split[0];
        this.columnType = split[1];
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName).append(" ").append(this.columnType);
        return sb.toString();
    }
}
