# 🏦 Bank Application

### Description
Backend application developed with Java, Spring Boot and JPA/Hibernate, which allows centralized management of customers, accounts and financial transactions.

### Content Table
- [Installation and usage](#-installation-and-usage)
- [System Architecture](#-system-architecture)
- [Technologies used for development](#-technologies-used-for-development)
- [Contributions](#-contributions)
- [About me](#-about-me)
- [License](#-license)

### ⚙ Installation and usage
```bash
# Previous requirements
Java 11+ | Spring Boot 2.4.2+ |Maven 3.8+

# Clone repository
git clone https://github.com/Felipezc97/java-spring-boot-bank-application.git

# Compilation stage
mvn -f account/pom.xml -Dtest=sampleTest.java
mvn -f client/pom.xml -Dtest=sampleTest.java

# Run application
mvn spring-boot:run
```

**Main Endpoints:**

| Method | Path                                              | Description                                                                                                              |
|--------|---------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `GET`  | `/api/clients`                                    | Get all clients information                                                                                              |
| `GET`  | `/api/clients/{id}`                               | Get information for specific client                                                                                      |
| `POST` | `/api/v1/users/{id}`                              | Create a new client                                                                                                      |
| `GET`  | `/api/clients`                                    | Get all accounts information                                                                                             |
| `GET`  | `/api/clients/{id}`                               | Get information for specific account                                                                                     |
| `POST` | `/api/v1/users/{id}`                              | Create a new aacount                                                                                                     |
| `POST` | `/api/transactions`                               | Create a new record in transactions table validating the amount of the desired transaction vs the balance of tha account |
| `GET`  | `/api/transactions/clients/{clientId}/report`     | Get a report like a statement with all accounts and transactions for a specific client|

For more information about the specification of the microservices you can visit `account-service-spec.json` and `client-service-spec.json`

When microservices are running, you can visit the following URL to see full documentation:
- (Account) http://localhost:8000/v2/api-docs
- (Client) http://localhost:8001/v2/api-docs

Another URL is enabled to display the information in a more visually friendly way.
- (Account) http://localhost:8000/swagger-ui.html
- (Client) http://localhost:8001/swagger-ui.html

### 🏗 System Architecture
(Pending to upload diagram)

### 🛠 Technologies used for development
<h4>Backend</h4>
<div style="display: flex; gap: 5px;">
    <img src="https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white" />
    <img src="https://img.shields.io/badge/Spring_Boot-2.4.2-6DB33F?logo=springboot&logoColor=white" />
</div>
<h4>Tools</h4>
<div style="display: flex; gap: 5px;">
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-2023.1-000000?logo=intellijidea" />
  <img src="https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white" />
</div>

### 🤝 Contributions
1. Fork your project (gh repo fork your-user/your-project)
2. Create your branch (git checkout -b feature/new-feature)
3. Commit your changes (git commit -m ‘feat: add system X’)
4. Push to branch (git push origin feature/new-feature)
5. Open a Pull Request to original repository

### 💻 About me
Software developer with solid experience in Java, Spring Boot and deploy with AWS and Azure Services, located in Atuntaqui, Imbabura, EC.

Did you like this project or find the information useful?  
**It would be great to keep in touch!** 👇

<div style="display: flex; gap: 5px;">
<a href="https://linkedin.com/in/felipezc97">
  <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
<a href="https://x.com/felipezc97">
  <img src="https://img.shields.io/badge/Twitter-1DA1F2?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
<a href="https://www.youtube.com/@felipezc97">
  <img src="https://img.shields.io/badge/Youtube-c4302b?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
</div>

### 📜 License
This project is not licensed. You may use, modify and distribute it freely without restriction.  
However, attribution to the original author is appreciated.
