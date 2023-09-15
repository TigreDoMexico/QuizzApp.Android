package com.tigredomexico.quizzapp.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quizz {
    private String Pergunta;
    private List<String> Respostas;
    private int RespostaCorreta;

    public Quizz(String pergunta, List<String> respostas, int respostaCorreta) {
        this.Pergunta = pergunta;
        this.Respostas = respostas;
        this.RespostaCorreta = respostaCorreta;
    }

    public String getPergunta() {
        return Pergunta;
    }

    public String getResposta(int index) {
        if(Respostas == null) {
            return "";
        }
        return Respostas.get(index);
    }

    public int getRespostaCorreta() {
        return RespostaCorreta;
    }

    public static List<Quizz> GerarPerguntasAleatorias() {
        List<Quizz> perguntas = new ArrayList<Quizz>();

        for(int i = 0; i < 3; i++) {
            String pergunta = String.format("Pergunta %d ABC", i + 1);

            String resposta1 = String.format("Resposta A, Q%d", i + 1);
            String resposta2 = String.format("Resposta B, Q%d", i + 1);
            String resposta3 = String.format("Resposta C, Q%d", i + 1);

            Quizz quizz = new Quizz(
                    pergunta,
                    new ArrayList<>(Arrays.asList(resposta1, resposta2, resposta3)),
                    i);

            perguntas.add(quizz);
        }

        return perguntas;
    }
}
