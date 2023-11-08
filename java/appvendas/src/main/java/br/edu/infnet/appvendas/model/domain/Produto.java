package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_produto", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 4000, message = "A descricao deve ter entre {min} e {max} caracteres.")
    private String descricao;

    @Positive(message = "Favor informar o codigo do produto, diferente de 0")
    @Column(unique = true)
    private int codigo;

    @Positive(message = "O preço deve ser maior que zero")
    private float preco;

    @NotNull(message = "Favor informar se existe estoque")
    @Column(columnDefinition = "boolean default false")
    private boolean estoque;

    @Size(max = 1, message = "O tipo de produto deve ter {max} caracteres.")
    @Column(columnDefinition = "VARCHAR(1) DEFAULT 'M'")

    private String tipoProduto;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(Boolean estoque) {
        this.estoque = estoque;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", estoque=" + estoque +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", vendedorId=" + vendedor.getId() +
                '}';
    }
}
