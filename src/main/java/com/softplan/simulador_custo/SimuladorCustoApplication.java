package com.softplan.simulador_custo;

import com.softplan.simulador_custo.adapter.in.LerCalculoComposicao;
import com.softplan.simulador_custo.application.application.service.CalcularComposicaoService;
import com.softplan.simulador_custo.input.*;
import com.softplan.simulador_custo.output.EscreverValorComposicao;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SimuladorCustoApplication {

    public static void main(String[] args) {
        CalcularComposicaoService calcularComposicaoService = new CalcularComposicaoService();
        LerCalculoComposicao lerCalculoComposicao = new LerCalculoComposicao(calcularComposicaoService);
        lerCalculoComposicao.ler();

       // extracted();
    }

    private static void extracted() {
        LerComposicoes ler = new LerComposicoes();

        JsonComposicao[] jsonComposicoes = ler.ler();

        TransformarComposicao transformarComposicao = new TransformarComposicao();
        List<Composicao> composicoes = transformarComposicao.transformar(jsonComposicoes);

        LocalizarSubComposicao localizarSubComposicao = new LocalizarSubComposicao();
        localizarSubComposicao.preencherSubComposicoes(composicoes);

        CalcularComposicao calcularComposicao = new CalcularComposicao();
        calcularComposicao.calcularComposicoes(composicoes);

        EscreverValorComposicao escreverValorComposicao = new EscreverValorComposicao();
        escreverValorComposicao.escrever(composicoes);
    }

}
