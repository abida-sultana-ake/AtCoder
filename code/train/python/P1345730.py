import numpy as np

if __name__ == "__main__":
    N = int(input())
    a = input().split()

    a = list(map(int, a))
    a = np.array(a)

    colors_flag = np.zeros(8)
    other = 0
    for rate in a:
        if(rate >= 3200):
            other += 1
        elif(colors_flag[int(rate/400)] == 1):
            continue
        else:
            colors_flag[int(rate/400)] = 1
    color_num = np.sum(colors_flag)
    print(int(color_num if color_num != 0 else 1), int(color_num + other))
