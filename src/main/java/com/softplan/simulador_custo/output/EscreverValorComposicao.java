package com.softplan.simulador_custo.output;

import com.softplan.simulador_custo.input.Composicao;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class EscreverValorComposicao {

    public static final String OUTPUT_FILE="dados-saida-servicos-composicoes.txt";

    public void escrever(List<Composicao> composicoes) {

        List<String[]> data = new ArrayList<>();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        for (Composicao composicao : composicoes) {
            data.add(new String[]{
                    composicao.getCodigoComposicao().toString(),
                    composicao.getDescricaoComposicao(),
                    composicao.getUnidadeComposicao(),
                    df.format(composicao.getValorComposicao())
            });
        }

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get(OUTPUT_FILE)))) {
            for (String[] row : data) {
                writer.printf("%1$5s\t%2$3s\t\t%3$3s\t\t%4$3s",
                        row[0], row[1], row[2], row[3]);
                writer.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
