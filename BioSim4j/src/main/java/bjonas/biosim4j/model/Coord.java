package bjonas.biosim4j.model;

import java.util.Objects;

public class Coord {
    private final long x;
    private final long y;

    public Coord(long x0, long y0) {
        this.x = x0;
        this.y = y0;
    }

    public Coord() {
        this(0, 0);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public boolean isNormalized() {
        return x >= -1 && x <= 1 && y >= -1 && y <= 1;
    }

    /**
     * A normalized Coord has x and y == -1, 0, or 1.
     * A normalized Coord may be used as an offset to one of the
     * 8-neighbors.
     * We'll convert the Coord into a Dir, then convert Dir to normalized Coord.
     */
    public Coord normalize() {
        return asDir().asNormalizedCoord();
    }

    public long length() {
        return (long) (Math.sqrt(x * x + y * y));
    } // round down

    /**
     * // Effectively, we want to check if a coordinate lies in a 45 degree region (22.5 degrees each side)
     * // centered on each compass direction. By first rotating the system by 22.5 degrees clockwise
     * // the boundaries to these regions become much easier to work with as they just align with the 8 axes.
     * // (Thanks to @Asa-Hopkins for this optimization -- drm)
     */
    public Dir asDir() {
        // tanN/tanD is the best rational approximation to tan(22.5) under the constraint that
        // tanN + tanD < 2**16 (to avoid overflows). We don't care about the scale of the result,
        // only the ratio of the terms. The actual rotation is (22.5 - 1.5e-8) degrees, whilst
        // the closest a pair of int16_t's come to any of these lines is 8e-8 degrees, so the result is exact

        int tanN = 13860;
        int tanD = 33461;
        /*

    const Dir conversion[16] {  S, C, SW, N, SE, E, N,
                                N, N, N, W, NW, N, NE, N, N};

    const int32_t xp = x * tanD + y * tanN;
    const int32_t yp = y * tanD - x * tanN;

    // We can easily check which side of the four boundary lines
    // the point now falls on, giving 16 cases, though only 9 are
    // possible.
    return conversion[(yp > 0) * 8 + (xp > 0) * 4 + (yp > xp) * 2 + (yp >= -xp)];
         */
        throw new UnsupportedOperationException();

    }

    public Polar asPolar() {
        return new Polar((int) length(), asDir());

    }

    public Coord plus(Coord other) {
        System.err.println("number conversion: int16_t");
        return new Coord(x + other.x, y + other.y);
    }
    public Coord minus(Coord other) {
        System.err.println("number conversion: int16_t");
        return new Coord(x - other.x, y - other.y);
    }


    public Coord multiply(long a) {
        return new Coord(a * x, a * y);
    }
    /**

     *
     *     Coord operator+(Dir d) const { return *this + d.asNormalizedCoord(); }
     *     Coord operator-(Dir d) const { return *this - d.asNormalizedCoord(); }
     *
     *     float raySameness(Coord other) const; // returns -1.0 (opposite) .. 1.0 (same)
     *     float raySameness(Dir d) const; // returns -1.0 (opposite) .. 1.0 (same)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
