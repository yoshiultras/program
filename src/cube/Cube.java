package cube;

import java.awt.*;

public class Cube {
    Facet[] _facets;

    public Cube() {
        _facets = new Facet[6];
        _facets[0] = new Facet(new R3Vector(0, 0, 1), new R3Vector(1, 0, 1), new R3Vector(1, 1, 1),
                                new R3Vector(0, 1, 1), new Color(0xFF0000)); // перед

        _facets[1] = new Facet(new R3Vector(0, 1, 0), new R3Vector(0, 1, 1), new R3Vector(1, 1, 1),
                                new R3Vector(1, 1, 0), new Color(0xFF7300)); // верх

        _facets[2] = new Facet(new R3Vector(1, 1, 1), new R3Vector(1, 0, 1), new R3Vector(1, 0, 0),
                                new R3Vector(1, 1, 0), new Color(0xFFCC00)); // бок перед

        _facets[3] = new Facet(new R3Vector(0, 0, 0), new R3Vector(1, 0, 0), new R3Vector(1, 0, 1),
                                new R3Vector(0, 0, 1), new Color(0x0AFF2C)); // низ

        _facets[4] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0, 1), new R3Vector(0, 1, 1),
                                new R3Vector(0, 1, 0), new Color(0x0033FF)); // бок зад

        _facets[5] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 1, 0), new R3Vector(1, 1, 0),
                                new R3Vector(1, 0, 0), new Color(0xE600FF)); // зад
    }

    public void scale(double k) {
        for (Facet facet : _facets) {
            facet.scale(k);
        }
    }
    public void translate(double dx, double dy, double dz) {
        for (Facet facet : _facets) {
            facet.translate(dx, dy, dz);
        }
    }
    public void rotate(double ux, double uy, double uz) {
        for (Facet facet : _facets) {
            facet.rotate(ux, uy, uz);
        }
    }
    public void draw(Graphics2D g, boolean transp) {
        for (Facet facet : _facets) {
            if(facet.isVisible()) facet.draw(g, transp);
        }
    }
}
