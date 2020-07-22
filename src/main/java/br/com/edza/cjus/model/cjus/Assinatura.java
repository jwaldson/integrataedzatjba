package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_assinatura")
public class Assinatura implements Serializable {

	public Assinatura() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Assinatura(Integer id,  String assinatura, String algoritmoHashAssinatura,
			String cadeiaCertificadoAssinatura, String codificacaoCertificadoAssinatura, Timestamp dataAssinatura,
			String signatatioLoginIdentficador) {
		super();
		this.id = id;
		this.assinatura = assinatura;
		this.algoritmoHashAssinatura = algoritmoHashAssinatura;
		this.cadeiaCertificadoAssinatura = cadeiaCertificadoAssinatura;
		this.codificacaoCertificadoAssinatura = codificacaoCertificadoAssinatura;
		this.dataAssinatura = dataAssinatura;
		this.signatatioLoginIdentficador = signatatioLoginIdentficador;
	}



	public Assinatura(Integer documentoid) {
		super();
		this.documentoid = documentoid;
	}

	
	@Id
	@Column(name = "assinaturaid")
	private Integer id;
	
	@Column(name = "documentoid")
	private Integer documentoid;
	
	@Column(name = "assinatura")
	private String assinatura;

	@Column(name = "algoritmohashassinatura")
	private String algoritmoHashAssinatura;

	@Column(name = "cadeiacertificadoassinatura")
	private String cadeiaCertificadoAssinatura;

	@Column(name = "codificacaocertificadoassinatura")
	private String codificacaoCertificadoAssinatura;

	@Column(name = "dataassinatura")
	private Timestamp dataAssinatura;

	@Column(name = "signatatiologinidentficador")
	private String signatatioLoginIdentficador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getAlgoritmoHashAssinatura() {
		return algoritmoHashAssinatura;
	}

	public void setAlgoritmoHashAssinatura(String algoritmoHashAssinatura) {
		this.algoritmoHashAssinatura = algoritmoHashAssinatura;
	}

	public String getCadeiaCertificadoAssinatura() {
		return cadeiaCertificadoAssinatura;
	}

	public void setCadeiaCertificadoAssinatura(String cadeiaCertificadoAssinatura) {
		this.cadeiaCertificadoAssinatura = cadeiaCertificadoAssinatura;
	}

	public String getCodificacaoCertificadoAssinatura() {
		return codificacaoCertificadoAssinatura;
	}

	public void setCodificacaoCertificadoAssinatura(String codificacaoCertificadoAssinatura) {
		this.codificacaoCertificadoAssinatura = codificacaoCertificadoAssinatura;
	}

	public Timestamp getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Timestamp dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public String getSignatatioLoginIdentficador() {
		return signatatioLoginIdentficador;
	}

	public void setSignatatioLoginIdentficador(String signatatioLoginIdentficador) {
		this.signatatioLoginIdentficador = signatatioLoginIdentficador;
	}



	public Integer getDocumentoid() {
		return documentoid;
	}



	public void setDocumentoid(Integer documentoid) {
		this.documentoid = documentoid;
	}

}

