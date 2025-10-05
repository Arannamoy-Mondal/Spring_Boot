### POM (Project Object Model)


### Select JRE version:

```bash
sudo update-alternatives --config java
```

### Run command for linux:

```bash
mvn clean && mvn package && mvn spring-boot:run
```

### API's:
- 1. localhost:8000/hello

### Layers of Spring Boot

## 1️⃣ Presentation Layer (Controller Layer)

* **কি কাজ করে:**
  ইউজারের request handle করে এবং response return করে।
* **কোনো UI framework** বা REST API এখানে বসে।
* **Key Components:**

  * `@Controller` (web pages জন্য)
  * `@RestController` (REST API জন্য)
  * `@RequestMapping`, `@GetMapping`, `@PostMapping` ইত্যাদি

**Example:**

```java
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() { ... }
}
```

---

## 2️⃣ Service Layer (Business Logic Layer)

* **কি কাজ করে:**
  সমস্ত business logic handle করে। Controller শুধু service কে call করে।
* **Key Components:**

  * `@Service`
  * `@Transactional`

**Example:**

```java
@Service
public class UserService {
    public List<User> getAllUsers() { ... }
}
```

---

## 3️⃣ Data Access Layer (Repository Layer)

* **কি কাজ করে:** Database operations handle করে।
* **Key Components:**

  * `@Repository`
  * Spring Data JPA interfaces: `JpaRepository`, `CrudRepository`

**Example:**

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
```

---

## 4️⃣ Model Layer (Entity Layer)

* **কি কাজ করে:** Database table represent করে।
* **Key Components:**

  * `@Entity`
  * `@Table`, `@Id`, `@GeneratedValue`

**Example:**

```java
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
```

---

## 5️⃣ Configuration Layer

* **কি কাজ করে:** Spring Boot app setup ও configuration handle করে।
* **Key Components:**

  * `@Configuration`
  * `@Bean`
  * `application.properties` / `application.yml`

**Example:**

```java
@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

---

## 6️⃣ Optional Layers

### a) Security Layer

* `Spring Security` দিয়ে authentication & authorization handle করা হয়।
* `@EnableWebSecurity` + `WebSecurityConfigurerAdapter` ব্যবহার হয়।

### b) Exception / Advice Layer

* Global exception handling, response standardization।
* `@ControllerAdvice` + `@ExceptionHandler` ব্যবহার হয়।

---

### 🌐 Layer Diagram (Simple)

```
Client (Browser/Postman)
        |
        v
Presentation Layer (Controller)
        |
        v
Service Layer (Business Logic)
        |
        v
Repository Layer (Database Access)
        |
        v
Database (MySQL/PostgreSQL/H2)
```

---

💡 **Tip:**

* এই layered architecture Django এর **views → models → templates** এর মতো।
* Spring Boot-এ আরও modular এবং Java ecosystem friendly, plus REST API, Microservices সহজে integrate করা যায়।

