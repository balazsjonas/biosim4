package bjonas;

import bjonas.biosim4j.simulator.Action;
import bjonas.biosim4j.simulator.Sensor;

public class Main {
    public static void main(String[] args) {

        simulator(args);
        System.out.println("Hello world!");
    }

    private static void simulator(String[] args) {
        printSensorsActions(); // show the agents' capabilities

        // Simulator parameters are available read-only through the global
        // variable p after paramManager is initialized.
        // Todo: remove the hardcoded parameter filename.

        throw new UnsupportedOperationException();
    }

    /**
     *
     // List the names of the active sensors and actions to stdout.
     // "Active" means those sensors and actions that are compiled into
     // the code. See sensors-actions.h for how to define the enums.
     */
    private static void printSensorsActions() {
        int i;
        System.out.println( "Sensors:" );
        for(var s: Sensor.values()) {
            System.out.println("  "+ s);
        }

        System.out.println( "Actions:" );
        for(var a: Action.values()) {
            System.out.println("  "+ a);
        }

        System.out.println();
    }

}