def slv(string):
    ret = ''
    for i in range(len(string)):
        if string[i] == ',':
            ret += ' '
        else:
            ret += string[i]
    return ret

if __name__ == '__main__':
    s = input()
    print(slv(s))