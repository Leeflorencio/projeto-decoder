package com.ead.course.models;

import com.ead.course.enums.CourseLevel;
import com.ead.course.enums.CourseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_COURSES")
public class CourseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID courseId;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 250)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseStatus courseStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;
    @Column(nullable = false)
    private UUID userInstructor;


    //coleçao de modulos dentro de curso || um curso pode ter varios modulos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //tipo de acesso
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)     //associacao entre modulo e curso
    @Fetch(FetchMode.SUBSELECT) //realiza uma consulta para curso e uma para os modulos vinculados
    private Set<ModuleModel> modules;
}

/*nnnnnnnnn
delete em cascata JPA
    cascade = CascadeType.ALL, orphanRemoval = true
    quando um dos cursos for deletado, o JPA vai deletar todos os modulos vinculados a ele.
 */

 /*
 delete em cascata delegado ao BANCO DE DADOS
    @OnDelete(action = OnDeleteAction.CASCADE)
    quando um dos cursos for deletado, o JPA vai deletar todos os modulos vinculados a ele.
  */