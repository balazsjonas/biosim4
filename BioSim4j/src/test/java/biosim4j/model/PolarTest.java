package biosim4j.model;

import bjonas.biosim4j.model.Compass;
import bjonas.biosim4j.model.Coord;
import bjonas.biosim4j.model.Dir;
import bjonas.biosim4j.model.Polar;
import org.junit.jupiter.api.Test;

import static bjonas.biosim4j.model.Compass.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolarTest {

    @Test
    public void test() {
        System.out.println("hello");
        // Polar
        // ctor from mag, dir
        Polar p1 = new Polar();
        assertEquals(0, p1.getMag());
        assertEquals(new Dir(CENTER), p1.getDir());

        p1 = new Polar(0, Compass.S);
        assertEquals(0, p1.getMag());
        assertEquals(new Dir(S), p1.getDir());

        p1 = new Polar(10, SE);
        assertEquals(10, p1.getMag());
        assertEquals(new Dir(SE), p1.getDir());


        p1 =new  Polar(-10, Compass.NW);
        assertEquals(-10, p1.getMag());
        assertEquals(new Dir(NW), p1.getDir());

        // .asCoord()
        Coord c1 =new  Polar(0, CENTER).asCoord();
        assertEquals(0, c1.getX());
        assertEquals(0, c1.getY());

        c1 = new Polar(10, CENTER).asCoord();
        assertEquals(0, c1.getX());
        assertEquals(0, c1.getY());

        c1 =new Polar(20, Compass.N).asCoord();
        assertEquals(0, c1.getX());
        assertEquals(20, c1.getY());

        //c1 = Polar(12, Compass.W).asCoord();
        p1 =new  Polar(12, Compass.W);
        c1 = p1.asCoord();
        assertEquals(-12, c1.getX());
        assertEquals(0, c1.getY());

        c1 = new Polar(14, Compass.NE).asCoord();
        assertEquals(10, c1.getX());
        assertEquals(10, c1.getY());
        c1 = new Polar(-14, Compass.NE).asCoord();
        assertEquals(-10, c1.getX());
        assertEquals(-10, c1.getY());


        c1 = new Polar(14, Compass.E).asCoord();
        assertEquals(14, c1.getX());
        assertEquals(0, c1.getY());

        c1 = new Polar(-14, Compass.E).asCoord();
        assertEquals(-14, c1.getX());
        assertEquals(0, c1.getY());
    }
}