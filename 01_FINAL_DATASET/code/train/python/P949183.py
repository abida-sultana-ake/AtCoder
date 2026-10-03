n = int(input())

t, a = map(int,input().split())
vote1 = t
vote2 = a

for i in range(n - 1):
    t, a = map(int,input().split())

    num1 = (vote1 + t - 1) // t
    num2 = (vote2 + a - 1) // a

    if num1 >= num2:
        vote1 = num1 * t
        vote2 = num1 * a
    else:
        vote1 = num2 * t
        vote2 = num2 * a

print(vote1 + vote2)
