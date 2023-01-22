package bjonas.model;

import lombok.Data;

@Data
public class Gene {
    private static final double f1 = 8.0;
    private static final double f2 = 64.0;

    private NeuronType neuronType;
    private long sourceNum;
    private SinkType sinkType;
    private long sinkNum;
    private long weight;

    public double weightAsFloat() {
        return weight / 8192.0;
    }



}
