public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        dataManager.loadData(".\\in.txt");
        dataManager.registerDataProcessor(new DataFilter("Электроника"));
        dataManager.registerDataProcessor(new DataTransformer(1.1));
        dataManager.registerDataProcessor(new DataAggregator());

        dataManager.processData();
        dataManager.saveData(".\\out.txt");
    }
}
