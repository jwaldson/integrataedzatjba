package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_assunto")
public class AssuntoProcessual implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AssuntoProcessual() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AssuntoProcessual(Integer id, String principal, Integer codigoNacional) {
		super();
		this.id = id;
		this.principal = principal;
		this.codigoNacional = codigoNacional;
	}



	public AssuntoProcessual(Integer processoid) {
		super();
		this.processoid = processoid;
	}
	
	@Id
	@Column(name = "assuntoid")
	private Integer id;

	@Column(name = "processoid")
	private Integer processoid;

	@Column(name = "principal")
	private String principal;

	@Column(name = "codigonacional")
	private Integer codigoNacional;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcessoid() {
		return processoid;
	}

	public void setProcessoid(Integer processoid) {
		this.processoid = processoid;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Integer getCodigoNacional() {
		return codigoNacional;
	}

	public void setCodigoNacional(Integer codigoNacional) {
		this.codigoNacional = codigoNacional;
	}
	
}

