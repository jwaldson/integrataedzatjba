
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoOrgaoJulgador complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoOrgaoJulgador"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="codigoOrgao" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nomeOrgao" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="instancia" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="ORIG"/&gt;
 *             &lt;enumeration value="REV"/&gt;
 *             &lt;enumeration value="ESP"/&gt;
 *             &lt;enumeration value="EXT"/&gt;
 *             &lt;enumeration value="ADM"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="codigoMunicipioIBGE" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoOrgaoJulgador")
public class TipoOrgaoJulgador {

    @XmlAttribute(name = "codigoOrgao", required = true)
    protected String codigoOrgao;
    @XmlAttribute(name = "nomeOrgao", required = true)
    protected String nomeOrgao;
    @XmlAttribute(name = "instancia", required = true)
    protected String instancia;
    @XmlAttribute(name = "codigoMunicipioIBGE", required = true)
    protected int codigoMunicipioIBGE;

    /**
     * Obtém o valor da propriedade codigoOrgao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoOrgao() {
        return codigoOrgao;
    }

    /**
     * Define o valor da propriedade codigoOrgao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoOrgao(String value) {
        this.codigoOrgao = value;
    }

    /**
     * Obtém o valor da propriedade nomeOrgao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeOrgao() {
        return nomeOrgao;
    }

    /**
     * Define o valor da propriedade nomeOrgao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeOrgao(String value) {
        this.nomeOrgao = value;
    }

    /**
     * Obtém o valor da propriedade instancia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstancia() {
        return instancia;
    }

    /**
     * Define o valor da propriedade instancia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstancia(String value) {
        this.instancia = value;
    }

    /**
     * Obtém o valor da propriedade codigoMunicipioIBGE.
     * 
     */
    public int getCodigoMunicipioIBGE() {
        return codigoMunicipioIBGE;
    }

    /**
     * Define o valor da propriedade codigoMunicipioIBGE.
     * 
     */
    public void setCodigoMunicipioIBGE(int value) {
        this.codigoMunicipioIBGE = value;
    }

}
