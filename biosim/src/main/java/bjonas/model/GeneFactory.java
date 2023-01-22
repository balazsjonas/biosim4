package bjonas.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneFactory {
    private final Random random;

    public GeneFactory(Random random) {
        this.random = random;
    }

    public long randomUint() {
        return random.nextLong();
    }

    public long randomUint(long min, long max) {
        return randomUint() % (max - min + 1) + min;
    }

    private NeuronType getRandomNeuronType() {
        return NeuronType.values()[(int) randomUint() % NeuronType.values().length];
    }
    private SinkType getRandomSinkType() {
        return SinkType.values()[(int) randomUint() % SinkType.values().length];
    }

    public Gene makeRandomGene() {
        Gene gene = new Gene();
        gene.setNeuronType(getRandomNeuronType());;
        gene.setSourceNum(randomUint(0, 0x7fff));
        gene.setSinkType(getRandomSinkType());
        gene.setSinkNum(randomUint(0, 0x7fff));
        gene.setWeight(randomUint(0, 0xffff)-0x8000);


        return gene;
    }

    public Genome makeRandomGenome(int length) {
        Genome genome = new Genome();
        List<Gene> genes = IntStream.range(0, length).boxed().map(i -> makeRandomGene())
                .collect(Collectors.toList());
        genome.setGenes(genes);
        return genome;
    }
}
