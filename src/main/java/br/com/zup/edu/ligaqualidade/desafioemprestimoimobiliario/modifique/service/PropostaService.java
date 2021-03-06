package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Proposta;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.repository.PropostaRepository;

import java.util.List;

public class PropostaService {

    public static List<Proposta> campoValido(String[] campos, List<Proposta> propostas) {

        if (campos[2].equals("deleted")) {
            return PropostaRepository.removeProposta(campos[4], propostas);
        }

        double valorEmprestimo = Double.parseDouble(campos[5]);
        int parcelas = Integer.parseInt(campos[6]);
        if (valorEmprestimo < 30000.0 || valorEmprestimo > 3000000.0 || parcelas < 24 || parcelas > 180)
            return propostas;

        switch (campos[2]) {
            case "created":
                return PropostaRepository.criaProposta(campos, propostas);
            case "updated":
                return PropostaRepository.atualizaProposta(campos, propostas);
        }
        return propostas;
    }
}
