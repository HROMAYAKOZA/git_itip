import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class secondTask {
    public static void main(String[] args) {
        String sourceFileName = "from.txt";
        String destinationFileName = "to.txt";
        try {
            FileInputStream fis = new FileInputStream(sourceFileName);
            FileOutputStream fos = new FileOutputStream(destinationFileName);
            byte[] buffer = new byte[1024]; // буфер для копирования данных
            int bytesRead = fis.read(buffer);
            while (bytesRead != -1) {
                fos.write(buffer, 0, bytesRead);
                bytesRead = fis.read(buffer);
            }
            fis.close();
            fos.close();
            System.out.println("Файл успешно скопирован.");
        }
        catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.err.println("Файл не найден или доступ к нему ограничен: " + e.getMessage());
        }
        catch (IOException e) {
            // e.printStackTrace()ы;
            System.err.println("Произошла ошибка при копировании файла: " + e.getMessage());
        }
    }
}
