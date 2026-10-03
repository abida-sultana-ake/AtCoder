def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

n = ri()
if(n <= 59):
    print("Bad")
elif(n <= 89):
    print("Good")
elif(n <= 99):
    print("Great")
else:
    print("Perfect")