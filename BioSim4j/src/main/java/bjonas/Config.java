package bjonas;

import lombok.Data;

@Data
public class Config {
    private int numThreads = 4;
    private int sizeX = 128;
    private int sizeY = 182;
    private int population = 3000;
    private int stepsPerGeneration = 300;
    private int maxGenerations = 200;
    /*
    # genomeInitialLengthMin and genomeInitialLengthMax should be set to
# the same value. (For future use, the max length might be larger to
# allow mutations that lengthen the genome.) Range 1..INT_MAX and
# must be no larger than genomeMaxLength. The range of genomeMaxLength
# is genomeInitialLengthMax..INT_MAX. Cannot be changed after a
# simulation starts.

     */
    private int genomeMaxLength = 300;
    private int genomeInitialLengthMax = 24;
    private int genomeInitialLengthMin = 24;

    private int maxNumberNeurons = 5;
    private boolean killEnable = false;
    private boolean sexualReproduction = true;
    private boolean chooseParentsByFitness = true;
    private double pointMutationRate = 0.001;
    /**
     * # responsivenessCurveKFactor is a small positive integer that determines
     * # the shape of the curve that determines how reactive an agent is to its
     * # sensory inputs. Typical values are # 1, 2, 3, or 4, but greater values
     * # are allowed experimentally.
     */
    private int responsivenessCurveKFactor = 2;
    private double populationSensorRadius = 2.5;
    private int longProbeDistance = 16;
    private int shortProbeBarrierDistance = 4;
    private double signalSensorRadius = 2.0;
    private int signalLayers = 1;
    private String imageDir = "images";
    private String logDir = "logs";
    private int displayScale = 8;
    private int agentSize = 4;
    /**
     * # challenge determines the selection criterion for reproduction. This is
     * # typically always under active development. See survival-criteria.cpp for
     * # more information.
     * # 0 = circle
     * # 1 = right half
     * # 2 = right quarter
     * # 3 = neighbor count
     * # 4 = center weighted
     * # 40 = center unweighted
     * # 5 = corner 1/4 radius
     * # 6 = corner 1/4 radius weighted
     * # 7 = migrate distance
     * # 8 = center sparse
     * # 9 = left eighth
     * # 10 = radioactive walls
     * # 11 = against any wall
     * # 12 = touch any wall any time
     * # 13 = east-west eighths
     * # 14 = near barrier
     * # 15 = pairs
     * # 16 = contact location sequence
     * # 17 = altruism, circle + NE corner
     */
    private int challenge = 6;
    /**
     * # The simulator supports a feature called "barriers." Barriers are locations
     * # in the simulated 2D world where agents may not occupy. The value of
     * # barrierType is typically under active development. See createBarrier.cpp
     * # for more information.
     * # 0 = none
     * # 1 = vertical bar constant location
     * # 2 = vertical bar random locations
     * # 3 = five staggered vertical bars
     * # 4 = horiz bar constant location north center
     * # 5 = floating islands
     * # 6 = sequence of spots
     */
    private int barrierType = 0;
    /**
     * # This is an example of an automatic parameter change based on the generation.
     * # If uncommented, the barrier type will automatically change to the new value
     * # when the simulation reaches the generation specified after the @ delimiter.
     * # barrierType@500 = 5
     * <p>
     * # If true, then the random number generator (RNG) will be seeded by the value
     * # in RNGSeed, causing each thread to receive a deterministic sequence from
     * # the RNG. If false, the RNG will be randomly seeded and program output will
     * # be non-deterministic. Cannot be changed after a simulation starts.
     */
    private boolean deterministic = false;

    /**
     * # If deterministic is true, the random number generator will be seeded with
     * # this value. If deterministic is false, this value is ignored. Legal values
     * # are integers 0 to 4294967295. Cannot be changed after a simulation starts.
     */
    private int RNGSeed = 12345678;

}
