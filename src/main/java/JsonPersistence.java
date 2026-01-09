import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JsonPersistence {


    static Map<String, String> productData = new HashMap<>();
    static Gson gson = new Gson();
    static Reader reader;

    public static void main(String[] args) throws IOException {
        leituraJson();
        escritaArquivoJson();
    }

    public static void leituraJson() throws FileNotFoundException {
        reader = new FileReader("src/main/resources/test-product.json");
        productData = gson.fromJson(reader, Map.class);

        System.out.println(productData.get("url"));
        System.out.println(productData.get("produto"));
        System.out.println(productData.get("valor"));

    }

    public static void escritaArquivoJson() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/copia_test-product.json");
        productData.put("email", "product@gmail.com");
        productData.put("senha", "102030");
        gson.toJson(productData, writer);
        writer.flush();
        writer.close();
    }
}
