public class OnlineStore {
    public static void main(String[] args) {
        HashTable<Integer, Product> hashTable = new HashTable<Integer, Product>();
        if (hashTable.isEmpty()) {
            System.out.println("Hash Table is empty.");
        }
        else{
            System.out.println("Hash Tavke is not empty.");
        }
        hashTable.put(1234567, new Product("Хороший Кола", "Сильногазированный напиток", 80, 10));
        hashTable.put(7654321, new Product("6days", "Круассаны", 115, 7));
        System.out.println(hashTable.get(1234567).display());
        if (hashTable.isEmpty()) {
            System.out.println("Hash Table is empty.");
        }
        else{
            System.out.println("Hash Table is not empty.");
        }
        System.out.println("size = " + hashTable.size());
        hashTable.remove(1234567);
        System.out.println(hashTable.get(1234567));
        System.out.println("size = " + hashTable.size());   
        System.out.println(hashTable.get(7654321).display());
        hashTable.get(7654321).setAmount(6);
        System.out.println(hashTable.get(7654321).display());
    }
}

class Product {
    private String name, description;
    private int price, amount;

    public Product() {
        this.price = 0;
        this.amount = 0;
    }

    public Product(String name, String description, int price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String display() {
        String s = this.name + " " + this.description + " " + this.price + " " + this.amount;
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}