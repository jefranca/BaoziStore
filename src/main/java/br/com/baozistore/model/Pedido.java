package br.com.baozistore.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="pedidos")
public class Pedido {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotNull @ManyToOne(optional=false) @JoinColumn(name="cliente_id") @JsonIgnore private Cliente cliente;
  @NotNull @ManyToOne(optional=false) @JoinColumn(name="produto_id") @JsonIgnore private Produto produto;
  @NotNull @Min(1) private Integer quantidade;
  public Pedido() {}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  @JsonProperty("clienteId") public Long getClienteId(){return cliente==null?null:cliente.getId();}
  @JsonProperty("produtoId") public Long getProdutoId(){return produto==null?null:produto.getId();}
  public Cliente getCliente(){return cliente;} public void setCliente(Cliente c){cliente=c;}
  public Produto getProduto(){return produto;} public void setProduto(Produto p){produto=p;}
  public Integer getQuantidade(){return quantidade;} public void setQuantidade(Integer q){quantidade=q;}
}
