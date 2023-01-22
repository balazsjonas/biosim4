package bjonas.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class NodeMap {
    private Map<Integer, Node> nodeMap = new HashMap<>();

    public NodeMap(Genome genome, int maxNumberNeurons) {
        for(Gene conn: genome.getGenes()) {
            if(conn.getSinkType().equals(SinkType.NEURON)) {
                Node node = nodeMap.get(conn.getSinkNum());
                if(node == null) {
                    if(conn.getSinkNum() >= maxNumberNeurons) {
                        throw new IllegalStateException("sinkNum");
                    }
                    node = new Node();
                    nodeMap.put(conn.getSinkNum(), node);
                    // node.numOutputs = 0
                    // node.numSelfInputs = 0
                    // node.numInputsFromSensorsOrOtherNeurons = 0
                }
                if ( conn.getNeuronType().equals(NeuronType.NEURON) && (conn.getSourceNum() == conn.getSinkNum())) {
                    node.numSelfInputs++;
                }
                else {
                    node.numInputsFromSensorsOrOtherNeurons++;
                }

            }
            if(conn.getNeuronType().equals(NeuronType.NEURON)) {
                Node node = nodeMap.get(conn.getSourceNum());
                if(node == null) {
                    if (conn.getSinkNum() >= maxNumberNeurons) {
                        throw new IllegalStateException("sinkNum");
                    }
                    node = new Node();
                    nodeMap.put(conn.getSinkNum(), node);
                    // node.numOutputs = 0
                    // node.numSelfInputs = 0
                    // node.numInputsFromSensorsOrOtherNeurons = 0
                }
                node.numOutputs++;
            }
        }

    }
}
