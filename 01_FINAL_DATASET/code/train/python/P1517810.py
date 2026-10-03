def main():
    global N, B
    N = int(input())
    B = tuple(int(input()) for _ in range(N - 1))

    staff = []
    for i in range(N - 1):
        if B[i] == 1:
            staff.append(salary(i + 2))

    boss = min(staff) + max(staff) + 1
    print(boss)

def salary(n):
    s = []
    for i in range(N - 1):
        if B[i] == n:
            s.append(salary(i + 2))

    if len(s) == 0:
        return 1
    else:
        return max(s) + min(s) + 1

main()
