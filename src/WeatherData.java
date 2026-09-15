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
        WeatherData rain = new WeatherData();
        rain.addTemperature(99.1);
        rain.addTemperature(142);
        rain.addTemperature(85);
        rain.addTemperature(85.1);
        rain.addTemperature(84.6);
        rain.addTemperature(94.3);
        rain.addTemperature(124.9);
        rain.addTemperature(98);
        rain.addTemperature(101);
        rain.addTemperature(102.5);
        rain.cleanData(85, 120);
        System.out.println(rain.temperatures);
        WeatherData weatherData = new WeatherData();
        weatherData.addTemperature(100.5);
        weatherData.addTemperature(98.5);
        weatherData.addTemperature(102);
        weatherData.addTemperature(103.9);
        weatherData.addTemperature(87.5);
        weatherData.addTemperature(105.2);
        weatherData.addTemperature(90.3);
        weatherData.addTemperature(94.8);
        weatherData.addTemperature(109.1);
        weatherData.addTemperature(102.1);
        weatherData.addTemperature(107.4);
        weatherData.addTemperature(93.2);
        System.out.println(weatherData.longestHeatWave(100.5));
        System.out.println(weatherData.longestHeatWave(95.2));

    }
}