
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento destinado a permitir a
 * 				individualiza��o
 * 				de uma pessoa f�sica ou jur�dica.
 * 
 * <p>Classe Java de tipoPessoa complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoPessoa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outroNome" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="documento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDocumentoIdentificacao" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="endereco" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoEndereco" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="pessoaRelacionada" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoRelacionamentoPessoal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="pessoaVinculada" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoPessoa" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nome" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="sexo" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}modalidadeGeneroPessoa" /&gt;
 *       &lt;attribute name="nomeGenitor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nomeGenitora" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataNascimento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoData" /&gt;
 *       &lt;attribute name="dataObito" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoData" /&gt;
 *       &lt;attribute name="numeroDocumentoPrincipal" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoCadastroIdentificador" /&gt;
 *       &lt;attribute name="tipoPessoa" use="required" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoQualificacaoPessoa" /&gt;
 *       &lt;attribute name="cidadeNatural" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="estadoNatural"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[A-Za-z]{2}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="nacionalidade" default="BR"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[A-Za-z]{2}"/&gt;
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
@XmlType(name = "tipoPessoa", propOrder = {
    "outroNome",
    "documento",
    "endereco",
    "pessoaRelacionada",
    "pessoaVinculada"
})
public class TipoPessoa {

    protected List<String> outroNome;
    protected List<TipoDocumentoIdentificacao> documento;
    protected List<TipoEndereco> endereco;
    @XmlElement(nillable = true)
    protected List<TipoRelacionamentoPessoal> pessoaRelacionada;
    protected TipoPessoa pessoaVinculada;
    @XmlAttribute(name = "nome", required = true)
    protected String nome;
    @XmlAttribute(name = "sexo", required = true)
    protected ModalidadeGeneroPessoa sexo;
    @XmlAttribute(name = "nomeGenitor")
    protected String nomeGenitor;
    @XmlAttribute(name = "nomeGenitora")
    protected String nomeGenitora;
    @XmlAttribute(name = "dataNascimento")
    protected String dataNascimento;
    @XmlAttribute(name = "dataObito")
    protected String dataObito;
    @XmlAttribute(name = "numeroDocumentoPrincipal")
    protected String numeroDocumentoPrincipal;
    @XmlAttribute(name = "tipoPessoa", required = true)
    protected TipoQualificacaoPessoa tipoPessoa;
    @XmlAttribute(name = "cidadeNatural")
    protected String cidadeNatural;
    @XmlAttribute(name = "estadoNatural")
    protected String estadoNatural;
    @XmlAttribute(name = "nacionalidade")
    protected String nacionalidade;

    /**
     * Gets the value of the outroNome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outroNome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutroNome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutroNome() {
        if (outroNome == null) {
            outroNome = new ArrayList<String>();
        }
        return this.outroNome;
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
     * {@link TipoDocumentoIdentificacao }
     * 
     * 
     */
    public List<TipoDocumentoIdentificacao> getDocumento() {
        if (documento == null) {
            documento = new ArrayList<TipoDocumentoIdentificacao>();
        }
        return this.documento;
    }

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
     * Gets the value of the pessoaRelacionada property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pessoaRelacionada property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPessoaRelacionada().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoRelacionamentoPessoal }
     * 
     * 
     */
    public List<TipoRelacionamentoPessoal> getPessoaRelacionada() {
        if (pessoaRelacionada == null) {
            pessoaRelacionada = new ArrayList<TipoRelacionamentoPessoal>();
        }
        return this.pessoaRelacionada;
    }

    /**
     * Obt�m o valor da propriedade pessoaVinculada.
     * 
     * @return
     *     possible object is
     *     {@link TipoPessoa }
     *     
     */
    public TipoPessoa getPessoaVinculada() {
        return pessoaVinculada;
    }

    /**
     * Define o valor da propriedade pessoaVinculada.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoPessoa }
     *     
     */
    public void setPessoaVinculada(TipoPessoa value) {
        this.pessoaVinculada = value;
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
     * Obt�m o valor da propriedade sexo.
     * 
     * @return
     *     possible object is
     *     {@link ModalidadeGeneroPessoa }
     *     
     */
    public ModalidadeGeneroPessoa getSexo() {
        return sexo;
    }

    /**
     * Define o valor da propriedade sexo.
     * 
     * @param value
     *     allowed object is
     *     {@link ModalidadeGeneroPessoa }
     *     
     */
    public void setSexo(ModalidadeGeneroPessoa value) {
        this.sexo = value;
    }

    /**
     * Obt�m o valor da propriedade nomeGenitor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeGenitor() {
        return nomeGenitor;
    }

    /**
     * Define o valor da propriedade nomeGenitor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeGenitor(String value) {
        this.nomeGenitor = value;
    }

    /**
     * Obt�m o valor da propriedade nomeGenitora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeGenitora() {
        return nomeGenitora;
    }

    /**
     * Define o valor da propriedade nomeGenitora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeGenitora(String value) {
        this.nomeGenitora = value;
    }

    /**
     * Obt�m o valor da propriedade dataNascimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define o valor da propriedade dataNascimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascimento(String value) {
        this.dataNascimento = value;
    }

    /**
     * Obt�m o valor da propriedade dataObito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataObito() {
        return dataObito;
    }

    /**
     * Define o valor da propriedade dataObito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataObito(String value) {
        this.dataObito = value;
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
     * Obt�m o valor da propriedade tipoPessoa.
     * 
     * @return
     *     possible object is
     *     {@link TipoQualificacaoPessoa }
     *     
     */
    public TipoQualificacaoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * Define o valor da propriedade tipoPessoa.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoQualificacaoPessoa }
     *     
     */
    public void setTipoPessoa(TipoQualificacaoPessoa value) {
        this.tipoPessoa = value;
    }

    /**
     * Obt�m o valor da propriedade cidadeNatural.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidadeNatural() {
        return cidadeNatural;
    }

    /**
     * Define o valor da propriedade cidadeNatural.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidadeNatural(String value) {
        this.cidadeNatural = value;
    }

    /**
     * Obt�m o valor da propriedade estadoNatural.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNatural() {
        return estadoNatural;
    }

    /**
     * Define o valor da propriedade estadoNatural.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNatural(String value) {
        this.estadoNatural = value;
    }

    /**
     * Obt�m o valor da propriedade nacionalidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidade() {
        if (nacionalidade == null) {
            return "BR";
        } else {
            return nacionalidade;
        }
    }

    /**
     * Define o valor da propriedade nacionalidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidade(String value) {
        this.nacionalidade = value;
    }

}
