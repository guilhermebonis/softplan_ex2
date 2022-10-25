package com.softplan.simulador_custo.application.application.port.in.command;

public record ComposicaoCommand(int codigoComposicao,
                         String descricaoComposicao,
                         String unidadeComposicao,
                         String tipoItem,
                         int codigoItem,
                         String descricaoItemComposicao,
                         String unidadeItem,
                         String quantidadeComposicao,
                         String valorUnitario) {

}