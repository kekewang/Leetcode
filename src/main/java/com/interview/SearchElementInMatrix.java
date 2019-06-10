package com.interview;

class StaticStuff {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        System.out.println("x=" + x);
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    static {
        x /= 3;
    }
}

public class SearchElementInMatrix {

    private int[][] matrix = new int[3][3];

    SearchElementInMatrix() {
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
    }

    public boolean searchMatrix() {
        return doSearch(0, 0, 10);
    }

    public boolean doSearch(int i, int j, int k) {

        if (i >= 3 || j >= 3) return false;

        if (matrix[i][j] < k) {
            boolean r1 = doSearch(i + 1, j, k);
            if (r1) return r1;

            boolean r2 = doSearch(i, j + 1, k);
            if (r2) return r2;
        } else if (matrix[i][j] == k) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        SearchElementInMatrix s = new SearchElementInMatrix();
        System.out.println(s.searchMatrix());
    }
}
