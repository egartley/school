from stacks import LinkedStack
from action import Action
from course import Course


class Transcript:

    def __init__(self):
        self.courses = {}

    def add_course(self, course):
        if course.code not in self.courses:
            self.courses[course.code] = course

    def remove_course(self, course):
        if course.code in self.courses:
            del self.courses[course.code]

    def update_course(self, course):
        if course.code in self.courses:
            self.courses[course.code] = course

    def get_course(self, course_code):
        for course in self.courses.values():
            if course.code == course_code:
                return course
        return None

    def save_to_file(self, filename):
        with open(filename, "w") as file:
            for code, course in self.courses.items():
                file.write(code)
                file.write("\n")
                file.write(course.name)
                file.write("\n")
                file.write(str(course.credits))
                file.write("\n")
                file.write(course.letter_grade)
                file.write("\n")
                file.write(course.semester)
                file.write("\n")
                file.write(course.teacher_name)
                file.write("\n")

    def load_from_file(self, filename):
        with open(filename, "r") as file:
            lines = file.readlines()
        for i in range(len(lines)):
            lines[i] = lines[i].strip()
        for c in range(0, len(lines) - 1, 6):
            self.add_course(Course(lines[c], lines[c + 1], int(lines[c + 2]),
                                   lines[c + 3], lines[c + 4], lines[c + 5]))


def is_valid_grade(letter_grade):
    return letter_grade.upper() in letter_gpa_scale.keys()


def lookup_course(transcript):
    if len(transcript.courses) == 0:
        print("Cannot lookup courses in an empty transcript")
    else:
        input_code = input("Course code: ").upper()
        course = transcript.get_course(input_code)
        if course is None:
            print("No course with code \"" + input_code + "\" found")
        else:
            print(course)


def add_course(transcript):
    input_course_code = input("Course code: ").upper()
    if input_course_code in transcript.courses:
        print("Course already exists")
    else:
        course_name = input("Course name: ")
        teacher_name = input("Instructor: ")
        semester = input("Semester: ")
        num_credits = input("Credits: ")
        while not num_credits.isnumeric():
            num_credits = input("Credits: ")
        num_credits = int(num_credits)
        letter_grade = input("Grade: ").upper()
        while not is_valid_grade(letter_grade):
            letter_grade = input("Grade: ").upper()
        course = Course(input_course_code, course_name, num_credits, letter_grade, semester, teacher_name)
        transcript.add_course(course)
        undo_actions.push(Action(Action.ADD, course))
        print("Added", input_course_code)


def update_course(transcript):
    input_course_code = input("Course code: ").upper()
    course = transcript.get_course(input_course_code)
    if course is None:
        print("No course with code \"" + input_course_code + "\" found")
    else:
        editable_commands = ["g", "i", "n", "c"]
        input_command = input("Change (g)rade, (i)nstructor, (n)ame, or (c)redits? ").lower()
        while input_command not in editable_commands:
            input_command = input("Change (g)rade, (i)nstructor, (n)ame, or (c)redits? ").lower()
        new_value = input("Change to: ")
        old_value = None
        if input_command == "g":
            while not is_valid_grade(new_value):
                new_value = input("Change to: ")
            old_value = course.letter_grade
            course.letter_grade = new_value
        elif input_command == "c":
            while not new_value.isnumeric():
                new_value = input("Change to: ")
            old_value = course.credits
            course.credits = int(new_value)
        elif input_command == "i":
            old_value = course.teacher_name
            course.teacher_name = new_value
        elif input_command == "n":
            old_value = course.name
            course.name = new_value
        transcript.update_course(course)
        undo_actions.push(Action(Action.UPDATE, course, [input_command, old_value, new_value]))
        print("Updated", course.code)


def delete_course(transcript):
    if len(transcript.courses) == 0:
        print("Cannot remove courses from an empty transcript")
        return
    input_course_code = input("Course code: ").upper()
    course = transcript.get_course(input_course_code)
    if course is None:
        print("No course with code \"" + input_course_code + "\" found")
    else:
        transcript.remove_course(course)
        undo_actions.push(Action(Action.REMOVE, course))
        print("Deleted", course.code)


def find_course(transcript):
    if len(transcript.courses) == 0:
        print("Cannot find courses in an empty transcript")
    else:
        findable_commands = ["i", "g", "c", "s"]
        find_command = input("Find by (i)nstructor, (g)rade, (s)emester or (c)redits? ").lower()
        while find_command not in findable_commands:
            find_command = input("Find by (i)nstructor, (g)rade, (s)emester or (c)redits? ").lower()
        find_value = input("Find: ")
        found_courses = []
        if find_command == "i":
            for course in transcript.courses.values():
                if course.teacher_name == find_value:
                    found_courses.append(course)
        elif find_command == "g":
            for course in transcript.courses.values():
                if course.letter_grade == find_value:
                    found_courses.append(course)
        elif find_command == "s":
            for course in transcript.courses.values():
                if course.semester == find_value:
                    found_courses.append(course)
        elif find_command == "c":
            for course in transcript.courses.values():
                if str(course.credits) == find_value:
                    found_courses.append(course)
        if len(found_courses) > 0:
            print("Results:")
            for course in found_courses:
                print(course)
        else:
            print("No courses found")


def get_courses_by_code(transcript, course_code):
    courses = []
    for course in transcript.courses.values():
        if course_code in course.code:
            courses.append(course)
    return courses


def print_gpa(gpa):
    print("GPA:", gpa)


def get_total_credits(courses):
    total_credits = 0
    for course in courses:
        total_credits += course.credits
    return total_credits


def get_total_grades(courses):
    total_grades = 0
    for course in courses:
        total_grades += letter_gpa_scale[course.letter_grade] * course.credits
    return total_grades


def calculate_gpa(transcript):
    if len(transcript.courses) > 0:
        total_grades = get_total_grades(transcript.courses)
        total_credits = get_total_credits(transcript.courses)
        print_gpa(round(total_grades / total_credits, 3))
    else:
        print("Cannot calculate GPA without any courses in transcript")


def calculate_field_gpa(transcript):
    if len(transcript.courses) == 0:
        print("Cannot calculate field GPA without any courses in transcript")
    else:
        input_course_code = input("Courses from: ")
        courses = get_courses_by_code(transcript, input_course_code)
        if len(courses) > 0:
            total_grades = get_total_grades(courses)
            total_credits = get_total_credits(courses)
            print_gpa(round(total_grades / total_credits, 3))
        else:
            print("Could not find any courses from \"" + input_course_code + "\"")


def undo_action(transcript):
    if undo_actions.is_empty():
        print("Nothing to undo")
        return
    last_action = undo_actions.pop()
    course = last_action.course
    if last_action.type == Action.UPDATE:
        if last_action.data is not None:
            if last_action.data[0] == Action.GRADE:
                course.letter_grade = last_action.data[1]
                print("Changed the grade for", course.code, "back to", last_action.data[1])
            elif last_action.data[0] == Action.TEACHER:
                course.teacher_name = last_action.data[1]
                print("Changed the instructor for", course.code, "back to", last_action.data[1])
            elif last_action.data[0] == Action.NAME:
                course.name = last_action.data[1]
                print("Changed the name for", course.code, "back to", last_action.data[1])
            elif last_action.data[0] == Action.CREDITS:
                course.credits = last_action.data[1]
                print("Changed the credits for", course.code, "back to", last_action.data[1])
    elif last_action.type == Action.REMOVE:
        transcript.add_course(course)
        print("Re-added", course.code)
    elif last_action.type == Action.ADD:
        transcript.remove_course(course)
        print("Deleted", course.code)
    redo_actions.push(last_action)


def redo_action(transcript):
    if redo_actions.is_empty():
        print("Nothing to redo")
        return
    last_action = redo_actions.pop()
    course = last_action.course
    if last_action.type == Action.UPDATE:
        if last_action.data is not None:
            if last_action.data[0] == Action.GRADE:
                course.letter_grade = last_action.data[2]
                print("Returned the grade for", course.code, "to", last_action.data[2])
            elif last_action.data[0] == Action.TEACHER:
                course.teacher_name = last_action.data[2]
                print("Returned the instructor for", course.code, "to", last_action.data[2])
            elif last_action.data[0] == Action.NAME:
                course.name = last_action.data[2]
                print("Returned the name for", course.code, "to", last_action.data[2])
            elif last_action.data[0] == Action.CREDITS:
                course.credits = last_action.data[2]
                print("Returned the credits for", course.code, "to", last_action.data[2])
    elif last_action.type == Action.REMOVE:
        transcript.remove_course(course)
        print("Deleted", course.code)
    elif last_action.type == Action.ADD:
        transcript.add_course(course)
        print("Re-added", course.code)
    undo_actions.push(last_action)


def process_user_command(user_command, transcript):
    if user_command == "lo":
        lookup_course(transcript)
    elif user_command == "a":
        add_course(transcript)
    elif user_command == "up":
        update_course(transcript)
    elif user_command == "d":
        delete_course(transcript)
    elif user_command == "f":
        find_course(transcript)
    elif user_command == "sh":
        if len(transcript.courses) == 0:
            print("No courses in transcript")
        else:
            for course in transcript.courses.values():
                print(course)
    elif user_command == "c":
        calculate_gpa(transcript)
    elif user_command == "fi":
        calculate_field_gpa(transcript)
    elif user_command == "u":
        undo_action(transcript)
    elif user_command == "r":
        redo_action(transcript)
    elif user_command == "s":
        if len(transcript.courses) == 0:
            print("No courses in transcript")
        else:
            transcript.save_to_file(input("File name: "))
    elif user_command == "l":
        transcript.load_from_file(input("File name: "))
    print()


def print_user_menu():
    print("TRANSCRIPT MANAGER\n--------------------\n(Lo)okup course")
    print("(A)dd course\n(Up)date course(D)elete course\n(F)ind")
    print("(Sh)ow all\n(C)alculate GPA\n(Fi)eld GPA\n(U)ndo")
    print("(R)edo\n(S)ave\n(L)oad\n(E)xit")


def start_user_menu(transcript):
    valid_commands = ["lo", "a", "up", "d", "f", "sh", "c", "fi", "u", "r", "s", "l", "e"]
    user_command = ""
    while user_command != "e":
        print_user_menu()
        user_command = input("Type a command: ").lower()
        while user_command not in valid_commands:
            print("Invalid command")
            user_command = input("Type a command: ").lower()
        process_user_command(user_command, transcript)

    print("Goodbye")


undo_actions = LinkedStack()
redo_actions = LinkedStack()
letter_gpa_scale = {"A+": 4.0, "A": 4.0, "A-": 3.7, "B+": 3.3, "B": 3.0, "B-": 2.7,
                    "C+": 2.3, "C": 2.0, "C-": 1.7, "D+": 1.3, "D": 1.0, "D-": 0.7,
                    "F": 0.0}


def main():
    transcript = Transcript()
    start_user_menu(transcript)


main()
