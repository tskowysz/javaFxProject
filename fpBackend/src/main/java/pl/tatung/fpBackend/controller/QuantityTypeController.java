package pl.tatung.fpBackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tatung.fpBackend.entity.Operator;
import pl.tatung.fpBackend.entity.QuantityType;
import pl.tatung.fpBackend.repository.OperatorRepository;
import pl.tatung.fpBackend.repository.QuantityTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/quantity_types")
    public QuantityType newQuantityTypes(@RequestBody QuantityType quantityType) {
        return quantityTypeRepository.save(quantityType);
    }

    @GetMapping("/quantity_types")
    public List<QuantityType> listQuantityTypes() {
        return quantityTypeRepository.findAll();
    }
    @DeleteMapping("/quantity_types")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType){
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }
}
