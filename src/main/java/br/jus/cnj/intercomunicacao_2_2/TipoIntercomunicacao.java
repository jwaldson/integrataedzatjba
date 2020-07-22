
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento raiz da intercomunicação. Ele deverá
 * 				conter um dos elementos principais (processojudicial,
 * 				avisocomunicacao e comunicacaoprocessual).
 * 
 * <p>Classe Java de tipoIntercomunicacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoIntercomunicacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="processojudicial" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoProcessoJudicial" maxOccurs="unbounded"/&gt;
 *         &lt;element name="avisocomunicacao" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoAvisoComunicacaoPendente" maxOccurs="unbounded"/&gt;
 *         &lt;element name="comunicacaoprocessual" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoComunicacaoProcessual" maxOccurs="unbounded"/&gt;
 *         &lt;element name="documento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoDocumento" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoIntercomunicacao", propOrder = {
    "processojudicial",
    "avisocomunicacao",
    "comunicacaoprocessual",
    "documento"
})
public class TipoIntercomunicacao {

    protected List<TipoProcessoJudicial> processojudicial;
    protected List<TipoAvisoComunicacaoPendente> avisocomunicacao;
    protected List<TipoComunicacaoProcessual> comunicacaoprocessual;
    protected List<TipoDocumento> documento;

    /**
     * Gets the value of the processojudicial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processojudicial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessojudicial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoProcessoJudicial }
     * 
     * 
     */
    public List<TipoProcessoJudicial> getProcessojudicial() {
        if (processojudicial == null) {
            processojudicial = new ArrayList<TipoProcessoJudicial>();
        }
        return this.processojudicial;
    }

    /**
     * Gets the value of the avisocomunicacao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avisocomunicacao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvisocomunicacao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoAvisoComunicacaoPendente }
     * 
     * 
     */
    public List<TipoAvisoComunicacaoPendente> getAvisocomunicacao() {
        if (avisocomunicacao == null) {
            avisocomunicacao = new ArrayList<TipoAvisoComunicacaoPendente>();
        }
        return this.avisocomunicacao;
    }

    /**
     * Gets the value of the comunicacaoprocessual property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comunicacaoprocessual property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComunicacaoprocessual().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoComunicacaoProcessual }
     * 
     * 
     */
    public List<TipoComunicacaoProcessual> getComunicacaoprocessual() {
        if (comunicacaoprocessual == null) {
            comunicacaoprocessual = new ArrayList<TipoComunicacaoProcessual>();
        }
        return this.comunicacaoprocessual;
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

}
