package bjonas.biosim4j.model;

import static bjonas.biosim4j.model.Compass.CENTER;

public class Polar {
    public static final Coord NormalizedCoords[] = {
            new Coord(-1, -1), // SW
            new Coord(0, -1),  // S
            new Coord(1, -1),  // SE
            new Coord(-1, 0),  // W
            new Coord(0, 0),   // CENTER
            new Coord(1, 0),   // E
            new Coord(-1, 1),  // NW
            new Coord(0, 1),   // N
            new Coord(1, 1)    // NE
    };
    private final int mag;
    private final Dir dir;

    public Polar(int mag, Dir dir) {
        this.mag = mag;
        this.dir = dir;
    }

    public Polar(int mag, Compass dir) {
        this.mag = mag;
        this.dir = new Dir(dir);
    }

    public Polar() {
        this(0, CENTER);
    }

    public int getMag() {
        return mag;
    }

    public Dir getDir() {
        return dir;
    }

    /**
     * Compass values:
     * <p>
     * 6  7  8
     * 3  4  5
     * 0  1  2
     */
    public Coord asCoord() {
        System.err.println("low level number manipulation");
// (Thanks to @Asa-Hopkins for this optimized function -- drm)

        // 3037000500 is 1/sqrt(2) in 32.32 fixed point
        long coordMags[] = {
                3037000500L,  // SW
                1L << 32,   // S
                3037000500L,  // SE
                1L << 32,   // W
                0,           // CENTER
                1L << 32,   // E
                3037000500L,  // NW
                1L << 32,   // N
                3037000500L   // NE
        };

        long len = coordMags[dir.asInt()] * mag;

        // We need correct rounding, the idea here is to add/sub 1/2 (in fixed point)
        // and truncate. We extend the sign of the magnitude with a cast,
        // then shift those bits into the lower half, giving 0 for mag >= 0 and
        // -1 for mag<0. An XOR with this copies the sign onto 1/2, to be exact
        // we'd then also subtract it, but we don't need to be that precise.

        long temp = ((long) mag >> 32) ^ ((1L << 31) - 1);
        len = (len + temp) / (1L << 32); // Divide to make sure we get an arithmetic shift

        return NormalizedCoords[dir.asInt()].multiply(len);

    }
}
