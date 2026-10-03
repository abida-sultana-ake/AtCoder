M,D = map(int, input().split())
if M < D :
    print("NO")
elif M%D == 0 :
    print("YES")
else :
    print("NO")