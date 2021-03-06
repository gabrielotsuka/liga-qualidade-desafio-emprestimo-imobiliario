package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Garantia;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Proposta;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.repository.PropostaRepository;

import java.util.List;
import java.util.Set;

public class GarantiaService {
    public static List<Proposta> campoValido(String[] campos, List<Proposta> propostas) {
        Proposta proposta = PropostaRepository.buscaProposta(campos[0], propostas);
        assert proposta != null;
        Double somaGarantias = soma(proposta);
        if (Set.of("PR", "SC", "RS").contains(campos[7]) || proposta.getValorEmprestimo().equals(somaGarantias)) {
            return propostas;
        }
        return propostas;
    }

    private static Double soma(Proposta proposta) {
        Double response = 0.0;
        for (Garantia garantia : proposta.getGarantias()) {
            response += garantia.getValorGarantia();
        }
        return response;
    }
}
