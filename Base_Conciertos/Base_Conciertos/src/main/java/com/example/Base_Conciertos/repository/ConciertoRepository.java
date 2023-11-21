package com.example.Base_Conciertos.repository;

import com.example.Base_Conciertos.entity.Concierto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConciertoRepository extends JpaRepository<Concierto, Integer> {
}
