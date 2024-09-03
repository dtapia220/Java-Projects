package WeatherApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class weatherApp {
    public static void main(String[] args) {
        String apiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJ2IjoxLCJ1c2VyIjoic3R1ZGVudF90YXBpYSIsImlzcyI6ImxvZ2luLm1ldGVvbWF0aWNzLmNvbSIsImV4cCI6MTY5Mzc3NTI0OCwic3ViIjoiYWNjZXNzIn0.talOS07GwkVbYQrLnlR1ZNMLPgj4WXqAESc5An3_a2EBWP6cHqOLHtN49B3qWhd93BWMzyQTLsoCTT0Ly6WC9g";
        String city = "New York"; // Replace with the desired city name

        try {
            // Create a URL for the API request
            String apiUrl = "https://student_tapia:N0x4ck0cJL@api.meteomatics.com" + city + "&appid=" + apiKey;
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Display the raw weather data response
            System.out.println("Raw Weather Data for " + city + ":");
            System.out.println(response.toString());

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









