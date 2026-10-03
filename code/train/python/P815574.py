import re
 
class IO_for_Contest(object):
    @staticmethod
    def my_input():
        #return raw_input()
        return input()
 
    @staticmethod
    def read_from_input():
        n, k = IO_for_Contest.read_n_int(2)
        d = IO_for_Contest.read_n_int(k)
        return n, d
 
    @staticmethod
    def read_line():
        return IO_for_Contest.my_input().strip()
 
    @staticmethod
    def read_int():
        return int(IO_for_Contest.my_input().strip())
 
    @staticmethod
    def read_n_int(n):
        return list(map( \
                int, \
                re.split('\s+', IO_for_Contest.my_input().strip())))[ : n]
 
def solve():
    n, d = IO_for_Contest.read_from_input()
    print(inner_solve(n, d))

def inner_solve(n, d):
    while True:
        s_n = str(n)
        success = False
        for i in range(len(s_n)):
            if int(s_n[i]) in d:
                break
        else:
            success = True
        if success:
            return n
        n += 1

if __name__ == '__main__':
    solve()
