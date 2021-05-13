class Course:

    def __init__(self, code="", name="", credits=0, grade="", semester="", teacher=""):
        self.code = code
        self.name = name
        self.credits = credits
        self.letter_grade = grade
        self.semester = semester
        self.teacher_name = teacher

    def __str__(self):
        return get_formatted_column("[" + self.letter_grade + "]", 5) \
               + " " + get_formatted_column(self.code, 9) \
               + " " + get_formatted_column(self.name, 31) \
               + " " + get_formatted_column(self.teacher_name, 21) \
               + " " + get_formatted_column(self.semester, 12) \
               + " " + get_formatted_column(str(self.credits) + " credits", 11)


def get_formatted_column(value, length):
    return value + " " * (length - len(value)) if len(value) < length else value
