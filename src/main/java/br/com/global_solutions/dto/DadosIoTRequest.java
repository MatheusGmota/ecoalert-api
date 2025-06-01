package br.com.global_solutions.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DadosIoTRequest {

    @NotNull(message = "O campo temperatura é obrigatorio.")
    private Double temperatura;

    @NotNull(message = "O campo umidade é obrigatorio.")
    private Double umidade;

    @NotNull(message = "O campo nivelAguaCm é obrigatorio.")
    private Double nivelAguaCm;

    @NotNull(message = "O campo porcentagemNivel é obrigatorio.")
    private Double porcentagemNivel;

    @NotBlank(message = "O campo localização é obrigatório.")
    @Size(min = 2, message = "O campo localização tem que ter mais de 2 caracteres.")
    private String localizacao;

    @NotBlank(message = "O campo latitude é obrigatório.")
    @Size(min = 8, max = 10, message = "O campo localização tem que ter 10 caracteres.")
    private String latitude;

    @NotBlank(message = "O campo longitude é obrigatório.")
    private String longitude;

    public DadosIoTRequest() {}

    public DadosIoTRequest(Double temperatura, Double umidade, Double nivelAguaCm, Double porcentagemNivel, String localizacao, String latitude, String longitude) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.nivelAguaCm = nivelAguaCm;
        this.porcentagemNivel = porcentagemNivel;
        this.localizacao = localizacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public Double getNivelAguaCm() {
        return nivelAguaCm;
    }

    public Double getPorcentagemNivel() {
        return porcentagemNivel;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public void setNivelAguaCm(Double nivelAguaCm) {
        this.nivelAguaCm = nivelAguaCm;
    }

    public void setPorcentagemNivel(Double porcentagemNivel) {
        this.porcentagemNivel = porcentagemNivel;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}