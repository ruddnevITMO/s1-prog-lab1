public class Main {
    public static void main(String[]args) {
        int amountOf = 0;
        for ( int i = 4; i <= 24; i+=2 ) {
            if (i % 2 == 0) {
                amountOf += 1;
            }
        }
        long[] d = new long[amountOf];
        float[] x = new float[19];
        double[][] p = new double[11][19];
        for (int i = 0, j = 4; j <= 24; i++, j+=2) { d[i] = j; }
        for (int i = 0; i < 19; i++) {
            float min = -9.0f;
            float max = 5.0f;
            float range = max - min;
            x[i] = min + (float)(Math.random() * range);
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                // если d[i] == 10
                if (d[i] == 10) {
                    p[i][j] = Math.atan((Math.PI / 4) * Math.pow(((x[j] -
                            2)/14), 2));
                }
                // если d[i] in {4, 6, 14, 20, 22}
                else if (d[i] == 4 || d[i] == 6 || d[i] == 14 || d[i] == 20
                        || d[i] == 22) {
                    p[i][j] = Math.atan(Math.sin(x[j]));
                }
                // для остальных значений d[i]
                else {
                    p[i][j] = Math.cbrt(Math.atan(1 / Math.pow(Math.E,
                            Math.abs(x[j]))));
                }
            }
        }

        for ( int i = 0; i < p.length; i++ ) {
            for ( int j = 0; j < p[i].length; j++ ) {
                System.out.printf("%.4f\t", p[i][j]);
            }
            System.out.printf("\n");
        }
    }
}