import java.util.ArrayList;
public class WeatherData {
    private ArrayList<Double> temperatures;

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
            while (temperatures.get(i) >= threshold && i < temperatures.size()) {
                current++;
                i++;
            }
            if (current > longest) {
                longest = current;
            }
        }
        return longest;
    }
}