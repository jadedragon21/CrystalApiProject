//package com.tts.CrystalApiProject;
//
//
//import com.tts.CrystalApiProject.model.Crystal;
//import com.tts.CrystalApiProject.repo.CrystalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import com.tts.CrystalApiProject.service.CrystalService;

//uncomment this out below to run once and then comment the file out entirely
//so it doesn't reseed the database with duplicates from your data.sql file
//TODO implement the gems make sure to uncomment and run again and comment out
//TODO the repo below and add a new Gem Repository at a later date.
////@Component
//public class Runner implements CommandLineRunner {
//
//    @Autowired
//    CrystalRepository crystalRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        crystalRepository.save(new Crystal((long)1, "clear", "clear quartz"));
//        crystalRepository.save(new Crystal((long)2,"clear", "clear quartz"));
//        crystalRepository.save(new Crystal((long)3,"purple", "amethyst"));
//        crystalRepository.save(new Crystal((long)4,"yellow", "citrine"));
//        crystalRepository.save(new Crystal((long)5,"blue", "celestine"));
//        crystalRepository.save(new Crystal((long)6,"yellow", "tourmaline"));
//        crystalRepository.save(new Crystal((long)7,"white", "calcite"));
//        crystalRepository.save(new Crystal((long)8,"multi", "fluorite"));
//        crystalRepository.save(new Crystal((long)9,"purple", "charoite"));
//        crystalRepository.save(new Crystal((long)10,"multi", "agate"));
//        crystalRepository.save(new Crystal((long)11,"blue", "lapis lazuli"));
//        crystalRepository.save(new Crystal((long)12,"iridescent", "aura quartz"));
//        crystalRepository.save(new Crystal((long)13,"white", "selenite"));
//    }
//}