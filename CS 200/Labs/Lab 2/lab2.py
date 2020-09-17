from deque import Deque

d = Deque()
print(len(d), d)
d.add_to_front("C")
print(len(d), d)
d.add_to_front("B")
print(len(d), d)
d.add_to_front("A")
print(len(d), d)
d.add_to_end("D")
print(len(d), d)
d.add_to_end("E")
print(len(d), d)
r = d.remove_from_front()
print(len(d), d, "removed", r)
r = d.remove_from_front()
print(len(d), d, "removed", r)
r = d.remove_from_end()
print(len(d), d, "removed", r)
r = d.remove_from_end()
print(len(d), d, "removed", r)
try:
    r = d.remove_from_end()
    print(len(d), d, "removed", r)
except IndexError:
    print("Tried to remove from an empty deque")
try:
    r = d.remove_from_end()
    print(len(d), d, "removed", r)
except IndexError:
    print("Tried to remove from an empty deque")