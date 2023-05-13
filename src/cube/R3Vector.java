package cube;

public class R3Vector {
    private double _x, _y, _z;

    public R3Vector(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getZ() {
        return _z;
    }
    public void scale(double k) {
        _x *= k;
        _y *= k;
        _z *= k;
    }
    public void translate(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }
    public void rotate(double ux, double uy, double uz) {
        rotateX(ux);
        rotateY(uy);
        rotateZ(uz);
    }
    private void rotateX(double u) {
        u = Math.toRadians(u);
        double y = _y;
        _y = _y * Math.cos(u) - _z * Math.cos(u);
        _z = _z * Math.cos(u) + y * Math.sin(u);
    }
    private void rotateY(double u) {
        u = Math.toRadians(u);
        double x = _x;
        _x = _z * Math.sin(u)  + _x * Math.cos(u);
        _z = _z * Math.cos(u) - x * Math.sin(u);
    }
    private void rotateZ(double u) {
        u = Math.toRadians(u);
        double x = _x;
        _x = _x * Math.cos(u) - _y * Math.sin(u);
        _y = x * Math.sin(u) + _y * Math.cos(u);
    }

    public static R3Vector vect(R3Vector a, R3Vector b){
        return new R3Vector(a._y*b._z - a._z*b._y,
                a._z*b._x - a._x*b._z,
                a._x*b._y - a._y*b._x);
    }

	/*
	public static R3Vector dot(R3Vector a, R3Vector b){
		return new R3Vector(a._x*b._x,a._y*b._y, a._z*b._z);
	}
	*/
    public static R3Vector toR3Vector(R3Vector begin, R3Vector end){
        return new R3Vector(end._x - begin._x,
                end._y - begin._y,
                end._z - begin._z);
    }
}
