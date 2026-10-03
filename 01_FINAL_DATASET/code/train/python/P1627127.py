def ILINRows(N): return list(map(int,[input() for i in range(N)]))
def getIndexes(lis,elem):
    return  [i for i, x in enumerate(lis) if x == elem]
n=int(input())
lis = ILINRows(n)
li_uniq = list(set(lis))
li_uniq.remove(max(li_uniq))
print(max(li_uniq))