package br.com.baozistore.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="produtos")
public class Produto {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank private String nome;
  @NotNull @DecimalMin("0.01") @Column(precision=10,scale=2) private BigDecimal preco;
  @NotNull private Boolean estoque;
  public Produto() {}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
  public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal preco){this.preco=preco;}
  public Boolean getEstoque(){return estoque;} public void setEstoque(Boolean estoque){this.estoque=estoque;}
}
