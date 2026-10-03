#coding:utf-8

if __name__ == "__main__":
    n, m = map(int, raw_input().split(" "))
    x_list = map(int, raw_input().split(" "))
    y_list = map(int, raw_input().split(" "))

    x_sum = 0
    for i in range(1, n + 1):
        x_sum += (i - 1) * x_list[i-1] - (n - i) * x_list[i-1]

    y_sum = 0
    for j in range(1, m + 1):
        y_sum += (j - 1) * y_list[j-1] - (m - j) * y_list[j-1]

    print (x_sum * y_sum) % (10 ** 9 + 7)
