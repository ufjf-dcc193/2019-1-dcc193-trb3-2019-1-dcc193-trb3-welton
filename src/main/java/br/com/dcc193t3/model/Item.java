package br.com.dcc193t3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Item
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToMany
    private List<Etiqueta> etiqueta;

    public Item() {
        etiqueta = new ArrayList<>();
    }

    public Item(Long id, String titulo, List<Etiqueta> etiqueta) {
        this.id = id;
        this.titulo = titulo;
        this.etiqueta = etiqueta;
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

    public List<Etiqueta> getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Item id(Long id) {
        this.id = id;
        return this;
    }

    public Item titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Item etiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", titulo='" + getTitulo() + "'" + ", etiqueta='" + getEtiqueta() + "'"
                + "}";
    }

}