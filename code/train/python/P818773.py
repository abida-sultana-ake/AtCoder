H1, W1 = map(int, input().split())
H2, W2 = map(int, input().split())
if (H1 - H2)*(H1 - W2)*(W1 - H2)*(W1 - W2) == 0:
 print("YES")
else:
 print("NO")
