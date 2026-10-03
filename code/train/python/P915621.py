class NumExpression:
    def __init__(self, input_value, rank):
        self.raw_value = input_value
        self.rank = rank

    @property
    def value(self):
        list = self.expression.split("+")
        sum = 0
        for num in list:
            sum += int(num)
        return sum

    @property
    def expression(self):
        #print("rank = {0}".format(self.rank))
        points = self.gen_points(self.rank, len(self.raw_value) - 1)
        #print("gen_points = {0}".format(points))
        expression = self.insert_plus(points)
        #print("expression = {0}".format(expression))
        return expression

    def gen_points(self, num, width):
        """
        num → 2進数に変換してリストで返す
        """
        points = [0] * width
        temp = num
        i = 1
        while True:
            p = temp % 2 
            if p == 1:
                points[width - i] = 1
            temp = temp >> 1
            if temp == 0:
                break
            i += 1

        return points

    def insert_plus(self, points):
        """
        point位置に"+"を挿入する
        """
        i = 0 #points[0]
        new_value = self.raw_value[0:i]
        for point in points:
            new_value += self.raw_value[i:i+1]
            if point == 1:
                new_value += "+"
            i += 1

        new_value += self.raw_value[i:]
        return new_value

class Calculator:
    def __init__(self, input_value):
        self.input_value = input_value
        self.expressions = self.make_expressions()

    def len(self):
        return len(self.input_value)

    def make_expressions(self):
        expressions = []
        for i in range(0, pow(2, self.len()-1)):
            expression = NumExpression(self.input_value, i)
            expressions.append(expression)
        return expressions

    def compute_sum(self):
        sum = 0
        for expression in self.expressions:
            sum += expression.value

        return sum

if __name__ == "__main__":
    num = input()
    c = Calculator(num)
    print(c.compute_sum())
