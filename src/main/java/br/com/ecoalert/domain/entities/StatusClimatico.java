package br.com.ecoalert.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_STATUS_CLIMATICO")
@SequenceGenerator(name = "status", sequenceName = "SEQ_STATUS_CLIMATICO", allocationSize = 1)
public class StatusClimatico {

    @Id
    @GeneratedValue(generator = "status", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_stats_clim")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "umidade")
    private Double umidade;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "data_hora")
    private LocalDateTime dataHoraAtualizacao;

    public StatusClimatico() {
    }

    public StatusClimatico(String longitude, String latitude, String localizacao, Double umidade, Double temperatura, String descricao) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.localizacao = localizacao;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
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

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }
}