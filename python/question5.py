# функция для поиска минимального пути
def find_minimum_path_sum(triangle):
    if not triangle:
        return 0
    
    triangle_height = len(triangle)
    # Используем только один массив длиной triangle_height+1
    dp = [0] * (triangle_height + 1)
    
    # Проходим снизу вверх
    for row in range(triangle_height - 1, -1, -1):
        for col in range(len(triangle[row])):
            # Обновляем на месте - экономим память
            dp[col] = triangle[row][col] + min(dp[col], dp[col + 1])
    
    return dp[0]


# примеры:

triangle1 = [
    [2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3],
    [6, 4, 9, 1, 7]
]

# Ожидаемый результат: 15
min_sum1 = find_minimum_path_sum(triangle1)
print(f"Треугольник1: Минимальная сумма пути = {min_sum1}") 
# Вывод: 15

triangle2 = [
    [-10]
]

# Ожидаемый результат: -10
min_sum2 = find_minimum_path_sum(triangle2)
print(f"Треугольник2: Минимальная сумма пути = {min_sum2}")
# Вывод: -10

triangle3 = [
    [1],
    [2, 3]
]

# Ожидаемый результат: 3
min_sum3 = find_minimum_path_sum(triangle3)
print(f"Треугольник3: Минимальная сумма пути = {min_sum3}")
# Вывод: 3