import sys
from datetime import datetime
from datetime import timedelta

def main():
    s = sys.stdin.readline().rstrip()
    dt = datetime.strptime(s, '%Y/%m/%d')

    while True:
        y = dt.year
        m = dt.month
        d = dt.day

        if (y % m == 0 and (y / m) % d == 0):
            print(dt.strftime('%Y/%m/%d'))
            return
        dt += timedelta(days=1)

    return 0

if __name__ == '__main__':
    sys.exit(main())
