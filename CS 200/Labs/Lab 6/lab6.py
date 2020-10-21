from priority_queue import *

q = HeapPriorityQueue()
for i in range(32):
    q.add(i, "#"*(i % 4))

print("pushpop")
print("Min:", q.min())
print("Operation 1:", q.pushpop(-12, "pushpop1")[1])
print("Min:", q.min())
print("Operation 2:", q.pushpop(34, "pushpop2")[1])
print("Min:", q.min())

print("\nreplace")
print("Operation 1:", q.replace(-3, "replace1")[1])
print("Min:", q.min())
print("Operation 2:", q.replace(14, "replace2")[1])
print("Min:", q.min())
