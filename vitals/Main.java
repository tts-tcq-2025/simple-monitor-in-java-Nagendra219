package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
         return isTemperatureOk() && isSocOk() && isChargeRateOk();
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
