
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir o armazenamento
 * 				dos dados relacionados à assinatura digital de um
 * 				objeto.
 * 
 * <p>Classe Java de tipoAssinatura complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoAssinatura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="signatarioLogin" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoSignatarioSimples" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="assinatura" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataAssinatura" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" /&gt;
 *       &lt;attribute name="cadeiaCertificado" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="algoritmoHash" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="codificacaoCertificado" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoAssinatura", propOrder = {
    "signatarioLogin"
})
public class TipoAssinatura {

    protected List<TipoSignatarioSimples> signatarioLogin;
    @XmlAttribute(name = "assinatura")
    protected String assinatura;
    @XmlAttribute(name = "dataAssinatura")
    protected String dataAssinatura;
    @XmlAttribute(name = "cadeiaCertificado")
    protected String cadeiaCertificado;
    @XmlAttribute(name = "algoritmoHash")
    protected String algoritmoHash;
    @XmlAttribute(name = "codificacaoCertificado")
    protected String codificacaoCertificado;

    /**
     * Gets the value of the signatarioLogin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signatarioLogin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignatarioLogin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoSignatarioSimples }
     * 
     * 
     */
    public List<TipoSignatarioSimples> getSignatarioLogin() {
        if (signatarioLogin == null) {
            signatarioLogin = new ArrayList<TipoSignatarioSimples>();
        }
        return this.signatarioLogin;
    }

    /**
     * Obtém o valor da propriedade assinatura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssinatura() {
        return assinatura;
    }

    /**
     * Define o valor da propriedade assinatura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssinatura(String value) {
        this.assinatura = value;
    }

    /**
     * Obtém o valor da propriedade dataAssinatura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAssinatura() {
        return dataAssinatura;
    }

    /**
     * Define o valor da propriedade dataAssinatura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAssinatura(String value) {
        this.dataAssinatura = value;
    }

    /**
     * Obtém o valor da propriedade cadeiaCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadeiaCertificado() {
        return cadeiaCertificado;
    }

    /**
     * Define o valor da propriedade cadeiaCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadeiaCertificado(String value) {
        this.cadeiaCertificado = value;
    }

    /**
     * Obtém o valor da propriedade algoritmoHash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgoritmoHash() {
        return algoritmoHash;
    }

    /**
     * Define o valor da propriedade algoritmoHash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgoritmoHash(String value) {
        this.algoritmoHash = value;
    }

    /**
     * Obtém o valor da propriedade codificacaoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodificacaoCertificado() {
        return codificacaoCertificado;
    }

    /**
     * Define o valor da propriedade codificacaoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodificacaoCertificado(String value) {
        this.codificacaoCertificado = value;
    }

}
