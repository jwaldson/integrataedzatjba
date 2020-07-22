
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo destinado a permitir a criação de documentos
 * 				identificadores de uma determinada pessoa.
 * 
 * <p>Classe Java de tipoDocumentoIdentificacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoDocumentoIdentificacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="codigoDocumento" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="emissorDocumento" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tipoDocumento" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}modalidadeDocumentoIdentificador" /&gt;
 *       &lt;attribute name="nome" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoDocumentoIdentificacao")
public class TipoDocumentoIdentificacao {

    @XmlAttribute(name = "codigoDocumento", required = true)
    protected String codigoDocumento;
    @XmlAttribute(name = "emissorDocumento", required = true)
    protected String emissorDocumento;
    @XmlAttribute(name = "tipoDocumento", required = true)
    protected ModalidadeDocumentoIdentificador tipoDocumento;
    @XmlAttribute(name = "nome")
    protected String nome;

    /**
     * Obtém o valor da propriedade codigoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    /**
     * Define o valor da propriedade codigoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDocumento(String value) {
        this.codigoDocumento = value;
    }

    /**
     * Obtém o valor da propriedade emissorDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmissorDocumento() {
        return emissorDocumento;
    }

    /**
     * Define o valor da propriedade emissorDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmissorDocumento(String value) {
        this.emissorDocumento = value;
    }

    /**
     * Obtém o valor da propriedade tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link ModalidadeDocumentoIdentificador }
     *     
     */
    public ModalidadeDocumentoIdentificador getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define o valor da propriedade tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link ModalidadeDocumentoIdentificador }
     *     
     */
    public void setTipoDocumento(ModalidadeDocumentoIdentificador value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

}
