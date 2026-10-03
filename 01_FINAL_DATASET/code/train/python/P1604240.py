def read_int_list():
    return list(int(i) for i in input().split())
a = sorted(read_int_list())
print(a[-1] + max(a[-2]+a[-5], a[-3]+a[-4]))