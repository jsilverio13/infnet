package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movel")
public class Movel extends Produto {
    private String comodo;
    private String material;
    public Movel() {
    }

    public String getComodo() {
        return comodo;
    }

    public void setComodo(String comodo) {
        this.comodo = comodo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Movel{" +
                "descricao='" + getDescricao() + '\'' +
                ", comodo='" + comodo + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
