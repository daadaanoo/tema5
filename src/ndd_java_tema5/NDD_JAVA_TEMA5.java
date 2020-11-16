package NDD_JAVA_tema5;

import java.io.FileOutputStream;
import java.util.Random;
import java.util.prefs.Preferences;

public class NDD_JAVA_TEMA5 {

    public static void main(String[] args) {
        Preferences node = Preferences.userRoot().node("tema5");
        System.out.println("Если в таблице сумма значений не равна нулю, то уменьшить максимальный элемент таблицы в два раза, а минимальный элемент уменьшить в три раза");

        final int rows = 4;
        final int columns = 5;
        int matrix[][] = new int[rows][columns];
        int k, A, B, C, D, E;
        System.out.println("Матрица");
        Random random = new Random();
        // Создаем случайные данные для xml
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //k = (int) Math.round(Math.random() * 9);
                k = random.nextInt(10);
                matrix[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }

        // Реализация алгоритма по варианту задания
        int countOfOne = 0, max = matrix[0][0], maxi = 0, maxj = 0;
        //поиск максимального элемента
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                k = matrix[i][j];
                if (k > max) {
                    max = k;
                    maxi = i;
                    maxj = j;
                }
            }
        }
        int min = matrix[0][0], mini = 0, minj = 0;
        //поиск минимального элемента
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                k = matrix[i][j];
                if (k < min) {
                    min = k;
                    mini = i;
                    minj = j;
                }
            }
        }

        System.out.println("Макс.элем.: a[" + (maxi + 1) + "," + (maxj + 1) + "] = " + matrix[maxi][maxj] + "," + "Мин.элем.: a[" + (min + 1) + "," + (minj + 1) + "] = " + matrix[mini][minj]);

        matrix[maxi][maxj] = matrix[maxi][maxj] / 2;
        matrix[mini][minj] = matrix[mini][minj] / 3;

        for (int i = 0; i < rows; i++) {
            node.putInt("A" + i, matrix[i][0]);
            node.putInt("B" + i, matrix[i][1]);
            node.putInt("C" + i, matrix[i][2]);
            node.putInt("D" + i, matrix[i][3]);
            node.putInt("E" + i, matrix[i][4]);
        }
        System.out.println("Новая матрица:");
        for (int i = 0; i < rows; i++) {
            A = node.getInt("A" + i, 0);
            B = node.getInt("B" + i, 0);
            C = node.getInt("C" + i, 0);
            D = node.getInt("D" + i, 0);
            E = node.getInt("E" + i, 0);
            System.out.println(A + " " + B + " " + C + " " + D + " " + E);
        }
        try {
            node.exportSubtree(new FileOutputStream("myPreferences.xml"));
        } catch (Exception e) {
        }

    }
}
