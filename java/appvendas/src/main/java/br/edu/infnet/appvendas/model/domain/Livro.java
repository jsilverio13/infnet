package br.edu.infnet.appvendas.model.domain;

import java.time.LocalDate;
import java.util.Date;

public class Livro extends Produto {

    public Livro() {
    }

    public String autor;
    public LocalDate data;
    public String genero;

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
                "descricao='" + descricao + '\'' +
                ", autor='" + autor + '\'' +
                ", data=" + data +
                ", genero='" + genero + '\'' +
                '}';
    }
}
