class Course:
    def __init__(self, number, title):
        self.number = number
        self.title = title

    def print_info(self):
        print("Course Information:")
        print("   Course Number:", self.number)
        print("   Course Title:", self.title)

class OfferedCourse(Course):
    
    def __init__(self, number, title, instructor_name, term, class_time):
        Course.__init__(self, number, title)
        self.instructor_name = instructor_name
        self.term = term
        self.class_time = class_time

if __name__ == "__main__":
    course_number = input()
    course_title = input()

    o_course_number =  input()
    o_course_title =  input()
    instructor_name = input()
    term = input()
    class_time = input()
    
    my_course = Course(course_number, course_title)
    my_course.print_info()
    
    my_offered_course = OfferedCourse(o_course_number, o_course_title, instructor_name, term, class_time)
    my_offered_course.print_info()

    print('   Instructor Name:', my_offered_course.instructor_name)
    print('   Term:', my_offered_course.term)
    print('   Class Time:', my_offered_course.class_time)
