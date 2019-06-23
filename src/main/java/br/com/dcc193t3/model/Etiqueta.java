package br.com.dcc193t3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Etiqueta
 */
@Entity
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricaoTextual;
    private String url;

    public Etiqueta() {
    }

    public Etiqueta(Long id, String titulo, String descricaoTextual, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
        this.url = url;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricaoTextual() {
        return this.descricaoTextual;
    }

    public void setDescricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Etiqueta id(Long id) {
        this.id = id;
        return this;
    }

    public Etiqueta titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Etiqueta descricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
        return this;
    }

    public Etiqueta url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", titulo='" + getTitulo() + "'" + ", descricaoTextual='"
                + getDescricaoTextual() + "'" + ", url='" + getUrl() + "'" + "}";
    }

}