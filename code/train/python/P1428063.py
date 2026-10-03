import sys
readline = sys.stdin.readline
write = sys.stdout.write
flush = sys.stdout.flush

def query(n):
    write("? %d\n" % n)
    flush()
    return readline().strip() == 'Y'
def answer(n):
    write("! %d\n" % n)
    flush()

"""
N = 123
q = 0
def dummy(n, N):
    return ((n <= N and str(n) <= str(N)) or (n > N and str(n) > str(N)))
def query(n):
    global q
    q += 1
    assert q <= 64
    print q, n, N, dummy(n, N)
    return dummy(n, N)
def answer(n):
    print "check", n, N
    assert n == N
"""

dig = None
for i in xrange(10):
    if not query(10**i):
        dig = i
        break
else:
    # 10**k
    for i in xrange(10):
        if query(10**i+1):
            ans = 10**i
            break
    answer(ans)
    exit(0)

def check(ans, i):
    if i == dig-1:
        return not query(int("".join(map(str, ans)))*10)
    return query(int("".join(map(str, ans))))

ans = []
for i in xrange(dig):
    ans.append(0)
    left = (i<1)-1; right = 10
    while left+1 < right:
        mid = (left + right) / 2
        ans[i] = mid
        if check(ans, i):
            left = mid
        else:
            right = mid
    if i == dig-1:
        ans[i] = left+1
    else:
        ans[i] = left

num = int("".join(map(str, ans)))
answer(num)
