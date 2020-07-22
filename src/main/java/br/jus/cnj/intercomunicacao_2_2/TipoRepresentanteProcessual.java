
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir a identifica��o
 * 				de
 * 				um advogado inscrito na Ordem dos Advogados do Brasil,
 * 				de um
 * 				escrit�rio de advocacia inscrito ou de um �rg�o de
 * 				representa��o
 * 				processual (advocacia p�blica, MP e
 * 				defensoria p�blica).
 * 
 * <p>Classe Java de tipoRepresentanteProcessual complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoRepresentanteProcessual"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endereco" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoEndereco" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nome" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="inscricao" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoCadastroOAB" /&gt;
 *       &lt;attribute name="numeroDocumentoPrincipal" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="intimacao" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="tipoRepresentante" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}modalidadeRepresentanteProcessual" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoRepresentanteProcessual", propOrder = {
    "endereco"
})
public class TipoRepresentanteProcessual {

    protected List<TipoEndereco> endereco;
    @XmlAttribute(name = "nome", required = true)
    protected String nome;
    @XmlAttribute(name = "inscricao")
    protected String inscricao;
    @XmlAttribute(name = "numeroDocumentoPrincipal")
    protected String numeroDocumentoPrincipal;
    @XmlAttribute(name = "intimacao", required = true)
    protected boolean intimacao;
    @XmlAttribute(name = "tipoRepresentante", required = true)
    protected ModalidadeRepresentanteProcessual tipoRepresentante;

    /**
     * Gets the value of the endereco property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endereco property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndereco().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoEndereco }
     * 
     * 
     */
    public List<TipoEndereco> getEndereco() {
        if (endereco == null) {
            endereco = new ArrayList<TipoEndereco>();
        }
        return this.endereco;
    }

    /**
     * Obt�m o valor da propriedade nome.
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

    /**
     * Obt�m o valor da propriedade inscricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscricao() {
        return inscricao;
    }

    /**
     * Define o valor da propriedade inscricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscricao(String value) {
        this.inscricao = value;
    }

    /**
     * Obt�m o valor da propriedade numeroDocumentoPrincipal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoPrincipal() {
        return numeroDocumentoPrincipal;
    }

    /**
     * Define o valor da propriedade numeroDocumentoPrincipal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoPrincipal(String value) {
        this.numeroDocumentoPrincipal = value;
    }

    /**
     * Obt�m o valor da propriedade intimacao.
     * 
     */
    public boolean isIntimacao() {
        return intimacao;
    }

    /**
     * Define o valor da propriedade intimacao.
     * 
     */
    public void setIntimacao(boolean value) {
        this.intimacao = value;
    }

    /**
     * Obt�m o valor da propriedade tipoRepresentante.
     * 
     * @return
     *     possible object is
     *     {@link ModalidadeRepresentanteProcessual }
     *     
     */
    public ModalidadeRepresentanteProcessual getTipoRepresentante() {
        return tipoRepresentante;
    }

    /**
     * Define o valor da propriedade tipoRepresentante.
     * 
     * @param value
     *     allowed object is
     *     {@link ModalidadeRepresentanteProcessual }
     *     
     */
    public void setTipoRepresentante(ModalidadeRepresentanteProcessual value) {
        this.tipoRepresentante = value;
    }

}
