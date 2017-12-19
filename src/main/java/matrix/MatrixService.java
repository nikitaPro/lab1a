package matrix;

import org.jetbrains.annotations.NotNull;

public class MatrixService {

  /**
   * The elements of the main diagonal of a square matrix will be sorted in ascending order.
   * 
   * @param matrix
   *          a square matrix of int values which will be sorted.
   * @throws IllegalArgumentException
   *           if matrix not square
   */
  public void sortDiagonal(@NotNull int[][] matrix) {
    if (!isSquare(matrix)) {
      throw new IllegalArgumentException("Only square matrix permitted");
    }
    int size = matrix.length;
    int[] diag = new int[size];
    for (int i = 0; i < size; i++) {
      diag[i] = matrix[i][i];
    }
    int buf;
    boolean already;
    for (int i = 0; i < diag.length; i++) {
      already = true;
      for (int j = 0; j < diag.length - 1 - i; j++) {
        if (diag[j] > diag[j + 1]) {
          buf = diag[j];
          diag[j] = diag[j + 1];
          diag[j + 1] = buf;
          already = false;
        }
      }
      if (already) {
        break;
      }
    }
    for (int i = 0; i < size; i++) {
      matrix[i][i] = diag[i];
    }
  }

  /**
   * Mirror reflect a square matrix elements under the main diagonal, by elements which above the
   * main diagonal.
   * 
   * @param matrix
   *          a square matrix of int values which will reflected.
   * @throws IllegalArgumentException
   *           if matrix not square
   */
  public void mirror(@NotNull int[][] matrix) {
    if (!isSquare(matrix)) {
      throw new IllegalArgumentException("Only square matrix permitted");
    }
    int size = matrix.length;
    for (int i = 0; i < size; i++) {
      for (int j = 1 + i; j < size; j++) {
        matrix[i][j] = matrix[j][i];
      }
    }
  }

  /**
   * Returns whether matrix is a square.
   * 
   * @param matrix
   *          a square matrix of int values which will reflected.
   * @return true, if the matrix is a square, false otherwise
   */
  private boolean isSquare(int[][] matrix) {
    int rowSize = matrix.length;
    boolean isEqual = true;
    for (int i = 0; i < rowSize; i++) {
      isEqual &= rowSize == matrix[i].length;
    }
    return isEqual;
  }
}
