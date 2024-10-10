package checkpoint2;

public class App {
    public static void main(String[] args) {
        NucleotideoRandomGenerator generator = new NucleotideoRandomGeneratorImpl();
        String sequence = generator.generate(200);
        System.out.println("Sequência gerada: " + sequence);
    }
}
