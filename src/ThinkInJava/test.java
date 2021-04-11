package ThinkInJava;


class Glyph {
    private int biao = 2;
    void draw() {System.out.println("Glyph.draw()"); }
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
    private static int biao2 = 2;
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    private static int biao3 = 3;
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}



public class test {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }

}
