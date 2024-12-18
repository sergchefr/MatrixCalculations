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

    public static Matrix getMinor(Matrix matrix, int a, int b){
        RegularFrac[][] c = new RegularFrac[matrix.getHeight()-1][matrix.getWidth()-1];
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {

                if (a==i | b==j) continue;
                else if (i<a&j<b) c[i][j] = matrix.getMatrix()[i][j];
                else if (i<a&j>b) c[i][j-1] = matrix.getMatrix()[i][j];
                else if (i>a&j<b) c[i-1][j] = matrix.getMatrix()[i][j];
                else if (i>a&j>b) c[i-1][j-1] = matrix.getMatrix()[i][j];
            }
        }
        return new Matrix(c);
    }

    public static RegularFrac getDet2x2(Matrix matrix){
        if (matrix.getWidth()!=2 | matrix.getHeight()!=2) throw new MatrixException("not a 2x2 matrix");
        return FracMath.sum(FracMath.prod(matrix.getMatrix()[0][0],matrix.getMatrix()[1][1]),FracMath.prod(FracMath.prod(matrix.getMatrix()[0][1],matrix.getMatrix()[1][0]),-1));
    }


}
