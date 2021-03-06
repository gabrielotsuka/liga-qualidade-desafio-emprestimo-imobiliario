package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.Solucao;

public class SolucaoTest {
	
  @ParameterizedTest
  @CsvSource({
	  "test/input/input000.txt,test/output/output000.txt",
  })
  
  public void teste(String entrada,String saidaEsperada) throws IOException  {
      Path inputPath = Paths.get(entrada);
      Path outputPath = Paths.get(saidaEsperada);

      List<String> inputLines = Files.readAllLines(inputPath);
      List<String> outputLines = Files.readAllLines(outputPath);
      
      String idsValidados = Solucao.processMessages(inputLines);
      
//      Assertions.assertEquals(outputLines.get(0),idsValidados);
  }
}