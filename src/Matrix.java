import java.util.Arrays;

public class Matrix {
    private RegularFrac[][] matrix;//1- str number, 2 - column number
    
    public Matrix(RegularFrac[][] matrix){
        this.matrix=matrix;
    }

    public Matrix(long[][] matrix){
        RegularFrac[][] c = new  RegularFrac[matrix[0].length][matrix.length];
        for (int m = 0; m < matrix[0].length; m++) {
            for (int n = 0; n < matrix.length; n++) {
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
        return matrix;
    }
}
