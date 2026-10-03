n = int(input());
s = [];
alphabets=['a', 'b', 'c', 'd', 'e', 'f', 'g',
           'h', 'i', 'j', 'k', 'l', 'm', 'n',
           'o', 'p', 'q', 'r', 's', 't', 'u',
           'v', 'w', 'x', 'y', 'z']

for i in range(0, n):
    s.append(input());

for alp in alphabets:
    num=9999999999;
    for ss in s:
        if num > ss.count(alp):
            num = ss.count(alp);
    print(alp * num, end='');
