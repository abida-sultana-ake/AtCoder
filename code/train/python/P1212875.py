o = str(input())
e = str(input())
print("".join(i + j for i, j in zip(o, e + " ")).rstrip())
