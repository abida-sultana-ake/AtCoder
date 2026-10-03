def match():
    start = 0
    for start in range(12):
        for i in range(20):
            if S[i] != piano[start + i]:
                break
        else:
            return start

piano = "WBWBWWBWBWBW" * 10
S = input()
lst = ["Do"] * 2 + ["Re"] * 2 + ["Mi"] + ["Fa"] * 2 + ["So"] * 2 + ["La"] * 2 + ["Si"]
m = match()
print(lst[m])
