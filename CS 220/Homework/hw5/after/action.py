class Action:
    ADD = "a"
    REMOVE = "d"
    UPDATE = "up"
    GRADE = "g"
    NAME = "n"
    TEACHER = "i"
    CREDITS = "c"

    def __init__(self, action_type, course, data=None):
        self.type = action_type
        self.course = course
        self.data = data
