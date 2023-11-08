package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro extends Produto {
    @NotNull
    @Size(min = 5, max = 300, message = "O autor deve ter entre {min} e {max} caracteres.")
    private String autor;

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @NotNull
    @Size(min = 5, max = 500, message = "O genero deve ter entre {min} e {max} caracteres.")
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
                "autor='" + autor + '\'' +
                ", data=" + data +
                ", genero='" + genero + '\'' +
                '}' +  " || " + super.toString();
    }
}
