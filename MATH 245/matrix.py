class Matrix:

    def __init__(self, get_input=True, rows=0, cols=0, elements=None):
        if elements is None:
            elements = []
        self.rows = rows
        self.cols = cols
        if get_input:
            r = 0
            while r < rows:
                c = 0
                col = []
                while c < cols:
                    n = int(input(str(r) + ", " + str(c) + ": "))
                    col.append(n)
                    c += 1
                elements.append(col)
                r += 1
        self.m = elements

    def dim(self):
        return str(self.rows) + "x" + str(self.cols)

    def check_dim(self, other):
        return self.dim() == other.dim()

    def check_dim_inner(self, other):
        return self.cols == other.rows

    def add_sub(self, pos=True, other=None):
        if not self.check_dim(other):
            print("Cannot add with different dimensions!")
            return None
        added = []
        r = 0
        while r < len(self.m):
            col = []
            c = 0
            while c < len(self.m[r]):
                n = 1
                if not pos:
                    n = -1
                col.append(self.m[r][c] + (n * other.m[r][c]))
                c += 1
            added.append(col)
            r += 1
        return Matrix(False, self.rows, self.cols, added)

    def multiply(self, other):
        if not self.check_dim_inner(other):
            print("Cannot multiply with non-equal inner dimensions!")
            return
        product = []
        for r in range(self.rows):
            col = []
            for c in range(other.cols):
                col.append(0)
            product.append(col)
        # Credit: https://www.programiz.com/python-programming/examples/multiply-matrix
        for i in range(len(self.m)):
            for j in range(len(other.m[0])):
                for k in range(len(other.m)):
                    product[i][j] += self.m[i][k] * other.m[k][j]
        return Matrix(False, self.rows, other.cols, product)

    def print(self):
        for e in self.m:
            print(*e, sep=", ")

    def __str__(self):
        s = ""
        for r in self.m:
            row = ""
            for c in r:
                row += str(c) + ", "
            s += row[:-2] + "\n"
        return s


# Credit: https://stackoverflow.com/a/39881366/13954969
def get_transpose(m):
    return map(list, zip(*m))


# Credit: https://stackoverflow.com/a/39881366/13954969
def getMatrixMinor(m, i, j):
    return [row[:j] + row[j + 1:] for row in (m[:i] + m[i + 1:])]


# Credit: https://stackoverflow.com/a/39881366/13954969
def getMatrixDeternminant(m):
    # base case for 2x2 matrix
    if len(m) == 2:
        return m[0][0] * m[1][1] - m[0][1] * m[1][0]
    determinant = 0
    for c in range(len(m)):
        determinant += ((-1) ** c) * m[0][c] * getMatrixDeternminant(getMatrixMinor(m, 0, c))
    return determinant


# Credit: https://stackoverflow.com/a/39881366/13954969
def get_inverse(m):
    det = getMatrixDeternminant(m)
    if len(m) == 2:
        return [[m[1][1] / det, -1 * m[0][1] / det], [-1 * m[1][0] / det, m[0][0] / det]]
    cof = []
    for r in range(len(m)):
        row = []
        for c in range(len(m)):
            minor = getMatrixMinor(m, r, c)
            row.append(((-1) ** (r + c)) * getMatrixDeternminant(minor))
        cof.append(row)
    cof = get_transpose(cof)
    for r in range(len(cof)):
        for c in range(len(cof)):
            cof[r][c] = cof[r][c] / det
    return cof


def new():
    name = input("Name: ")
    if name not in M:
        M[name] = Matrix(True, int(input("Rows: ")), int(input("Cols: ")))
    else:
        print("Matrix already exists!")


def view():
    name = input("Name: ")
    if name in M:
        print(len(M[name].m))
        M[name].print()
    else:
        print("Invalid name!")


def add_sub(pos):
    n1 = input("Matrix 1: ")
    n2 = input("Matrix 2: ")
    if n1 in M and n2 in M:
        res = M[n1].add_sub(pos, M[n2])
        if res is not None:
            res.print()
    else:
        print("Invalid name(s)!")


def add():
    add_sub(True)


def subtract():
    add_sub(False)


def multiply():
    n1 = input("Matrix 1: ")
    n2 = input("Matrix 2: ")
    if n1 in M and n2 in M:
        product = M[n1].multiply(M[n2])
        if product is not None:
            product.print()
    else:
        print("Invalid name(s)!")


def transpose():
    name = input("Name: ")
    if name in M:
        # Credit: https://stackoverflow.com/a/4937526/13954969
        print([*zip(*M[name].m)])
    else:
        print("Invalid name!")


def inverse():
    name = input("Name: ")
    if name in M:
        print(get_inverse(M[name].m))
    else:
        print("Invalid name!")


M = {}
print("(N)ew matrix")
print("(V)iew matrix")
print("(A)ddition")
print("(S)ubtraction")
print("(M)ultiply")
print("(T)ranspose")
print("(I)nverse")
print("(E)xit or (Q)uit")

command = input("\nEnter command: ")
command = command[0].lower()

while command != "e" and command != "q":
    if command == "n":
        new()
    elif command == "v":
        view()
    elif command == "a":
        add()
    elif command == "s":
        subtract()
    elif command == "m":
        multiply()
    elif command == "t":
        transpose()
    elif command == "i":
        inverse()
    else:
        print("Unknown command!")

    command = input("\nEnter command: ")
    command = command.lower()
