package bjonas.model;

import lombok.Data;

import java.util.List;

@Data
public class NeuralNet {
    List<Neuron> neurons;
    List<Gene> connections;
}
