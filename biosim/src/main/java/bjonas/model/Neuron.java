package bjonas.model;

import lombok.Data;

@Data
public class Neuron {
    private double output;
    /**
     * undriven neurons have fixed output values
     */
    private boolean driven;
}
