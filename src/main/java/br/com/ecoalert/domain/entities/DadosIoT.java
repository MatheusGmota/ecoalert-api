package br.com.ecoalert.domain.entities;

import br.com.ecoalert.dto.DadosIoTRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DADOS_IOT")
@SequenceGenerator(name = "alerta", sequenceName = "SEQ_ALERTA_CLIMATICO", allocationSize = 1)
public class DadosIoT {

    @Id
    @GeneratedValue(generator = "dados_iot", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_dados_iot")
    private Long id;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "umidade")
    private Double umidade;

    @Column(name = "nivelAguaCm")
    private Double nivelAguaCm;

    @Column(name = "porcentagemNivel")
    private Double porcentagemNivel;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public DadosIoT() {
    }
    // Construtor para facilitar instaciamento a partir do DTO
    public DadosIoT(DadosIoTRequest dto) {
        this.temperatura = dto.getTemperatura();
        this.umidade = dto.getUmidade();
        this.nivelAguaCm = dto.getNivelAguaCm();
        this.porcentagemNivel = dto.getPorcentagemNivel();
        this.localizacao = dto.getLocalizacao();
        this.latitude = dto.getLatitude();
        this.longitude = dto.getLongitude();
    }

    public DadosIoT(Double temperatura, Double umidade, Double nivelAguaCm, Double porcentagemNivel, String localizacao, String latitude, String longitude,LocalDateTime dataHora) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.nivelAguaCm = nivelAguaCm;
        this.porcentagemNivel = porcentagemNivel;
        this.localizacao = localizacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getNivelAguaCm() {
        return nivelAguaCm;
    }

    public void setNivelAguaCm(Double nivelAguaCm) {
        this.nivelAguaCm = nivelAguaCm;
    }

    public Double getPorcentagemNivel() {
        return porcentagemNivel;
    }

    public void setPorcentagemNivel(Double porcentagemNivel) {
        this.porcentagemNivel = porcentagemNivel;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
