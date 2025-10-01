package cat.itacademy.s04.t02.n02.s04t02n02.controller;

import cat.itacademy.s04.t02.n02.s04t02n02.dto.FruitRequest;
import cat.itacademy.s04.t02.n02.s04t02n02.dto.FruitResponse;
import cat.itacademy.s04.t02.n02.s04t02n02.service.FruitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fruta")
public class FruitController {
    private final FruitService service;
    public FruitController(FruitService service) { this.service = service; }

    @PostMapping("/add")
    public ResponseEntity<FruitResponse> add(@Valid @RequestBody FruitRequest request) {
        FruitResponse created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/<built-in function id>").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FruitResponse>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/getOne/<built-in function id>")
    public ResponseEntity<FruitResponse> getOne(@PathVariable Long id) { return ResponseEntity.ok(service.getById(id)); }

    @PutMapping("/update/<built-in function id>")
    public ResponseEntity<FruitResponse> update(@PathVariable Long id, @Valid @RequestBody FruitRequest request) { 
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/delete/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
