N = input()
t = N[0]
jurge = "SAME"
for i in range(1, len(N)):
    if t == N[i]:
        pass
    else:
        jurge = "DIFFERENT"
        break
if jurge == "SAME":
    print("SAME")
else:
    print("DIFFERENT")
    