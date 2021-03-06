package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.repository;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Proposta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Collections.emptyList;

public class PropostaRepository {

    public static List<Proposta> removeProposta(String idProposta, List<Proposta> propostas) {
        for (Proposta proposta : propostas) {
            if (proposta.getIdProposta().equals(idProposta)){
                propostas.remove(proposta);
                break;
            }
        }
        return propostas;
    }

    public static List<Proposta> criaProposta(String[] campos, List<Proposta> propostas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        LocalDateTime dateTime = LocalDateTime.parse(campos[3], formatter);
        propostas.add(new Proposta(
                campos[0], emptyList(), emptyList(), Double.parseDouble(campos[5]), dateTime
        ));
        return propostas;
    }

    public static List<Proposta> atualizaProposta(String[] campos, List<Proposta> propostas) {
        removeProposta(campos[5], propostas);
        return criaProposta(campos,propostas);
    }

    public static Proposta buscaProposta(String idProposta, List<Proposta> propostas) {
        for (Proposta proposta : propostas) {
            if(idProposta.equals(proposta.getIdProposta()))
                return proposta;
        }
        return null;
    }
}
