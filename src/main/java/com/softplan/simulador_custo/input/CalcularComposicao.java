package com.softplan.simulador_custo.input;

import java.util.List;

public class CalcularComposicao {

    public void calcularComposicoes(List<Composicao> composicoes) {
        marcarComposicaoParaCalcular(composicoes);
        calcularInsumoSemComposicao(composicoes);
        calcularInsumoComComposicao(composicoes);
    }

    private void marcarComposicaoParaCalcular(List<Composicao> composicoes) {

        for (Composicao composicao : composicoes) {
            composicao.setValorComposicaoCalculado(
                    !composicao.getInsumos().stream()
                            .filter(i -> i.getTipoItem().equals("COMPOSICAO"))
                            .findAny().isPresent()
            );
        }
    }

    private void calcularInsumoSemComposicao(List<Composicao> composicoes) {
        for (Composicao composicao : composicoes) {
            if(composicao.isValorComposicaoCalculado())
                composicao.setValorComposicao(calcularComposicao(composicao));
        }
    }

    private void calcularInsumoComComposicao(List<Composicao> composicoes) {
        for (Composicao composicao : composicoes) {
            if(!composicao.isValorComposicaoCalculado())
                calcularComposicao(composicao);
        }
    }

    private float calcularComposicao(Composicao composicao) {
        float totalComposicao = 0;

        for (Insumo insumo : composicao.getInsumos()) {
            if (insumo.isValorInsumoCalculado())
                totalComposicao += insumo.getValorInsumo();
            else
                totalComposicao += calcularInsumo(insumo);
        }

        composicao.setValorComposicao(totalComposicao);
        return totalComposicao;
    }

    private float calcularInsumo(Insumo insumo) {

        float valorComposicao = calcularComposicao(insumo.getSubComposicao()) * insumo.getQuantidadeComposicao();
        insumo.setValorInsumoCalculado(true);
        insumo.setValorInsumo(valorComposicao);
        return valorComposicao;
    }
}
