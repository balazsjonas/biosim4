package bjonas.biosim4j.model;

import org.junit.jupiter.api.Test;

import static bjonas.biosim4j.model.Compass.SW;
import static org.junit.jupiter.api.Assertions.*;

class DirTest {

    @Test
    void testAsInt() {

        assertEquals(Compass.C.ordinal(), new Dir(Compass.CENTER).asInt());


        assertEquals(0, new Dir(SW).asInt());

        assertEquals(1, new Dir(Compass.S).asInt());
        assertEquals(2, new Dir(Compass.SE).asInt());

        assertEquals(3, new Dir(Compass.W).asInt());

        assertEquals(4, new Dir(Compass.C).asInt());

        assertEquals(5, new Dir(Compass.E).asInt());

        assertEquals(6, new Dir(Compass.NW).asInt());
        assertEquals(7, new Dir(Compass.N).asInt());
        assertEquals(8, new Dir(Compass.NE).asInt());
                 /*
     *

     *     assert(Dir((Compass)((Dir((Compass)8)).asInt())).asInt() == 8);
     *     assert(Dir((Compass)(Dir(Compass::NE).asInt())).asInt() == 8);
     *     d2 = Compass::E;
     *     d1 = d2;
     *     assert(d1.asInt() == 5);
     *     d2 = d1;
     *     assert(d1.asInt() == 5);

                  */
    }
    @Test
    void testEquality() {
        Dir d1 = new Dir(Compass.C);
        assertEquals(d1, Compass.C);

        d1 = new Dir(Compass.SE);
        assertEquals(d1, Compass.SE);

        assertNotEquals(new Dir(Compass.W), Compass.NW);
        assertEquals(new Dir(Compass.N), new Dir(Compass.N));

    }
    @Test void testRotate() {
        Dir d1 = new Dir(Compass.NE);
        assertEquals(new Dir(Compass.E), d1.rotate(1));
        assertEquals(new Dir(Compass.SE), d1.rotate(2));
        assertEquals(new Dir(Compass.N), d1.rotate(-1));
        assertEquals(new Dir(Compass.NW), d1.rotate(-2));
        assertEquals(new Dir(Compass.N).rotate(1), d1);
        assertEquals(new Dir(SW).rotate(-2), Compass.SE);
/*
     *

     *     // .asNormalizedCoord()
     *     Coord c1 = Dir(Compass::CENTER).asNormalizedCoord();
     *     assert(c1.x == 0 && c1.y == 0);
     *     d1 = Compass::SW;
     *     c1 = d1.asNormalizedCoord();
     *     assert(c1.x == -1 && c1.y == -1);
     *     c1 = Dir(Compass::S).asNormalizedCoord();
     *     assert(c1.x == 0 && c1.y == -1);
     *     c1 = Dir(Compass::SE).asNormalizedCoord();
     *     assert(c1.x == 1 && c1.y == -1);
     *     c1 = Dir(Compass::W).asNormalizedCoord();
     *     assert(c1.x == -1 && c1.y == 0);
     *     c1 = Dir(Compass::E).asNormalizedCoord();
     *     assert(c1.x == 1 && c1.y == 0);
     *     c1 = Dir(Compass::NW).asNormalizedCoord();
     *     assert(c1.x == -1 && c1.y == 1);
     *     c1 = Dir(Compass::N).asNormalizedCoord();
     *     assert(c1.x == 0 && c1.y == 1);
     *     c1 = Dir(Compass::NE).asNormalizedCoord();
     *     assert(c1.x == 1 && c1.y == 1);
     *
     *     // .asNormalizedPolar()
     *     d1 = Compass::SW;
     *     Polar p1 = d1.asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::SW);
     *     p1 = Dir(Compass::S).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::S);
     *     p1 = Dir(Compass::SE).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::SE);
     *     p1 = Dir(Compass::W).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::W);
     *     p1 = Dir(Compass::E).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::E);
     *     p1 = Dir(Compass::NW).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::NW);
     *     p1 = Dir(Compass::N).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::N);
     *     p1 = Dir(Compass::NE).asNormalizedPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::NE);
     */

}}