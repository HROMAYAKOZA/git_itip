public class ponter {
    public static void main(String[] args) {
        Point2d myPoint = new Point2d (); //создает точку (0,0)
        Point2d myOtherPoint = new Point2d (5,3); //создает точку (5,3)
        Point2d aThirdPoint = new Point2d();
        System.out.println(myOtherPoint.getX() + " " + myOtherPoint.getY());
        Point3d my3dPoint = new Point3d(3, 2, 1);
        System.out.println(my3dPoint.getX()+" "+my3dPoint.getY()+" "+my3dPoint.getZ());
    }
}
