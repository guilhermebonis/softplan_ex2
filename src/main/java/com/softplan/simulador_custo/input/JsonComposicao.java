package com.softplan.simulador_custo.input;

public record JsonComposicao(int codigoComposicao,
                             String descricaoComposicao,
                             String unidadeComposicao,
                             String tipoItem,
                             int codigoItem,
                             String descricaoItemComposicao,
                             String unidadeItem,
                             String quantidadeComposicao,
                             String valorUnitario) {

}
