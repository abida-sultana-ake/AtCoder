def count(a, t):
    ans = 0
    for i in range(len(t)):
        if a[i] == t[i]:
            ans += 0
        elif a[i] == "g" and t[i] == "p":
            ans -= 1
        elif a[i] == "p" and t[i] == "g":
            ans += 1
    return ans


def main():
    s = input()
    a = "gp" * (len(s) // 2 + 1)
    print(count(a, s))

if __name__ == '__main__':
    main()
