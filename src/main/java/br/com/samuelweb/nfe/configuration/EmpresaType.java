package br.com.samuelweb.nfe.configuration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Empresa")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpresaType implements Serializable {

	/**
	 * version 1.0
	 */
	private static final long serialVersionUID = -7397562823740536772L;

	@XmlAttribute(name = "estado", required = true)
	protected String estado;

	@XmlAttribute(name = "ambiente", required = true)
	protected String ambiente;

	@XmlAttribute(name = "schema", required = true)
	protected String pastaSchemas;

	@XmlAttribute(name = "versaoNFe", required = true)
	protected String versaoNfe;

	@XmlAttribute(name = "cnpj", required = true)
	protected String cnpj;

	@XmlElement(name = "certificado", required = true)
	protected String certificado;

	@XmlElement(name = "senha", required = true)
	protected String senha;

	@XmlAttribute(name = "nome", required = true)
	protected String nomeEmpresa;

	public EmpresaType() {

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getPastaSchemas() {
		return pastaSchemas;
	}

	public void setPastaSchemas(String pastaSchemas) {
		this.pastaSchemas = pastaSchemas;
	}

	public String getVersaoNfe() {
		return versaoNfe;
	}

	public void setVersaoNfe(String versaoNfe) {
		this.versaoNfe = versaoNfe;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

}
