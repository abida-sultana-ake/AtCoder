x=input()
print("YES"if all(x[i]==x[len(x)-i-1]for i in range(len(x)))else"NO")