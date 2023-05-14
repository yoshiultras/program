package cube;

public class R3Vector {
    public double x, y, z;

    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    public void scale(double k){
        x *= k;
        y *= k;
        z *= k;
    }
    public void translate(double dx, double dy, double dz){
        x+=dx;
        y+=dy;
        z+=dz;
    }
    public void rotate(double ux, double uy, double uz){
        this.rotateX(ux);
        this.rotateY(uy);
        this.rotateZ(uz);
    }
    private void rotateX(double u) {
        u = Math.toRadians(u);
        double a = y;
        y = y * Math.cos(u) - z * Math.sin(u);
        z = a * Math.sin(u) + z * Math.cos(u);
    }
    private void rotateY(double u) {
        u = Math.toRadians(u);
        double a = z;
        z = z * Math.cos(u) - x * Math.sin(u);
        x = a * Math.sin(u) + x * Math.cos(u);
    }
    private void rotateZ(double u) {
        u = Math.toRadians(u);
        double a = x;
        x = x * Math.cos(u) - y * Math.sin(u);
        y = a * Math.sin(u) + y * Math.cos(u);
    }

    //    public static R3Vector dot(R3Vector a, R3Vector b){
//        return new R3Vector(a.x*b.x,a.y*b.y, a.z*b.z);
//    }
    public static R3Vector vect(R3Vector a, R3Vector b){
        return new R3Vector(a.y*b.z - a.z*b.y,
                a.z*b.x - a.x*b.z,
                a.x*b.y - a.y*b.x);
    }
    public static R3Vector toR3Vector(R3Vector begin, R3Vector end){
        return new R3Vector(end.x - begin.x,
                end.y - begin.y,
                end.z - begin.z);
    }
}
