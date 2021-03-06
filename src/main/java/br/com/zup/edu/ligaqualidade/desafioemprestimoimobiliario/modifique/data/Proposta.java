package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data;

import java.time.LocalDateTime;
import java.util.List;

public class Proposta {
    private String idProposta;
    private List<Garantia> garantias;
    private List<Proponente> proponentes;
    private Double valorEmprestimo;
    private LocalDateTime dataPagamento;

    public Proposta(String idProposta, List<Garantia> garantias, List<Proponente> proponentes, Double valorEmprestimo, LocalDateTime dataPagamento) {
        this.idProposta = idProposta;
        this.garantias = garantias;
        this.proponentes = proponentes;
        this.valorEmprestimo = valorEmprestimo;
        this.dataPagamento = dataPagamento;
    }

    public String getIdProposta() {
        return idProposta;
    }
    
    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public List<Garantia> getGarantias() {
        return garantias;
    }
}


