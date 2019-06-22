package br.com.dcc193t3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Vinculo
 */
@Entity
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Item itemOrigem;
    @ManyToOne
    private Item itemDestino;
    @OneToMany
    private List<Etiqueta> listaEtiqueta;
    @OneToMany
    private List<Anotacao> listaAnotacao;


    public Vinculo() {
    }

    public Vinculo(Long id, Item itemOrigem, Item itemDestino, List<Etiqueta> listaEtiqueta, List<Anotacao> listaAnotacao) {
        this.id = id;
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
        this.listaEtiqueta = listaEtiqueta;
        this.listaAnotacao = listaAnotacao;
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

    public List<Etiqueta> getListaEtiqueta() {
        return this.listaEtiqueta;
    }

    public void setListaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }

    public List<Anotacao> getListaAnotacao() {
        return this.listaAnotacao;
    }

    public void setListaAnotacao(List<Anotacao> listaAnotacao) {
        this.listaAnotacao = listaAnotacao;
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

    public Vinculo listaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
        return this;
    }

    public Vinculo listaAnotacao(List<Anotacao> listaAnotacao) {
        this.listaAnotacao = listaAnotacao;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", itemOrigem='" + getItemOrigem() + "'" +
            ", itemDestino='" + getItemDestino() + "'" +
            ", listaEtiqueta='" + getListaEtiqueta() + "'" +
            ", listaAnotacao='" + getListaAnotacao() + "'" +
            "}";
    }


}