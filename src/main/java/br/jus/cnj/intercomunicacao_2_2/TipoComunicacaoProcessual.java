
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a comunicar concretamente
 * 				uma
 * 				provid�ncia judicial para uma parte. A dataReferencia indica o
 * 				momento em que foi considerada a parte intimada, seja por provoca��o
 * 				do intimado/citado/notificado, seja por decurso do prazo legal para
 * 				tomada de ci�ncia.
 * 
 * <p>Classe Java de tipoComunicacaoProcessual complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoComunicacaoProcessual"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="destinatario" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoParte"/&gt;
 *         &lt;element name="processo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="teor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDocumento" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parametro" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;any namespace='##other'/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}identificadorComunicacao" /&gt;
 *       &lt;attribute name="tipoComunicacao" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoComunicacao" /&gt;
 *       &lt;attribute name="tipoPrazo" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoPrazo" /&gt;
 *       &lt;attribute name="dataReferencia" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" /&gt;
 *       &lt;attribute name="prazo" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nivelSigilo" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoComunicacaoProcessual", propOrder = {
    "destinatario",
    "processo",
    "teor",
    "documento",
    "parametro",
    "any"
})
public class TipoComunicacaoProcessual {

    @XmlElement(required = true)
    protected TipoParte destinatario;
    @XmlElement(required = true)
    protected String processo;
    protected String teor;
    protected List<TipoDocumento> documento;
    protected List<String> parametro;
    @XmlAnyElement(lax = true)
    protected Object any;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "tipoComunicacao")
    protected String tipoComunicacao;
    @XmlAttribute(name = "tipoPrazo")
    protected TipoPrazo tipoPrazo;
    @XmlAttribute(name = "dataReferencia")
    protected String dataReferencia;
    @XmlAttribute(name = "prazo")
    protected Integer prazo;
    @XmlAttribute(name = "nivelSigilo")
    protected Integer nivelSigilo;

    /**
     * Obt�m o valor da propriedade destinatario.
     * 
     * @return
     *     possible object is
     *     {@link TipoParte }
     *     
     */
    public TipoParte getDestinatario() {
        return destinatario;
    }

    /**
     * Define o valor da propriedade destinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoParte }
     *     
     */
    public void setDestinatario(TipoParte value) {
        this.destinatario = value;
    }

    /**
     * Obt�m o valor da propriedade processo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcesso() {
        return processo;
    }

    /**
     * Define o valor da propriedade processo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcesso(String value) {
        this.processo = value;
    }

    /**
     * Obt�m o valor da propriedade teor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeor() {
        return teor;
    }

    /**
     * Define o valor da propriedade teor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeor(String value) {
        this.teor = value;
    }

    /**
     * Gets the value of the documento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoDocumento }
     * 
     * 
     */
    public List<TipoDocumento> getDocumento() {
        if (documento == null) {
            documento = new ArrayList<TipoDocumento>();
        }
        return this.documento;
    }

    /**
     * Gets the value of the parametro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getParametro() {
        if (parametro == null) {
            parametro = new ArrayList<String>();
        }
        return this.parametro;
    }

    /**
     * Obt�m o valor da propriedade any.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * Define o valor da propriedade any.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

    /**
     * Obt�m o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obt�m o valor da propriedade tipoComunicacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoComunicacao() {
        return tipoComunicacao;
    }

    /**
     * Define o valor da propriedade tipoComunicacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoComunicacao(String value) {
        this.tipoComunicacao = value;
    }

    /**
     * Obt�m o valor da propriedade tipoPrazo.
     * 
     * @return
     *     possible object is
     *     {@link TipoPrazo }
     *     
     */
    public TipoPrazo getTipoPrazo() {
        return tipoPrazo;
    }

    /**
     * Define o valor da propriedade tipoPrazo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoPrazo }
     *     
     */
    public void setTipoPrazo(TipoPrazo value) {
        this.tipoPrazo = value;
    }

    /**
     * Obt�m o valor da propriedade dataReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataReferencia() {
        return dataReferencia;
    }

    /**
     * Define o valor da propriedade dataReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataReferencia(String value) {
        this.dataReferencia = value;
    }

    /**
     * Obt�m o valor da propriedade prazo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrazo() {
        return prazo;
    }

    /**
     * Define o valor da propriedade prazo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrazo(Integer value) {
        this.prazo = value;
    }

    /**
     * Obt�m o valor da propriedade nivelSigilo.
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

}
