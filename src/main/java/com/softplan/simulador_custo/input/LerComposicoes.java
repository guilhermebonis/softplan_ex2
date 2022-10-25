package com.softplan.simulador_custo.input;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LerComposicoes {

    public static final String JSON_FILE="dados-entrada-servicos-composicoes.json";

    public LerComposicoes() {

    }

    public  JsonComposicao[] ler()  {
        ObjectMapper mapper = new ObjectMapper();

        File json = null;

        URL resource = getClass().getClassLoader().getResource(JSON_FILE);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            try {
                json = new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        JsonComposicao[] composicoes = null;
        try {

            composicoes = mapper.readValue(json, JsonComposicao[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return composicoes;
    }
}
