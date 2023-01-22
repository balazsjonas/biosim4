package bjonas.model;

import lombok.Data;

import java.util.Set;

@Data
public class Node {
    private int id;
    private Set<Node> inputs;
}
