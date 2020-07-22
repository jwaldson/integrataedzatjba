
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento que encapsula os dados de resposta relativos à existência de alterações em um processo judicial.
 * 
 * <p>Classe Java de tipoConsultarAlteracaoResposta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConsultarAlteracaoResposta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sucesso" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="hashCabecalho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hashMovimentacoes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hashDocumentos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoConsultarAlteracaoResposta", propOrder = {
    "sucesso",
    "mensagem",
    "hashCabecalho",
    "hashMovimentacoes",
    "hashDocumentos"
})
public class TipoConsultarAlteracaoResposta {

    protected boolean sucesso;
    @XmlElement(required = true)
    protected String mensagem;
    protected String hashCabecalho;
    protected String hashMovimentacoes;
    protected String hashDocumentos;

    /**
     * Obtém o valor da propriedade sucesso.
     * 
     */
    public boolean isSucesso() {
        return sucesso;
    }

    /**
     * Define o valor da propriedade sucesso.
     * 
     */
    public void setSucesso(boolean value) {
        this.sucesso = value;
    }

    /**
     * Obtém o valor da propriedade mensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Define o valor da propriedade mensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Obtém o valor da propriedade hashCabecalho.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashCabecalho() {
        return hashCabecalho;
    }

    /**
     * Define o valor da propriedade hashCabecalho.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashCabecalho(String value) {
        this.hashCabecalho = value;
    }

    /**
     * Obtém o valor da propriedade hashMovimentacoes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashMovimentacoes() {
        return hashMovimentacoes;
    }

    /**
     * Define o valor da propriedade hashMovimentacoes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashMovimentacoes(String value) {
        this.hashMovimentacoes = value;
    }

    /**
     * Obtém o valor da propriedade hashDocumentos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashDocumentos() {
        return hashDocumentos;
    }

    /**
     * Define o valor da propriedade hashDocumentos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashDocumentos(String value) {
        this.hashDocumentos = value;
    }

}
