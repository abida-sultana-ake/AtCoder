def read_int_list():
    return list(map(int, input().split()))

n = read_int_list()
n.sort()
print(n[0]+n[1])