package pl.tatung.fpBackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tatung.fpBackend.entity.Warehouse;
import pl.tatung.fpBackend.repository.WarehouseRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseRepository warehouseTypeRepository;

    @PostMapping("/warehouses")
    public Warehouse newWarehouse(@RequestBody Warehouse newWarehouse) {
        return warehouseTypeRepository.save(newWarehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> listWarehouses() {
        return warehouseTypeRepository.findAll();
    }
    @DeleteMapping("/warehouses")
    public ResponseEntity deleteWarehouse(@RequestBody Long idWarehouse){
        warehouseTypeRepository.deleteById(idWarehouse);
        return ResponseEntity.ok().build();
    }
}
