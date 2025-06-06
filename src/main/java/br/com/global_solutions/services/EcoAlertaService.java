package br.com.global_solutions.services;

import br.com.global_solutions.domain.entities.AlertaClimatico;
import br.com.global_solutions.domain.entities.DadosIoT;
import br.com.global_solutions.domain.entities.LimiarClimatico;
import br.com.global_solutions.domain.entities.StatusClimatico;
import br.com.global_solutions.domain.enums.Gravidade;
import br.com.global_solutions.domain.enums.StatusEvento;
import br.com.global_solutions.domain.enums.TipoEvento;
import br.com.global_solutions.dto.DadosIoTRequest;
import br.com.global_solutions.repositories.AlertaClimaticoRepository;
import br.com.global_solutions.repositories.DadosIoTRepository;
import br.com.global_solutions.repositories.LimiarClimaticoRepository;
import br.com.global_solutions.repositories.StatusClimaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EcoAlertaService {

    public List<LimiarClimatico> limiares;

    @Autowired
    private DadosIoTRepository dadosIoTRepository;

    @Autowired
    private AlertaClimaticoRepository alertaClimaticoRepository;

    @Autowired
    private StatusClimaticoRepository statusClimaticoRepository;

    @Autowired
    private LimiarClimaticoRepository limiarClimaticoRepository;

    public void processarDados(DadosIoTRequest request) {
        this.limiares = limiarClimaticoRepository.findAll();
        DadosIoT dadosIoT = new DadosIoT(request);
        dadosIoT.setDataHora(LocalDateTime.now());
        dadosIoTRepository.save(dadosIoT);

        StatusClimatico statusClimatico = new StatusClimatico();
        statusClimatico.setDataHoraAtualizacao(LocalDateTime.now());
        statusClimatico.setDescricao("");
        statusClimatico.setLatitude(dadosIoT.getLatitude());
        statusClimatico.setLongitude(dadosIoT.getLongitude());
        statusClimatico.setTemperatura(dadosIoT.getTemperatura());
        statusClimatico.setUmidade(dadosIoT.getUmidade());
        statusClimatico.setLocalizacao(dadosIoT.getLocalizacao());

        verificarAlertas(dadosIoT);

        statusClimaticoRepository.save(statusClimatico);
    }

    public AlertaClimatico obterAlertaClimatico(String localizacao) {
        return alertaClimaticoRepository.findFirstByLocalizacaoAndStatusEventoOrderByDataHoraEmissaoDesc(localizacao, StatusEvento.ATIVO).orElse(null);
    }

    public StatusClimatico obterStatusClimatico(String localizacao) {
        return statusClimaticoRepository.findFirstByLocalizacaoOrderByDataHoraAtualizacaoDesc(localizacao).orElse(null);
    }

    public List<AlertaClimatico> obterHistoricoAlerta(String localizacao) {
        return alertaClimaticoRepository.findByLocalizacaoOrderByDataHoraEmissaoDesc(localizacao);
    }

    private void verificarAlertas(DadosIoT dadosIoT) {
        for (LimiarClimatico limiar : limiares) {
            double valorSensor = obterValorSensor(dadosIoT, limiar.getParametroSensor());

            TipoEvento tipoEvento = mapearTipoEvento(limiar.getParametroSensor());

            if (valorSensor <= limiar.getValorMin()) {
                AlertaClimatico alertaMin = new AlertaClimatico();
                alertaMin.setDataHoraEmissao(LocalDateTime.now());
                alertaMin.setGravidade(Gravidade.ALTA);
                alertaMin.setLongitude(dadosIoT.getLongitude());
                alertaMin.setLatitude(dadosIoT.getLatitude());
                alertaMin.setLocalizacao(dadosIoT.getLocalizacao());
                alertaMin.setStatusEvento(StatusEvento.ATIVO);
                alertaMin.setRecomendacoes(limiar.getRecomendacaoAlerta());
                alertaMin.setMensagem(limiar.getMsgMin());
                alertaMin.setTipoEvento(tipoEvento);
                alertaClimaticoRepository.save(alertaMin);

            } else if (valorSensor > limiar.getValorMax()) {
                AlertaClimatico alertaMax = new AlertaClimatico();
                alertaMax.setDataHoraEmissao(LocalDateTime.now());
                alertaMax.setGravidade(Gravidade.ALTA);
                alertaMax.setLongitude(dadosIoT.getLongitude());
                alertaMax.setLatitude(dadosIoT.getLatitude());
                alertaMax.setLocalizacao(dadosIoT.getLocalizacao());
                alertaMax.setStatusEvento(StatusEvento.ATIVO);
                alertaMax.setRecomendacoes(limiar.getRecomendacaoAlerta());
                alertaMax.setMensagem(limiar.getMsgMax());
                alertaMax.setTipoEvento(tipoEvento);
                alertaClimaticoRepository.save(alertaMax);
            }
        }
    }

    private TipoEvento mapearTipoEvento(String parametroSensor) {
        return switch (parametroSensor.toLowerCase()) {
            case "umidade" -> TipoEvento.BAIXA_UMIDADE;
            case "temperatura" -> TipoEvento.ONDA_CALOR;
            case "nivelagua" -> TipoEvento.INUNDACAO_CRITICA;
            case "porcentagemnivel" -> TipoEvento.PRE_INUNDACAO;
            case "vento" -> TipoEvento.VENTO_FORTE;
            case "chuva" -> TipoEvento.CHUVA_FORTE;
            case "tremor" -> TipoEvento.TREMOR_TERRA;
            case "incendio" -> TipoEvento.INCENDIO;
            default -> TipoEvento.INCENDIO; // fallback ou pode lançar exceção se preferir
        };
    }


    private double obterValorSensor(DadosIoT dados, String parametro) {
        return switch (parametro.toLowerCase()) {
            case "temperatura" -> dados.getTemperatura();
            case "umidade" -> dados.getUmidade();
            case "nivelagua" -> dados.getNivelAguaCm();
            case "porcentagemnivel" -> dados.getPorcentagemNivel();
            default -> 0;
        };
    }
}