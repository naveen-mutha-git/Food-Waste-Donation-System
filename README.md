# 🍱 Food Waste Donation System

A modern full-stack web application that connects food donors, NGOs, and volunteers to reduce food wastage and help people in need.

The system allows donors to donate surplus food, NGOs to manage donation requests, volunteers to coordinate deliveries, and administrators to monitor the overall platform through a secure dashboard.

---

## 🚀 Features

- Secure Login & Registration
- Role-Based Authentication (Admin / NGO / Donor)
- Food Donation Management
- NGO Dashboard
- Donor Dashboard
- Admin Dashboard
- Accept & Reject Donation Requests
- Food Request Tracking
- User Management
- Feedback System
- Responsive User Interface
- Form Validation
- Session-Based Authentication
- Database Integration using MySQL
- MVC Architecture with Spring Boot

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend
- HTML5
- CSS3
- Bootstrap 5
- Thymeleaf
- JavaScript

### Database
- MySQL

### Development Tools
- Spring Tool Suite (STS)
- VS Code
- Git
- GitHub

---

## 🔐 Authentication

- Secure Login
- User Registration
- Session Management
- Role-Based Access Control
- Protected Routes

---

## 👥 User Roles

### 👨‍💼 Admin
- Manage users
- Monitor donations
- View dashboard statistics
- Manage NGOs

### 🏢 NGO
- View available food donations
- Accept or reject donation requests
- Update donation status

### 🍱 Donor
- Register and Login
- Donate surplus food
- Track donation status
- View donation history

---

## 📱 Responsive Design

The application is fully responsive and optimized for:

- Desktop
- Laptop
- Tablet
- Mobile Devices

Bootstrap 5 ensures a clean and responsive user experience across all screen sizes.

---

## 📂 Project Structure

```text
FoodWasteDonation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   ├── dto/
│   │   │   └── config/
│   │   │
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## ⚙️ Installation

### Clone the Repository

```bash
git clone https://github.com/naveen-mutha-git/Food-Waste-Donation-System.git
```

### Navigate to Project

```bash
cd Food-Waste-Donation-System
```

### Configure MySQL

Update the database credentials inside:

```
src/main/resources/application.properties
```

### Run the Application

```bash
mvn spring-boot:run
```

Open your browser:

```
http://localhost:8080
```

---

## 🎯 Future Enhancements

- Email Notifications
- Live Donation Tracking
- Google Maps Integration
- QR Code Verification
- Mobile Application
- Payment Gateway for Donations
- AI-Based Food Recommendation

---

## 🤝 Contributing

Contributions, feature requests, and improvements are welcome.

Feel free to fork this repository and submit a Pull Request.

---

## 📄 License

This project is developed for educational and learning purposes.

---

## 👨‍💻 Developer

**Mutha Naveen**

- Java Full Stack Developer
- Spring Boot Developer
- GitHub: https://github.com/naveen-mutha-git

---

⭐ If you found this project helpful, consider giving it a Star on GitHub.
