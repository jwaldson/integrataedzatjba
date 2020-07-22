
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir apresentar
 * 				informações relativas à movimentação processual.
 * 
 * <p>Classe Java de tipoMovimentoProcessual complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoMovimentoProcessual"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="complemento" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="movimentoNacional" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoMovimentoNacional"/&gt;
 *           &lt;element name="movimentoLocal" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoMovimentoLocal"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="idDocumentoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dataHora" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" /&gt;
 *       &lt;attribute name="nivelSigilo" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="identificadorMovimento" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoMovimentoProcessual", propOrder = {
    "complemento",
    "movimentoNacional",
    "movimentoLocal",
    "idDocumentoVinculado"
})
public class TipoMovimentoProcessual {

    protected List<String> complemento;
    protected TipoMovimentoNacional movimentoNacional;
    protected TipoMovimentoLocal movimentoLocal;
    protected List<String> idDocumentoVinculado;
    @XmlAttribute(name = "dataHora", required = true)
    protected String dataHora;
    @XmlAttribute(name = "nivelSigilo")
    protected Integer nivelSigilo;
    @XmlAttribute(name = "identificadorMovimento")
    protected String identificadorMovimento;

    /**
     * Gets the value of the complemento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complemento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplemento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComplemento() {
        if (complemento == null) {
            complemento = new ArrayList<String>();
        }
        return this.complemento;
    }

    /**
     * Obtém o valor da propriedade movimentoNacional.
     * 
     * @return
     *     possible object is
     *     {@link TipoMovimentoNacional }
     *     
     */
    public TipoMovimentoNacional getMovimentoNacional() {
        return movimentoNacional;
    }

    /**
     * Define o valor da propriedade movimentoNacional.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMovimentoNacional }
     *     
     */
    public void setMovimentoNacional(TipoMovimentoNacional value) {
        this.movimentoNacional = value;
    }

    /**
     * Obtém o valor da propriedade movimentoLocal.
     * 
     * @return
     *     possible object is
     *     {@link TipoMovimentoLocal }
     *     
     */
    public TipoMovimentoLocal getMovimentoLocal() {
        return movimentoLocal;
    }

    /**
     * Define o valor da propriedade movimentoLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMovimentoLocal }
     *     
     */
    public void setMovimentoLocal(TipoMovimentoLocal value) {
        this.movimentoLocal = value;
    }

    /**
     * Gets the value of the idDocumentoVinculado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idDocumentoVinculado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdDocumentoVinculado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdDocumentoVinculado() {
        if (idDocumentoVinculado == null) {
            idDocumentoVinculado = new ArrayList<String>();
        }
        return this.idDocumentoVinculado;
    }

    /**
     * Obtém o valor da propriedade dataHora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataHora() {
        return dataHora;
    }

    /**
     * Define o valor da propriedade dataHora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataHora(String value) {
        this.dataHora = value;
    }

    /**
     * Obtém o valor da propriedade nivelSigilo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNivelSigilo() {
        return nivelSigilo;
    }

    /**
     * Define o valor da propriedade nivelSigilo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNivelSigilo(Integer value) {
        this.nivelSigilo = value;
    }

    /**
     * Obtém o valor da propriedade identificadorMovimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorMovimento() {
        return identificadorMovimento;
    }

    /**
     * Define o valor da propriedade identificadorMovimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorMovimento(String value) {
        this.identificadorMovimento = value;
    }

}
