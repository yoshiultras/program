package cube;

import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] _vertex;
    private Color _color;
    public Facet (R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4, Color color) {
        _vertex = new R3Vector[]{v1, v2, v3, v4};
        _color = color;
    }
    public void scale(double k) {
        for (R3Vector vec : _vertex) {
            vec.scale(k);
        }
    }
    public void translate(double dx, double dy, double dz) {
        for (R3Vector vec : _vertex) {
            vec.translate(dx, dy, dz);
        }
    }
    public void rotate(double ux, double uy, double uz) {
        for (R3Vector vec : _vertex) {
            vec.rotate(ux, uy, uz);
        }
    }
    public void draw(Graphics2D g, boolean transp, boolean perspective, int c) {
        Path2D p = new Path2D.Double();
        if (perspective) {
            p.moveTo(_vertex[0].getX() * (1 + _vertex[0].getZ() / c), _vertex[0].getY() * (1 + _vertex[0].getZ() / c));
            p.lineTo(_vertex[1].getX() * (1 + _vertex[1].getZ() / c), _vertex[1].getY() * (1 + _vertex[1].getZ() / c));
            p.lineTo(_vertex[2].getX() * (1 + _vertex[2].getZ() / c), _vertex[2].getY() * (1 + _vertex[2].getZ() / c));
            p.lineTo(_vertex[3].getX() * (1 + _vertex[3].getZ() / c), _vertex[3].getY() * (1 + _vertex[3].getZ() / c));
            p.lineTo(_vertex[0].getX() * (1 + _vertex[0].getZ() / c), _vertex[0].getY() * (1 + _vertex[0].getZ() / c));
        } else {
            p.moveTo(_vertex[0].getX(), _vertex[0].getY());
            p.lineTo(_vertex[1].getX(), _vertex[1].getY());
            p.lineTo(_vertex[2].getX(), _vertex[2].getY());
            p.lineTo(_vertex[3].getX(), _vertex[3].getY());
            p.lineTo(_vertex[0].getX(), _vertex[0].getY());
        }
        p.closePath();
        g.setColor(_color);
        if (transp) g.draw(p);
        else g.fill(p);
    }
    public boolean isVisible() {
        return R3Vector.vect(
                R3Vector.toR3Vector(_vertex[0], _vertex[1]),
                R3Vector.toR3Vector(_vertex[1], _vertex[2])
        ).getZ() > 0;
    }
    public boolean isVisiblePersp(int c) {
        return R3Vector.vect(
                R3Vector.toR3Vector(new R3Vector(_vertex[0].getX() * (1 + _vertex[0].getZ() / c), _vertex[0].getY() * (1 + _vertex[0].getZ() / c), _vertex[0].getZ()),
                        new R3Vector(_vertex[1].getX() * (1 + _vertex[1].getZ() / c), _vertex[1].getY() * (1 + _vertex[1].getZ() / c), _vertex[1].getZ())),
                R3Vector.toR3Vector(new R3Vector(_vertex[1].getX() * (1 + _vertex[1].getZ() / c), _vertex[1].getY() * (1 + _vertex[1].getZ() / c), _vertex[1].getZ()),
                        new R3Vector(_vertex[2].getX() * (1 + _vertex[2].getZ() / c), _vertex[2].getY() * (1 + _vertex[2].getZ() / c), _vertex[2].getZ()))
        ).getZ() > 0;
    }
}
