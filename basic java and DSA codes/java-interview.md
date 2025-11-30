
---

## 👤 Summary Introduction

**Tell me about yourself.**

I am a backend engineer with a little over **3 years of hands-on experience** in designing and developing scalable backend systems using Core Java, Spring Boot, Spring MVC, and Hibernate. I have worked extensively with RESTful microservices, database-driven applications, and integrations with third-party systems.  
I follow clean coding practices, SOLID principles, reusable design patterns, and focus on building secure, maintainable, and production-ready services.  
I am comfortable in agile environments and have collaborated with QA, DevOps, architecture teams, and product owners for sprint planning and deployments.  
I’ve also contributed to code reviews, automation testing, CI/CD pipelines, and debugging production issues, improving stability and developer efficiency.

---

## ☕ Core Java Interview Answers

### 🔹 What are the key OOP principles?

The four pillars of OOP are:

- **Encapsulation** – Binding data and behavior inside a class.
- **Inheritance** – Code reuse by inheriting properties from a parent class.
- **Polymorphism** – Ability to process objects differently based on type (compile-time & runtime).
- **Abstraction** – Hiding implementation details using abstract classes/interfaces.

### 🔹 What are SOLID principles?

- **S — Single Responsibility Principle**
	- A class should have one job only.
- **O — Open/Closed Principle**
	- Open for extension, closed for modification.
- **L — Liskov Substitution Principle**
	- Subclasses should replace parent classes without breaking functionality.
- **I — Interface Segregation**
	- Use smaller specific interfaces, not large generic ones.
- **D — Dependency Inversion**
	- Depend on abstractions, not concrete implementations.

### 🔹 Difference between HashMap and ConcurrentHashMap?

| Feature | HashMap | ConcurrentHashMap |
|--------|---------|--------------------|
| Thread-safe | ❌ | ✔️ |
| Synchronization | None | Segment-based locking |
| Null Keys | Allowed | Not allowed |
| Performance | Faster in single thread | Optimized for concurrent environment |

---

## 🌱 Spring Boot & Spring Framework

### 🔹 What is Dependency Injection?

Dependency Injection allows Spring to manage object creation and inject required dependencies automatically using:

- **Constructor Injection**
- **Setter Injection**
- **Field Injection (not recommended)**

### 🔹 Explain Spring Boot Auto-configuration?

Spring Boot automatically configures beans based on classpath dependencies.  
Example: If `spring-web-starter` is added, Spring automatically configures:

- DispatcherServlet
- Embedded Tomcat
- JSON converters

### 🔹 What are Spring Boot starters?

Predefined dependency bundles like:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-test`

They simplify dependency management.

---

## 🧵 Spring Data JPA & Hibernate

### 🔹 Difference between `save()` and `saveAndFlush()`?

| Method | Behavior |
|--------|----------|
| `save()` | Stores the entity but may delay SQL execution until transaction commit. |
| `saveAndFlush()` | Forces immediate SQL execution with flush. |

### 🔹 Explain JPA caching levels:

- **L1 Cache** – Session-level / mandatory
- **L2 Cache** – Optional / Hibernate-configurable (EhCache, Redis)

---

## 🌐 RESTful Microservices

### 🔹 Explain REST constraints:

- Stateless
- Client-server architecture
- Uniform resource identifiers (URI)
- Cacheable responses
- Layered architecture

### 🔹 How do you secure REST APIs?

- OAuth2 + JWT
- HTTPS
- Input validation
- Roles-based authorization (Spring Security)
- Rate limiting

---

## 🐳 DevOps & CI/CD

### 🔹 How does Docker help in deployment?

Docker packages applications with dependencies into lightweight containers ensuring:

- Portability
- Faster environment provisioning
- Consistency across environments

### 🔹 What is your exposure to GitHub Actions/Jenkins?

I’ve used GitHub Actions/Jenkins for:

- Automated build
- Unit test execution
- Static code analysis (Sonar)
- Artifact deployment to staging/production

---

## 📡 Messaging: Kafka & MQ

### 🔹 Kafka vs MQ

| Feature | Kafka | MQ (ActiveMQ/RabbitMQ) |
|--------|-------|-------------------------|
| Use case | Event streaming, high throughput | Transactional messaging |
| Ordering | Partition-based | Queue-based |
| Storage | Persistent log | Message queue store |

---

## 🧪 Testing (JUnit & Mockito)

### 🔹 What is mocking?

Mocking helps simulate external dependencies like DB or API calls so we test the logic in isolation.

Example:

```java
@Mock
UserRepository repo;

@InjectMocks
UserService service;
```
