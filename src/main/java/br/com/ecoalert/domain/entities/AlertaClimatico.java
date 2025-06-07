package br.com.ecoalert.domain.entities;

import br.com.ecoalert.domain.enums.Gravidade;
import br.com.ecoalert.domain.enums.StatusEvento;
import br.com.ecoalert.domain.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_ALERTA_CLIMATICO")
@SequenceGenerator(name = "alerta", sequenceName = "SEQ_ALERTA_CLIMATICO", allocationSize = 1)
public class AlertaClimatico {

    @Id
    @GeneratedValue(generator = "alerta", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_alerta")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;

    @Enumerated(EnumType.STRING)
    @Column(name = "gravidade")
    private Gravidade gravidade;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "recomendacoes")
    private String recomendacoes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private LocalDateTime dataHoraEmissao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEvento statusEvento;

    public AlertaClimatico() {}

    public AlertaClimatico(TipoEvento tipoEvento, Gravidade gravidade, String localizacao, String latitude, String longitude, String mensagem, String recomendacoes) {
        this.tipoEvento = tipoEvento;
        this.gravidade = gravidade;
        this.localizacao = localizacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mensagem = mensagem;
        this.recomendacoes = recomendacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(Gravidade gravidade) {
        this.gravidade = gravidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public LocalDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public StatusEvento getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(StatusEvento statusEvento) {
        this.statusEvento = statusEvento;
    }
}
