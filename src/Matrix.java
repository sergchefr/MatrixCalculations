public class Matrix implements Cloneable {
    private RegularFrac[][] matrix;//1- str number, 2 - column number
    private int width;
    private int height;
    
    public Matrix(RegularFrac[][] matrix){
        this.matrix=matrix;
        this.width = this.matrix[0].length;
        this.height = matrix.length;
        for (RegularFrac[] regularFracs : matrix) {
            if(regularFracs.length!= width) throw  new MatrixException("different string length");
        }
    }

    public Matrix(long[][] matrix){
        this.width = matrix[0].length;
        this.height = matrix.length;
        for (long[] str : matrix) {
            if(str.length!= width) throw  new MatrixException("different string length");
        }
        RegularFrac[][] c = new  RegularFrac[matrix.length][matrix[0].length];
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[0].length; n++) {
                c[m][n] = new RegularFrac(matrix[m][n]);
            }
        }
        this.matrix=c;
    }

    @Override
    public String toString() {
        String c ="";
        for (RegularFrac[] str : matrix) {
            for (RegularFrac element : str) {
                c+=element+" ";
            }
            c+="\n";
        }
        return c;
    }

    public RegularFrac[][] getMatrix() {
        return matrix.clone();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Matrix clone(){
        return new Matrix(this.getMatrix().clone());
    }
}
