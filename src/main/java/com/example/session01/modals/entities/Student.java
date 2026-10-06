package com.example.session01.modals.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // Constructor không tham số
@AllArgsConstructor // Constructor đầy đủ tham số
@Getter // Sinh ra các hàm getter cho các thuộc tính
@Setter // Sinh ra các hàm setter cho các thuộc tính
public class Student {
    private Long id;
    private String name;
    private Integer age;

    // constructor

    // getter and setter

}
