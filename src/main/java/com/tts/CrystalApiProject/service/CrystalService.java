package com.tts.CrystalApiProject.service;

import com.tts.CrystalApiProject.model.Crystal;

import java.util.Optional;

public interface CrystalService {

    Optional<Crystal> getCrystal(Long id);
    Iterable<Crystal> getAllCrystals();
    Optional<Crystal> getGems(Long id);
    Iterable<Crystal> getAllGems();

}
