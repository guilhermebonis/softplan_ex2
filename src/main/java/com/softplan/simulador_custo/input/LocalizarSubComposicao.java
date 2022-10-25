package com.softplan.simulador_custo.input;

import java.util.List;
import java.util.Optional;

public class LocalizarSubComposicao {

    public void preencherSubComposicoes(List<Composicao> composicoes) {
        for (Composicao composicao: composicoes) {
            for (Insumo insumo: composicao.getInsumos()) {
                if (insumo.getTipoItem().equals("COMPOSICAO")) {
                    Optional<Composicao> composicaoLocalizada = localizarComposicao(composicoes, insumo.getCodigoItem());
                    if (composicaoLocalizada.isPresent())
                        insumo.setSubComposicao(composicaoLocalizada.get());
                }
            }
        }
    }

    private Optional<Composicao> localizarComposicao(List<Composicao> composicoes, int codigoComposicao) {
        return composicoes.stream().filter(c -> c.getCodigoComposicao().equals(codigoComposicao)).findFirst();
    }
}
