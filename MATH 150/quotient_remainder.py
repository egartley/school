def get_q_r(m, n):
    q = m // n
    r = m - (n * q)
    return [q, r]

if __name__ == "__main__":
    m = int(input("m: "))
    n = int(input("n: "))
    print(get_q_r(m, n))
