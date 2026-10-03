K,S = map(int, input().split(" "))

combo_count = 0
for X in range(max(0, S-K*2), min(S//3, K)+1):
    S2 = S-X
    for Y in range(max(X,S2-K), min(S2//2, K)+1):
        Z = S2 - Y
        if X == Y and Y == Z:
            combo_count += 1
        elif X == Y or Y == Z:
            combo_count += 3
        else:
            combo_count += 6
print(combo_count)