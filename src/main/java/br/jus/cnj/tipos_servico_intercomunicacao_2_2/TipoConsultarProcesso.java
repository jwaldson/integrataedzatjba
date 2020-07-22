
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Elemento destinado a encapsular os parâmetros
 * 				necessários a uma consulta processual.
 * 				A identificação do consultante
 * 				e sua senha são desnecessárias caso
 * 				tenha havido a autenticação e
 * 				autorização por meio de certificado
 * 				cliente.
 * 
 * <p>Classe Java de tipoConsultarProcesso complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConsultarProcesso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idConsultante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="senhaConsultante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroProcesso" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoNumeroUnico"/&gt;
 *         &lt;element name="dataReferencia" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" minOccurs="0"/&gt;
 *         &lt;element name="movimentos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="incluirCabecalho" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;element name="incluirDocumentos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;element name="documento" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoConsultarProcesso", propOrder = {
    "idConsultante",
    "senhaConsultante",
    "numeroProcesso",
    "dataReferencia",
    "movimentos",
    "incluirCabecalho",
    "incluirDocumentos",
    "documento"
})
public class TipoConsultarProcesso {

    @XmlElement(required = true)
    protected String idConsultante;
    @XmlElement(required = true)
    protected String senhaConsultante;
    @XmlElement(required = true)
    protected String numeroProcesso;
    protected String dataReferencia;
    protected Boolean movimentos;
    protected Boolean incluirCabecalho;
    protected Boolean incluirDocumentos;
    protected List<String> documento;

    /**
     * Obtém o valor da propriedade idConsultante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConsultante() {
        return idConsultante;
    }

    /**
     * Define o valor da propriedade idConsultante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConsultante(String value) {
        this.idConsultante = value;
    }

    /**
     * Obtém o valor da propriedade senhaConsultante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaConsultante() {
        return senhaConsultante;
    }

    /**
     * Define o valor da propriedade senhaConsultante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaConsultante(String value) {
        this.senhaConsultante = value;
    }

    /**
     * Obtém o valor da propriedade numeroProcesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    /**
     * Define o valor da propriedade numeroProcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroProcesso(String value) {
        this.numeroProcesso = value;
    }

    /**
     * Obtém o valor da propriedade dataReferencia.
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
     * Obtém o valor da propriedade movimentos.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMovimentos() {
        return movimentos;
    }

    /**
     * Define o valor da propriedade movimentos.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMovimentos(Boolean value) {
        this.movimentos = value;
    }

    /**
     * Obtém o valor da propriedade incluirCabecalho.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncluirCabecalho() {
        return incluirCabecalho;
    }

    /**
     * Define o valor da propriedade incluirCabecalho.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncluirCabecalho(Boolean value) {
        this.incluirCabecalho = value;
    }

    /**
     * Obtém o valor da propriedade incluirDocumentos.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncluirDocumentos() {
        return incluirDocumentos;
    }

    /**
     * Define o valor da propriedade incluirDocumentos.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncluirDocumentos(Boolean value) {
        this.incluirDocumentos = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getDocumento() {
        if (documento == null) {
            documento = new ArrayList<String>();
        }
        return this.documento;
    }

}
