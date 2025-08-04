package Day13; // problem no. 73

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        input = input.replaceAll("\\[\\[", "").replaceAll("]]", "");
        String[] rows = input.split("],\\s*\\[");

        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(",");
            matrix[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                matrix[i][j] = Integer.parseInt(elements[j].trim());
            }
        }

        Solution ob = new Solution();
        ob.setZeroes(matrix);

        // Printing in same nested array format
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            if (i < matrix.length - 1) System.out.print(",");
        }
        System.out.println("]");
        sc.close();
    }
}
