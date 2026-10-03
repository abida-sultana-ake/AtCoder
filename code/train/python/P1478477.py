from collections import defaultdict


def main():
    s = input()
    ans = ""
    for c in s:
        if c in ["0", "1"]:
            ans += c
        elif c == "B" and len(ans) > 0:
            ans = ans[:len(ans) - 1]
    print(ans)

if __name__ == '__main__':
    main()
