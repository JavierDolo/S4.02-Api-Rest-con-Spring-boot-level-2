package cat.itacademy.s04.t02.n02.s04t02n02.service;

import cat.itacademy.s04.t02.n02.s04t02n02.dto.FruitRequest;
import cat.itacademy.s04.t02.n02.s04t02n02.dto.FruitResponse;
import cat.itacademy.s04.t02.n02.s04t02n02.exception.ResourceNotFoundException;
import cat.itacademy.s04.t02.n02.s04t02n02.model.Fruit;
import cat.itacademy.s04.t02.n02.s04t02n02.repository.FruitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FruitService {
    private final FruitRepository repository;

    public FruitService(FruitRepository repository) { this.repository = repository; }

    public FruitResponse create(FruitRequest request) { 
        Fruit fruit = new Fruit(request.getName(), request.getQuantityKilos());
        Fruit saved = repository.save(fruit);
        return new FruitResponse(saved.getId(), saved.getName(), saved.getQuantityKilos());
    }

    public FruitResponse getById(Long id) { 
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));
        return new FruitResponse(fruit.getId(), fruit.getName(), fruit.getQuantityKilos());
    }

    public List<FruitResponse> getAll() { 
        return repository.findAll().stream()
                .map(f -> new FruitResponse(f.getId(), f.getName(), f.getQuantityKilos()))
                .toList();
    }

    public FruitResponse update(Long id, FruitRequest request) { 
        Fruit existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));
        existing.setName(request.getName());
        existing.setQuantityKilos(request.getQuantityKilos());
        Fruit updated = repository.save(existing);
        return new FruitResponse(updated.getId(), updated.getName(), updated.getQuantityKilos());
    }

    public void delete(Long id) { 
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Fruit not found with id: " + id);
        repository.deleteById(id);
    }
}
