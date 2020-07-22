
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir a consulta de teor de comunica��o processual pendente relativa ao consultante em um determinado processo judicial. 
 * Os dados encapsulados s�o o identificador do consultante, sua senha, e o n�mero do processo judicial no qual se est� efetivando a consulta de comunica��o.
 * Os par�metros de identifica��o e senha s�o dispens�veis no caso de autentica��o de certificado cliente.
 * 
 * <p>Classe Java de tipoConsultarTeorComunicacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConsultarTeorComunicacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idConsultante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="senhaConsultante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="numeroProcesso" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoNumeroUnico"/&gt;
 *           &lt;element name="identificadorAviso" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}identificadorComunicacao"/&gt;
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
@XmlType(name = "tipoConsultarTeorComunicacao", propOrder = {
    "idConsultante",
    "senhaConsultante",
    "numeroProcesso",
    "identificadorAviso"
})
public class TipoConsultarTeorComunicacao {

    protected String idConsultante;
    protected String senhaConsultante;
    protected String numeroProcesso;
    protected String identificadorAviso;

    /**
     * Obt�m o valor da propriedade idConsultante.
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
     * Obt�m o valor da propriedade senhaConsultante.
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
     * Obt�m o valor da propriedade numeroProcesso.
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
     * Obt�m o valor da propriedade identificadorAviso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorAviso() {
        return identificadorAviso;
    }

    /**
     * Define o valor da propriedade identificadorAviso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorAviso(String value) {
        this.identificadorAviso = value;
    }

}
