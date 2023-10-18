package br.edu.infnet.appvendas.model.domain;

public class Movel extends Produto {
    public Movel() {
    }

    public String comodo;
    public String material;

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
                "descricao='" + descricao + '\'' +
                ", comodo='" + comodo + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
