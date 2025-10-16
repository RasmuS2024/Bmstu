package java;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class question5 {
    public static int findMinimumPathSum(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        int triangleHeight = triangle.size();
        // Используем только один массив длиной triangleHeight+1
        int[] dp = new int[triangleHeight + 1];
        
        // Проходим снизу вверх
        for (int row = triangleHeight - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Обновляем на месте - экономим память
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        
        return dp[0];
    }
    
    public static void main(String[] args) {
        // Пример 1
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        triangle1.add(Arrays.asList(6, 4, 9, 1, 7));

        int minSum1 = findMinimumPathSum(triangle1);
        System.out.println("Треугольник1: Минимальная сумма пути = " + minSum1);
        // Вывод: 15

        // Пример 2
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));

        int minSum2 = findMinimumPathSum(triangle2);
        System.out.println("Треугольник2: Минимальная сумма пути = " + minSum2);
        // Вывод: -10

        // Пример 3
        List<List<Integer>> triangle3 = new ArrayList<>();
        triangle3.add(Arrays.asList(1));
        triangle3.add(Arrays.asList(2, 3));

        int minSum3 = findMinimumPathSum(triangle3);
        System.out.println("Треугольник3: Минимальная сумма пути = " + minSum3);
        // Вывод: 3
    }
}
