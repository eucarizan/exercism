import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Matrix {
    Set<MatrixCoordinate> lmc = new HashSet<>();

    Matrix(List<List<Integer>> rows) {
        for (int i = 0; i < rows.size(); i++) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < row.size(); j++) {
                final int j2 = j;
                List<Integer> col = rows.stream().map(x -> x.get(j2)).collect(Collectors.toList());
                if (isSaddle(row.get(j), row, col)) {
                    lmc.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return lmc;
    }

    boolean isSaddle(Integer val, List<Integer> row, List<Integer> column) {
        Integer maxRow = row.stream().max(Integer::compare).get();
        Integer minCol = column.stream().min(Integer::compare).get();
        return val >= maxRow && val <= minCol;
    }
}

// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

// import static java.util.stream.IntStream.range;

// class Matrix {

// private final int rows;
// private final int cols;
// private final int[] rowsMax;
// private final int[] colsMin;

// Matrix(List<List<Integer>> values) {
// this.rows = values.size();
// this.cols = rows > 0 ? values.get(0).size() : 0;

// this.rowsMax = values.stream()
// .mapToInt(row -> row.stream().mapToInt(Integer::intValue)
// .max().orElseThrow())
// .toArray();

// this.colsMin = range(0, cols)
// .map(col -> range(0, rows)
// .map(i -> values.get(i).get(col)).min().orElseThrow())
// .toArray();
// }

// Set<MatrixCoordinate> getSaddlePoints() {
// return range(0, rows).boxed()
// .flatMap(row -> range(0, cols)
// .filter(col -> rowsMax[row] == colsMin[col])
// .mapToObj(col -> new MatrixCoordinate(row + 1, col + 1)))
// .collect(Collectors.toSet());
// }
// }
