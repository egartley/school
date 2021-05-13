# Evan Gartley Section 03
# Lab 9

from stacks import LinkedStack


# a class/course that has a code, name, grade, instructor, semester and number of credits
class Course:

    def __init__(self, code="", name="", credit=0, grade="", semester="", teacher=""):
        self.code = code
        self.name = name
        self.credits = credit
        self.grade = grade
        self.semester = semester
        self.teacher = teacher

    def __str__(self):
        return format_column("[" + self.grade + "]", 5) + " " + format_column(self.code, 9) \
               + " " + format_column(self.name, 31) + " " + format_column(self.teacher, 21) \
               + " " + format_column(self.semester, 12) + " " + format_column(str(self.credits) + " credits", 11)


# a collection of user-added courses
class Transcript:

    def __init__(self):
        self.courses = {}

    def add_course(self, course):
        # add course if not already added
        if course.code not in self.courses:
            self.courses[course.code] = course

    def remove_course(self, course):
        # remove course if already added
        if course.code in self.courses:
            del self.courses[course.code]

    def update_course(self, course):
        # re-set the value for key of course's code
        if course.code in self.courses:
            self.courses[course.code] = course

    def lookup_course(self, code):
        # return the course with the given code
        for course in self.courses.values():
            if course.code == code:
                return course
        return None

    def save(self, filename):
        with open(filename, "w") as file:
            for code, course in self.courses.items():
                file.write(code)
                file.write("\n")
                file.write(course.name)
                file.write("\n")
                file.write(str(course.credits))
                file.write("\n")
                file.write(course.grade)
                file.write("\n")
                file.write(course.semester)
                file.write("\n")
                file.write(course.teacher)
                file.write("\n")

    def load(self, filename):
        with open(filename, "r") as file:
            lines = file.readlines()
        for i in range(len(lines)):
            # get rid of \n's
            lines[i] = lines[i].strip()
        for c in range(0, len(lines) - 1, 6):
            # add course by every 6 lines
            self.add_course(Course(lines[c], lines[c + 1], int(lines[c + 2]), lines[c + 3], lines[c + 4], lines[c + 5]))


# an addition, removal, or update of a course
class Action:
    # action types
    ADD = "a"
    REMOVE = "d"
    UPDATE = "up"
    # data types
    GRADE = "g"
    NAME = "n"
    TEACHER = "i"
    CREDITS = "c"

    def __init__(self, t, course, d=None):
        # an "action" used for undo/redo, with optional list `data` for new/old course attributes
        self.type = t
        self.course = course
        self.data = d


def format_column(value, length):
    # returned formatted value for a visually aligned table when course is outputted
    return value + " " * (length - len(value)) if len(value) < length else value


def valid_grade(grade):
    # return if the given grade is a valid letter and has a +, -, or no second character
    return grade.upper() in scale.keys()


def lookup_course(t):
    # find and display a course in the transcript
    if len(t.courses) == 0:
        print("Cannot lookup courses in an empty transcript")
    else:
        code = input("Course code: ").upper()
        course = t.lookup_course(code)
        if course is None:
            print("No course with code \"" + code + "\" found")
        else:
            print(course)


def add_course(t):
    # add a course to the transcript
    code = input("Course code: ").upper()
    if code in t.courses:
        print("Course already exists")
    else:
        name = input("Course name: ")
        teacher = input("Instructor: ")
        semester = input("Semester: ")
        creds = input("Credits: ")
        while not creds.isnumeric():
            # make sure input is a number
            creds = input("Credits: ")
        creds = int(creds)
        grade = input("Grade: ").upper()
        while not valid_grade(grade):
            # make sure input is a valid grade
            grade = input("Grade: ").upper()
        course = Course(code, name, creds, grade, semester, teacher)
        t.add_course(course)
        # add to undo stack
        undo.push(Action(Action.ADD, course))
        print("Added", code)


def update_course(t):
    # change a course's non-unique attribute
    code = input("Course code: ").upper()
    course = t.lookup_course(code)
    if course is None:
        print("No course with code \"" + code + "\" found")
    else:
        canedit = ["g", "i", "n", "c"]
        # get what attribute to change
        toedit = input("Change (g)rade, (i)nstructor, (n)ame, or (c)redits? ").lower()
        while toedit not in canedit:
            toedit = input("Change (g)rade, (i)nstructor, (n)ame, or (c)redits? ").lower()
        # new value for attribute
        changeto = input("Change to: ")
        old = None
        if toedit == "g":
            while not valid_grade(changeto):
                # ensure valid grade
                changeto = input("Change to: ")
            old = course.grade
            course.grade = changeto
        elif toedit == "c":
            while not changeto.isnumeric():
                # ensure number is entered
                changeto = input("Change to: ")
            old = course.credits
            course.credits = int(changeto)
        elif toedit == "i":
            old = course.teacher
            course.teacher = changeto
        elif toedit == "n":
            old = course.name
            course.name = changeto
        t.update_course(course)
        # add to undo stack
        undo.push(Action(Action.UPDATE, course, [toedit, old, changeto]))
        print("Updated", course.code)


def delete_course(t):
    # remove course from transcript
    if len(t.courses) == 0:
        print("Cannot remove courses from an empty transcript")
        return
    code = input("Course code: ").upper()
    course = t.lookup_course(code)
    if course is None:
        print("No course with code \"" + code + "\" found")
    else:
        t.remove_course(course)
        # add to undo stack
        undo.push(Action(Action.REMOVE, course))
        print("Deleted", course.code)


def find_course(t):
    # find course(s) by non-unique attribute in transcript
    if len(t.courses) == 0:
        print("Cannot find courses in an empty transcript")
    else:
        canfind = ["i", "g", "c", "s"]
        # get attribute to search by
        findby = input("Find by (i)nstructor, (g)rade, (s)emester or (c)redits? ").lower()
        while findby not in canfind:
            findby = input("Find by (i)nstructor, (g)rade, (s)emester or (c)redits? ").lower()
        # get search value
        tofind = input("Find: ")
        found = []
        if findby == "i":
            for course in t.courses.values():
                if course.teacher == tofind:
                    found.append(course)
        elif findby == "g":
            for course in t.courses.values():
                if course.grade == tofind:
                    found.append(course)
        elif findby == "s":
            for course in t.courses.values():
                if course.semester == tofind:
                    found.append(course)
        elif findby == "c":
            for course in t.courses.values():
                if str(course.credits) == tofind:
                    found.append(course)
        if len(found) > 0:
            print("Results:")
            for course in found:
                print(course)
        else:
            print("No courses found")


def calc_gpa(t):
    # display calculated gpa for all courses in transcript
    if len(t.courses) > 0:
        grades = 0
        allcredits = 0
        for course in t.courses.values():
            grades += scale[course.grade] * float(course.credits)
            allcredits += course.credits
        print("GPA:", round(grades / allcredits, 3))
    else:
        print("Cannot calculate GPA without any courses in transcript")


def field_gpa(t):
    # display calculated gpa for courses from the given field
    if len(t.courses) == 0:
        print("Cannot calculate field GPA without any courses in transcript")
    else:
        code = input("Courses from: ")
        courses = []
        for course in t.courses.values():
            if code in course.code:
                courses.append(course)
        if len(courses) > 0:
            grades = 0
            allcredits = 0
            for course in courses:
                grades += scale[course.grade] * course.credits
                allcredits += course.credits
            print("GPA:", round(grades / allcredits, 3))
        else:
            print("Could not find any courses from \"" + code + "\"")


def do_undo(t):
    # undo the most recent action if any
    if undo.is_empty():
        print("Nothing to undo")
        return
    action = undo.pop()
    course = action.course
    if action.type == Action.UPDATE:
        if action.data is not None:
            if action.data[0] == Action.GRADE:
                course.grade = action.data[1]
                print("Changed the grade for", course.code, "back to", action.data[1])
            elif action.data[0] == Action.TEACHER:
                course.teacher = action.data[1]
                print("Changed the instructor for", course.code, "back to", action.data[1])
            elif action.data[0] == Action.NAME:
                course.name = action.data[1]
                print("Changed the name for", course.code, "back to", action.data[1])
            elif action.data[0] == Action.CREDITS:
                course.credits = action.data[1]
                print("Changed the credits for", course.code, "back to", action.data[1])
    elif action.type == Action.REMOVE:
        t.add_course(course)
        print("Re-added", course.code)
    elif action.type == Action.ADD:
        t.remove_course(course)
        print("Deleted", course.code)
    # allow this action to be redone
    redo.push(action)


def do_redo(t):
    # redo the most recent undo action if any
    if redo.is_empty():
        print("Nothing to redo")
        return
    action = redo.pop()
    course = action.course
    if action.type == Action.UPDATE:
        if action.data is not None:
            if action.data[0] == Action.GRADE:
                course.grade = action.data[2]
                print("Returned the grade for", course.code, "to", action.data[2])
            elif action.data[0] == Action.TEACHER:
                course.teacher = action.data[2]
                print("Returned the instructor for", course.code, "to", action.data[2])
            elif action.data[0] == Action.NAME:
                course.name = action.data[2]
                print("Returned the name for", course.code, "to", action.data[2])
            elif action.data[0] == Action.CREDITS:
                course.credits = action.data[2]
                print("Returned the credits for", course.code, "to", action.data[2])
    elif action.type == Action.REMOVE:
        t.remove_course(course)
        print("Deleted", course.code)
    elif action.type == Action.ADD:
        t.add_course(course)
        print("Re-added", course.code)
    # allow this action to be undone
    undo.push(action)


undo = LinkedStack()
redo = LinkedStack()
# letter grade conversion for calculating gpa
scale = {"A+": 4.0, "A": 4.0, "A-": 3.7, "B+": 3.3, "B": 3.0, "B-": 2.7, "C+": 2.3,
         "C": 2.0, "C-": 1.7, "D+": 1.3, "D": 1.0, "D-": 0.7, "F": 0.0}


def main():
    t = Transcript()
    valid = ["lo", "a", "up", "d", "f", "sh", "c", "fi", "u", "r", "s", "l", "e"]
    command = ""
    while command != "e":
        print("TRANSCRIPT MANAGER\n--------------------\n(Lo)okup course\n(A)dd course\n(Up)date course")
        print("(D)elete course\n(F)ind\n(Sh)ow all\n(C)alculate GPA\n(Fi)eld GPA\n(U)ndo\n(R)edo\n(S)ave")
        print("(L)oad\n(E)xit")

        # get valid command
        command = input("Type a command: ").lower()
        while command not in valid:
            print("Invalid command")
            command = input("Type a command: ").lower()

        if command == "lo":
            lookup_course(t)
        elif command == "a":
            add_course(t)
        elif command == "up":
            update_course(t)
        elif command == "d":
            delete_course(t)
        elif command == "f":
            find_course(t)
        elif command == "sh":
            # show all courses
            if len(t.courses) == 0:
                print("No courses in transcript")
            else:
                for course in t.courses.values():
                    print(course)
        elif command == "c":
            calc_gpa(t)
        elif command == "fi":
            field_gpa(t)
        elif command == "u":
            do_undo(t)
        elif command == "r":
            do_redo(t)
        elif command == "s":
            # save to file
            if len(t.courses) == 0:
                print("No courses in transcript")
                continue
            t.save(input("File name: "))
        elif command == "l":
            # load from file
            t.load(input("File name: "))
        print()

    print("Goodbye")


main()
