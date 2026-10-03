class Parenter:
    def __init__(self):
        self.left = 0
        self.right = 0
        self.data = ""

    def _run(self, letter):
        if letter == "(":
            self.data += "("
            self.left += 1
        if letter == ")":
            if self.left > 0:
                self.left -= 1
                self.data += ")"
            else:
                self.right += 1
                self.data += ")"
    
    def run(self, string):
        for s in string:
            self._run(s)
        self.data = "("*self.right + self.data + ")"*self.left
    

p = Parenter()
N = input()
data = input()
p.run(data)
print(p.data)