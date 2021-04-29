package com.cjoice.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoa") //indica que o valor da classe será representado como um elemento XML raíz;
//@XmlType(propOrder = {"nome", "endereco","dependentes"})
@XmlAccessorType(XmlAccessType.FIELD) //indica que as anotações estão ou nos atributos ou nos métodos da classe
public class Pessoa {

    @XmlAttribute(name = "id", required = true) //mapeia o valor de um campo como atributo no xml.
    int id;

    @XmlElement  //indica que o atributo será uma tag do xml;
    private String nome;
    
    @XmlElement 
    private Endereco endereco;
    
    @XmlElementWrapper(name = "dependentes") //mapeia um objeto do tipo lista;
    @XmlElement(name = "dependente")
    private List<Dependente> dependentes; 

    public Pessoa(){}

    public Pessoa(int id, String nome, Endereco endereco, List<Dependente> dependentes) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.dependentes = dependentes;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public String toString() {
        return "Pessoa [dependentes=" + dependentes + ", endereco=" + endereco + ", id=" + id + ", nome=" + nome + "]";
    }

}