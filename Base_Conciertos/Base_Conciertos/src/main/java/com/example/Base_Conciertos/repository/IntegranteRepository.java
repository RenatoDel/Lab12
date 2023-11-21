package com.example.Base_Conciertos.repository;

import com.example.Base_Conciertos.entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {
}
