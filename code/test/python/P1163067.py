n = int()
a = list()

def solve():
    s = set(a)
    max_ = 0
    ans = ""

    for i in s:
        if max_ <= a.count(i):
            max_ = a.count(i)
            ans = i
    return ans

def main():
    n = int(input())
    for i in range(n):
        a.append(input())
    print(solve())

if __name__ == '__main__':
    main()