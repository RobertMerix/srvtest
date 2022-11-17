package org.example;

public class Position {

    private static String imei;
    private static String alarm;
    private static String localHours;
    private static String localMinutes;
    private static String ref_id;
    private static String utcHours;
    private static String utcMinutes;
    private static String deltaMinutes;
    private static String transaction_date;
    private static Boolean gps_signal;
    private static String latitude;
    private static String longitude;
    private static String speed;
    private static String course;
    private static String altitude;
    private static String fuel1;
    private static String fuel2;
    private static String temperature;


    public Position() {
    }


    public static String getImei() {
        return imei;
    }

    public static void setImei(String imei) {
        Position.imei = imei;
    }

    public static String getAlarm() {
        return alarm;
    }

    public static void setAlarm(String alarm) {
        Position.alarm = alarm;
    }

    public static String getLocalHours() {
        return localHours;
    }

    public static void setLocalHours(String localHours) {
        Position.localHours = localHours;
    }

    public static String getLocalMinutes() {
        return localMinutes;
    }

    public static void setLocalMinutes(String localMinutes) {
        Position.localMinutes = localMinutes;
    }

    public static String getRef_id() {
        return ref_id;
    }

    public static void setRef_id(String ref_id) {
        Position.ref_id = ref_id;
    }

    public static String getUtcHours() {
        return utcHours;
    }

    public static void setUtcHours(String utcHours) {
        Position.utcHours = utcHours;
    }

    public static String getUtcMinutes() {
        return utcMinutes;
    }

    public static void setUtcMinutes(String utcMinutes) {
        Position.utcMinutes = utcMinutes;
    }

    public static String getDeltaMinutes() {
        return deltaMinutes;
    }

    public static void setDeltaMinutes(String deltaMinutes) {
        Position.deltaMinutes = deltaMinutes;
    }

    public static String getTransaction_date() {
        return transaction_date;
    }

    public static void setTransaction_date(String transaction_date) {
        Position.transaction_date = transaction_date;
    }

    public static Boolean getGps_signal() {
        return gps_signal;
    }

    public static void setGps_signal(Boolean gps_signal) {
        Position.gps_signal = gps_signal;
    }

    public static String getLatitude() {
        return latitude;
    }

    public static void setLatitude(String latitude) {
        Position.latitude = latitude;
    }

    public static String getLongitude() {
        return longitude;
    }

    public static void setLongitude(String longitude) {
        Position.longitude = longitude;
    }

    public static String getSpeed() {
        return speed;
    }

    public static void setSpeed(String speed) {
        Position.speed = speed;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        Position.course = course;
    }

    public static String getAltitude() {
        return altitude;
    }

    public static void setAltitude(String altitude) {
        Position.altitude = altitude;
    }

    public static String getFuel1() {
        return fuel1;
    }

    public static void setFuel1(String fuel1) {
        Position.fuel1 = fuel1;
    }

    public static String getFuel2() {
        return fuel2;
    }

    public static void setFuel2(String fuel2) {
        Position.fuel2 = fuel2;
    }

    public static String getTemperature() {
        return temperature;
    }

    public static void setTemperature(String temperature) {
        Position.temperature = temperature;
    }
}

