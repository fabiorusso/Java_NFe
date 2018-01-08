/**
 * 
 */
package br.com.samuelweb.nfe;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import br.com.samuelweb.certificado.Certificado;
import br.com.samuelweb.nfe.exception.NfeException;
import br.com.samuelweb.nfe.util.Estados;
import br.com.samuelweb.nfe.util.ProxyUtil;

/**
 * @author Samuel Oliveira
 *
 *         Inicia Configurações Nfe.
 */
public final class ConfiguracoesIniciaisNfe {

	private static Map<String, ConfiguracoesIniciaisNfe> instance = new HashMap<String, ConfiguracoesIniciaisNfe>();

	private Estados estado;
	private String ambiente;
	private Certificado certificado;
	private String pastaSchemas;
	private String versaoNfe;
	private ProxyUtil proxyUtil;
	private String cnpj;
	private boolean contigenciaSCAN;

	// Construtor Singleton
	private ConfiguracoesIniciaisNfe() {
	}

	// Construtor Privado
	private ConfiguracoesIniciaisNfe(Estados estado, String ambiente, Certificado certificado, String pastaSchemas,
			String versaoNfe) {
		this.setEstado(estado);
		this.setAmbiente(ambiente);
		this.setCertificado(certificado);
		this.setPastaSchemas(pastaSchemas);
		this.setVersaoNfe(versaoNfe);
		this.setCnpj(cnpj);
	}

	private void readFileConfiguration() throws ConfiguracaoNfeException {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("/certificados.properties"));
			String filename = prop.getProperty("file.path");
			System.out.println("file: " + filename);

			File configFile = new File(filename);
			if (!configFile.exists()) {
				throw new ArquivoConfiguracaoNaoEncontradoException("Filename: " + filename);
			}
			
			

		} catch (IOException e) {

		}
	}

	private ConfiguracoesIniciaisNfe(Estados estado, String ambiente, String pastaSchemas, String versaoNfe,
			String cnpj) {
		this.setEstado(estado);
		this.setAmbiente(ambiente);
		this.setCnpj(cnpj);
		this.setPastaSchemas(pastaSchemas);
		this.setVersaoNfe(versaoNfe);

	}

	public static ConfiguracoesIniciaisNfe iniciaConfiguracoes(Estados estado, String ambiente, Certificado certificado,
			String pastaSchemas, String versaoNfe, String cnpj) {

		instance.put(cnpj, new ConfiguracoesIniciaisNfe(estado, ambiente, certificado, pastaSchemas, versaoNfe));
		System.out.println("Api Java Nfe Versão 3.10.8 - Samuel Olivera - samuk.exe@hotmail.com");
		System.out.println("Certificado: " + certificado.getTipo().toUpperCase() + " - "
				+ certificado.getNome().toUpperCase() + " - Vencimento: " + certificado.getVencimento());
		System.out.println("Ambiente: " + (ambiente.equals("1") ? "Produção" : "Homologação") + " - Estado: "
				+ estado.getNome() + " - Versão: " + versaoNfe);
		return instance.get(cnpj);
	}

	public static ConfiguracoesIniciaisNfe getInstance(String cnpj) throws NfeException {
		if (instance == null) {
			throw new NfeException("Configurações Não Foram Inicializadas.");
		}
		
		if(instance.get(cnpj)==null) {
			throw new NfeException("Esse CNPJ("+ cnpj +") não foi inicializado.");
		}

		return instance.get(cnpj);
	}

	public void setProxy(String ip, int porta, String usuario, String senha) {
		proxyUtil = new ProxyUtil(ip, porta, usuario, senha);
	}

	/**
	 * @return the pastaSchemas
	 */
	public String getPastaSchemas() {
		return pastaSchemas;
	}

	/**
	 * @param pastaSchemas
	 *            the pastaSchemas to set
	 */
	public void setPastaSchemas(String pastaSchemas) {
		this.pastaSchemas = pastaSchemas;
	}

	/**
	 * @return the versaoNfe
	 */
	public String getVersaoNfe() {
		return versaoNfe;
	}

	/**
	 * @param versaoNfe
	 *            the versaoNfe to set
	 */
	public void setVersaoNfe(String versaoNfe) {
		this.versaoNfe = versaoNfe;
	}

	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return ambiente;
	}

	/**
	 * @param ambiente
	 *            the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	/**
	 * @return the certificado
	 */
	public Certificado getCertificado() {
		return certificado;
	}

	/**
	 * @param certificado
	 *            the certificado to set
	 */
	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	/**
	 * 
	 * @return configuracao do proxy
	 */
	public ProxyUtil getProxy() {
		return proxyUtil;
	}

	/**
	 * @return the contigenciaSCAN
	 */
	public boolean isContigenciaSCAN() {
		return contigenciaSCAN;
	}

	/**
	 * @param contigenciaSCAN
	 *            the contigencia to set
	 */
	public void setContigenciaSCAN(boolean contigenciaSCAN) {
		this.contigenciaSCAN = contigenciaSCAN;
	}

	/**
	 * @return the estado
	 */
	public Estados getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
