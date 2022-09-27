package bjonas.biosim4j.simulator;

/**
 * // Place the action neuron you want enabled prior to NUM_ACTIONS. Any
 * // that are after NUM_ACTIONS will be disabled in the simulator.
 * // If new items are added to this enum, also update the name functions
 * // in analysis.cpp.
 * // I means the action affects the individual internally (Indiv)
 * // W means the action also affects the environment (Peeps or Grid)
 */
public enum Action {
    MOVE_X,                   // W +- X component of movement
    MOVE_Y,                   // W +- Y component of movement
    MOVE_FORWARD,             // W continue last direction
    MOVE_RL,                  // W +- component of movement
    MOVE_RANDOM,              // W
    SET_OSCILLATOR_PERIOD,    // I
    SET_LONGPROBE_DIST,       // I
    SET_RESPONSIVENESS,       // I
    EMIT_SIGNAL0,             // W
    MOVE_EAST,                // W
    MOVE_WEST,                // W
    MOVE_NORTH,               // W
    MOVE_SOUTH,               // W
    MOVE_LEFT,                // W
    MOVE_RIGHT,               // W
    MOVE_REVERSE,             // W
    NUM_ACTIONS,       // <<----------------- END OF ACTIVE ACTIONS MARKER
    KILL_FORWARD ;            // W

    public static final  float ACTION_MIN = 0.0f;
    public static final  float ACTION_MAX = 1.0f;
    public static final  float ACTION_RANGE = ACTION_MAX - ACTION_MIN;
}
