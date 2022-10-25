package com.softplan.simulador_custo.application.application.port.out;


import com.softplan.simulador_custo.application.composicao.Composicao;

public interface CalcularComposicao {

    Composicao calcular(Composicao.ComposicaoId composicaoId);
}
