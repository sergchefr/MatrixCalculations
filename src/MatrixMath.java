public class MatrixMath {
    public static Matrix sum(Matrix a, Matrix b){
        if (a.getHeight()!=b.getHeight() | a.getWidth()!=b.getWidth()) throw new MatrixException("different matrix sizes");
        RegularFrac[][] c = new RegularFrac[a.getHeight()][a.getWidth()];
        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < a.getWidth(); j++) {
                c[i][j]=FracMath.sum(a.getMatrix()[i][j],b.getMatrix()[i][j]);
            }
        }
        return new Matrix(c);
    }

    public static Matrix prod(Matrix a,long b){
        RegularFrac[][] c = new RegularFrac[a.getHeight()][a.getWidth()];
        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < a.getWidth(); j++) {
                c[i][j]=FracMath.prod(a.getMatrix()[i][j],b);
            }
        }
        return new Matrix(c);
    }
    public static Matrix prod(Matrix a,RegularFrac b){
        RegularFrac[][] c = new RegularFrac[a.getHeight()][a.getWidth()];
        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < a.getWidth(); j++) {
                c[i][j]=FracMath.prod(a.getMatrix()[i][j],b);
            }
        }
        return new Matrix(c);
    }

    public static Matrix prod(Matrix a,Matrix b){
        if(a.getWidth()!=b.getHeight()) throw new MatrixException("unable to prod");
        RegularFrac[][] c = new RegularFrac[a.getHeight()][b.getWidth()];
        for (int m = 0; m < a.getHeight(); m++) {
            for (int n = 0; n < b.getWidth(); n++) {

                RegularFrac h= new RegularFrac(0);
                for (int k = 0; k < a.getWidth(); k++) {
                    h=FracMath.sum(h, FracMath.prod(a.getMatrix()[m][k],b.getMatrix()[k][n]));
                }
                c[m][n] = h;

            }
        }
        return new Matrix(c);
    }
}
