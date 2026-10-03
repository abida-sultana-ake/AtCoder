s1 = input()
s2 =  input()
alt = "atcoder"
result = True
def judge(s1, s2):
    global result
    for i in range(len(s1)):
        if s1[i] == s2[i]:
            pass
        elif s1[i] == "@" and s2[i] in alt or s1[i] in alt and s2[i] == "@":
            pass
        elif s1[i] == "@" and s2[i] == "@":
            pass
        else:
            result = False
            break
    if result:
        return("You can win")
    else:
        return("You will lose")

print(judge(s1, s2))