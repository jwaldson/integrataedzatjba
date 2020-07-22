
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import br.jus.cnj.intercomunicacao_2_2.TipoCabecalhoProcesso;
import br.jus.cnj.intercomunicacao_2_2.TipoDocumento;
import br.jus.cnj.intercomunicacao_2_2.TipoParametro;


/**
 * Tipo de elemento que encapsula os dados da manifesta��o processual que est� sendo apresentada.
 * Quando se tratar de processo em curso, deve ser informado o n�mero do processo para o qual � dirigida a manifesta��o. Caso seja processo origin�rio, devem ser enviados os dados b�sicos do processo para sua autua��o e distribui��o.
 * 
 * <p>Classe Java de tipoEntregarManifestacaoProcessual complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoEntregarManifestacaoProcessual"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idManifestante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="senhaManifestante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="numeroProcesso" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoNumeroUnico"/&gt;
 *           &lt;element name="dadosBasicos" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoCabecalhoProcesso"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="documento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDocumento" maxOccurs="unbounded"/&gt;
 *         &lt;element name="dataEnvio" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDataHora"/&gt;
 *         &lt;element name="parametros" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoParametro" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoEntregarManifestacaoProcessual", propOrder = {
    "idManifestante",
    "senhaManifestante",
    "numeroProcesso",
    "dadosBasicos",
    "documento",
    "dataEnvio",
    "parametros"
})
public class TipoEntregarManifestacaoProcessual {

    protected String idManifestante;
    protected String senhaManifestante;
    protected String numeroProcesso;
    protected TipoCabecalhoProcesso dadosBasicos;
    @XmlElement(required = true)
    protected List<TipoDocumento> documento;
    @XmlElement(required = true)
    protected String dataEnvio;
    protected List<TipoParametro> parametros;

    /**
     * Obt�m o valor da propriedade idManifestante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdManifestante() {
        return idManifestante;
    }

    /**
     * Define o valor da propriedade idManifestante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdManifestante(String value) {
        this.idManifestante = value;
    }

    /**
     * Obt�m o valor da propriedade senhaManifestante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaManifestante() {
        return senhaManifestante;
    }

    /**
     * Define o valor da propriedade senhaManifestante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaManifestante(String value) {
        this.senhaManifestante = value;
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
     * Obt�m o valor da propriedade dadosBasicos.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabecalhoProcesso }
     *     
     */
    public TipoCabecalhoProcesso getDadosBasicos() {
        return dadosBasicos;
    }

    /**
     * Define o valor da propriedade dadosBasicos.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabecalhoProcesso }
     *     
     */
    public void setDadosBasicos(TipoCabecalhoProcesso value) {
        this.dadosBasicos = value;
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
     * {@link TipoDocumento }
     * 
     * 
     */
    public List<TipoDocumento> getDocumento() {
        if (documento == null) {
            documento = new ArrayList<TipoDocumento>();
        }
        return this.documento;
    }

    /**
     * Obt�m o valor da propriedade dataEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEnvio() {
        return dataEnvio;
    }

    /**
     * Define o valor da propriedade dataEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEnvio(String value) {
        this.dataEnvio = value;
    }

    /**
     * Gets the value of the parametros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoParametro }
     * 
     * 
     */
    public List<TipoParametro> getParametros() {
        if (parametros == null) {
            parametros = new ArrayList<TipoParametro>();
        }
        return this.parametros;
    }

}
