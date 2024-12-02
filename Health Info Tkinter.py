
import tkinter as tk
from tkinter import messagebox
import os



app = tk.Tk()
app.title("Patient Diagnosis System")
app.state("zoomed")
app.configure(bg="cyan")


def submit_patient():
    patient_name = patient_name_entry.get()
    diagnosis = diagnosisentry.get()
    condition = condition_var.get()


    if not patient_name or not diagnosis or condition == "Select":
        messagebox.showwarning("Warning", "Please fill in all fields.")
        return

    try:
        with open("patients.txt", "r") as file:
            patients = file.readlines()
            for line in patients:
                if f"Patient: {patient_name}" in line:
                    messagebox.showwarning("Warning", "Patient's name already exists.")
                    return
    except FileNotFoundError:
        open("patients.txt", "w").close()

    with open("patients.txt", "a") as file:
        file.write(f"Patient: {patient_name}, Diagnose: {diagnosis}, Condition: {condition}\n")

    messagebox.showinfo("Success", "Patient information submitted successfully!")
    patient_name_entry.delete(0, tk.END)
    diagnosisentry.delete(0, tk.END)
    condition_var.set("Select")


def aboutus():
    messagebox.showinfo("About Us", "We are striving to improve the global healthcare system, advancing with every passing second.")


def exit_application():
    app.quit()


def deletefiles():

    password_window = tk.Toplevel(app)
    password_window.title("Authorization Access 001")
    password_window.geometry("400x200")
    password_window.configure(bg="cyan")

    def verifypassword():
        password = password_entry.get()
        if password == "NatzuiHealthIS":
            try:
                if os.path.exists("patients.txt"):
                    os.remove("patients.txt")
                    messagebox.showinfo("Success", "All files deleted successfully.")
                else:
                    messagebox.showinfo("Info", "Error.")
            except Exception as e:
                messagebox.showerror("Error", f"Error: {e}")
            finally:
                password_window.destroy()
        else:
            messagebox.showwarning("Warning", "Incorrect password access.")
            password_entry.delete(0, tk.END)

    tk.Label(password_window, text="Enter password to delete all info ", bg="cyan", font=("Arial", 14)).pack(pady=20)
    password_entry = tk.Entry(password_window, font=("Arial", 14))  
    password_entry.pack(pady=10)

    submit_password_button = tk.Button(password_window, text="Submit", command=verifypassword, font=("Arial", 14), bg="lightblue")
    submit_password_button.pack(pady=10)



app.grid_rowconfigure(0, weight=1)  
app.grid_rowconfigure(2, weight=1)
app.grid_columnconfigure(0, weight=1) 
app.grid_columnconfigure(2, weight=1)


frame = tk.Frame(app, bg="cyan")
frame.grid(row=1, column=1)


tk.Label(frame, text="Patient's Name:", bg="cyan", font=("Arial", 16)).grid(row=0, column=0, padx=20, pady=20, sticky="e")
patient_name_entry = tk.Entry(frame, font=("Arial", 16))
patient_name_entry.grid(row=0, column=1, padx=20, pady=20)


tk.Label(frame, text="Diagnosed with:", bg="cyan", font=("Arial", 16)).grid(row=1, column=0, padx=20, pady=20, sticky="e")
diagnosisentry = tk.Entry(frame, font=("Arial", 16))
diagnosisentry.grid(row=1, column=1, padx=20, pady=20)


tk.Label(frame, text="Condition:", bg="cyan", font=("Arial", 16)).grid(row=2, column=0, padx=20, pady=20, sticky="e")
condition_var = tk.StringVar()
condition_var.set("Select") 
condition_dropdown = tk.OptionMenu(frame, condition_var, "Low", "Mid", "Critical")
condition_dropdown.config(font=("Arial", 16))
condition_dropdown.grid(row=2, column=1, padx=20, pady=20)


subbutton = tk.Button(frame, text="Submit", command=submit_patient, font=("Arial", 16), bg="lightblue")
subbutton.grid(row=3, column=0, columnspan=2, pady=40)


aboutbutton = tk.Button(app, text="About Us", command=aboutus, font=("Arial", 12), bg="lightblue")
aboutbutton.place(x=10, y=10)


exitbutton = tk.Button(app, text="Exit", command=exit_application, font=("Arial", 12), bg="lightblue")
exitbutton.place(x=110, y=10)


deletebutton = tk.Button(app, text="Delete All Files", command=deletefiles, font=("Arial", 12), bg="lightblue")
deletebutton.place(relx=1.0, x=-20, y=10, anchor="ne")  


app.mainloop()