N = int(input())
w = [a for a in input().strip(".").split()]

result = sum([1 for i in w if i == "TAKAHASHIKUN"]) + sum([1 for i in w if i == "Takahashikun"]) + sum([1 for i in w if i == "takahashikun"])

print(result)