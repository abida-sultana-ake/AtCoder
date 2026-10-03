def read():
    return int(input())

def reads(sep=None):
    return list(map(int, input().split(sep)))

def main():
    abc = reads()
    print('YES' if list(sorted(abc)) == [5,5,7] else 'NO')

main()
