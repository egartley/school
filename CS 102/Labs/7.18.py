def get_num_of_characters(input_str):
    return len(input_str)

def output_without_whitespace(s):
    print("String with no whitespace:", s.replace(" ", "").replace("\t", ""))

if __name__ == '__main__':
    sentence = input("Enter a sentence or phrase:\n")
    print("\nYou entered:", sentence)
    print("\nNumber of characters:", get_num_of_characters(sentence))
    output_without_whitespace(sentence)
