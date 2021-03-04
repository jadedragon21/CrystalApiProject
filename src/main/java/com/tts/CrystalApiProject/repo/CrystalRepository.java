package com.tts.CrystalApiProject.repo;

import com.tts.CrystalApiProject.model.Crystal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrystalRepository extends CrudRepository<Crystal, Long> {
    public List<Crystal> findByColor(String color);
}

