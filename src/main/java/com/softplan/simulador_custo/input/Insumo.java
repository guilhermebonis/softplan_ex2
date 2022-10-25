package com.softplan.simulador_custo.input;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class Insumo {

    public Insumo(Integer codigoComposicao, String descricaoComposicao, Integer quantidadeComposicao, String unidadeComposicao, float valorUnitario, Integer codigoItem, String descricaoItem, String tipoItem, String unidadeItem) {
        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = descricaoComposicao;
        this.quantidadeComposicao = quantidadeComposicao;
        this.unidadeComposicao = unidadeComposicao;
        this.valorUnitario = valorUnitario;
        this.codigoItem = codigoItem;
        this.descricaoItem = descricaoItem;
        this.tipoItem = tipoItem;
        this.unidadeItem = unidadeItem;
    }

    public Insumo(int codigoComposicao, String descricaoComposicao, String quantidadeComposicao, String unidadeComposicao, String valorUnitario, Integer codigoItem, String descricaoItem, String tipoItem, String unidadeItem) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("0.#");
        format.setDecimalFormatSymbols(symbols);

        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = descricaoComposicao;
        this.unidadeComposicao = unidadeComposicao;
        this.codigoItem = codigoItem;
        this.descricaoItem = descricaoItem;
        this.tipoItem = tipoItem;
        this.unidadeItem = unidadeItem;

        try {
            if (quantidadeComposicao.isEmpty())
                quantidadeComposicao = "0,0";
            if (valorUnitario.isEmpty())
                valorUnitario = "0,0";

            this.quantidadeComposicao = format.parse(quantidadeComposicao).floatValue();
            this.valorUnitario = format.parse(valorUnitario).floatValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

preencherValorInsumo();
    }

    public Integer getCodigoComposicao() {
        return codigoComposicao;
    }

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public float getQuantidadeComposicao() {
        return quantidadeComposicao;
    }

    public String getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public String getUnidadeItem() {
        return unidadeItem;
    }

    private Integer codigoComposicao;
    private String descricaoComposicao;
    private float quantidadeComposicao;
    private String unidadeComposicao;
    private float valorUnitario;
    private Integer codigoItem;
    private String descricaoItem;
    private String tipoItem;
    private String unidadeItem;

    private Composicao subComposicao;

    public Composicao getSubComposicao() {
        return subComposicao;
    }

    public void setSubComposicao(Composicao subComposicao) {
        this.subComposicao = subComposicao;
    }

    private float valorInsumo;

    public float getValorInsumo() {
        return valorInsumo;
    }

    public void setValorInsumo(float valorInsumo) {
        this.valorInsumo = arredondar(valorInsumo);
    }

    private float arredondar(float valor) {
        BigDecimal bd = new BigDecimal(valor);
        BigDecimal res = bd.setScale(2, RoundingMode.HALF_UP);
        return res.floatValue();
    }

    private boolean valorInsumoCalculado;

    public boolean isValorInsumoCalculado() {
        return valorInsumoCalculado;
    }

    public void setValorInsumoCalculado(boolean valorInsumoCalculado) {
        this.valorInsumoCalculado = valorInsumoCalculado;
    }

    private void preencherValorInsumo() {
        if (this.getTipoItem().equals("INSUMO")) {
            this.setValorInsumoCalculado(true);
            this.setValorInsumo(this.getValorUnitario() * this.getQuantidadeComposicao());
        }
        else {
            this.setValorInsumoCalculado(false);
            this.setValorInsumo(0);
        }
    }
}
