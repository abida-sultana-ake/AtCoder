n = int(input())

matrix = []
for i in range(n):
    matrix.append(list(input()))


def reverse(matrix_, size_):
    to_return = [[None for j in range(size_)] for i in range(size_)]
    for i in range(size_):
        for j in range(size_):
            to_return[j][i] = matrix_[i][j]

    for i in range(size_):
        to_return[i] = to_return[i][::-1]

    return to_return


def print_matrix(matrix_):
    for each_line in matrix_:
        print("".join(each_line))


print_matrix(
    reverse(
        matrix, n
    )
)
