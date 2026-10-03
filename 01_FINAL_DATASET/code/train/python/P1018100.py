#!/usr/bin/env python3


WORDS = ["dream", "dreamer", "erase", "eraser"]


def can_construct(s):
    while len(s) > 0:
        for word in WORDS:
            i = s.rfind(word)
            if i != -1 and len(s) == i + len(word):
                s = s[:i]
                break
        else:
            return False
    return True


def main():
    print("YES" if can_construct(input()) else "NO")


if __name__ == '__main__':
    main()
