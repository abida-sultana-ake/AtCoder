from logging import getLogger, StreamHandler, DEBUG
logger = getLogger(__name__)
handler = StreamHandler()
handler.setLevel(DEBUG)
logger.setLevel(DEBUG)
logger.addHandler(handler)

import sys

def match(s, sw, index, N):
    if s[index]=='o':
        if sw[index]=='S':
            return sw[(index - 1 + N) % N] == sw[(index + 1 + N) % N]
        else:
            return sw[(index - 1 + N) % N] != sw[(index + 1 + N) % N]
    else:
        if sw[index]=='W':
            return sw[(index - 1 + N) % N] == sw[(index + 1 + N) % N]
        else:
            return sw[(index - 1 + N) % N] != sw[(index + 1 + N) % N]


N = int(input())
s = input()


	 
    

for j in range(4):
    sw = ""
    if j%2==0:
        sw+= 'S'
    else:
        sw+= 'W'

    if (int(j/2))%2==0:
        sw+= 'S'
    else:
        sw+= 'W'
#    logger.debug(sw)


    for i in range(N-2):
        if (sw[i+1] == 'S' and s[i+1] == 'o') or (sw[i+1] == 'W' and s[i+1] == 'x'):
            sw+=sw[i]
        else:
            if sw[i] == 'S':
                sw+='W'
            else:
                sw+='S'

#        logger.debug(sw)

    if match(s,sw,0,N) and match(s,sw,N-1,N):
        print(sw)
        sys.exit()

print(-1)
