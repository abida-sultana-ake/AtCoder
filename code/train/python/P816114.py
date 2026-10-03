def no_dislike_number(num, D):
    for dislike in D:
        if dislike in num:
            return False
    return True

MAX = 10000
N, K = map(int, input().split())
D = input().split()
num = N
while(True):
    if no_dislike_number(str(num), D):
        print(num)
        break
    num += 1