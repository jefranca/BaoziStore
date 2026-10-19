package br.com.baozistore.controller;
import br.com.baozistore.model.Produto;
import br.com.baozistore.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/produtos")
public class ProdutoController {
  private final ProdutoRepository repo;
  public ProdutoController(ProdutoRepository repo){this.repo=repo;}
  @PostMapping public ResponseEntity<Produto> criar(@Valid @RequestBody Produto x){x.setId(null);return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(x));}
  @GetMapping public List<Produto> listar(){return repo.findAll();}
  @GetMapping("/{id}") public ResponseEntity<Produto> buscar(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
  @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
