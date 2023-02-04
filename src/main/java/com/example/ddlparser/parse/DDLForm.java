package com.example.ddlparser.parse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DDLForm {
    private String ddl;

    @Override
    public String toString() {
        return "DDLForm{" +
                "ddl='" + ddl + '\'' +
                '}';
    }
}
