package br.com.samuelweb.nfe.configuration;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.samuelweb.nfe.ConfiguracaoNfeException;

public class ReadConfigurationFile {

	public ReadConfigurationFile() {
	}

	public ConfigurationXML read(String name) throws ConfiguracaoNfeException {

		try {
			JAXBContext c = JAXBContext.newInstance(ConfigurationXML.class);
			return (ConfigurationXML) c.createUnmarshaller().unmarshal(new File(name));

		} catch (JAXBException e) {
			throw new ConfiguracaoNfeException(e);
		}
	}

	public ConfigurationXML read(InputStream stream) throws ConfiguracaoNfeException {
		try {
			JAXBContext c = JAXBContext.newInstance(ConfigurationXML.class);
			return (ConfigurationXML) c.createUnmarshaller().unmarshal(stream);

		} catch (JAXBException e) {
			throw new ConfiguracaoNfeException(e);
		}

	}

}
