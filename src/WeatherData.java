import java.util.ArrayList;
public class WeatherData {
    private ArrayList<Double> temperatures;

    public WeatherData() {
        temperatures = new ArrayList<>();
    }

    public void addTemperature(double temp) {
        temperatures.add(temp);
    }

    public void cleanData(double lower, double upper){
        for(int i = 0; i < temperatures.size(); i++){
            if(temperatures.get(i) < lower || temperatures.get(i) > upper){
                temperatures.remove(i);
                i--;
            }
        }
    }

    public int longestHeatWave (double threshold) {
        int longest = 0;
        for (int i = 0; i < temperatures.size(); i++) {
            int current = 0;
            while (i < temperatures.size() && temperatures.get(i) >= threshold) {
                current++;
                i++;
            }
            if (current > longest) {
                longest = current;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addTemperature(90);
        weatherData.addTemperature(80);
        weatherData.addTemperature(70);
        weatherData.addTemperature(60);
        weatherData.addTemperature(51);
        weatherData.cleanData(70, 80);
        System.out.println(weatherData.longestHeatWave(70));

    }
}