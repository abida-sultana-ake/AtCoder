
N,M = map(int,input().split())

class Bellman_Ford(object):
	"""
	ベルマンフォード法, O(EV)
	ステータス:distance(list),prev(list),length(int)
	edge=[i, j, cost] のリスト
	"""
	def __init__(self, edge, start, length):
		self.start=start
		self.length=length
		self.distance=[float("inf") for x in range(self.length)]
		self.distance[start]=0
		self.prev=[0 for x in range(self.length)]
		self.prev[start]=-1
		self.solvable=True
		def update():
			for i in edge:
				d=self.distance[i[0]]+i[2]
				if d<self.distance[i[1]]:
					self.distance[i[1]]=d 
					self.prev[i[1]]=i[0]
		for i in range(length-1):
			update()
		memo=self.distance[-1]
		for i in range(length-1):
			update()
		if memo!=self.distance[-1]:
			self.solvable=False

	def route(self,goal):
		route=[]
		while(True):
			route.append(self.prev[goal])
			goal=self.prev[goal]
			if goal==self.start:
				break
		route.reverse()
		return(route)

edges = []
for i in range(M):
	a,b,c = map(int,input().split())
	edges.append([a-1,b-1,-c])

B = Bellman_Ford(edges,0,N)
if (not B.solvable):
	print("inf")
else:
	print(-B.distance[-1])














