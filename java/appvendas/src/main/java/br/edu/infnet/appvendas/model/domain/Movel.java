package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;

//@Entity
//@Table(name = "tb_movel")
public class Movel extends Produto {
    public Movel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comodo;
    private String material;

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
