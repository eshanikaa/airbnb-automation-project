**Airbnb Automation Project**
A simple, clean, beginner‑friendly Selenium + Cucumber BDD automation project designed to automate basic Airbnb search functionalities.
This project is intentionally kept minimal to avoid complications and to focus on clarity and working code.

🚀 Tech Stack Used
Java
Selenium WebDriver
Cucumber BDD
Maven
TestNG/JUnit
Allure Reports

🔍 What This Project Automates:
1️⃣ Open Airbnb homepage
2️⃣ Enter location
4️⃣ Validate that input fields accept the values


Sample Feature Run:
-Feature: Airbnb Search Feature
-  Scenario: User searches for a location
  -  Given User is on Airbnb homepage
 -   When User enters location "New York"
 -   And User clicks on search button
  -  Then Search results should be displayed
 
