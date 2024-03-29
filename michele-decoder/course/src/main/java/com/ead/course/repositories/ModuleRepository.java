package com.ead.course.repositories;

import com.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

    /*"altera" o carregamento LAZY para EAGER
    @EntityGraph(attributePaths = {"course"})
    ModuleModel findByTitle(String title);
     */

    //SQL de forma nativa

    //trazer todos os modulos de um determinado curso, passamos um ID de um curso.
    //select = selecione todos os modulos onde o curso_id seja igual o id especifico indicado no metodo
    @Query(value = "select * from tb_modules where course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);
}
