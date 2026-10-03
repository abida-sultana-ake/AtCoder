A, B = map(int, input().split())

total = A+B

if A >= 1 and B <=9 :
    if total < 10:
        print(total)
    else:
        print('error')