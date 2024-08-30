print()
print()
print("Created by: Nathan Allyn S. Acosta")
print()
print("───★──────★──────★──────★──────★──────★──────★")
print()
print("          📌Personal Data Sheet XI                  ")
print()
print("───★──────★──────★──────★──────★──────★──────★")
print()
print()

intro = input("👋 Hello User! What is your Name? ▶ ")

if intro.isdigit():
    print("Sorry User, but names don't have numbers. Please provide a valid name and rerun the code.")
    
else:
    print()
    age = input(f"👋 Nice to meet you, {intro}! So, what is your age? (must be a number form, not a word) ▶ ")
    if not age.isdigit():
        print("Please input a number instead of a word, but let's proceed anyway.")
        
        
    print()
    address = input("Okay, so where do you live? ▶ ")
    if address.isdigit():
        print(f"{intro}, please use only words for your address. If you need to include a number, write it out as a word. Please rerun the program.")
    else:
        print()
        status = input("What is your status? (For example: Single, Married, Divorced) ▶ ")
        
        print()
        gender = input("What is your gender? ▶ ")
        if gender.isdigit():
            print(f"Genders have no numbers, {intro}, but let's proceed anyway.")
            
        print()
        birthdate = input("When is your birthdate? (MM/DD/YY or any format is fine) ▶ ")
        
        print()
        blood_type = input("What is your blood type? (Type X or N/A if you don't know) ▶ ")
        if blood_type.isdigit():
            print(f"{intro}, blood types don't contain numbers; this isn't a chemical test result input. Let's proceed anyway.")
        
        print()
        sight = input("Do you have any issues with your eyesight? (Yes/No) ▶ ")
        if sight.isdigit():
            print("Really? A number? Okay, let's proceed.")
          
        print()  
        work = input("What is your occupation? ▶ ")
        if work.isdigit():
            print("Occupations don't have numbers, but let's proceed anyway.")
        
        print()    
        medical_history = input("Any medical history? (For example: Diabetes, Myopia, etc. If none, type N/A or X) ▶ ")
        if medical_history.isdigit():
            print("Medical history usually doesn't contain numbers.")
            
        print()
        game = input("Which game type do you prefer the most? (For example: RPG, Battle Royale, Survival Game, etc) ▶ ")
        if game.isdigit():
            print(f"{intro}, game types don't have numbers; this isn't a math formula.")
        
        print()
        bones = input("During your childhood, did you have any bone fractures/broken bones? (If not, type 0) ▶ ")
        
        print()
        sports = input("What is your favorite hobby besides gaming? ▶ ")
        
        print()
        contact = input(f"{intro}, this is the last question. What is your contact number? ▶ ")
        if not contact.isdigit():
            print(f"{intro}, contact numbers should only contain numbers.")
            
        print()
        print("\n★──────★──────★ Personal Data Sheet Result ★──────★──────★")
        print()
        print("                      Personal Information                        ")
        print(f"👤  Your is Name: {intro}")
        print(f"👤  Age: {age}")
        print(f"🏠  Address: {address}")
        print(f"🧿  Status: {status}")
        print(f"🧿  Gender: {gender}")
        print(f"🥼  Occupation: {work}")
        print(f"🧬️  Birthdate: {birthdate}")
        print(f"📞  Contact Number: {contact}")
        print()
        print("★──────★──────★  Health Information  ★──────★──────★")
        print()
        print(f"🏥  Medical History: {medical_history}")
        print(f"🩸  Blood Type: {blood_type}")
        print(f"👁️‍🗨️  Sight Abnormalities: {sight}")
        print(f"🦴  Bone Fracture Count: {bones}")
        print()
        print("★──────★──────★  Hobbies Information  ★──────★──────★")
        print()
        print(f"🎮  Preferred Game Type: {game}")
        print(f"🎮  Hobby/Hobbies: {sports}")
        print()
        print("★──────★──────★ THANK YOU FOR YOUR COOPERATION ★──────★──────★")    