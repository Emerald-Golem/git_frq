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

    }
}