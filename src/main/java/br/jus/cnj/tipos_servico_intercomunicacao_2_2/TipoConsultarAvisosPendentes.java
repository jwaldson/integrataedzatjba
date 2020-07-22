
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento que reune o conjunto de dados pertinentes � realiza��o de uma consulta de avisos de comunica��o pendentes.
 * Caso seja omitida a dataInicioConsulta, dever� retornar a lista de todos os avisos pendentes (ou seja, aqueles em rela��o aos quais ainda n�o houve ci�ncia pelo comunicado).
 * Caso j� tenha havido a ci�ncia (por consulta realizada com o uso da opera��o consultarTeorComunicacao ou por decurso do prazo legal de ci�ncia), n�o dever� retornar o aviso.
 * 
 * <p>Classe Java de tipoConsultarAvisosPendentes complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConsultarAvisosPendentes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idRepresentado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idConsultante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="senhaConsultante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataReferencia" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoConsultarAvisosPendentes", propOrder = {
    "idRepresentado",
    "idConsultante",
    "senhaConsultante",
    "dataReferencia"
})
public class TipoConsultarAvisosPendentes {

    protected String idRepresentado;
    protected String idConsultante;
    protected String senhaConsultante;
    protected String dataReferencia;

    /**
     * Obt�m o valor da propriedade idRepresentado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRepresentado() {
        return idRepresentado;
    }

    /**
     * Define o valor da propriedade idRepresentado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRepresentado(String value) {
        this.idRepresentado = value;
    }

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

}
