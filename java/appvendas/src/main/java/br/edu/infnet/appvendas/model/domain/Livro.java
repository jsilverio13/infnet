package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro extends Produto {
    private String autor;
    private LocalDate data;
    private String genero;
    public Livro() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "descricao='" + getDescricao() + '\'' +
                ", autor='" + autor + '\'' +
                ", data=" + data +
                ", genero='" + genero + '\'' +
                '}';
    }
}
