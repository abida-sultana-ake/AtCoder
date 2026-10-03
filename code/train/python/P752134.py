import sys

n=sys.stdin.readline().strip()
n=int(n)

ten="1"
sev="7"
zero=""

for z in range(n-1) :
	zero+="0"
	
print(ten+zero+sev)