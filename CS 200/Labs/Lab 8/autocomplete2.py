import timeit
from binary_search_tree import TreeMap


class Term:

    def __init__(self, query, weight):
        if query is None:
            raise TypeError("Query cannot be none")
        if weight < 0:
            raise ValueError("Weight cannot be negative")
        self.query = query
        self._weight = weight

    def get_weight(self):
        return self._weight

    def __eq__(self, other):
        return self.query == other.query

    def __lt__(self, other):
        return self.query < other.query

    def __str__(self):
        return self.query + " (" + str(self._weight) + ")"


def build_tree(filename):
    terms = []
    with open(filename, "r", encoding="utf-8") as file:
        first = True
        for line in file.readlines():
            if first:
                first = False
                continue
            data = line.strip().split("	")
            terms.append(Term(data[1], float(data[0])))
    tree = TreeMap()
    for term in terms:
        tree[term.query] = term
    return tree


def all_matches(tree, prefix):
    matches = []
    for term in tree.find_range(prefix, None):
        if term[0][:len(prefix)] == prefix:
            matches.append(term[1])
        else:
            break
    matches.sort(key=Term.get_weight, reverse=True)
    return matches


def main():
    tree = build_tree(input("Enter file: "))
    num_results = int(input("Enter number of results to show: "))
    query = input("Enter search: ")
    while len(query) > 0:
        start = timeit.default_timer()
        matches = all_matches(tree, query)
        end = timeit.default_timer()
        for n in range(num_results):
            if n == len(matches):
                break
            term = matches[n]
            print(term.get_weight(), "\t", term.query)
        print("Query took", (end - start) / 1000, "ms")
        query = input("Enter search: ")


main()
