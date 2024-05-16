package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "SUBCATEGORIES")
public class SubCategories {
    @Id
    @Column(name = "SUBCATEGORYID")
    private Integer subCategoryId;
    @Column(name = "SUBCATEGORYNAME")
    private String subCategoryName;
    @Column(name = "SUBCATEGORYDESC")
    private String subCategoryDesc;

    @ManyToOne
    @JoinColumn(name = "CATEGORYID")
    private Categories categories;

}