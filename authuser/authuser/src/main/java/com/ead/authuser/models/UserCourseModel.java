package com.ead.authuser.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_users_courses")
public class UserCourseModel implements Serializable {

    private static final long serialVersionUID = 1L; // controle de versionamento feitos pela JVM, fazendo a comparação de cada atributo vinculado com cada classe

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserModel userModel;
    @Column(nullable = false)
    private UUID courseId;

}