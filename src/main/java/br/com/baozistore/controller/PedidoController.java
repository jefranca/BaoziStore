package br.com.baozistore.controller;
import br.com.baozistore.model.Pedido;
import br.com.baozistore.repository.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/pedidos")
public class PedidoController {
  private final PedidoRepository pedidos; private final ClienteRepository clientes; private final ProdutoRepository produtos;
  public PedidoController(PedidoRepository p,ClienteRepository c,ProdutoRepository pr){pedidos=p;clientes=c;produtos=pr;}
  public record Entrada(@NotNull Long clienteId,@NotNull Long produtoId,@NotNull @Min(1) Integer quantidade){}
  @PostMapping public ResponseEntity<Pedido> criar(@Valid @RequestBody Entrada x){Pedido p=new Pedido();p.setCliente(clientes.findById(x.clienteId()).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente não encontrado")));p.setProduto(produtos.findById(x.produtoId()).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Produto não encontrado")));p.setQuantidade(x.quantidade());return ResponseEntity.status(HttpStatus.CREATED).body(pedidos.save(p));}
  @GetMapping public List<Pedido> listar(){return pedidos.findAll();}
  @GetMapping("/{id}") public ResponseEntity<Pedido> buscar(@PathVariable Long id){return pedidos.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
  @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!pedidos.existsById(id))return ResponseEntity.notFound().build();pedidos.deleteById(id);return ResponseEntity.noContent().build();}
}
