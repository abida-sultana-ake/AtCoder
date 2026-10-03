# -*- coding: UTF-8 -*-

def cal(count):
    if(count == 1):
        return 1
    else:
        return count * (count + 1)/2



if __name__ == "__main__":
    n = int(raw_input())
    a = map(int, raw_input().split())

    t = 1
    c = 0

    for l in range(n):
        if(l+1 == n):
            c = c + cal(t)
        elif(a[l+1] > a[l]):
            t = t + 1
        else:
            c = c + cal(t)
            t = 1

    print(c)
