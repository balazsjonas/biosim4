package bjonas.model;

import lombok.Data;

import java.util.Set;

@Data
public class Node {
    private int id;
    int numOutputs;
    int numSelfInputs;
    int numInputsFromSensorsOrOtherNeurons;
    private Set<Node> inputs;
}
