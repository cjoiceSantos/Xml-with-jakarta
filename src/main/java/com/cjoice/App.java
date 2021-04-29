package com.cjoice;

import java.util.ArrayList;
import java.util.List;

import com.cjoice.domain.Dependente;
import com.cjoice.domain.Endereco;
import com.cjoice.domain.Pessoa;
import com.cjoice.service.XmlServices;

public class App {

    public static void main(String[] args) {

            Endereco endereco = new Endereco("Rua Ayrton Senna", "Nova Parnamirim", "Parnamirim", "RN");
            Dependente d1 = new Dependente(1, "Maria");
            Dependente d2 = new Dependente(2, "João");
            Dependente d3 = new Dependente(3, "Joana");
            List<Dependente> dependentes = new ArrayList<Dependente>();
            dependentes.add(d1);
            dependentes.add(d2);
            dependentes.add(d3);
            
            Pessoa pessoa = new Pessoa();
            pessoa.setId(1);
            pessoa.setNome("José");
            pessoa.setEndereco(endereco);
            pessoa.setDependentes(dependentes);
            
            XmlServices service = new XmlServices();

            System.out.println("Gerando o XML");
            service.convertObjectsToXML(pessoa);
            System.out.println("Lendo o XML");
            Pessoa result = (Pessoa) service.convertXMLToObjects(Pessoa.class,"C:\\test\\teste.xml");
            System.out.println(result);
        }

}