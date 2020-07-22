
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoCabecalhoProcesso complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoCabecalhoProcesso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="polo" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoPoloProcessual" maxOccurs="unbounded"/&gt;
 *         &lt;element name="assunto" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoAssuntoProcessual" maxOccurs="unbounded"/&gt;
 *         &lt;element name="magistradoAtuante" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoCadastroIdentificador" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="processoVinculado" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoVinculacaoProcessual" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="prioridade" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="outroParametro" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoParametro" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="valorCausa" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="orgaoJulgador" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoOrgaoJulgador"/&gt;
 *         &lt;element name="outrosnumeros" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numero" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoNumeroUnico" /&gt;
 *       &lt;attribute name="competencia" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="classeProcessual" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="codigoLocalidade" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nivelSigilo" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="intervencaoMP" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="tamanhoProcesso" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="dataAjuizamento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoCabecalhoProcesso", propOrder = {
    "polo",
    "assunto",
    "magistradoAtuante",
    "processoVinculado",
    "prioridade",
    "outroParametro",
    "valorCausa",
    "orgaoJulgador",
    "outrosnumeros"
})
public class TipoCabecalhoProcesso {

    @XmlElement(required = true)
    protected List<TipoPoloProcessual> polo;
    @XmlElement(required = true)
    protected List<TipoAssuntoProcessual> assunto;
    protected List<String> magistradoAtuante;
    protected List<TipoVinculacaoProcessual> processoVinculado;
    protected List<String> prioridade;
    protected List<TipoParametro> outroParametro;
    protected Double valorCausa;
    @XmlElement(required = true)
    protected TipoOrgaoJulgador orgaoJulgador;
    protected List<String> outrosnumeros;
    @XmlAttribute(name = "numero", required = true)
    protected String numero;
    @XmlAttribute(name = "competencia")
    protected Integer competencia;
    @XmlAttribute(name = "classeProcessual", required = true)
    protected int classeProcessual;
    @XmlAttribute(name = "codigoLocalidade", required = true)
    protected String codigoLocalidade;
    @XmlAttribute(name = "nivelSigilo", required = true)
    protected int nivelSigilo;
    @XmlAttribute(name = "intervencaoMP")
    protected Boolean intervencaoMP;
    @XmlAttribute(name = "tamanhoProcesso")
    protected Integer tamanhoProcesso;
    @XmlAttribute(name = "dataAjuizamento")
    protected String dataAjuizamento;

    /**
     * Gets the value of the polo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoPoloProcessual }
     * 
     * 
     */
    public List<TipoPoloProcessual> getPolo() {
        if (polo == null) {
            polo = new ArrayList<TipoPoloProcessual>();
        }
        return this.polo;
    }

    /**
     * Gets the value of the assunto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assunto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssunto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoAssuntoProcessual }
     * 
     * 
     */
    public List<TipoAssuntoProcessual> getAssunto() {
        if (assunto == null) {
            assunto = new ArrayList<TipoAssuntoProcessual>();
        }
        return this.assunto;
    }

    /**
     * Gets the value of the magistradoAtuante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the magistradoAtuante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMagistradoAtuante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMagistradoAtuante() {
        if (magistradoAtuante == null) {
            magistradoAtuante = new ArrayList<String>();
        }
        return this.magistradoAtuante;
    }

    /**
     * Gets the value of the processoVinculado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processoVinculado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessoVinculado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoVinculacaoProcessual }
     * 
     * 
     */
    public List<TipoVinculacaoProcessual> getProcessoVinculado() {
        if (processoVinculado == null) {
            processoVinculado = new ArrayList<TipoVinculacaoProcessual>();
        }
        return this.processoVinculado;
    }

    /**
     * Gets the value of the prioridade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prioridade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrioridade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrioridade() {
        if (prioridade == null) {
            prioridade = new ArrayList<String>();
        }
        return this.prioridade;
    }

    /**
     * Gets the value of the outroParametro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outroParametro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutroParametro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoParametro }
     * 
     * 
     */
    public List<TipoParametro> getOutroParametro() {
        if (outroParametro == null) {
            outroParametro = new ArrayList<TipoParametro>();
        }
        return this.outroParametro;
    }

    /**
     * Obt�m o valor da propriedade valorCausa.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValorCausa() {
        return valorCausa;
    }

    /**
     * Define o valor da propriedade valorCausa.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValorCausa(Double value) {
        this.valorCausa = value;
    }

    /**
     * Obt�m o valor da propriedade orgaoJulgador.
     * 
     * @return
     *     possible object is
     *     {@link TipoOrgaoJulgador }
     *     
     */
    public TipoOrgaoJulgador getOrgaoJulgador() {
        return orgaoJulgador;
    }

    /**
     * Define o valor da propriedade orgaoJulgador.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoOrgaoJulgador }
     *     
     */
    public void setOrgaoJulgador(TipoOrgaoJulgador value) {
        this.orgaoJulgador = value;
    }

    /**
     * Gets the value of the outrosnumeros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outrosnumeros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutrosnumeros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutrosnumeros() {
        if (outrosnumeros == null) {
            outrosnumeros = new ArrayList<String>();
        }
        return this.outrosnumeros;
    }

    /**
     * Obt�m o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obt�m o valor da propriedade competencia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompetencia() {
        return competencia;
    }

    /**
     * Define o valor da propriedade competencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompetencia(Integer value) {
        this.competencia = value;
    }

    /**
     * Obt�m o valor da propriedade classeProcessual.
     * 
     */
    public int getClasseProcessual() {
        return classeProcessual;
    }

    /**
     * Define o valor da propriedade classeProcessual.
     * 
     */
    public void setClasseProcessual(int value) {
        this.classeProcessual = value;
    }

    /**
     * Obt�m o valor da propriedade codigoLocalidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoLocalidade() {
        return codigoLocalidade;
    }

    /**
     * Define o valor da propriedade codigoLocalidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoLocalidade(String value) {
        this.codigoLocalidade = value;
    }

    /**
     * Obt�m o valor da propriedade nivelSigilo.
     * 
     */
    public int getNivelSigilo() {
        return nivelSigilo;
    }

    /**
     * Define o valor da propriedade nivelSigilo.
     * 
     */
    public void setNivelSigilo(int value) {
        this.nivelSigilo = value;
    }

    /**
     * Obt�m o valor da propriedade intervencaoMP.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIntervencaoMP() {
        return intervencaoMP;
    }

    /**
     * Define o valor da propriedade intervencaoMP.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIntervencaoMP(Boolean value) {
        this.intervencaoMP = value;
    }

    /**
     * Obt�m o valor da propriedade tamanhoProcesso.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTamanhoProcesso() {
        return tamanhoProcesso;
    }

    /**
     * Define o valor da propriedade tamanhoProcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTamanhoProcesso(Integer value) {
        this.tamanhoProcesso = value;
    }

    /**
     * Obt�m o valor da propriedade dataAjuizamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAjuizamento() {
        return dataAjuizamento;
    }

    /**
     * Define o valor da propriedade dataAjuizamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAjuizamento(String value) {
        this.dataAjuizamento = value;
    }

}
