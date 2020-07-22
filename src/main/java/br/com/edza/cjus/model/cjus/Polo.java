package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_polo")
public class Polo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Polo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Polo(Integer processoid) {
		super();
		this.processoid = processoid;
	}
	
	public Polo(Integer id, String modalidadeProcessual, List<Pessoa> pessoas) {
		super();
		this.id = id;
		this.modalidadeProcessual = modalidadeProcessual;
		this.pessoas = pessoas;
	}

	@Id
	@Column(name = "poloid")
	private Integer id;
	
	@Column(name = "processoid")
	private Integer processoid;

	@Column(name = "modalidade")
	private String modalidadeProcessual;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "poloid")
	private List<Pessoa> pessoas;

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

	public String getModalidadeProcessual() {
		return modalidadeProcessual;
	}

	public void setModalidadeProcessual(String modalidadeProcessual) {
		this.modalidadeProcessual = modalidadeProcessual;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}

