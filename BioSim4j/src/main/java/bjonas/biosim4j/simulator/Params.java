package bjonas.biosim4j.simulator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * // A private copy of Params is initialized by ParamManager::init(), then modified by
 * // UI events by ParamManager::uiMonitor(). The main simulator thread can get an
 * // updated, read-only, stable snapshot of Params with ParamManager::paramsSnapshot.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Params {
    int population; // >= 0
    int stepsPerGeneration; // > 0
    int maxGenerations; // >= 0
    int numThreads; // > 0
    int signalLayers; // >= 0
    int genomeMaxLength; // > 0
    int maxNumberNeurons; // > 0
    double pointMutationRate; // 0.0..1.0
    double geneInsertionDeletionRate; // 0.0..1.0
    double deletionRatio; // 0.0..1.0
    boolean killEnable;
    boolean sexualReproduction;
    boolean chooseParentsByFitness;
    float populationSensorRadius; // > 0.0
    int signalSensorRadius; // > 0
    float responsiveness; // >= 0.0
    int responsivenessCurveKFactor; // 1, 2, 3, or 4
    int longProbeDistance; // > 0
    int shortProbeBarrierDistance; // > 0
    float valenceSaturationMag;
    boolean saveVideo;
    int videoStride; // > 0
    int videoSaveFirstFrames; // >= 0, overrides videoStride
    int displayScale;
    int agentSize;
    int genomeAnalysisStride; // > 0
    int displaySampleGenomes; // >= 0
    int genomeComparisonMethod; // 0 = Jaro-Winkler; 1 = Hamming
    boolean updateGraphLog;
    int updateGraphLogStride; // > 0
    int challenge;
    int barrierType; // >= 0
    boolean deterministic;
    int RNGSeed; // >= 0

    // These must not change after initialization
    long sizeX; // 2..0x10000
    long sizeY; // 2..0x10000
    int genomeInitialLengthMin; // > 0 and < genomeInitialLengthMax
    int genomeInitialLengthMax; // > 0 and < genomeInitialLengthMin
    String logDir;
    String imageDir;
    String graphLogUpdateCommand;

    // These are updated automatically and not set via the parameter file
    int parameterChangeGenerationNumber; // the most recent generation number that an automatic parameter change occured at
}
