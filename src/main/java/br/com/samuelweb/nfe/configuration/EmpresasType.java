package br.com.samuelweb.nfe.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "empresas")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpresasType {
	
	@XmlElement(name="empresa")
	protected List<EmpresaType> empresas;

	public EmpresasType() {

	}

	public List<EmpresaType> getEmpresas() {
		if (empresas == null)
			empresas = new ArrayList<>();

		return empresas;
	}

	public void setEmpresas(List<EmpresaType> empresas) {
		this.empresas = empresas;
	}

}
