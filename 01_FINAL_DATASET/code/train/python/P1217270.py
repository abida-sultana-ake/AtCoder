N = int(input())
s = list(input())
check_SW = True
X1 = ["S","S"]
X2 = ["S","W"]
X3 = ["W","S"]
X4 = ["W","W"]

flg1 , flg2 , flg3 , flg4 = "","","",""
def check(X):
    for i in range(1,N-1):
        if (X[i] == "S" and s[i]=="o") or (X[i] == "W" and s[i] == "x"):
            X.append(X[i-1])
        else:
            if X[i-1] == "S":
                X.append("W")
            else:
                X.append("S")
    for i in range(N):
        if (s[i] == "o" and X[i] == "S") or (s[i] == "x" and X[i] == "W") :
            if X[(i-1)%N] != X[(i+1)%N]:
                return False , X
                break
        else:
            if X[(i-1)%N] == X[(i+1)%N]:
                return False , X
                break
    return True , X

flg1 , X1 = check(X1)
flg2 , X2 = check(X2)
flg3 , X3 = check(X3)
flg4 , X4 = check(X4)

if flg1:
    print("".join(X1))
elif flg2:
    print("".join(X2))   
elif flg3:
    print("".join(X3))    
elif flg4:
    print("".join(X4))     
else:
    print(-1)