
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir prestar
 * 				informa��es relativas a movimentos criados localmente pelo tribunal.
 * 
 * <p>Classe Java de tipoMovimentoLocal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoMovimentoLocal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="movimentoLocalPai" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoMovimentoLocal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="codigoMovimento" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="codigoPaiNacional" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="descricao" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoMovimentoLocal", propOrder = {
    "movimentoLocalPai"
})
public class TipoMovimentoLocal {

    protected TipoMovimentoLocal movimentoLocalPai;
    @XmlAttribute(name = "codigoMovimento", required = true)
    protected int codigoMovimento;
    @XmlAttribute(name = "codigoPaiNacional", required = true)
    protected int codigoPaiNacional;
    @XmlAttribute(name = "descricao", required = true)
    protected String descricao;

    /**
     * Obt�m o valor da propriedade movimentoLocalPai.
     * 
     * @return
     *     possible object is
     *     {@link TipoMovimentoLocal }
     *     
     */
    public TipoMovimentoLocal getMovimentoLocalPai() {
        return movimentoLocalPai;
    }

    /**
     * Define o valor da propriedade movimentoLocalPai.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMovimentoLocal }
     *     
     */
    public void setMovimentoLocalPai(TipoMovimentoLocal value) {
        this.movimentoLocalPai = value;
    }

    /**
     * Obt�m o valor da propriedade codigoMovimento.
     * 
     */
    public int getCodigoMovimento() {
        return codigoMovimento;
    }

    /**
     * Define o valor da propriedade codigoMovimento.
     * 
     */
    public void setCodigoMovimento(int value) {
        this.codigoMovimento = value;
    }

    /**
     * Obt�m o valor da propriedade codigoPaiNacional.
     * 
     */
    public int getCodigoPaiNacional() {
        return codigoPaiNacional;
    }

    /**
     * Define o valor da propriedade codigoPaiNacional.
     * 
     */
    public void setCodigoPaiNacional(int value) {
        this.codigoPaiNacional = value;
    }

    /**
     * Obt�m o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

}
