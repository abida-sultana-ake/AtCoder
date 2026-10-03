from collections import Counter


def main():
    w = input()
    d = Counter(w)
    for k, v in d.items():
        if v % 2 != 0:
            print("No")
            break
    else:
        print("Yes")


if __name__ == '__main__':
    main()
