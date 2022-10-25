package com.softplan.simulador_custo.application.composicao;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Composicao {

    @Getter
    private final ComposicaoId id;

    public static Composicao withoutId() {
        return new Composicao(null);
    }

    public static Composicao withId(ComposicaoId composicaoId) {
        return new Composicao(composicaoId);
    }

    public Optional<ComposicaoId> getId(){
        return Optional.ofNullable(this.id);
    }

    @Value
    public static class ComposicaoId {
        private String value;
    }
}
