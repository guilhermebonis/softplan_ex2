package com.softplan.simulador_custo.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransformarComposicao {

    public TransformarComposicao() {

    }

    public List<Composicao> transformar(JsonComposicao[] json) {

        List<Composicao> composicoes = new ArrayList<>();
        Composicao composicao = null;

        for (JsonComposicao jsonComposicao : json) {
            Optional<Composicao> composicaoLocalizada = localizarComposicao(composicoes, jsonComposicao.codigoComposicao());

            if (composicaoLocalizada.isPresent())
                composicao = composicaoLocalizada.get();
            else {
                composicao = new Composicao();
                composicao.setCodigoComposicao(jsonComposicao.codigoComposicao());
                composicao.setDescricaoComposicao(jsonComposicao.descricaoComposicao());
                composicao.setUnidadeComposicao(jsonComposicao.unidadeComposicao());
                composicoes.add(composicao);
            }

            adicionarInsumo(composicao, jsonComposicao);
        }
        return composicoes;
    }

    private void adicionarInsumo(Composicao composicao, JsonComposicao jsonComposicao) {

        Insumo insumo = new Insumo(
                jsonComposicao.codigoComposicao(),
                jsonComposicao.descricaoComposicao(),
                jsonComposicao.quantidadeComposicao(),
                jsonComposicao.unidadeComposicao(),
                jsonComposicao.valorUnitario(),
                jsonComposicao.codigoItem(),
                jsonComposicao.descricaoItemComposicao(),
                jsonComposicao.tipoItem(),
                jsonComposicao.unidadeItem()
        );

        composicao.getInsumos().add(insumo);
    }

    private Optional<Composicao> localizarComposicao(List<Composicao> composicoes, int codigoComposicao) {
        return composicoes.stream().filter(c -> c.getCodigoComposicao().equals(codigoComposicao)).findFirst();
    }
}
