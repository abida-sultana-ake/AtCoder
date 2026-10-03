def main():
    global N, B
    N = int(input())
    B = tuple(int(input()) for _ in range(N - 1))

    boss = salary(1)
    print(boss)

def salary(n):
    staff = []
    for i in range(N - 1):
        if B[i] == n:
            staff.append(salary(i + 2))

    if len(staff) == 0:
        return 1
    else:
        return max(staff) + min(staff) + 1

main()
