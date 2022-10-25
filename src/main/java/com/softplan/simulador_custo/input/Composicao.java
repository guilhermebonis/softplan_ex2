package com.softplan.simulador_custo.input;

import java.util.ArrayList;
import java.util.List;

public class Composicao {

    private List<Insumo> insumos;
    private Integer codigoComposicao;
    private float valorComposicao;
    private boolean valorComposicaoCalculado;


    public Composicao() {
        this.insumos = new ArrayList<>();
        this.setValorComposicaoCalculado(true);
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public Integer getCodigoComposicao() {
        return codigoComposicao;
    }

    public void setCodigoComposicao(Integer codigoComposicao) {
        this.codigoComposicao = codigoComposicao;
    }

    public float getValorComposicao() {
        return valorComposicao;
    }

    private String descricaoComposicao;

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public void setValorComposicao(float valorComposicao) {
        this.valorComposicao = valorComposicao;
    }

    private String unidadeComposicao;

    public boolean isValorComposicaoCalculado() {
        return valorComposicaoCalculado;
    }

    public void setValorComposicaoCalculado(boolean valorComposicaoCalculado) {
        this.valorComposicaoCalculado = valorComposicaoCalculado;
    }

    public void setDescricaoComposicao(String descricaoComposicao) {
        this.descricaoComposicao = descricaoComposicao;
    }

    public String getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public void setUnidadeComposicao(String unidadeComposicao) {
        this.unidadeComposicao = unidadeComposicao;
    }
}
