N = int(input())
d = [int(input()) for i in range(N)]

# max
print(sum(d))
# min
if ((2*max(d) - sum(d)) > 0):
    print((2*max(d) - sum(d)))
else:
    print(0)