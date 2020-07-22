
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento que encapsula dados essenciais a confirmação de envio de processo entre tribunais.
 * 
 * <p>Classe Java de tipoConfirmarRecebimento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConfirmarRecebimento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idRecebedor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="senhaRecebedor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="protocolo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoConfirmarRecebimento", propOrder = {
    "idRecebedor",
    "senhaRecebedor",
    "protocolo"
})
public class TipoConfirmarRecebimento {

    @XmlElement(required = true)
    protected String idRecebedor;
    @XmlElement(required = true)
    protected String senhaRecebedor;
    @XmlElement(required = true)
    protected String protocolo;

    /**
     * Obtém o valor da propriedade idRecebedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRecebedor() {
        return idRecebedor;
    }

    /**
     * Define o valor da propriedade idRecebedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRecebedor(String value) {
        this.idRecebedor = value;
    }

    /**
     * Obtém o valor da propriedade senhaRecebedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaRecebedor() {
        return senhaRecebedor;
    }

    /**
     * Define o valor da propriedade senhaRecebedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaRecebedor(String value) {
        this.senhaRecebedor = value;
    }

    /**
     * Obtém o valor da propriedade protocolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolo() {
        return protocolo;
    }

    /**
     * Define o valor da propriedade protocolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolo(String value) {
        this.protocolo = value;
    }

}
