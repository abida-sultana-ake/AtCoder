s=input()
print("YES"if all(a==b or a=='*'or b=='*'for(a,b)in zip(s,reversed(s)))else"NO")