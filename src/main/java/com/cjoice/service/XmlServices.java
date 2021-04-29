package com.cjoice.service;

import java.io.File;

import com.cjoice.domain.Pessoa;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlServices {
   
    public  void convertObjectsToXML(Object object){
        /**
         *  JAXBContext nos fornecerá um objeto Marshaller, criando uma instancia
         *a partir dos pacotes ou classes mapeadas com as anotações XML
         */
        JAXBContext jaxbContext = null;
        
        try {

            // Normal JAXB RI
            jaxbContext = JAXBContext.newInstance(object.getClass());
            
            /**
             * JAXB define um runtine padrão, e o EclipseLink MOXy é uma implementação 
             * desse tempo de execução.
             * Definindo manualmente (ou criar aquivo jaxb.properties)
             */
            /* jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                .createContext(new Class[]{Pessoa.class}, null); */

            //Marshall é o processo de transformar objetos Java em XML
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //Setando a formatação do XML 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Saída para um arquivo xml
            jaxbMarshaller.marshal(object, new File("C:\\test\\teste.xml"));
            // Saída no  console
            jaxbMarshaller.marshal(object, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public  Object convertXMLToObjects(Class class_object, String file_name){
        JAXBContext jaxbContext = null; 
       
        try {
            System.out.println(file_name);

            // Normal JAXB RI
            jaxbContext = JAXBContext.newInstance(class_object);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            // EclipseLink MOXy needs jaxb.properties at the same package with Fruit.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
           /*  jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[]{Fruit.class}, null); */
  
            File file = new File(file_name);
            /**
             * Unmarshall faz o caminho inverso, usa os dados de um XML para popular objetos Java.
             */
            
            return jaxbUnmarshaller.unmarshal(file);
  
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
