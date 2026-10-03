X, Y = [int(x) for x in input().split()]

lose = [-1,0,1]

if X-Y in lose:
    print("Brown")
else:
    print("Alice")