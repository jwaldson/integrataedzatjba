
package br.jus.cnj.servico_intercomunicacao_2_2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConfirmarRecebimento;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConfirmarRecebimentoResposta;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarAlteracao;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarAlteracaoResposta;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarAvisosPendentes;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarAvisosPendentesResposta;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarProcesso;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarProcessoResposta;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarTeorComunicacao;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoConsultarTeorComunicacaoResposta;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoEntregarManifestacaoProcessual;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoEntregarManifestacaoProcessualResposta;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.jus.cnj.servico_intercomunicacao_2_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarAvisosPendentes_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarAvisosPendentes");
    private final static QName _ConsultarAvisosPendentesResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarAvisosPendentesResposta");
    private final static QName _ConsultarTeorComunicacao_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarTeorComunicacao");
    private final static QName _ConsultarTeorComunicacaoResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarTeorComunicacaoResposta");
    private final static QName _ConsultarProcesso_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarProcesso");
    private final static QName _ConsultarProcessoResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarProcessoResposta");
    private final static QName _EntregarManifestacaoProcessual_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "entregarManifestacaoProcessual");
    private final static QName _EntregarManifestacaoProcessualResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "entregarManifestacaoProcessualResposta");
    private final static QName _ConsultarAlteracao_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarAlteracao");
    private final static QName _ConsultarAlteracaoResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "consultarAlteracaoResposta");
    private final static QName _ConfirmarRecebimento_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "confirmarRecebimento");
    private final static QName _ConfirmarRecebimentoResposta_QNAME = new QName("http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", "confirmarRecebimentoResposta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.jus.cnj.servico_intercomunicacao_2_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarAvisosPendentes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarAvisosPendentes }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarAvisosPendentes")
    public JAXBElement<TipoConsultarAvisosPendentes> createConsultarAvisosPendentes(TipoConsultarAvisosPendentes value) {
        return new JAXBElement<TipoConsultarAvisosPendentes>(_ConsultarAvisosPendentes_QNAME, TipoConsultarAvisosPendentes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarAvisosPendentesResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarAvisosPendentesResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarAvisosPendentesResposta")
    public JAXBElement<TipoConsultarAvisosPendentesResposta> createConsultarAvisosPendentesResposta(TipoConsultarAvisosPendentesResposta value) {
        return new JAXBElement<TipoConsultarAvisosPendentesResposta>(_ConsultarAvisosPendentesResposta_QNAME, TipoConsultarAvisosPendentesResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarTeorComunicacao }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarTeorComunicacao }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarTeorComunicacao")
    public JAXBElement<TipoConsultarTeorComunicacao> createConsultarTeorComunicacao(TipoConsultarTeorComunicacao value) {
        return new JAXBElement<TipoConsultarTeorComunicacao>(_ConsultarTeorComunicacao_QNAME, TipoConsultarTeorComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarTeorComunicacaoResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarTeorComunicacaoResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarTeorComunicacaoResposta")
    public JAXBElement<TipoConsultarTeorComunicacaoResposta> createConsultarTeorComunicacaoResposta(TipoConsultarTeorComunicacaoResposta value) {
        return new JAXBElement<TipoConsultarTeorComunicacaoResposta>(_ConsultarTeorComunicacaoResposta_QNAME, TipoConsultarTeorComunicacaoResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarProcesso }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarProcesso }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarProcesso")
    public JAXBElement<TipoConsultarProcesso> createConsultarProcesso(TipoConsultarProcesso value) {
        return new JAXBElement<TipoConsultarProcesso>(_ConsultarProcesso_QNAME, TipoConsultarProcesso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarProcessoResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarProcessoResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarProcessoResposta")
    public JAXBElement<TipoConsultarProcessoResposta> createConsultarProcessoResposta(TipoConsultarProcessoResposta value) {
        return new JAXBElement<TipoConsultarProcessoResposta>(_ConsultarProcessoResposta_QNAME, TipoConsultarProcessoResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEntregarManifestacaoProcessual }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoEntregarManifestacaoProcessual }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "entregarManifestacaoProcessual")
    public JAXBElement<TipoEntregarManifestacaoProcessual> createEntregarManifestacaoProcessual(TipoEntregarManifestacaoProcessual value) {
        return new JAXBElement<TipoEntregarManifestacaoProcessual>(_EntregarManifestacaoProcessual_QNAME, TipoEntregarManifestacaoProcessual.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoEntregarManifestacaoProcessualResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoEntregarManifestacaoProcessualResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "entregarManifestacaoProcessualResposta")
    public JAXBElement<TipoEntregarManifestacaoProcessualResposta> createEntregarManifestacaoProcessualResposta(TipoEntregarManifestacaoProcessualResposta value) {
        return new JAXBElement<TipoEntregarManifestacaoProcessualResposta>(_EntregarManifestacaoProcessualResposta_QNAME, TipoEntregarManifestacaoProcessualResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarAlteracao }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarAlteracao }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarAlteracao")
    public JAXBElement<TipoConsultarAlteracao> createConsultarAlteracao(TipoConsultarAlteracao value) {
        return new JAXBElement<TipoConsultarAlteracao>(_ConsultarAlteracao_QNAME, TipoConsultarAlteracao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConsultarAlteracaoResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConsultarAlteracaoResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "consultarAlteracaoResposta")
    public JAXBElement<TipoConsultarAlteracaoResposta> createConsultarAlteracaoResposta(TipoConsultarAlteracaoResposta value) {
        return new JAXBElement<TipoConsultarAlteracaoResposta>(_ConsultarAlteracaoResposta_QNAME, TipoConsultarAlteracaoResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConfirmarRecebimento }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConfirmarRecebimento }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "confirmarRecebimento")
    public JAXBElement<TipoConfirmarRecebimento> createConfirmarRecebimento(TipoConfirmarRecebimento value) {
        return new JAXBElement<TipoConfirmarRecebimento>(_ConfirmarRecebimento_QNAME, TipoConfirmarRecebimento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoConfirmarRecebimentoResposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoConfirmarRecebimentoResposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.cnj.jus.br/servico-intercomunicacao-2.2.2/", name = "confirmarRecebimentoResposta")
    public JAXBElement<TipoConfirmarRecebimentoResposta> createConfirmarRecebimentoResposta(TipoConfirmarRecebimentoResposta value) {
        return new JAXBElement<TipoConfirmarRecebimentoResposta>(_ConfirmarRecebimentoResposta_QNAME, TipoConfirmarRecebimentoResposta.class, null, value);
    }

}
