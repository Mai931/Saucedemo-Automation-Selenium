# 🧪 SauceDemo Automation Testing Framework

## 📖 Overview  
This project is a UI Automation Testing Framework developed for the SauceDemo website.  
It validates core functionalities of an e-commerce system using a structured, maintainable, and scalable automation approach.

The framework is built using **Selenium WebDriver**, **TestNG**, and follows the **Page Factory Model** design pattern with integrated **Extent Reports** for advanced reporting.

---

## 🎯 Objectives  
- Automate critical user workflows  
- Ensure application stability and correctness  
- Apply best practices in test automation  
- Build a reusable and scalable automation framework  

---

## 🛠️ Tech Stack  
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Factory Model (`@FindBy`)  
- Extent Reports  
- Git & GitHub  

---

## 📂 Project Structure  
src/test/java
├── base → BasePage & BaseClass
├── factory → DriverFactory
├── pages → Page classes using Page Factory
├── tests → Test classes
├── extent reports → TestListeners & ExtentReportsManager
├── utils → Utilities 
├── wrappers → Reusable Methods

test output
├── ExtentReport_7KcKv.html


---

## ⚙️ Key Features  

- Page Factory Model using `@FindBy` annotations  
- Clean separation between test logic and page logic  
- Reusable utility and wrapper methods  
- Base classes for WebDriver setup and teardown  
- Integration with **Extent Reports** for detailed reporting  
- Screenshot capture on test failure  
- Step-by-step logging for better debugging  
- Browser Incognito Mode setup to avoid system popups  
- Scalable and maintainable framework design  

---

## 🧪 Test Scenarios Covered  

This project includes **53 automated test cases** covering almost all critical and major user scenarios of the SauceDemo application.

The test suite validates:
- Positive scenarios  
- Negative scenarios  
- Edge cases  
- End-to-end user flows  

### 🔐 Authentication (Login)
- Login with valid credentials  
- Login with invalid credentials  
- Validate error messages  
- Verify login with empty fields  

### 🛍️ Products Page  
- Verify products are displayed correctly  
- Add single and multiple products  
- Remove products from inventory  

### 🛒 Cart Functionality  
- Verify items appear in cart  
- Remove single item  
- Remove all items  
- Verify items are removed from DOM  

### 💰 Checkout Process  
- Fill checkout information (valid & invalid)  
- Validate required fields  
- Verify total price calculation  
- Complete checkout successfully  

### 🔄 End-to-End Flow  
- Full journey: Login → Add to Cart → Checkout → Order Completion  

---

✔ Total Automated Test Cases: **53**  
✔ Designed for high coverage and reliability
---

## 🧠 Special Implementations  

- Implemented **Page Factory Model** using `@FindBy` annotations  
- Used `PageFactory.initElements()` for element initialization  
- Wrapper methods for common actions (click, sendKeys, etc.)  
- Utility classes to reduce code duplication  
- Custom logic to calculate and validate total price  
- Integrated **Extent Reports** for professional test reporting  
- Added screenshots in reports for failed test cases  

---

## 📊 Reporting  

This project uses **Extent Reports** to generate interactive and detailed HTML reports.

### ✨ Report Features:
- Test execution summary (Pass / Fail / Skip)  
- Step-by-step logs for each test  
- Screenshot capture on failure  
- Timestamped execution logs  
- Clean and user-friendly UI  

📁 Report Location:
/test-output/ExtentReport_7KcKv

---

## 📸 Sample Report  

> <img width="1352" height="651" alt="report1" src="https://github.com/user-attachments/assets/9166dd50-bf26-4931-9b5b-04b58f96dab9" />


---

## ▶️ How to Run the Project  

1. Clone the repository  
2. Open the project in IntelliJ or Eclipse  
3. Run using TestNG XML file  

---

## 🚀 Future Enhancements  

- Integrate Allure Reports  
- Add Cucumber (BDD) support  
- Implement CI/CD using GitHub Actions  
- Cross-browser testing  

---

## 👩‍💻 Author  

**Mai Atef**  
Software Testing Engineer  

🔗 LinkedIn: http://www.linkedin.com/in/mai-atef-86b876209  

---
