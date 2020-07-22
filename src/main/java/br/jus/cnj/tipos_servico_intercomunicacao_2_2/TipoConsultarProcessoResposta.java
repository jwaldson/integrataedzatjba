
package br.jus.cnj.tipos_servico_intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import br.jus.cnj.intercomunicacao_2_2.TipoProcessoJudicial;


/**
 * Tipo de elemento que encapsula os dados de resposta relativos a uma consulta de processo judicial. Retorna indicativo do sucesso da operação, mensagem a seu respeito e zero ou um elemento do tipo 'tipoProcessoJudicial', definido no namespace http://www.cnj.jus.br/intercomunicao-2.2.2, contendo o processo consultado.
 * Os elementos documentos do elemento processo poderão encerrar apenas binários encriptados cuja chave será fornecida na consultaTeorComunicacao, caso haja intimação pendente para o documento transferido.
 * 
 * <p>Classe Java de tipoConsultarProcessoResposta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoConsultarProcessoResposta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sucesso" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="processo" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoProcessoJudicial" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoConsultarProcessoResposta", propOrder = {
    "sucesso",
    "mensagem",
    "processo"
})
public class TipoConsultarProcessoResposta {

    protected boolean sucesso;
    @XmlElement(required = true)
    protected String mensagem;
    protected TipoProcessoJudicial processo;

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
     * Obtém o valor da propriedade processo.
     * 
     * @return
     *     possible object is
     *     {@link TipoProcessoJudicial }
     *     
     */
    public TipoProcessoJudicial getProcesso() {
        return processo;
    }

    /**
     * Define o valor da propriedade processo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProcessoJudicial }
     *     
     */
    public void setProcesso(TipoProcessoJudicial value) {
        this.processo = value;
    }

}
