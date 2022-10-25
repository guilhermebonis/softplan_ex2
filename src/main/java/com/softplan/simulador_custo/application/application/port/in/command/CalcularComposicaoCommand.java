package com.softplan.simulador_custo.application.application.port.in.command;

import com.softplan.simulador_custo.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class CalcularComposicaoCommand extends SelfValidating<CalcularComposicaoCommand> {

    @NotNull
    private final ComposicaoCommand[] composicoes;

    public CalcularComposicaoCommand(ComposicaoCommand[] composicoes) {
        this.composicoes = composicoes;
        this.validateSelf();
    }
}