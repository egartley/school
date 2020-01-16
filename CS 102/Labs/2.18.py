exam = float(input())
homework = float(input())
lab = float(input())
part = float(input())

print("The course grade is:  {:.1f}".format((exam * 0.50) + (homework * 0.20) + (lab * 0.15) + (part * 0.15)))
