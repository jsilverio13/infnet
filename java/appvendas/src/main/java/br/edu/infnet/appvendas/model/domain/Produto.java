package br.edu.infnet.appvendas.model.domain;

public class Produto {
    public Produto() {
    }
    public String descricao;
    public int codigo;
    public float preco;
    public boolean estoque;


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

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
