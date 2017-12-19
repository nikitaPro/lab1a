package matrix;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatrixServiceTest {
  private int[][] squareExpectedMatrix = new int[][] { { 1, 1, 1, 1 }, { 0, 2, 1, 1 },
      { 0, 0, 3, 1 }, { 0, 0, 0, 4 } };
  private MatrixService matrix;

  @Before
  public void setUp() throws Exception {
    matrix = new MatrixService();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSortDiagonalMatrix10by0() {
    int[][] matrix10x0 = new int[10][0];
    matrix.sortDiagonal(matrix10x0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSortDiagonalTriangularMatrix() {
    int[][] triangularMatrix = new int[][] { { 2 }, { 0, 4 }, { 0, 0, 3 }, { 0, 0, 0, 1 } };
    matrix.sortDiagonal(triangularMatrix);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSortDiagonalRectangularMatrix1() {
    int[][] rectangularMatrix1 = new int[][] { { 2, 1, 1, 1, 1 }, { 0, 4, 1, 1, 1 },
        { 0, 0, 3, 1, 1 }, { 0, 0, 0, 1, 1 } };
    matrix.sortDiagonal(rectangularMatrix1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSortDiagonalRectangularMatrix2() {
    int[][] rectangularMatrix2 = new int[][] { { 2, 1, 1, 1 }, { 0, 4, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
    matrix.sortDiagonal(rectangularMatrix2);
  }

  @Test
  public void testSortDiagonalSquareRandomMatrix() {
    int[][] squareRandomMatrix = new int[][] { { 2, 1, 1, 1 }, { 0, 4, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 1 } };
    matrix.sortDiagonal(squareRandomMatrix);
    assertArray2DEquals(squareExpectedMatrix, squareRandomMatrix);
  }

  @Test
  public void testSortDiagonalSquareDescendingMatrix() {
    int[][] squareDescendingMatrix = new int[][] { { 4, 1, 1, 1 }, { 0, 3, 1, 1 }, { 0, 0, 2, 1 },
        { 0, 0, 0, 1 } };
    matrix.sortDiagonal(squareDescendingMatrix);
    assertArray2DEquals(squareExpectedMatrix, squareDescendingMatrix);
  }

  @Test
  public void testSortDiagonalSquareAscendingMatrix2() {
    int[][] squareAscendingMatrix2 = new int[][] { { 1, 1, 1, 1 }, { 0, 2, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 4 } };
    matrix.sortDiagonal(squareAscendingMatrix2);
    assertArray2DEquals(squareExpectedMatrix, squareAscendingMatrix2);
  }

  @Test
  public void testSortDiagonalZiroMatrix() {
    int[][] ziroMatrix = new int[0][0];
    matrix.sortDiagonal(ziroMatrix);
  }

  @Test
  public void testSortDiagonalMatrix1x1() {
    int[][] matrix1x1 = new int[][] { { 5 } };
    matrix.sortDiagonal(matrix1x1);
    assertArrayEquals(new int[][] { { 5 } }, matrix1x1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMirrorTriangularMatrix() {
    int[][] triangularMatrix = new int[][] { { 2 }, { 0, 4 }, { 0, 0, 3 }, { 0, 0, 0, 1 } };
    matrix.mirror(triangularMatrix);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMirrorRectangularMatrix1() {
    int[][] rectangularMatrix1 = new int[][] { { 2, 1, 1, 1, 1 }, { 0, 4, 1, 1, 1 },
        { 0, 0, 3, 1, 1 }, { 0, 0, 0, 1, 1 } };
    matrix.mirror(rectangularMatrix1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMirrorRectangularMatrix2() {
    int[][] rectangularMatrix2 = new int[][] { { 2, 1, 1, 1 }, { 0, 4, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
    matrix.mirror(rectangularMatrix2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMirrorMatrix10by0() {
    int[][] matrix10x0 = new int[10][0];
    matrix.mirror(matrix10x0);
  }

  @Test
  public void testMirrorSquareRandomMatrix() {
    int[][] squareRandomMatrix = new int[][] { { 2, 1, 1, 1 }, { 0, 4, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 1 } };
    matrix.mirror(squareRandomMatrix);
    int[][] squareMirrorRandomMatrix = new int[][] { { 2, 0, 0, 0 }, { 0, 4, 0, 0 }, { 0, 0, 3, 0 },
        { 0, 0, 0, 1 } };
    assertArray2DEquals(squareMirrorRandomMatrix, squareRandomMatrix);
  }

  @Test
  public void testMirrorSquareAscendingMatrix2() {
    int[][] squareAscendingMatrix2 = new int[][] { { 1, 1, 1, 1 }, { 0, 2, 1, 1 }, { 0, 0, 3, 1 },
        { 0, 0, 0, 4 } };
    matrix.mirror(squareAscendingMatrix2);
    int[][] squareMirrorAscendingMatrix = new int[][] { { 1, 0, 0, 0 }, { 0, 2, 0, 0 },
        { 0, 0, 3, 0 }, { 0, 0, 0, 4 } };
    assertArray2DEquals(squareMirrorAscendingMatrix, squareAscendingMatrix2);
  }

  @Test
  public void testMirrorMatrix1x1() {
    int[][] matrix1x1 = new int[][] {{5}};
    matrix.mirror(matrix1x1);
    assertArrayEquals(new int[][] { { 5 } }, matrix1x1);
  }

  @Test
  public void testMirrorZiroMatrix() {
    int[][] ziroMatrix = new int[0][0];
    matrix.mirror(ziroMatrix);
  }

  private void assertArray2DEquals(int[][] array1, int[][] array2) {
    if (array1.length != array2.length) {
      fail();
    }
    for (int i = 0; i < array1.length; i++) {
      assertArrayEquals(array1, array2);
    }
  }
}
