def func():
    s = {}
    for _ in range(int(input())):
        n = input()
        s[n] = s[n] + 1 if n in s else 0

    return max(s, key=(lambda x: s[x]))

def main():
    print(func())

if __name__ == '__main__':
    main()
