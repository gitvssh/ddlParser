package com.example.ddlparser.domain;

public enum ColumnType {
    VARCHAR("VARCHAR"),
    VARCHAR2("VARCHAR2"),
    CHAR("CHAR"),
    TEXT("TEXT"),
    INT("INT"),
    BIGINT("BIGINT"),
    TINYINT("TINYINT"),
    SMALLINT("SMALLINT"),
    MEDIUMINT("MEDIUMINT"),
    FLOAT("FLOAT"),
    DOUBLE("DOUBLE"),
    DECIMAL("DECIMAL"),
    NUMBER("NUMBER"),
    DATE("DATE"),
    TIME("TIME"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),
    YEAR("YEAR"),
    BIT("BIT"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY"),
    TINYBLOB("TINYBLOB"),
    BLOB("BLOB"),
    MEDIUMBLOB("MEDIUMBLOB"),
    LONGBLOB("LONGBLOB"),
    TINYTEXT("TINYTEXT"),
    MEDIUMTEXT("MEDIUMTEXT"),
    LONGTEXT("LONGTEXT"),
    ENUM("ENUM"),
    SET("SET"),
    GEOMETRY("GEOMETRY"),
    POINT("POINT"),
    LINESTRING("LINESTRING"),
    POLYGON("POLYGON"),
    MULTIPOINT("MULTIPOINT"),
    MULTILINESTRING("MULTILINESTRING"),
    MULTIPOLYGON("MULTIPOLYGON"),
    GEOMETRYCOLLECTION("GEOMETRYCOLLECTION"),
    JSON("JSON");

    private String type;

    ColumnType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
