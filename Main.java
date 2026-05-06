import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class VehicleCompany {
    private String companyName;
    private Map<String, String[]> cars;
    private Map<String, String> carImages;

    // Constructor to initialize the company name and cars map
    public VehicleCompany(String companyName) {
        this.companyName = companyName;
        this.cars = new HashMap<>();
        this.carImages = new HashMap<>();
    }

    // Method to add a car model, its price ranges (base and premium variants), and image file path
    public void addCarModel(String modelName, String baseVariant, String premiumVariant, String imagePath) {
        cars.put(modelName, new String[]{baseVariant, premiumVariant});
        carImages.put(modelName, imagePath);
    }

    // Overloaded method to add a car model without an image file path
    public void addCarModel(String modelName, String baseVariant, String premiumVariant) {
        cars.put(modelName, new String[]{baseVariant, premiumVariant});
    }

    // Method to display all car models and their price ranges in a table format
    public void displayCars() {
        System.out.println("Company: " + companyName);
        System.out.println("+----------------------+------------------+------------------+");
        System.out.println("| Model Name           | Base Variant     | Premium Variant  |");
        System.out.println("|----------------------+------------------+------------------|");
        for (Map.Entry<String, String[]> entry : cars.entrySet()) {
            System.out.printf("| %-20s | %-16s | %-16s |%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
        System.out.println("+----------------------+------------------+------------------+");
    }

    // Method to display cars within a specified amount range
    public void displayCarsByAmount(double amount) {
        boolean hasCars = false;
        System.out.println("Company: " + companyName);
        System.out.println("+----------------------+------------------+------------------+");
        System.out.println("| Model Name           | Base Variant     | Premium Variant  |");
        System.out.println("|----------------------+------------------+------------------|");
        for (Map.Entry<String, String[]> entry : cars.entrySet()) {
            String basePrice = entry.getValue()[0].replace(" Lakh", "");
            try {
                double baseAmount = Double.parseDouble(basePrice);
                if (baseAmount >= amount) {
                    hasCars = true;
                    System.out.printf("| %-20s | %-16s | %-16s |%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
                }
            } catch (NumberFormatException e) {
                // Handle parsing errors, if any
            }
        }
        if (!hasCars) {
            System.out.println("| No cars found in this price range.                      |");
        }
        System.out.println("+----------------------+------------------+------------------+");
    }

    // Method to display a car image
    public void displayCarImage(String modelName) {
        if (carImages.containsKey(modelName)) {
            String imagePath = carImages.get(modelName);
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                JFrame frame = new JFrame("Car Image - " + modelName);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ImageIcon icon = new ImageIcon(imagePath);
                JLabel label = new JLabel(icon);
                frame.add(label);
                frame.pack();
                frame.setVisible(true);
            } else {
                System.out.println("Image file not found for " + modelName);
            }
        } else {
            System.out.println("No image available for " + modelName);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        String reset  = "\u001B[0m";  // Reset color
        String red    = "\u001B[31m"; // Red
        String green  = "\u001B[32m"; // Green
        String yellow = "\u001B[33m"; // Yellow
        String blue   = "\u001B[34m"; // Blue
        String purple = "\u001B[35m"; // Purple
        String cyan   = "\u001B[36m"; // Cyan

        Scanner scanner = new Scanner(System.in);
        Map<String, VehicleCompany> companies = new HashMap<>();

        // Adding companies and their cars with image paths
        VehicleCompany suzuki = new VehicleCompany("Suzuki");
        suzuki.addCarModel("Alto K10",     "4.09 Lakh", "6.05 Lakh", "images/alto_k10.jpg");
        suzuki.addCarModel("S-Presso",     "4.26 Lakh", "6.12 Lakh", "images/spresso.jpg");
        suzuki.addCarModel("Baleno",       "6.49 Lakh", "9.71 Lakh", "images/baleno.jpg");
        suzuki.addCarModel("Eeco",         "5.44 Lakh", "6.78 Lakh");
        suzuki.addCarModel("Celerio",      "5.64 Lakh", "7.37 Lakh");
        suzuki.addCarModel("Wagon R",      "5.64 Lakh", "7.47 Lakh");
        suzuki.addCarModel("Ignis",        "6.49 Lakh", "8.12 Lakh");
        suzuki.addCarModel("Swift",        "6.49 Lakh", "9.64 Lakh");
        suzuki.addCarModel("Dzire",        "6.84 Lakh", "10.19 Lakh");
        suzuki.addCarModel("FRONX",        "7.52 Lakh", "13.04 Lakh");
        suzuki.addCarModel("Brezza",       "8.54 Lakh", "14.00 Lakh");
        suzuki.addCarModel("Ertiga",       "8.84 Lakh", "13.13 Lakh");
        suzuki.addCarModel("XL6",          "11.71 Lakh", "14.71 Lakh");
        suzuki.addCarModel("Jimny",        "12.76 Lakh", "14.95 Lakh");
        suzuki.addCarModel("Grand Vitara", "13.70 Lakh", "24.19 Lakh");
        companies.put("Suzuki", suzuki);

        VehicleCompany hyundai = new VehicleCompany("Hyundai");
        hyundai.addCarModel("Santro",           "5.50 Lakh",  "7.50 Lakh");
        hyundai.addCarModel("Grand i10 Nios",   "5.92 Lakh",  "8.50 Lakh");
        hyundai.addCarModel("i20",              "7.00 Lakh",  "11.50 Lakh");
        hyundai.addCarModel("Aura",             "6.30 Lakh",  "9.50 Lakh");
        hyundai.addCarModel("Verna",            "11.00 Lakh", "17.50 Lakh");
        hyundai.addCarModel("Venue",            "7.50 Lakh",  "13.00 Lakh");
        hyundai.addCarModel("Creta",            "11.00 Lakh", "20.00 Lakh", "images/Creta.jpg");
        hyundai.addCarModel("Alcazar",          "16.00 Lakh", "21.00 Lakh");
        hyundai.addCarModel("Kona Electric",    "23.80 Lakh", "24.90 Lakh");
        hyundai.addCarModel("Exter",            "6.00 Lakh",  "10.00 Lakh");
        hyundai.addCarModel("i20 N Line",       "9.00 Lakh",  "12.00 Lakh");
        companies.put("Hyundai", hyundai);

        VehicleCompany kia = new VehicleCompany("Kia");
        kia.addCarModel("Seltos",   "10.90 Lakh", "20.30 Lakh");
        kia.addCarModel("Sonet",    "7.89 Lakh",  "14.89 Lakh");
        kia.addCarModel("Carens",   "10.52 Lakh", "19.67 Lakh");
        kia.addCarModel("EV6",      "60.95 Lakh", "65.95 Lakh");
        kia.addCarModel("Carnival", "30.99 Lakh", "35.49 Lakh");
        companies.put("Kia", kia);

        VehicleCompany tata = new VehicleCompany("Tata");
        tata.addCarModel("Tiago",       "5.60 Lakh",  "8.40 Lakh");
        tata.addCarModel("Altroz",      "6.60 Lakh",  "10.74 Lakh");
        tata.addCarModel("Punch",       "6.13 Lakh",  "10.20 Lakh");
        tata.addCarModel("Nexon",       "8.00 Lakh",  "14.74 Lakh");
        tata.addCarModel("Harrier",     "15.49 Lakh", "24.99 Lakh");
        tata.addCarModel("Safari",      "16.19 Lakh", "25.49 Lakh");
        tata.addCarModel("Nexon EV Max","16.49 Lakh", "19.94 Lakh");
        companies.put("Tata", tata);

        VehicleCompany mahindra = new VehicleCompany("Mahindra");
        mahindra.addCarModel("Thar",           "10.98 Lakh", "16.94 Lakh");
        mahindra.addCarModel("Scorpio-N",      "13.26 Lakh", "24.54 Lakh");
        mahindra.addCarModel("XUV700",         "13.99 Lakh", "26.99 Lakh");
        mahindra.addCarModel("Bolero",         "9.33 Lakh",  "10.26 Lakh");
        mahindra.addCarModel("XUV300",         "7.99 Lakh",  "14.07 Lakh");
        mahindra.addCarModel("Bolero Neo",     "9.60 Lakh",  "11.99 Lakh");
        mahindra.addCarModel("Scorpio Classic","13.59 Lakh", "17.35 Lakh");
        mahindra.addCarModel("XUV400 EV",      "15.99 Lakh", "18.99 Lakh");
        mahindra.addCarModel("Marazzo",        "14.39 Lakh", "16.80 Lakh");
        mahindra.addCarModel("Alturas G4",     "33.30 Lakh", "36.70 Lakh");
        companies.put("Mahindra", mahindra);

        VehicleCompany toyota = new VehicleCompany("Toyota");
        toyota.addCarModel("Innova Crysta",        "19.99 Lakh", "26.43 Lakh");
        toyota.addCarModel("Fortuner",             "33.43 Lakh", "51.44 Lakh");
        toyota.addCarModel("Glanza",               "6.81 Lakh",  "10.00 Lakh");
        toyota.addCarModel("Urban Cruiser Hyryder", "11.14 Lakh", "20.19 Lakh");
        toyota.addCarModel("Camry",                "46.17 Lakh", "46.17 Lakh");
        toyota.addCarModel("Vellfire",             "1.10 Crore", "1.10 Crore");
        toyota.addCarModel("Hilux",                "30.40 Lakh", "37.90 Lakh");
        toyota.addCarModel("Etios",                "7.21 Lakh",  "9.30 Lakh");
        companies.put("Toyota", toyota);

        VehicleCompany skoda = new VehicleCompany("Skoda");
        skoda.addCarModel("Slavia",  "11.53 Lakh", "19.13 Lakh");
        skoda.addCarModel("Kushaq",  "11.89 Lakh", "20.49 Lakh");
        skoda.addCarModel("Kodiaq",  "39.99 Lakh", "43.49 Lakh");
        skoda.addCarModel("Superb",  "54.69 Lakh", "57.69 Lakh");
        skoda.addCarModel("Octavia", "26.45 Lakh", "29.45 Lakh");
        companies.put("Skoda", skoda);

        VehicleCompany volkswagen = new VehicleCompany("Volkswagen");
        volkswagen.addCarModel("Polo",   "6.49 Lakh",  "10.25 Lakh");
        volkswagen.addCarModel("Vento",  "9.99 Lakh",  "14.99 Lakh");
        volkswagen.addCarModel("Taigun", "11.62 Lakh", "19.75 Lakh");
        volkswagen.addCarModel("Virtus", "11.56 Lakh", "19.41 Lakh");
        volkswagen.addCarModel("Tiguan", "35.17 Lakh", "37.17 Lakh");
        volkswagen.addCarModel("T-Roc",  "21.35 Lakh", "21.35 Lakh");
        companies.put("Volkswagen", volkswagen);

        VehicleCompany mg = new VehicleCompany("MG");
        mg.addCarModel("Astor",      "9.98 Lakh",  "17.98 Lakh");
        mg.addCarModel("Hector",     "14.73 Lakh", "21.78 Lakh");
        mg.addCarModel("Hector Plus","17.00 Lakh", "21.90 Lakh");
        mg.addCarModel("Gloster",    "38.80 Lakh", "43.87 Lakh");
        mg.addCarModel("ZS EV",      "18.98 Lakh", "25.08 Lakh");
        mg.addCarModel("Comet EV",   "7.98 Lakh",  "9.98 Lakh");
        companies.put("MG", mg);

        VehicleCompany honda = new VehicleCompany("Honda");
        honda.addCarModel("Amaze",              "7.16 Lakh",  "9.92 Lakh");
        honda.addCarModel("City",               "11.71 Lakh", "15.96 Lakh");
        honda.addCarModel("City Hybrid (e:HEV)","19.50 Lakh", "20.62 Lakh");
        honda.addCarModel("Elevate",            "11.58 Lakh", "16.20 Lakh");
        honda.addCarModel("WR-V",               "8.89 Lakh",  "12.05 Lakh");
        honda.addCarModel("Jazz",               "8.00 Lakh",  "9.50 Lakh");
        companies.put("Honda", honda);

        VehicleCompany nissan = new VehicleCompany("Nissan");
        nissan.addCarModel("Magnite",          "6.00 Lakh",  "11.00 Lakh");
        nissan.addCarModel("Kicks",            "9.50 Lakh",  "14.50 Lakh");
        nissan.addCarModel("GT-R (Imported)",  "2.12 Crore", "2.12 Crore");
        nissan.addCarModel("X-Trail (Expected)","40.00 Lakh", "49.00 Lakh");
        companies.put("Nissan", nissan);

        VehicleCompany ford = new VehicleCompany("Ford");
        ford.addCarModel("EcoSport",  "8.19 Lakh",  "11.87 Lakh");
        ford.addCarModel("Endeavour", "29.99 Lakh", "35.34 Lakh");
        ford.addCarModel("Figo",      "5.49 Lakh",  "8.09 Lakh");
        ford.addCarModel("Aspire",    "6.04 Lakh",  "8.14 Lakh");
        ford.addCarModel("Mustang",   "74.61 Lakh", "74.61 Lakh");
        companies.put("Ford", ford);

        System.out.print(blue + "Enter the car brand you want : " + reset);
        String brand = scanner.nextLine();

        if (brand.equalsIgnoreCase("all")) {
            for (VehicleCompany company : companies.values()) {
                company.displayCars();
                System.out.println();
            }
            System.out.print(blue + "Enter the amount you want car in that amount: " + reset);
            double amount = scanner.nextDouble();
            for (VehicleCompany company : companies.values()) {
                company.displayCarsByAmount(amount);
                System.out.println();
            }
        } else if (companies.containsKey(brand)) {
            companies.get(brand).displayCars();
            System.out.print(red + "Enter the amount you want car in that amount: " + reset);
            double amount = scanner.nextDouble();
            companies.get(brand).displayCarsByAmount(amount);
            System.out.print(green + "Enter the model name to view its image: " + reset);
            scanner.nextLine(); // Consume the newline character
            String modelName = scanner.nextLine();
            companies.get(brand).displayCarImage(modelName);
        } else {
            System.out.println(blue + "Sorry, we don't have information on this brand." + reset);
        }

        scanner.close();
    }
}