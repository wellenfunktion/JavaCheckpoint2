package checkpoint2;

import java.io.FileWriter;
import java.util.Random;

public class NucleotideoRandomGeneratorImpl implements NucleotideoRandomGenerator {
    
    private static String NUCLEOTIDEOS = "ACGT"; // Define os nucleotídeos possíveis.
    private static String OUTPUT_FILE = "randomnucleotideosequence.txt"; // Define o arquivo de saída.

    @Override
    public String generate(int sequenceLength) {
        
        // Verifica se o tamanho da sequência é positivo.
        if (sequenceLength <= 0) {
            throw new IllegalArgumentException("O tamanho da sequência de nucleotídeos deve ser positiva.");
        }

        Random random = new Random(); // Cria um gerador de números aleatórios.
        StringBuilder sequence = new StringBuilder(sequenceLength); // Cria um StringBuilder para armazenar a sequência.

        // Gera a sequência aleatória.
        for (int i = 0; i < sequenceLength; i++) { // Loop para gerar cada nucleotídeo
            char nucleotideo = NUCLEOTIDEOS.charAt(random.nextInt(NUCLEOTIDEOS.length())); // Seleciona um nucleotídeo aleatório
            sequence.append(nucleotideo); // Adiciona o nucleotídeo à sequência.
        }

        String result = sequence.toString(); // Converte o StringBuilder para uma string.

        // Salva a sequência no arquivo de saída.
        saveToFile(result);

        // Retorna a sequência gerada.
        return result;
    }

    private void saveToFile(String sequence) {
        
        // Tenta salvar a sequência no arquivo de saída
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            writer.write(sequence);
            System.out.println("Sequência aleatória salva em " + OUTPUT_FILE);

        // Caso ocorra um erro, exibe uma mensagem de erro.
        } catch (Exception e) {
            System.err.println("Erro ao tentar salvar a sequência: " + e.getMessage());
        }
    }
}
