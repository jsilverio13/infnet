package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_movel")
public class Movel extends Produto {

    @NotNull
    @Size(min = 2, max = 200, message = "O comodo deve ter entre {min} e {max} caracteres.")
    private String comodo;

    @NotNull
    @Size(min = 2, max = 200, message = "O material deve ter entre {min} e {max} caracteres.")
    @Pattern(regexp = "^[A-Z]*$", message = "O material deve conter apenas letras maiúsculas.")
    private String material;


    @Column(columnDefinition = "int default 12")
    private int garantia;

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

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Movel{" +
                "comodo='" + comodo + '\'' +
                ", material='" + material + '\'' +
                ", garantia='" + garantia + '\'' +
                '}' + " || " + super.toString();
    }
}

