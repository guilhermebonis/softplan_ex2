package com.softplan.simulador_custo.application.application.service;

import com.softplan.simulador_custo.application.application.port.in.command.CalcularComposicaoCommand;
import com.softplan.simulador_custo.application.application.port.in.usecase.CalcularComposicaoUseCase;
import com.softplan.simulador_custo.common.UseCase;
import lombok.RequiredArgsConstructor;

//import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
//@Transactional
public class CalcularComposicaoService implements CalcularComposicaoUseCase {

    @Override
    public boolean CalcularComposicao(CalcularComposicaoCommand command) {
        return false;
    }
}
