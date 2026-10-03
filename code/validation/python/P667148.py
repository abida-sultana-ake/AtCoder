class Person:
    def __init__(self, x: float, y: float, c: float):
        self.x = x
        self.y = y
        self.c = c

if __name__ == '__main__':
    # 入力
    n = int(input())
    persons = []
    for i in range(0, n):
        x, y, c = map(float, input().split())
        persons.append(Person(x, y, c))

    max_time = 10 ** (5 + 3) * 2 + 1.
    min_time = 0.0
    mid_time = (max_time + min_time) / 2

    while (max_time - min_time > 0.0001):
        x_max = min([p.x + mid_time / p.c for p in persons])
        x_min = max([p.x - mid_time / p.c for p in persons])
        y_max = min([p.y + mid_time / p.c for p in persons])
        y_min = max([p.y - mid_time / p.c for p in persons])

        if x_max > x_min and y_max > y_min:
            max_time = mid_time
            mid_time = (max_time + min_time) / 2
        else:
            min_time = mid_time
            mid_time = (max_time + min_time) / 2

    print(mid_time)
