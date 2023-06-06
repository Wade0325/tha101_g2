package tw.idv.petpet.web.clinic.petCases.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.petCases.entity.PetCase;
import tw.idv.petpet.web.clinic.petCases.service.PetCaseService;

@RestController
@RequestMapping("/petcases")
public class PetCaseController {

    @Autowired
    private PetCaseService petCaseService;

    @GetMapping
    @ResponseBody
    public Map<String, List<PetCase>> getAllPetCases() {
        List<PetCase> petCases = petCaseService.getAllPetCases();
        Map<String, List<PetCase>> map = new HashMap<>();
        map.put("data", petCases);
        return map;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetCase> getPetCaseById(@PathVariable Integer id) {
        Optional<PetCase> petCase = petCaseService.getPetCaseById(id);
        return petCase.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PetCase> createPetCase(@RequestBody PetCase petCase) {
        PetCase createdPetCase = petCaseService.createPetCase(petCase);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPetCase);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PetCase> updatePetCase(@PathVariable Integer id, @RequestBody PetCase petCase) {
        Optional<PetCase> updatedPetCase = petCaseService.updatePetCase(id, petCase);
        return updatedPetCase.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePetCase(@PathVariable Integer id) {
        petCaseService.deletePetCase(id);
        return ResponseEntity.noContent().build();
    }
}
