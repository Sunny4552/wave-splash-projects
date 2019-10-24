import time
import random

boss = ["Alien", "Predator", "Hydra"]


def print_pause(string):
    print(string)
    time.sleep(1)


def valid_input(prompt, option1, option2):
    while True:
        print_pause(prompt)
        response = input()
        if option1 == response:
            break
        elif option2 == response:
            break
        else:
            print_pause("Invalid Input")
    return response


def controlCenter(items, g_boss):
    print_pause("You head towards the Control Center")
    print_pause("There the wild " + g_boss +
                " had jumped out and is about to attack you!")
    choice = valid_input("Would you like to (1) fight or (2) run away?", '1',
                         '2')
    if choice == '1':
        if "blaster" in items:
            print_pause("You get into a heated chase and get higher ground.")
            print_pause("With your blaster you kill the alien!")
            restart = valid_input("Would you like to play again? (y/n)", 'y',
                                  'n')
            if restart == "y":
                game()
        else:
            print_pause("You try to fend off the " + g_boss +
                        " with your blaster, but you stand no chance and the "
                        + g_boss + " defeats you")
            print_pause("GAME OVER")
            restart = valid_input("Would you like to play again? (y/n)", 'y',
                                  'n')
            if restart == "y":
                game()
    elif choice == '2':
        print_pause("You escape back to your pod, and luckily the " + g_boss +
                    " lost you")
        field(items, g_boss)


def cargoBay(items, g_boss):
    print_pause("The cargo bay seems to be free of hostiles")
    if "blaster" in items:
        print_pause("You have already searched the cargo bay"
                    "with the super blaster equiped")
    else:
        print_pause("In the weapons bay you find the super blaster S4000")
        items.append("blaster")
    print_pause("You return back to your pod.")
    field(items, g_boss)


def field(items, g_boss):
    path = 0
    while True:
        path = valid_input(
            "\nEnter 1 to head into the main control center.\n"
            "Enter 2 to check the cargo bay.", '1', '2')

        if path == '1':
            controlCenter(items, g_boss)
            break
        elif path == '2':
            cargoBay(items, g_boss)
            break
        else:
            print("Invalid input")


def intro(g_boss):
    print_pause(
        "You find yourself in a dark spaceship woken up from hypersleep.")
    print_pause("You're indicators tell you there is vicious " + g_boss +
                " on the ship.")
    print_pause("Oustside the room are two passageways.")
    print_pause("To your left is a cargo bay.")
    print_pause("To your right is the main control center")
    print_pause("In the room you find a pocket blaster"
                "(but not effective) to defend yourself")


def game():
    items = []
    g_boss = random.choice(boss)
    intro(g_boss)
    field(items, g_boss)


game()
