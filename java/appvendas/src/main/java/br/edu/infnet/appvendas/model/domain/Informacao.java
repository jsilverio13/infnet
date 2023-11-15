package br.edu.infnet.appvendas.model.domain;

public class Informacao
{
    private Integer id;
    private String campo;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Informacao{" +
                "id=" + id +
                ", campo='" + campo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
