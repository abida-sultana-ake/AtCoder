s=input()
n=len(s)
arr = []
start=0
if n==1:
    print(s+"1")
else:
    for i in range(1,n):
        if s[i]!=s[i-1]:
            arr.append(s[i-1]+str(len(s[start:i])))
            start = i
    arr.append(s[-1]+str(len(s[start:])))
print("".join(arr))
