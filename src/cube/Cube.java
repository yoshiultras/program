package cube;

import java.awt.*;

public class Cube {
    Facet[] facets;

    public Cube() {
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0), new R3Vector(1,1,0), new R3Vector(1,0,0), Color.red);//задн€€
        facets[1] = new Facet(new R3Vector(0,0,1), new R3Vector(1,0,1), new R3Vector(1,1,1), new R3Vector(0,1,1), Color.ORANGE);//передн€€
        facets[2] = new Facet(new R3Vector(0,1,0), new R3Vector(0,1,1), new R3Vector(1,1,1), new R3Vector(1,1,0), Color.blue);//верхн€€
        facets[3] = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,0,1), new R3Vector(0,0,1), Color.green);//нижн€€
        facets[4] = new Facet(new R3Vector(1,1,1), new R3Vector(1,0,1), new R3Vector(1,0,0), new R3Vector(1,1,0), Color.cyan);//права€
        facets[5] = new Facet(new R3Vector(0,1,1), new R3Vector(0,1,0), new R3Vector(0,0,0), new R3Vector(0,0,1), Color.MAGENTA);//лева€
        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double k) {
        for (Facet facet : facets) {
            facet.scale(k);
        }
    }
    public void translate(double dx, double dy, double dz) {
        for (Facet facet : facets) {
            facet.translate(dx, dy, dz);
        }
    }
    public void rotate(double ux, double uy, double uz) {
        for (Facet facet : facets) {
            facet.rotate(ux, uy, uz);
        }
    }
    public void draw(Graphics2D g, boolean transp) {
        for (Facet facet : facets) {
            if(facet.isVisible()) facet.draw(g, transp);
        }
    }
}
