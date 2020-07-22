
package br.jus.cnj.mni.cda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de valorDivida complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="valorDivida"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="valor" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataApuracao" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="dataInicioIncidencia" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="rubrica" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="PRINCIPAL"/&gt;
 *             &lt;enumeration value="MULTA"/&gt;
 *             &lt;enumeration value="JUROS"/&gt;
 *             &lt;enumeration value="CORRECAO"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="tipoValor" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="ORIGINARIO"/&gt;
 *             &lt;enumeration value="ATUALIZACAO"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valorDivida")
public class ValorDivida {

    @XmlAttribute(name = "valor", required = true)
    protected String valor;
    @XmlAttribute(name = "dataApuracao", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataApuracao;
    @XmlAttribute(name = "dataInicioIncidencia")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataInicioIncidencia;
    @XmlAttribute(name = "rubrica", required = true)
    protected String rubrica;
    @XmlAttribute(name = "tipoValor", required = true)
    protected String tipoValor;

    /**
     * Obtém o valor da propriedade valor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Define o valor da propriedade valor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
    }

    /**
     * Obtém o valor da propriedade dataApuracao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataApuracao() {
        return dataApuracao;
    }

    /**
     * Define o valor da propriedade dataApuracao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataApuracao(XMLGregorianCalendar value) {
        this.dataApuracao = value;
    }

    /**
     * Obtém o valor da propriedade dataInicioIncidencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInicioIncidencia() {
        return dataInicioIncidencia;
    }

    /**
     * Define o valor da propriedade dataInicioIncidencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInicioIncidencia(XMLGregorianCalendar value) {
        this.dataInicioIncidencia = value;
    }

    /**
     * Obtém o valor da propriedade rubrica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRubrica() {
        return rubrica;
    }

    /**
     * Define o valor da propriedade rubrica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRubrica(String value) {
        this.rubrica = value;
    }

    /**
     * Obtém o valor da propriedade tipoValor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoValor() {
        return tipoValor;
    }

    /**
     * Define o valor da propriedade tipoValor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoValor(String value) {
        this.tipoValor = value;
    }

}
