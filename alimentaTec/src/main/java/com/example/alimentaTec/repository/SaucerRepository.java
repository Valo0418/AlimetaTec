package com.example.alimentaTec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Saucer;

@Repository
public interface SaucerRepository extends JpaRepository<Saucer, Integer> {

    // @Query(value = "SELECT * FROM name_saucer WHERE name_saucer LIKE %:nameSaucer%", nativeQuery = true)
    // List<Saucer> buscarPorNombre(@Param("nameSaucer") String nameSaucer);

    @Query("SELECT s FROM Saucer s WHERE s.nameSaucer = :nameSaucer")
    List<Saucer> buscarPorNombre(@Param("nameSaucer") String nameSaucer);
           
}
