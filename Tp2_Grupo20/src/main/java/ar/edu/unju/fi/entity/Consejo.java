package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="consejos_salud")
public class Consejo {




    @Column(name="cons_titulo")
    @NotEmpty(message = "El nombre puede estar vacío")
    @Size(min = 4, max = 100, message = "El titulo no puede ser corto")
    private String titulo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="suc_id")
    private Long id;

    @Column(name="cons_cuerpo")
    @NotBlank(message = "Es necesario el consejo para los clientes")
    @Size(min = 5, max = 1000, message = "El consejo debe ser mas largo")
    private String esconsejo;

    @Column
    private boolean estado;




    public Consejo() {

    }


    public Consejo(String titulo,Long id,String esconsejo,boolean estado) {
        super();

        this.titulo = titulo;
        this.id = id;
        this.esconsejo = esconsejo;
        this.estado = estado;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsconsejo() {
        return esconsejo;
    }

    public void setEsconsejo(String consejo) {
        this.esconsejo = consejo;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public boolean isEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    }