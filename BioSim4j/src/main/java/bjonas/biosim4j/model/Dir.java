package bjonas.biosim4j.model;

import java.util.Arrays;
import java.util.Objects;

import static bjonas.biosim4j.model.Compass.*;

public class Dir {
    private static final Compass rotations[] = {SW, W, NW, N, NE, E, SE, S,
            S, SW, W, NW, N, NE, E, SE,
            SE, S, SW, W, NW, N, NE, E,
            W, NW, N, NE, E, SE, S, SW,
            C, C, C, C, C, C, C, C,
            E, SE, S, SW, W, NW, N, NE,
            NW, N, NE, E, SE, S, SW, W,
            N, NE, E, SE, S, SW, W, NW,
            NE, E, SE, S, SW, W, NW, N};
    private static final Dir dirRotations[] = Arrays.stream(rotations)
            .map(Dir::new)
            .toArray(Dir[]::new);
    private Compass dir9;

    public Dir() {
        this(Compass.CENTER);
    }

    public Dir(Compass dir) {
        dir9 = dir;
    }

    public int asInt() {
        return dir9.ordinal();
    }

    public Coord asNormalizedCoord() {
        throw new UnsupportedOperationException();
    }

    public Polar asNormalizedPolar() {
        throw new UnsupportedOperationException();
    }

    public Dir rotate(int n) {
        return dirRotations[asInt() * 8 + (n & 7)];
    }

    public Dir rotate() {
        return rotate(0);
    }

    public Dir rotate90DegCW() {
        return rotate(2);
    }

    public Dir rotate90DegCCW() {
        return rotate(-2);
    }

    public Dir rotate180Deg() {
        return rotate(4);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        final Dir dir;
        if (o instanceof Dir) {
            dir = (Dir) o;
        } else if (o instanceof Compass) {
            dir = new Dir((Compass) o);
        } else {
            return false;
        }

        return dir9 == dir.dir9;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dir9);
    }
}
