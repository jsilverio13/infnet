package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

//@Entity
//@Table(name = "tb_livro")
public class Livro extends Produto {
    public Livro() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String autor;
    private LocalDate data;
    private String genero;

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
