package biosim4j.model;

public class UnitTestBasicTypes {
    /**
     *
     *     // Coord
     *     // ctor from int16_t,int16_t
     *     c1 = Coord();
     *     assert(c1.x == 0 && c1.y == 0);
     *     c1 = Coord(1, 1);
     *     assert(c1.x == 1 && c1.y == 1);
     *     c1 = Coord(-6, 12);
     *     assert(c1.x == -6 && c1.y == 12);
     *
     *     // copy assignment
     *     Coord c2 = Coord(9, 101);
     *     assert(c2.x == 9 && c2.y == 101);
     *     c1 = c2;
     *     assert(c1.x == 9 && c2.y == 101);
     *
     *     // .isNormalized()
     *     assert(!c1.isNormalized());
     *     assert(Coord(0, 0).isNormalized());
     *     assert(Coord(0, 1).isNormalized());
     *     assert(Coord(1, 1).isNormalized());
     *     assert(Coord(-1, 0).isNormalized());
     *     assert(Coord(-1, -1).isNormalized());
     *     assert(!Coord(0, 2).isNormalized());
     *     assert(!Coord(1, 2).isNormalized());
     *     assert(!Coord(-1, 2).isNormalized());
     *     assert(!Coord(-2, 0).isNormalized());
     *
     *     // .normalize()
     *     // .asDir()
     *     c1 = Coord(0, 0);
     *     c2 = c1.normalize();
     *     assert(c2.x == 0 && c2.y == 0);
     *     assert(c2.asDir() == Compass::CENTER);
     *     c1 = Coord(0, 1).normalize();
     *     assert(c1.x == 0 && c1.y == 1);
     *     assert(c1.asDir() == Compass::N);
     *     c1 = Coord(-1, 1).normalize();
     *     assert(c1.x == -1 && c1.y == 1);
     *     assert(c1.asDir() == Compass::NW);
     *     c1 = Coord(100, 5).normalize();
     *     assert(c1.x == 1 && c1.y == 0);
     *     assert(c1.asDir() == Compass::E);
     *     c1 = Coord(100, 105).normalize();
     *     assert(c1.x == 1 && c1.y == 1);
     *     assert(c1.asDir() == Compass::NE);
     *     c1 = Coord(-5, 101).normalize();
     *     assert(c1.x == 0 && c1.y == 1);
     *     assert(c1.asDir() == Compass::N);
     *     c1 = Coord(-500, 10).normalize();
     *     assert(c1.x == -1 && c1.y == 0);
     *     assert(c1.asDir() == Compass::W);
     *     c1 = Coord(-500, -490).normalize();
     *     assert(c1.x == -1 && c1.y == -1);
     *     assert(c1.asDir() == Compass::SW);
     *     c1 = Coord(-1, -490).normalize();
     *     assert(c1.x == 0 && c1.y == -1);
     *     assert(c1.asDir() == Compass::S);
     *     c1 = Coord(1101, -1090).normalize();
     *     assert(c1.x == 1 && c1.y == -1);
     *     assert(c1.asDir() == Compass::SE);
     *     c1 = Coord(1101, -3).normalize();
     *     assert(c1.x == 1 && c1.y == 0);
     *     assert(c1.asDir() == Compass::E);
     *
     *     // .length()
     *     assert(Coord(0, 0).length() == 0);
     *     assert(Coord(0, 1).length() == 1);
     *     assert(Coord(-1, 0).length() == 1);
     *     assert(Coord(-1, -1).length() == 1); // round down
     *     assert(Coord(22, 0).length() == 22);
     *     assert(Coord(22, 22).length() == 31); // round down
     *     assert(Coord(10, -10).length() == 14); // round down
     *     assert(Coord(-310, 0).length() == 310);
     *
     *     // .asPolar()
     *     p1 = Coord(0, 0).asPolar();
     *     assert(p1.mag == 0 && p1.dir == Compass::CENTER);
     *     p1 = Coord(0, 1).asPolar();
     *     assert(p1.mag == 1 && p1.dir == Compass::N);
     *     p1 = Coord(-10, -10).asPolar();
     *     assert(p1.mag == 14 && p1.dir == Compass::SW); // round down mag
     *     p1 = Coord(100, 1).asPolar();
     *     assert(p1.mag == 100 && p1.dir == Compass::E); // round down mag
     *
     *     // operator+(Coord), operator-(Coord)
     *     c1 = Coord(0, 0) + Coord(6, 8);
     *     assert(c1.x == 6 && c1.y == 8);
     *     c1 = Coord(-70, 20) + Coord(10, -10);
     *     assert(c1.x == -60 && c1.y == 10);
     *     c1 = Coord(-70, 20) - Coord(10, -10);
     *     assert(c1.x == -80 && c1.y == 30);
     *
     *     // operator*(int)
     *     c1 = Coord(0, 0) * 1;
     *     assert(c1.x == 0 && c1.y == 0);
     *     c1 = Coord(1, 1) * -5;
     *     assert(c1.x == -5 && c1.y == -5);
     *     c1 = Coord(11, 5) * -5;
     *     assert(c1.x == -55 && c1.y == -25);
     *
     *     // operator+(Dir), operator-(Dir)
     *     c1 = Coord(0, 0);
     *     c2 = c1 + Dir(Compass::CENTER);
     *     assert(c2.x == 0 && c2.y == 0);
     *     c2 = c1 + Dir(Compass::E);
     *     assert(c2.x == 1 && c2.y == 0);
     *     c2 = c1 + Dir(Compass::W);
     *     assert(c2.x == -1 && c2.y == 0);
     *     c2 = c1 + Dir(Compass::SW);
     *     assert(c2.x == -1 && c2.y == -1);
     *
     *     c2 = c1 - Dir(Compass::CENTER);
     *     assert(c2.x == 0 && c2.y == 0);
     *     c2 = c1 - Dir(Compass::E);
     *     assert(c2.x == -1 && c2.y == 0);
     *     c2 = c1 - Dir(Compass::W);
     *     assert(c2.x == 1 && c2.y == 0);
     *     c2 = c1 - Dir(Compass::SW);
     *     assert(c2.x == 1 && c2.y == 1);
     *
     *     // raySameness()
     *     c1 = Coord { 0, 0 };
     *     c2 = Coord { 10, 11 };
     *     d1 = Compass::CENTER;
     *     assert(c1.raySameness(c2) == 1.0); // special case - zero vector
     *     assert(c2.raySameness(c1) == 1.0); // special case - zero vector
     *     assert(c2.raySameness(d1) == 1.0); // special case - zero vector
     *     c1 = c2;
     *     assert(c1.raySameness(c2) == 1.0);
     *     assert(areClosef(Coord(-10,-10).raySameness(Coord(10,10)), -1.0));
     *     c1 = Coord{0,11};
     *     c2 = Coord{20,0};
     *     assert(areClosef(c1.raySameness(c2), 0.0));
     *     assert(areClosef(c2.raySameness(c1), 0.0));
     *     c1 = Coord{0,444};
     *     c2 = Coord{113,113};
     *     assert(areClosef(c1.raySameness(c2), 0.707106781));
     *     c2 = Coord{113,-113};
     *     assert(areClosef(c1.raySameness(c2), -0.707106781));
     *

     *
     *     return true;
     */
}
