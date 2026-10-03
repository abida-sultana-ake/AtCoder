a1=input()
a2=input()

for i in range(len(a1)):
    if a1[i]!=a2[i]:
        if a1[i]=="@":
            if a2[i]!="a" and a2[i]!="t"  and a2[i]!="c" and a2[i]!="o" and a2[i]!="d" and a2[i]!="e" and a2[i]!="r":
                print("You will lose")
                break
        elif a2[i]=="@":
            if a1[i]!="a" and a1[i]!="t"  and a1[i]!="c" and a1[i]!="o" and a1[i]!="d" and a1[i]!="e" and a1[i]!="r":
                print("You will lose")
                break
        else:
                print("You will lose")
                break
else:
    print("You can win")