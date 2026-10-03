n=int(input())
print("YES"if all(n%i for i in range(2,int(n**0.5)+1))else"NO")