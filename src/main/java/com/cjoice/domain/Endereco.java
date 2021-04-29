package com.cjoice.domain;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "endereco")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType //indica que essa classe mapeia um tipo de informação específica;
public class Endereco {
    
    @XmlElement 
    private String rua;
    @XmlElement 
    private String bairro;
    @XmlElement 
    private String cidade;
    @XmlElement 
    private String estado; 

    public Endereco(){}

    public Endereco(String rua, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", rua=" + rua + "]";
    }

}
