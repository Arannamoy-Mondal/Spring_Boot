- Table of contents
- [Project Object Model](#pom-project-object-model)
- [Select JRE version](#select-jre-version)
- [Maven Installation](#maven-installation-for-apt-package-manager)
- [Server run command for linux](#server-run-command-for-linux)
- [JDBC](#jdbc)
- [Hibernate](#hibernate)

### POM (Project Object Model)


### Select JRE version:

```bash
sudo apt install openjdk-17-jdk -y
sudo update-alternatives --config java
```

### Maven installation for apt package manager

```bash
sudo apt install maven
```

### Server run command for linux

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



### JDBC
### Hibernate
- Installation postgres using podman

```bash
podman run -it --name Postgress -e POSTGRES_PASSWORD=password -e POSTGRES_USER=user -p 5432:5432 postgres 
```
`Then Press CTRL+C`

```bash
podman start Postgres
podman exec -it Postgres bash
```

```bash
psql -U user
```

```sql
create database "Hibernate";
```

```sql
\l # db list
```

```sql
\c dbName # Switch between multiple db
```


`Hibernate hibernate.cfg.xml`

```xml
<hibernate-configuration>
    <session-factory>
        <!-- JDBC Connection Settings -->
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/HIBERNATE</property>
        <property name="hibernate.connection.username">user</property>
        <property name="hibernate.connection.password">password</property>
    </session-factory>
</hibernate-configuration>
```
