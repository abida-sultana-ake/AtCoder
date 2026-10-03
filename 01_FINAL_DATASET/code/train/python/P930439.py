def getLnInput():
    return input().split()


def getNewVote(currentVote, newRatio):
    multFacCeil = []
    for i in range(2):
        multFacCeil.append((currentVote[i] - 1) // newRatio[i] + 1)
    newVote = []
    maxMF = max(multFacCeil)
    for i in range(2):
        newVote.append(newRatio[i] * maxMF)
    return newVote


def main():
    N = int(getLnInput()[0])
    voteNum = list(map(int, getLnInput()))
    for i in range(N - 1):
        newRatio = list(map(int, getLnInput()))
        voteNum = getNewVote(voteNum, newRatio)
    print(sum(voteNum))
    return


main()
