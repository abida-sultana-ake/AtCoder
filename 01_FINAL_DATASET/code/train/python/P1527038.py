st = list(input())
ls = list(set(st))
abc = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
set_ab = set(abc) - set(ls)
ans = list(set_ab)
ans.sort()
if ans:
    print(ans[0])
else:
    print("None")
