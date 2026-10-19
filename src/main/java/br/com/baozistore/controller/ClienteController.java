package br.com.baozistore.controller;
import br.com.baozistore.model.Cliente;
import br.com.baozistore.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/clientes")
public class ClienteController {
  private final ClienteRepository repo;
  public ClienteController(ClienteRepository repo){this.repo=repo;}
  @PostMapping public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente x){x.setId(null);return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(x));}
  @GetMapping public List<Cliente> listar(){return repo.findAll();}
  @GetMapping("/{id}") public ResponseEntity<Cliente> buscar(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
  @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
