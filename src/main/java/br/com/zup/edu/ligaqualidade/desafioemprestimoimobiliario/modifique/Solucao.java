package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Proposta;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service.GarantiaService;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service.ProponenteService;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service.PropostaService;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class Solucao {

    public static String processMessages(List<String> messages) {

        List<Proposta> propostas = emptyList();

        for (String linha: messages) {
            String[] campos = linha.split(",");
            switch (campos[1]) {
                case "proposal":
                    propostas = PropostaService.campoValido(campos, propostas);
                    break;
                case "warranty":
                    propostas = GarantiaService.campoValido(campos, propostas);
                    break;
                case "proponent":
                    propostas = ProponenteService.campoValido(campos, propostas);
                    break;
            }
        }

        assert propostas != null;
        return propostas.stream().map(Proposta::getIdProposta).collect(Collectors.joining(","));
  }
}