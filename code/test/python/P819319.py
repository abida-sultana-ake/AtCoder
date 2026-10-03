S = input()
P = "WBWBWWBWBWBW"*3
A = (["Do"]*2+["Re"]*2+["Mi"]+["Fa"]*2+["So"]*2+["La"]*2+["Si"])*2
print(A[P.find(S)])