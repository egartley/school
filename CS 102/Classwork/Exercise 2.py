import turtle
from random import randint

def draw_flower(t, num_petals, color, x, y):
    t.penup()
    t.setx(x)
    t.sety(y)
    t.pendown()
    t.speed(0)
    t.pencolor(color)
    t.fillcolor(color)
    t.shape("circle")
    angle = 360 / num_petals
    for i in range(num_petals):
        t.right(angle)
        t.forward(20)
        t.begin_fill()
        t.circle(8)
        t.end_fill()
        t.penup()
        t.setx(x)
        t.sety(y)
        t.pendown()

part = int(input("Part: "))
t = turtle.Turtle()

# Part 1
if part == 1:
    petals = int(input("Number of petals: "))
    color = input("Enter a color: ")
    x = int(input("X coordinate: "))
    y = int(input("Y coordinate: "))
    
    draw_flower(t, petals, color, x, y)
# Part 2   
elif part == 2:
    petals = int(input("Number of petals: "))
    color = input("Enter a color: ")
    x = int(input("Starting X coordinate: "))
    y = int(input("Starting Y coordinate: "))
    num_flowers = int(input("How many flowers? "))

    for i in range(num_flowers):
        draw_flower(t, petals, color, x + (i * 38), y - (i * 38))
# Part 3        
elif part == 3:
    petals = int(input("Number of petals: "))
    color = input("Enter a color: ")
    num_flowers = int(input("How many flowers? "))

    for i in range(num_flowers):
        draw_flower(t, petals, color, randint(-300, 300), randint(-300, 300))
# Part 4
elif part == 4:
    colors = ["red", "blue", "green", "yellow", "orange", "purple"]
    petals = int(input("Number of petals: "))
    
    for color in colors:
        draw_flower(t, petals, color, randint(-300, 300), randint(-300, 300))
# Part 5
elif part == 5:
    t.screen.colormode(255)
    for i in range(randint(3, 10)):
        draw_flower(t, randint(3, 8), (randint(0, 255), randint(0, 255), randint(0, 255)), randint(-300, 300), randint(-300, 300))
