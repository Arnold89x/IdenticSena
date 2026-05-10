package com.example.identic.repositories;

import com.example.identic.models.FichaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<FichaModel,Long> {
}
