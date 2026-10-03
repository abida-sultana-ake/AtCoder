import os
import sys


def manhatten(tupleA,tupleB):
	return abs(tupleA[0]-tupleB[0]) + abs(tupleA[1]-tupleB[1])

header = input().split()
N,M = int(header[0]),int(header[1])
students = []
checkpoints = []

for i in range(N):
	student = input().split()
	student = [int(x) for x in student]
	students.append(tuple(student))

for i in range(M):
	checkpoint =input().split()
	checkpoint = [int(x) for x in checkpoint]
	checkpoints.append(tuple(checkpoint))

for student in students:
	distance = []
	for checkpoint in checkpoints:
		d = manhatten(student,checkpoint)
		distance.append(d)
	print(distance.index(min(distance))+ 1)