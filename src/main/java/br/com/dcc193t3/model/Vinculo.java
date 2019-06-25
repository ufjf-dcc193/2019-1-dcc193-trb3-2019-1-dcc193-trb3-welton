package br.com.dcc193t3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Vinculo
 */
@Entity
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Item itemOrigem;
    @ManyToOne
    private Item itemDestino;
    @ManyToMany
    private List<Etiqueta> etiqueta;

    public Vinculo() {
    }

    public Vinculo(Long id, Item itemOrigem, Item itemDestino, List<Etiqueta> etiqueta) {
        this.id = id;
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
        this.etiqueta = etiqueta;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItemOrigem() {
        return this.itemOrigem;
    }

    public void setItemOrigem(Item itemOrigem) {
        this.itemOrigem = itemOrigem;
    }

    public Item getItemDestino() {
        return this.itemDestino;
    }

    public void setItemDestino(Item itemDestino) {
        this.itemDestino = itemDestino;
    }

    public List<Etiqueta> getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Vinculo id(Long id) {
        this.id = id;
        return this;
    }

    public Vinculo itemOrigem(Item itemOrigem) {
        this.itemOrigem = itemOrigem;
        return this;
    }

    public Vinculo itemDestino(Item itemDestino) {
        this.itemDestino = itemDestino;
        return this;
    }

    public Vinculo etiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", itemOrigem='" + getItemOrigem() + "'" + ", itemDestino='"
                + getItemDestino() + "'" + ", etiqueta='" + getEtiqueta() + "'" + "}";
    }

}