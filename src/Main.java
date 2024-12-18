//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RegularFrac a = new RegularFrac(1,8);
        RegularFrac b = new RegularFrac(2,8);

        Matrix c = new Matrix(new long[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });

        Matrix d=new Matrix(new long[][]{{1,2,3,4},{5,6,7,8}});

        //System.out.println(FracMath.devide(a,b));
        //System.out.println(c.getWidth());
        //System.out.println(c.getHeight());
        System.out.println(c);
        //System.out.println(d);
        System.out.println(MatrixMath.getMinor(c, 0,0));
        System.out.println(MatrixMath.getDet2x2(MatrixMath.getMinor(c, 0,0)));
        //System.out.println(MatrixMath.prod(d,c));
        //System.out.println(c.getMatrix()[0][1]);
        //System.out.println(new long[][]{{1,2,3},{4,5,6},{7,8,9}}.length);
        // SYSTEM.OUT SASI JOPU

    }
}

