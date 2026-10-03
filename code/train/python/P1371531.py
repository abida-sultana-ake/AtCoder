def ini(): return int(input())
def inli(): return list(map(int, input().split()))
def inf(): return float(input())
def inlf(): return list(map(float, input().split()))
def inl(): return list(input())
def pli(): return "".join(list(map(str, ans)))

a = input()
if a[0]==a[1] and  a[0]==a[2] and a[0]==a[3]:
    print("SAME")
else :
    print("DIFFERENT")