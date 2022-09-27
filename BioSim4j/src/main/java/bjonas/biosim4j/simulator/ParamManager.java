package bjonas.biosim4j.simulator;

import java.time.Instant;

public class ParamManager {
    private Params privParams;
    String configFileName;
    Instant lastModeTime; // when config file was last read

    public Params getPrivParams() {
        return privParams;
    }
}
