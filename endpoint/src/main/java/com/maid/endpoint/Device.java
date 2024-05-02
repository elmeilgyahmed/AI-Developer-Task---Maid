package com.maid.endpoint;

// This class represents a device with its specifications
public class Device {

    // Unique identifier for the device
    private String id;

    // Device specifications
    private int battery_power;   // Battery power of the device
    private int blue;            // Blue color availability (1 for true, 0 for false)
    private double clock_speed;  // Clock speed of the device
    private int dual_sim;        // Dual SIM support (1 for true, 0 for false)
    private int fc;              // Front camera quality
    private int four_g;          // 4G availability (1 for true, 0 for false)
    private int int_memory;      // Internal memory capacity
    private double m_dep;        // Mobile depth
    private int mobile_wt;       // Mobile weight
    private int n_cores;         // Number of processor cores
    private int pc;              // Primary camera quality
    private int px_height;       // Pixel height of the device
    private int px_width;        // Pixel width of the device
    private int ram;             // RAM capacity of the device
    private int sc_h;            // Screen height of the device
    private int sc_w;            // Screen width of the device
    private int talk_time;       // Talk time of the device
    private int three_g;         // 3G availability (1 for true, 0 for false)
    private int touch_screen;    // Touch screen availability (1 for true, 0 for false)
    private int wifi;            // WiFi availability (1 for true, 0 for false)

    // Predicted price range for the device
    private String price_range;

    // Getters and setters for the device properties

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBattery_power() {
        return battery_power;
    }

    public void setBattery_power(int battery_power) {
        this.battery_power = battery_power;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public double getClock_speed() {
        return clock_speed;
    }

    public void setClock_speed(double clock_speed) {
        this.clock_speed = clock_speed;
    }

    public int getDual_sim() {
        return dual_sim;
    }

    public void setDual_sim(int dual_sim) {
        this.dual_sim = dual_sim;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFour_g() {
        return four_g;
    }

    public void setFour_g(int four_g) {
        this.four_g = four_g;
    }

    public int getInt_memory() {
        return int_memory;
    }

    public void setInt_memory(int int_memory) {
        this.int_memory = int_memory;
    }

    public double getM_dep() {
        return m_dep;
    }

    public void setM_dep(double m_dep) {
        this.m_dep = m_dep;
    }

    public int getMobile_wt() {
        return mobile_wt;
    }

    public void setMobile_wt(int mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public int getN_cores() {
        return n_cores;
    }

    public void setN_cores(int n_cores) {
        this.n_cores = n_cores;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPx_height() {
        return px_height;
    }

    public void setPx_height(int px_height) {
        this.px_height = px_height;
    }

    public int getPx_width() {
        return px_width;
    }

    public void setPx_width(int px_width) {
        this.px_width = px_width;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSc_h() {
        return sc_h;
    }

    public void setSc_h(int sc_h) {
        this.sc_h = sc_h;
    }

    public int getSc_w() {
        return sc_w;
    }

    public void setSc_w(int sc_w) {
        this.sc_w = sc_w;
    }

    public int getTalk_time() {
        return talk_time;
    }

    public void setTalk_time(int talk_time) {
        this.talk_time = talk_time;
    }

    public int getThree_g() {
        return three_g;
    }

    public void setThree_g(int three_g) {
        this.three_g = three_g;
    }

    public int getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(int touch_screen) {
        this.touch_screen = touch_screen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }
}
