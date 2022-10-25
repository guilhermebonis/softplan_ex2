package com.softplan.simulador_custo.application.application.port.in.usecase;

import com.softplan.simulador_custo.application.application.port.in.command.CalcularComposicaoCommand;

public interface CalcularComposicaoUseCase {
    boolean CalcularComposicao(CalcularComposicaoCommand command);
}