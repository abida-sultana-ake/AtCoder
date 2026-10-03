N = int(input())
d = {int(input()):int(0) for _ in range(N)}
print(sorted(d.items(),key=lambda x:-x[0])[1][0])