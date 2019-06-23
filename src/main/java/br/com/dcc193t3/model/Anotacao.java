package br.com.dcc193t3.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Anotacao
 */
@Entity
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricaoTextual;
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtInclusao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtAlteracao;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Item item;

    public Anotacao() {
    }

    public Anotacao(Long id, String titulo, String descricaoTextual, String url, Date dtInclusao, Date dtAlteracao,
            Usuario usuario, Item item) {
        this.id = id;
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
        this.url = url;
        this.dtInclusao = dtInclusao;
        this.dtAlteracao = dtAlteracao;
        this.usuario = usuario;
        this.item = item;
    }

    public String getdtInclusaoStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDtInclusao());
    }

    public String getdtAlteracaoStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDtAlteracao());
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

    public Date getDtInclusao() {
        return this.dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public Date getDtAlteracao() {
        return this.dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Anotacao id(Long id) {
        this.id = id;
        return this;
    }

    public Anotacao titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Anotacao descricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
        return this;
    }

    public Anotacao url(String url) {
        this.url = url;
        return this;
    }

    public Anotacao dtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
        return this;
    }

    public Anotacao dtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
        return this;
    }

    public Anotacao usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Anotacao item(Item item) {
        this.item = item;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", titulo='" + getTitulo() + "'" + ", descricaoTextual='"
                + getDescricaoTextual() + "'" + ", url='" + getUrl() + "'" + ", dtInclusao='" + getDtInclusao() + "'"
                + ", dtAlteracao='" + getDtAlteracao() + "'" + ", usuario='" + getUsuario() + "'" + ", item='"
                + getItem() + "'" + "}";
    }

}