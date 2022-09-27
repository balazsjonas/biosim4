package bjonas.biosim4j.simulator;

/**
 * // Place the sensor neuron you want enabled prior to NUM_SENSES. Any
 * // that are after NUM_SENSES will be disabled in the simulator.
 * // If new items are added to this enum, also update the name functions
 * // in analysis.cpp.
 * // I means data about the individual, mainly stored in Indiv
 * // W means data about the environment, mainly stored in Peeps or Grid
 */
public enum Sensor {
    LOC_X,             // I distance from left edge
    LOC_Y,             // I distance from bottom
    BOUNDARY_DIST_X,   // I X distance to nearest edge of world
    BOUNDARY_DIST,     // I distance to nearest edge of world
    BOUNDARY_DIST_Y,   // I Y distance to nearest edge of world
    GENETIC_SIM_FWD,   // I genetic similarity forward
    LAST_MOVE_DIR_X,   // I +- amount of X movement in last movement
    LAST_MOVE_DIR_Y,   // I +- amount of Y movement in last movement
    LONGPROBE_POP_FWD, // W long look for population forward
    LONGPROBE_BAR_FWD, // W long look for barriers forward
    POPULATION,        // W population density in neighborhood
    POPULATION_FWD,    // W population density in the forward-reverse axis
    POPULATION_LR,     // W population density in the left-right axis
    OSC1,              // I oscillator +-value
    AGE,               // I
    BARRIER_FWD,       // W neighborhood barrier distance forward-reverse axis
    BARRIER_LR,        // W neighborhood barrier distance left-right axis
    RANDOM,            //   random sensor value, uniform distribution
    SIGNAL0,           // W strength of signal0 in neighborhood
    SIGNAL0_FWD,       // W strength of signal0 in the forward-reverse axis
    SIGNAL0_LR,        // W strength of signal0 in the left-right axis
    NUM_SENSES;        // <<------------------ END OF ACTIVE SENSES MARKER
    public static final float SENSOR_MIN = 0.0f;
    public static final  float SENSOR_MAX = 1.0f;
    public static final  float SENSOR_RANGE = SENSOR_MAX - SENSOR_MIN;

    public static final  float NEURON_MIN = -1.0f;
    public static final  float NEURON_MAX = 1.0f;
    public static final  float NEURON_RANGE = NEURON_MAX - NEURON_MIN;
}
