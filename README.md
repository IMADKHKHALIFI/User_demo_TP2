# 🔐 User Demo TP2 - Spring Boot Application

## 📘 Project Overview

**User Demo TP2** est une application Web de démonstration CRUD développée avec **Spring Boot**, **Spring Data JPA**, **Hibernate**, **Lombok** et **MySQL**.  
Elle gère des utilisateurs et leurs rôles dans un système sécurisé de manière simple et évolutive.

Cette application vise à mettre en pratique :
- La modélisation des entités JPA
- La gestion des relations ManyToMany
- L’implémentation de services REST
- La configuration d’une base de données MySQL
- La protection des mots de passe dans les réponses JSON

---

## 🧰 Technologies Utilisées

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Lombok**
- **MySQL**
- **Maven**
- **IntelliJ IDEA Ultimate**

---

## 🧱 Étapes de Développement

### 1. ⚙️ Configuration de l’Environnement
- IDE : IntelliJ IDEA Ultimate
- Maven pour la gestion des dépendances
- Serveur MySQL local (port 3306)

### 2. 📦 Création du Projet
Projet initialisé avec les dépendances :
- `Spring Web`
- `Spring Data JPA`
- `MySQL Driver`
- `Lombok`

### 3. 🧍 Développement de l’Entité User
Classe `User` avec :
- `userId` : identifiant principal
- `userName` : nom d’utilisateur (unique)
- `password` : mot de passe (protégé dans les réponses JSON)
- `roles` : liste des rôles associés (ManyToMany)

Annotations clés :
```java
@Entity
@Id
@Column(unique = true)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
```
###  4. 🔐 Développement de l’Entité Role
Classe Role avec :
    roleId
    roleName
    Liste des utilisateurs associés (@ManyToMany)

### 5. 📂 Repositories
Deux interfaces DAO :
    UserRepository
    RoleRepository

Étendent JpaRepository pour bénéficier de toutes les opérations CRUD.

### 6. 🧠 Services
Création des interfaces et implémentations de service :
    UserService / UserServiceImpl
    Gestion des interactions avec les repositories

### 7. 🌐 API REST
Contrôleur Web :
    UserController
    Expose des endpoints pour manipuler les utilisateurs (CRUD)

### 8. 🧾 Configuration de la Base de Données
Fichier application.properties :
```java
server.port=8083
spring.datasource.url=jdbc:mysql://localhost:3306/USER_DB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
```
### 📁 Structure du Projet
```markdown
src/main/java
└── net.imad.user_demo_tp2
    ├── entities
    │   ├── User.java
    │   └── Role.java
    ├── repositories
    │   ├── UserRepository.java
    │   └── RoleRepository.java
    ├── services
    │   ├── UserService.java
    │   └── UserServiceImpl.java
    ├── web
    │   └── UserController.java
    └── UserDemoTp2Application.java

```

## 🖼️ Sample Output

Here’s an example of a `GET` request result to `/users/{username}` (in this case `/users/IMAD`) rendered as JSON:

![User Role Output](3.png)


### ✅ Résumé
Ce projet met en œuvre un système de gestion d’utilisateurs avec des rôles associés, tout en utilisant de bonnes pratiques comme :
L’utilisation de Lombok pour réduire le code
La configuration fluide de la base de données
Le masquage des mots de passe dans les réponses JSON


### 👨‍💻 Auteur
Nom : Imad El Khelyfy
Email : imadelkhelyfy@gmail.com
Université : Faculté des Sciences, Meknès
Filière : Master SDIA
