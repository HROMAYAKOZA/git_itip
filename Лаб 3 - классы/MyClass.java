public class MyClass {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Анна", 35, 35000, 10);
        Manager manager2 = new Manager("Ольга", 28, 38000, 8);
        Administrator admin = new Administrator("Иван", 30, 50000, 5);
        Programmer programmer = new Programmer("Петр", 25, 40000, "Java");
        Programmer programmer2 = new Programmer();
        SecurityProgrammer sProgrammer = new SecurityProgrammer("Алексей", 27, 45000, "Rust", 2);

        manager1.displayInfo();
        System.out.println("Бонус менеджера 1: " + manager1.calculateBonus()+"\n");

        manager2.displayInfo();
        System.out.println("Бонус менеджера 2: " + manager2.calculateBonus()+"\n");

        admin.displayInfo();
        System.out.println("Бонус администратора: " + admin.calculateBonus()+"\n");

        programmer.displayInfo(true);
        System.out.println("Бонус программиста: " + programmer.calculateBonus()+"\n");

        sProgrammer.displayInfo();
        System.out.println("Бонус программиста ИБ: " + sProgrammer.calculateBonus()+"\n");

        programmer2.displayInfo();
        System.out.println();

        System.out.println("Количество менеджеров: " + Manager.getNumberOfManagers());
    }
}

abstract class Employee { // абстрактный класс
    private String name;
    private int age;
    private double salary;

    public Employee() {
        this.name = "";
        this.age = 0;
        this.salary = 0.0;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculateBonus(); // абстрактный метод

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Зарплата: " + salary);
    }
}

class Manager extends Employee {
    private int numberOfClients;

    private static int numberOfManagers = 0; // количество менеджеров  

    public Manager() {
        super();
        this.numberOfClients = 0;
        numberOfManagers++; //увеличиваем при создании
    }

    public Manager(String name, int age, double salary, int numberOfClients) {
        super(name, age, salary);
        this.numberOfClients = numberOfClients;
        numberOfManagers++;
    }

    public static int getNumberOfManagers() {
        return numberOfManagers;
    }

    public int getNumberOfClients() {
        return this.numberOfClients;
    }

    public void setNumberofClients(int clients) {
        this.numberOfClients = clients;
    }

    public double calculateBonus() {
        return getSalary() * 0.15 + numberOfClients * 10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество клиентов: " + numberOfClients);
    }
}

class Administrator extends Employee {
    private int experience;

    public Administrator() {
        super();
        this.experience = 0;
    }

    public Administrator(String name, int age, double salary, int experience) {
        super(name, age, salary);
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int exp) {
        this.experience = exp;
    }

    public double calculateBonus() {
        return getSalary() * 0.1 + experience * 500;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Опыт работы: " + experience + " лет");
    }
}

class Programmer extends Employee {
    private String programmingLanguage;

    public Programmer() {
        super();
        this.programmingLanguage = "";
    }

    public Programmer(String name, int age, double salary, String prLanguage) {
        super(name, age, salary);
        this.programmingLanguage = prLanguage;
    }

    public String getPrLanguage() {
        return this.programmingLanguage;
    }

    public void setPrLanguage(String language) {
        this.programmingLanguage = language;
    }

    // @Override
    public void displayInfo(boolean includeLanguage) {
        super.displayInfo();
        if (includeLanguage) {
            System.out.println("Язык программирования: " + programmingLanguage);
        }
    }

    public double calculateBonus() {
        return getSalary() * 0.2;
    }
}

class SecurityProgrammer extends Programmer {
    private int securityLevel;

    public SecurityProgrammer() {
        super();
        this.securityLevel = 0;
    }

    public SecurityProgrammer(String name, int age, double salary, String prLanguage, int sLevel) {
        super(name, age, salary, prLanguage);
        this.securityLevel = sLevel;
    }

    @Override
    public void displayInfo(boolean includeLanguage) {
        super.displayInfo();
        if (includeLanguage) {
            System.out.println("Язык программирования: " + getPrLanguage());
        }
        System.out.println("Уровень доступа: " + securityLevel);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Уровень доступа: " + securityLevel);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.3;
    }
}