package br.com.global_solutions.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_DADOS_IOT")
@SequenceGenerator(name = "alerta", sequenceName = "SEQ_ALERTA_CLIMATICO", allocationSize = 1)
public class DadosIoT {

    @Id
    @GeneratedValue(generator = "dados_iot", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_dados_iot")
    private Long id;

    private Double temperatura;

    private Double umidade;

    private Double nivelAguaCm;

    private Double porcentagemNivel;

    private String localizacao;

    private String latitude;

    private String longitude;

    public DadosIoT(Double temperatura, Double umidade, Double nivelAguaCm, Double porcentagemNivel, String localizacao, String latitude, String longitude) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.nivelAguaCm = nivelAguaCm;
        this.porcentagemNivel = porcentagemNivel;
        this.localizacao = localizacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
