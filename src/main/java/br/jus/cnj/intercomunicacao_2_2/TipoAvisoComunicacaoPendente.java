
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a indicar a existência de
 * 				uma
 * 				comunicação pendente.
 * 
 * <p>Classe Java de tipoAvisoComunicacaoPendente complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoAvisoComunicacaoPendente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="destinatario" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoParte"/&gt;
 *         &lt;element name="processo" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoCabecalhoProcesso"/&gt;
 *         &lt;element name="dataDisponibilizacao" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="idAviso" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}identificadorComunicacao" /&gt;
 *       &lt;attribute name="tipoComunicacao" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoComunicacao" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoAvisoComunicacaoPendente", propOrder = {
    "destinatario",
    "processo",
    "dataDisponibilizacao"
})
public class TipoAvisoComunicacaoPendente {

    @XmlElement(required = true)
    protected TipoParte destinatario;
    @XmlElement(required = true)
    protected TipoCabecalhoProcesso processo;
    @XmlElement(required = true)
    protected String dataDisponibilizacao;
    @XmlAttribute(name = "idAviso", required = true)
    protected String idAviso;
    @XmlAttribute(name = "tipoComunicacao")
    protected String tipoComunicacao;

    /**
     * Obtém o valor da propriedade destinatario.
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
     * Obtém o valor da propriedade processo.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabecalhoProcesso }
     *     
     */
    public TipoCabecalhoProcesso getProcesso() {
        return processo;
    }

    /**
     * Define o valor da propriedade processo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabecalhoProcesso }
     *     
     */
    public void setProcesso(TipoCabecalhoProcesso value) {
        this.processo = value;
    }

    /**
     * Obtém o valor da propriedade dataDisponibilizacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDisponibilizacao() {
        return dataDisponibilizacao;
    }

    /**
     * Define o valor da propriedade dataDisponibilizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDisponibilizacao(String value) {
        this.dataDisponibilizacao = value;
    }

    /**
     * Obtém o valor da propriedade idAviso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAviso() {
        return idAviso;
    }

    /**
     * Define o valor da propriedade idAviso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAviso(String value) {
        this.idAviso = value;
    }

    /**
     * Obtém o valor da propriedade tipoComunicacao.
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

}
