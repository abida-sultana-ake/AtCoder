if __name__ == '__main__':
    N = int(input())
    magic_lst_1 = []
    magic_lst_2 = []
    for _ in range(N):
        a, b = map(int, input().split(" "))
        if a < b:
            magic_lst_1.append([a, b])
        else:
            magic_lst_2.append([a, b])
    sorted_lst_1 = sorted(magic_lst_1, key=lambda x: x[0])
    sorted_lst_2 = sorted(magic_lst_2, key=lambda x: -x[1])
    temp = 0
    max_temp = 0
    for s in sorted_lst_1:
        temp += s[0]
        if temp > max_temp:
            max_temp = temp
        temp -= s[1]
    for s in sorted_lst_2:
        temp += s[0]
        if temp > max_temp:
            max_temp = temp
        temp -= s[1]

    print(max_temp)
