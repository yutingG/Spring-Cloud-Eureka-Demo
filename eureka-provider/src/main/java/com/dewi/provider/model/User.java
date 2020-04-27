package com.dewi.provider.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/26 7:55 PM
 */
@Entity
@Table(name = "TB_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;
}
