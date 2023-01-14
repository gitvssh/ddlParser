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
        return null;
    }
}
