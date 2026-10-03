import sys

stdin = sys.stdin
def na(): return map(int, stdin.readline().split())
def ns(): return stdin.readline().strip()
def ni(): return int(stdin.readline())

n = ni()
a = na()
st = set()
for i in a:
    if(i not in st):
        st.add(i)

c = len(st)
if(c%2 == 0):c=c-1

print(c)
