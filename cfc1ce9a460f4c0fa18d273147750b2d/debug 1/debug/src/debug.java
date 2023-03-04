public class debug {
    public static void main(String arg[]) {
        int[][] A = {
                {1, 2, 3},
                {1, 2, 3},
        };
        int[][] B = {
                {1, 2},
                {1, 2},
                {1, 2},
        };
        int hang = A.length;
        int lie = B[0].length;

        int[][] C = new int[hang][];
        for (int i = 0; i < hang; i++) {
            C[i] = new int[lie];
            for (int j = 0; j < lie; j++) {
                C[i][j] = 0;


                for (int y = 0; y < A[0].length; y++) {
                    C[i][j] += A[i][y] * B[y][j];
                }

            }
        }

        int hang2 = C.length;
        int lie2 = C[0].length;

        System.out.print("\n");

        for (int i = 0; i < hang2; i++) {
            for (int j = 0; j < lie2 - 1; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println(C[i][lie2 - 1]);
        }
    }
}
