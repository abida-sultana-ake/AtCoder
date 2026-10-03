import math

n, a, b = map(int, input().split())
mamono = [int(input()) for _ in range(n)]

def f(num):
        base = b * num
        diff = a - b
        attackcount = 0
        for i in range(n):
                tmp = math.ceil((mamono[i] - base) / diff)
                if tmp <= 0:
                        pass
                else:
                        attackcount += tmp 
        if attackcount <= num:
                return True
        else:
                return False


def bs(min, max):
        left = min
        right = max
        while left != right:
                mid = (left + right) //2
                if f(mid):
                        right = mid
                else:
                        left = mid + 1
        return left

print(bs(0, 1000000000))