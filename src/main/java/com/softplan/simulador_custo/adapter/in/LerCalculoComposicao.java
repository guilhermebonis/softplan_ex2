package com.softplan.simulador_custo.adapter.in;


import com.softplan.simulador_custo.application.application.port.in.command.CalcularComposicaoCommand;
import com.softplan.simulador_custo.application.application.port.in.command.ComposicaoCommand;
import com.softplan.simulador_custo.application.application.port.in.usecase.CalcularComposicaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LerCalculoComposicao {

    private final CalcularComposicaoUseCase calcularComposicaoUseCase;

    public void ler() {

        LerJsonComposicoes lerJson = new LerJsonComposicoes();

        ComposicaoCommand[] composicoes = lerJson.ler();

        CalcularComposicaoCommand command = new CalcularComposicaoCommand(composicoes);

        calcularComposicaoUseCase.CalcularComposicao(command);
    }
}
