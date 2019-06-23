package br.com.dcc193t3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Item
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    @OneToMany
    private List<Etiqueta> listaEtiqueta;
    @OneToMany
    private List<Vinculo> listaVinculo;


    public Item() {
    }

    public Item(Long id, String titulo, List<Etiqueta> listaEtiqueta, List<Vinculo> listaVinculo) {
        this.id = id;
        this.titulo = titulo;
        this.listaEtiqueta = listaEtiqueta;
        this.listaVinculo = listaVinculo;
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

    public List<Etiqueta> getListaEtiqueta() {
        return this.listaEtiqueta;
    }

    public void setListaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }

    public List<Vinculo> getListaVinculo() {
        return this.listaVinculo;
    }

    public void setListaVinculo(List<Vinculo> listaVinculo) {
        this.listaVinculo = listaVinculo;
    }

    public Item id(Long id) {
        this.id = id;
        return this;
    }

    public Item titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Item listaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
        return this;
    }

    public Item listaVinculo(List<Vinculo> listaVinculo) {
        this.listaVinculo = listaVinculo;
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", listaEtiqueta='" + getListaEtiqueta() + "'" +
            ", listaVinculo='" + getListaVinculo() + "'" +
            "}";
    }

}