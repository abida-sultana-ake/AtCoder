import sys
N = int(input())
src = [input() for i in range(N)]
if N == 1:
    print('DRAW')
    sys.exit()

st = set()
for i in range(N-1):
    st.add(src[i])
    if src[i+1] in st or src[i+1][0] != src[i][-1]:
        print('WIN' if i%2 == 0 else 'LOSE')
        break
else:
    print('DRAW')
