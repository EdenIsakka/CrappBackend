package com.example.crappBackend.Controller;

import com.example.crappBackend.model.Collector;
import com.example.crappBackend.repository.CollectrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collector")
public class CollectorController {
    @Autowired
    private CollectrorRepository collectrorRepository;

    @GetMapping
    private List<Collector> getAllCollector(){
        return collectrorRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity <Optional<Collector>> getCollectorById(@PathVariable Long id){
        Optional<Collector> collector = collectrorRepository.findById(id);
        //Posible exepcion
        return ResponseEntity.ok(collector);
    }

    @PostMapping
    public Collector createCollector(@RequestBody Collector collector){
        return collectrorRepository.save(collector);
    }

    @DeleteMapping("{id}")
    public void deleteCollector(@PathVariable Long id){
        collectrorRepository.deleteById(id);
    }
}
