haveMoney , increaseMoney= map(int,input().split())
day = 0
tyou = 2*10**12
while haveMoney < tyou:
	if increaseMoney == 0:
		day = tyou - haveMoney
		break
	haveMoney = haveMoney + 1 + haveMoney * increaseMoney
	day += 1
	
print(day)