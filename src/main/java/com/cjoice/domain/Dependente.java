package com.cjoice.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dependente")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "nome"}) ////indica que essa classe mapeia um tipo de informação específica;
public class Dependente {
    
    @XmlAttribute(required = true)
    private int id;
    @XmlElement 
    private String nome;

    public Dependente(){}

    public Dependente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Dependentes [id=" + id + ", nome=" + nome + "]";
    }
    
}
