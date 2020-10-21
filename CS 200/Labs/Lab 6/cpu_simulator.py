import csv
from priority_queue import *


class Job:

    def __init__(self, name, length, priority):
        self.name = name
        self.length = length
        self.priority = priority

    def __str__(self):
        return self.name


num_cpus = int(input("Enter number of CPUs: "))
filename = input("Enter filename: ")

completed = 0
queue = HeapPriorityQueue()
cpus = dict()
for c in range(num_cpus):
    cpus[c] = None

cycle = 1
with open(filename, "r") as file:
    reader = csv.reader(file, delimiter=",")
    for row in reader:
        if cycle > 1:
            # do cycle work
            for c, j in cpus.items():
                if j is not None:
                    job = j
                    job.length -= 1
                    if job.length == 0:
                        # job done
                        completed += 1
                        cpus[c] = None
                        if not queue.is_empty():
                            # there's a job waiting
                            cpus[c] = queue.remove_min()[1]
                    else:
                        # update job's length
                        cpus[c] = job
        if len(row) > 1:
            # there's a job to add
            job = Job(row[0], int(row[1]), int(row[2]))
            added = False
            for c, j in cpus.items():
                if j is None:
                    # cpu available, add
                    cpus[c] = job
                    added = True
                    break
            if not added:
                # all cpus are working, add to queue
                queue.add(job.priority, job)
        # output current jobs
        out = str(cycle) + ": "
        for job in cpus.values():
            if job is not None:
                out += job.name + ", "
            else:
                out += "-, "
        print(out[:-2])
        cycle += 1

print("Total number of jobs completed:", completed)
