
public class testlisne {
    public static void main(String[] args) {
        Line l1 = new Line(0, 1, 3, 4);
        Line l2 = new Line(1, 3, 3, 3);
        Point p1 = l2.intersectionWith(l1);
        System.out.println(p1.getX());
        System.out.println(p1.getY());
    }

}
