package br.com.dcc193t3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Usuario
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoAcesso;
    private String descricaoTextual;
    private String email;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String codigoAcesso, String descricaoTextual, String email) {
        this.id = id;
        this.nome = nome;
        this.codigoAcesso = codigoAcesso;
        this.descricaoTextual = descricaoTextual;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoAcesso() {
        return this.codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public String getDescricaoTextual() {
        return this.descricaoTextual;
    }

    public void setDescricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario id(Long id) {
        this.id = id;
        return this;
    }

    public Usuario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario codigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        return this;
    }

    public Usuario descricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", nome='" + getNome() + "'" + ", codigoAcesso='" + getCodigoAcesso()
                + "'" + ", descricaoTextual='" + getDescricaoTextual() + "'" + ", email='" + getEmail() + "'" + "}";
    }

}