class ShoppingCart:
    
    customer_name = "none"
    current_date = "January 1, 2016"
    cart_items = []
    
    def __init__(self, customer_name="none", current_date="January 1, 2016"):
        self.customer_name = customer_name
        self.current_date = current_date
    
    def add_item(self, item):
        self.cart_items.append(item)
    
    def remove_item(self, name):
        for i in range(len(self.cart_items)):
            if self.cart_items[i].item_name == name:
                self.cart_items.pop(i)
                break
        print("Item not found in cart. Nothing removed.")
    
    def modify_item(self, item):
        for cart_item in self.cart_items:
            if cart_item.item_name == item.item_name:
                cart_item.item_quantity += 1
                break
        print("Item not found in cart. Nothing modified.")
    
    def get_num_items_in_cart(self):
        total = 0
        for item in self.cart_items:
            total += item.item_quantity
        return total
    
    def get_cost_of_cart(self):
        cost = 0
        for item in self.cart_items:
            cost += item.item_price * item.item_quantity
        return cost
    
    def print_total(self):
        if len(self.cart_items) == 0:
            print("SHOPPING CART IS EMPTY")
        else:
            print("{}'s Shopping Cart - {}".format(self.customer_name, self.current_date))
            print("Number of Items:", self.get_num_items_in_cart())
            print()
            for item in self.cart_items:
                item.print_item_cost()
            print()
            print("Total: ${}".format(self.get_cost_of_cart()))
    
    def print_descriptions(self):
        if len(self.cart_items) > 0:
            print("{}'s Shopping Cart - {}".format(self.customer_name, self.current_date))
            print("Item Descriptions")
            for item in self.cart_items:
                item.print_item_description(item)

class ItemToPurchase:
    
    item_name = "none"
    item_price = 0
    item_quantity = 0
    item_description = "none"
    
    def __init__(self, item_name="none", item_price=0, item_quantity=0, item_description="none"):
        self.item_name = item_name
        self.item_price = item_price
        self.item_quantity = item_quantity
        self.item_description = item_description
    
    def print_item_cost(self):
        print("{} {} @ ${} = ${}".format(self.item_name, self.item_quantity, self.item_price, self.item_quantity * self.item_price))
    
    def print_item_description(self, item):
        print("{}: {}".format(item.item_name, item.item_description))

def print_menu(cart):
    user_choice = ""
    while user_choice != "q":
        print("\nMENU\na - Add item to cart\nr - Remove item from cart")
        print("c - Change item quantity\ni - Output items' descriptions")
        print("o - Output shopping cart\nq - Quit\n")
        
        if user_choice == "a":
            print("ADD ITEM TO CART")
            name = input("Enter the item name: ")
            desc = input("Enter the item description: ")
            price = int(input("Enter the item price: "))
            quantity = int(input("Enter the item quantity: "))
            cart.add_item(ItemToPurchase(name, price, quantity, desc))
        elif user_choice == "r":
            print("REMOVE ITEM FROM CART")
            cart.remove_item(input("Enter name of item to remove: "))
        elif user_choice == "c":
            print("CHANGE ITEM QUANTITY")
            name = input("Enter the item name: ")
            item = 0
            for cart_item in cart.cart_items:
                if name == cart_item.item_name:
                    item = cart_item
                    break
            if type(item) != type(0):
                for i in range(int(input("Enter the new quantity: ")) - item.item_quantity):
                    cart.modify_item(item)
        elif user_choice == "i":
            print("OUTPUT ITEMS' DESCRIPTIONS")
            cart.print_descriptions()
        elif user_choice == "o":
            print("OUTPUT SHOPPING CART")
            cart.print_total()
        
        while user_choice not in ["a", "r", "c", "i", "o", "q"]:
            user_choice = input("Choose an option:\n")
        
if __name__ == "__main__":
    customer = input("Enter customer's name:\n")
    date = input("Enter today's date:")
    print()
    print("\nCustomer name:", customer)
    print("Today's date:", date)
    
    print_menu(ShoppingCart(customer, date))
