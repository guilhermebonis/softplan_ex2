package com.softplan.simulador_custo.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softplan.simulador_custo.application.application.port.in.command.ComposicaoCommand;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;

public class LerJsonComposicoes {

    public static final String JSON_FILE="dados-entrada-servicos-composicoes.json";

    public  ComposicaoCommand[] ler() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream(JSON_FILE);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ClassPathResource res = new ClassPathResource(JSON_FILE);
        File json = new File(res.getPath());

        ComposicaoCommand[] composicoes = null;
        try {

            composicoes = mapper.readValue(json, ComposicaoCommand[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return composicoes;
    }

}
