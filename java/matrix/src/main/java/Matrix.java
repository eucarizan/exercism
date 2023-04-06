import java.util.Arrays;

class Matrix {
    private int[][] matrix;

    Matrix(String matrixAString) {
        matrix = Arrays.stream(matrixAString.split("\n"))
                .map(row -> Arrays.stream(row.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(row -> row[columnNumber - 1]).toArray();
    }

}

// class Matrix {
//     int[][] matrix;
//     int row;
//     int col;

//     Matrix(String matrixAsString) {
//         String[] arr = matrixAsString.split("\n");
//         String[] arr2 = arr[0].split(" ");

//         row = arr.length;
//         col = arr2.length;

//         this.matrix = new int[row][col];

//         for (int i = 0; i < arr.length; i++) {
//             String[] row = arr[i].split(" ");
//             for (int j = 0; j < row.length; j++) {
//                 matrix[i][j] = Integer.parseInt(row[j]);
//             }
//         }
//     }

//     int[] getRow(int rowNumber) {
//         int[] output = new int[col];

//         for (int i = 0; i < col; i++) {
//             output[i] = matrix[rowNumber - 1][i];
//         }

//         return output;
//     }

//     int[] getColumn(int columnNumber) {
//         int[] output = new int[row];

//         for (int i = 0; i < row; i++) {
//             output[i] = matrix[i][columnNumber - 1];
//         }

//         return output;
//     }
// }
