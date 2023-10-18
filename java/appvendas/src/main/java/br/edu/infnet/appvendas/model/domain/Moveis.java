package br.edu.infnet.appvendas.model.domain;

public class Moveis  extends Produto {
    public Moveis() {
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
        return "Moveis{" +
                ", descricao='" + descricao + '\'' +
                "comodo='" + comodo + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
