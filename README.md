# 🚗 Car Showroom Management System

A Java-based console application that allows users to browse, filter, and explore car models from various brands available in India — along with their price ranges and images.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## 📌 About the Project

This is a **Mini Project** built using Core Java that simulates a car showroom experience in the terminal. Users can explore cars from 12 major brands, filter them by budget, and even view car images — all from the console.

---

## ✨ Features

- 🔍 Browse cars by **brand name** or view **all brands** at once
- 💰 Filter cars **within your budget**
- 🖼️ View **car images** using a Swing popup window
- 🎨 **Color-coded** console output for better readability
- 📊 Neatly formatted **table display** for all car models
- 🚘 Covers **12 major Indian car brands** with 80+ models

---

## 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java (Core) | Main programming language |
| Java Collections (HashMap) | Storing car and company data |
| Java Scanner | User input handling |
| javax.swing (JFrame, JLabel) | Car image display |
| ANSI Color Codes | Colored console output |

---

## 📁 Project Structure

```
CarShowroom/
│
├── Main.java             # Main class with entry point and all company data
├── VehicleCompany.java   # Class to manage car brands and models
└── images/               # Folder containing car images
    ├── alto_k10.jpg
    ├── spresso.jpg
    ├── baleno.jpg
    ├── Creta.jpg
    └── ...
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above installed
- Any IDE (VS Code, IntelliJ, Eclipse) or terminal

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/your-username/car-showroom-java.git

# 2. Navigate to the project folder
cd car-showroom-java

# 3. Compile the Java files
javac Main.java

# 4. Run the application
java Main
```

---

## 💻 Usage

```
Enter the car brand you want : Hyundai

Company: Hyundai
+----------------------+------------------+------------------+
| Model Name           | Base Variant     | Premium Variant  |
|----------------------+------------------+------------------|
| Creta                | 11.00 Lakh       | 20.00 Lakh       |
| Venue                | 7.50 Lakh        | 13.00 Lakh       |
| Verna                | 11.00 Lakh       | 17.50 Lakh       |
+----------------------+------------------+------------------+

Enter the amount you want car in that amount: 10
Enter the model name to view its image: Creta
```

> Type `all` as the brand name to view cars from all companies at once.

---

## 🚀 Future Improvements

- [ ] Connect to **MySQL Database** instead of hardcoded data
- [ ] Add **EMI Calculator** for monthly payment estimation
- [ ] **Sort cars** by price (low to high / high to low)
- [ ] Build a **JavaFX GUI** for better user experience
- [ ] Add **fuel type filter** (Petrol / Diesel / Electric)
- [ ] **Export results** to a PDF or text file

---

## 👨‍💻 Author

**Charan**
- GitHub: [@your-username](https://github.com/your-username)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ **If you found this project helpful, please give it a star!** ⭐
