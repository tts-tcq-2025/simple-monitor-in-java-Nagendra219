package vitals;

public class Main {
    
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
         return isTemperatureOk() && isSocOk() && isChargeRateOk();
    }
    
    private boolean isTemperatureOk() {
        return temperature >= 0 && temperature <= 45;
    }
    private boolean isSocOk() {
        return soc >= 20 && soc <= 80;
    }
    private boolean isChargeRateOk() {
        return chargeRate <= 0.8;
    }

    static void testBatteryStatus(float temperature, float soc, float chargeRate, boolean expected) {
        boolean result = batteryIsOk(temperature, soc, chargeRate);
        String status = (result == expected) ? "PASSED" : "FAILED";
        System.out.printf("Test T=%.1f, SOC=%.1f, CR=%.2f -> Expected=%s, Got=%s => %s\n",
                temperature, soc, chargeRate, expected, result, status);
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");

        // Valid Case
        testBatteryStatus(25, 70, 0.7f, true);
        // All out of range
        testBatteryStatus(50, 85, 0.9f, false);
        // Temperature too low
        testBatteryStatus(-1, 70, 0.7f, false);
        // Temperature too high
        testBatteryStatus(46, 70, 0.7f, false);
        // SOC too low
        testBatteryStatus(25, 10, 0.7f, false);
        // SOC too high
        testBatteryStatus(25, 90, 0.7f, false);
        // Charge rate too high
        testBatteryStatus(25, 70, 0.9f, false);
        // Edge values (boundary conditions)
        testBatteryStatus(0, 20, 0.8f, true);   // Lower bounds
        testBatteryStatus(45, 80, 0.8f, true);  // Upper bounds
        System.out.println("Testing complete.");
    }
}
