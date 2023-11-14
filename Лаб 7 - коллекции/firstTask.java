import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class firstTask {
    public static void main(String[] args) {
        String filePath = ".\\text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String t = scanner.next();
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        scanner.close();

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return map.get(s2) - map.get(s1);
            }
        });
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println(list.get(i));
        }
    }
}
