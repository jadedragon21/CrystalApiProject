package com.tts.CrystalApiProject.controller;

import com.tts.CrystalApiProject.config.CrystalConfig;
import com.tts.CrystalApiProject.model.Crystal;
import com.tts.CrystalApiProject.repo.CrystalRepository;
import com.tts.CrystalApiProject.service.CrystalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = {
//SwaggerConfig.TAG_USER_CONTROLLER,
        CrystalConfig.TAG_V1})
@RequestMapping("/v1")
//same as the tags
//@Api(value = "crystal", description = "Operations pertaining to Crystals" )

public class CrystalController {

//    CrystalService crystalService;
//
//    public CrystalController (CrystalService crystalService) {
//        this.crystalService = crystalService;
//    }
//
//    //Swagger Methods
//    @ApiResponses( value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved crystal"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the crystal"),
//            @ApiResponse(code = 404, message = "Look harder young Jedi, something is wrong in the force!")
//    })
//    @ApiOperation(value = "Get all crystals", response = Crystal.class,
//            responseContainer = "List")
//    @GetMapping("/item/all")
//    public ResponseEntity<List<Crystal>> getAllCrystals() {
//        return new ResponseEntity<>(new ArrayList<Crystal>(), HttpStatus.OK);
//    }


//    // read methods
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Crystal>> getCrystalById(@PathVariable Long id) {
//        return new ResponseEntity<Optional<Crystal>>(crystalService.getCrystal(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public Iterable<Crystal> getAllCrystals() {
//        return crystalService.getAllCrystals();
//    }

    @Autowired
    CrystalRepository crystalRepository;

    @GetMapping("/crystals")
    @ApiOperation(value = "Get the list of all crystals, optionally filtered by color", response = Crystal.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found list of crystals"),
            @ApiResponse(code = 404, message = "Not Found - No crystals found")
    })
    //this one is wonky need to ask the ta's about how to single out the color of the crystals!
    public ResponseEntity<List<Crystal>> getCrystals(@RequestParam(value = "color", required = false) String color) {
        List<Crystal> foundCrystals;
        if (color != null) {
            foundCrystals = crystalRepository.findByColor(color);
            if(!foundCrystals.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(foundCrystals, HttpStatus.OK);
        }
        foundCrystals = (List<Crystal>) crystalRepository.findAll();
        if(foundCrystals.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCrystals, HttpStatus.OK);
    }

    @GetMapping("/crystals/{id}")
    @ApiOperation(value = "Get one particular crystal by specifying an Id", response = Crystal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Found Crystal with specified Id"),
            @ApiResponse(code = 404, message = "Not Found - No Crystal found with the specified Id")
    })
    public ResponseEntity<Crystal> getCrystalById(@PathVariable(value = "id") Long id) {
        Optional<Crystal> foundCrystal = crystalRepository.findById(id);
        if (foundCrystal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCrystal.get(), HttpStatus.OK);
    }

    @PostMapping("/crystals")
    @ApiOperation(value = "Create a new crystal, pending validation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created - Successfully created the new crystal"),
            @ApiResponse(code = 400, message = "Bad Request - Supplied Crystal object did not pass validation")
    })
    public ResponseEntity<Void> createCrystal(@RequestBody @Valid Crystal crystal, BindingResult bindingResult) {
        if (crystalRepository.findById(crystal.getId()).isPresent()) {
            bindingResult.rejectValue("crystalId", "error.crystalId", "Crystal Id is already taken");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        crystalRepository.save(crystal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/crystals/{id}")
    @ApiOperation(value = "Update a crystal with a supplied object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Successfully updated the crystal"),
            @ApiResponse(code = 400, message = "Bad Request - Supplied Crystal object did not pass validation"),
            @ApiResponse(code = 404, message = "Not Found - Could not find a crystal with the specified Id")
    })
    public ResponseEntity<Void> updateCrystal(@PathVariable(value = "id") Long id, @RequestBody Crystal crystal, BindingResult bindingResult) {
        if (!crystalRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        crystalRepository.save(crystal);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/crystals/{id}")
    @ApiOperation(value = "Delete a crystal based on Id number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Successfully deleted the crystal"),
            @ApiResponse(code = 404, message = "Not Found - Could not find a crystal with the specified Id")
    })
    public ResponseEntity<Void> deleteCrystal(@PathVariable(value = "id") Long id) {
        Optional<Crystal> findCrystal = crystalRepository.findById(id);

        if (findCrystal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        crystalRepository.deleteById(findCrystal.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

