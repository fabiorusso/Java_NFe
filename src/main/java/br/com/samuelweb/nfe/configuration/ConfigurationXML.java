package br.com.samuelweb.nfe.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigurationXML {

	protected EmpresasType empresas;

	public ConfigurationXML() {
		empresas = new EmpresasType();
	}

	public EmpresasType getEmpresas() {
		return empresas;
	}

	public void setEmpresas(EmpresasType empresas) {
		this.empresas = empresas;
	}

}
