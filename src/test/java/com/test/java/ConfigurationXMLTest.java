package com.test.java;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import br.com.samuelweb.nfe.ConfiguracaoNfeException;
import br.com.samuelweb.nfe.configuration.ConfigurationXML;
import br.com.samuelweb.nfe.configuration.EmpresaType;
import br.com.samuelweb.nfe.configuration.ReadConfigurationFile;

public class ConfigurationXMLTest {

	@Test
	public void test() throws JAXBException {
		ConfigurationXML xml = new ConfigurationXML();

		EmpresaType empresa = new EmpresaType();
		empresa.setAmbiente("H");
		empresa.setCertificado("C:\\certificados\\teste.pfx");
		empresa.setCnpj("1234567890123");
		empresa.setPastaSchemas("C:\\schemas\\");
		empresa.setVersaoNfe("3.10");
		empresa.setEstado("SP");
		empresa.setNomeEmpresa("Empresa Teste");
		empresa.setSenha("teste");
		xml.getEmpresas().getEmpresas().add(empresa);
		
		JAXBContext c = JAXBContext.newInstance(ConfigurationXML.class);
		Marshaller m= c.createMarshaller();
		
		m.marshal(xml, System.out);
		
	}
	
	@Test
	public void testReadConfigFile() throws ConfiguracaoNfeException {
		ConfigurationXML xml = new ReadConfigurationFile().read(getClass().getResourceAsStream("/configuration.xml"));
		assertNotNull(xml);
		
		for(EmpresaType e : xml.getEmpresas().getEmpresas()) {
			System.out.println("CNPJ: " + e.getCnpj());
		}
	}

}
