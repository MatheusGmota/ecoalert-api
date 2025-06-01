package br.com.global_solutions.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LIMIAR_CLIMATICO")
@SequenceGenerator(name = "limiar", sequenceName = "SEQ_LIMIAR_CLIMATICO", allocationSize = 1)
public class LimiarClimatico {

    @Id
    @GeneratedValue(generator = "limiar", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_limiar")
    private Long id;

    @Column(name = "parametro_sensor")
    private String parametroSensor;

    @Column(name = "valor_max")
    private Double valorMax;

    @Column(name = "valor_min")
    private Double valorMin;

    @Column(name = "msg_max")
    private Double msgMax;

    @Column(name = "msg_min")
    private Double msgMin;

    @Column(name = "mensagem_alerta")
    private String mensagemAlerta;

    @Column(name = "recomendacao_alerta")
    private String recomendacaoAlerta;

    public LimiarClimatico() {
    }

    public LimiarClimatico(String parametroSensor, Double valorMax, Double valorMin, Double msgMax, Double msgMin, String mensagemAlerta, String recomendacaoAlerta) {
        this.parametroSensor = parametroSensor;
        this.valorMax = valorMax;
        this.valorMin = valorMin;
        this.msgMax = msgMax;
        this.msgMin = msgMin;
        this.mensagemAlerta = mensagemAlerta;
        this.recomendacaoAlerta = recomendacaoAlerta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametroSensor() {
        return parametroSensor;
    }

    public void setParametroSensor(String parametroSensor) {
        this.parametroSensor = parametroSensor;
    }

    public Double getValorMax() {
        return valorMax;
    }

    public void setValorMax(Double valorMax) {
        this.valorMax = valorMax;
    }

    public Double getValorMin() {
        return valorMin;
    }

    public void setValorMin(Double valorMin) {
        this.valorMin = valorMin;
    }

    public Double getMsgMax() {
        return msgMax;
    }

    public void setMsgMax(Double msgMax) {
        this.msgMax = msgMax;
    }

    public Double getMsgMin() {
        return msgMin;
    }

    public void setMsgMin(Double msgMin) {
        this.msgMin = msgMin;
    }

    public String getMensagemAlerta() {
        return mensagemAlerta;
    }

    public void setMensagemAlerta(String mensagemAlerta) {
        this.mensagemAlerta = mensagemAlerta;
    }

    public String getRecomendacaoAlerta() {
        return recomendacaoAlerta;
    }

    public void setRecomendacaoAlerta(String recomendacaoAlerta) {
        this.recomendacaoAlerta = recomendacaoAlerta;
    }
}
