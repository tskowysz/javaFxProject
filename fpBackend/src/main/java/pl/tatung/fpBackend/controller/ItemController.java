package pl.tatung.fpBackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tatung.fpBackend.entity.Item;
import pl.tatung.fpBackend.repository.ItemRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping("/item")
    public Item newEmployee(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }

    @GetMapping("/item")
    public List<Item> listEmployees() {
        return itemRepository.findAll();
    }
    @DeleteMapping("/item")
    public ResponseEntity deleteItem(@RequestBody Long idItem){
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }


}
