package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/4
 */
public class RotateImage {


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose the matrix;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        } // mirror the transposed matrix horizontally
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

    }

    public void print(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage.print(matrix);
        System.out.println(" ====start======");
        rotateImage.rotate(matrix);
        System.out.println(" ======end====");
        rotateImage.print(matrix);
    }
}
