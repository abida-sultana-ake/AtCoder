n = int(input())
s = input()
ac = ["b"]
for i in range(17):
    ac.append("a"+ac[3*i]+"c")
    ac.append("c"+ac[3*i+1]+"a")
    ac.append("b"+ac[3*i+2]+"b")

print(-1 if not s in ac else ac.index(s))
