A,B,C,D,E,F = list(map(int, input().split()))
maxdensity=0;
maxtotal=0;
maxsugar=0;

listwater = list()
for nA in range(30):
    for nB in range(15):
    	water = 100*(nA*A+nB*B)
    	if water == 0:
    		continue
    	if water <= F and (not water in listwater):
    		listwater.append(water)

listsugar = list()
for nC in range(3000):
    for nD in range(1500):
    	sugar = (nC*C+nD*D)
    	if sugar <= F/2 and (not sugar in listsugar):
    		listsugar.append(sugar)

listsugar.sort()
listwater.sort()

for i in range(len(listsugar)):
    for j in range(len(listwater)):
    	total = listsugar[i] + listwater[j]
    	sugar = listsugar[i]
    	if total == 0:
    		continue
    	if total <= F and sugar*100 <= E*(total-sugar):
    		if maxdensity*total < sugar:
    			maxdensity = float(sugar)/float(total)
    			maxtotal = total
    			maxsugar = sugar
    	
if maxtotal == 0:
	maxtotal = A*100
print(maxtotal,end=" ")
print(maxsugar)