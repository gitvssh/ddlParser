package com.example.ddlparser.domain;

import jakarta.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
}
