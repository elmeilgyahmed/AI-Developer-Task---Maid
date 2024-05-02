package com.maid.endpoint;

// JSON processing packages
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// Spring web annotations for controller and request mapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Spring RestTemplate for making HTTP requests
import org.springframework.web.client.RestTemplate;

// Spring annotations for dependency injection
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

// Spring JdbcTemplate for database operations
import org.springframework.jdbc.core.JdbcTemplate;

// Java IO package for handling input-output exceptions
import java.io.IOException;

// Java utility packages for collections
import java.util.List;
import java.util.Map;



@RestController
public class Controller {

    private final String apiUrl;
    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Controller(RestTemplate restTemplate, @Value("${python.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @RequestMapping("/api/hello")
    public String hello() {
        /**
         * Display a welcome message for the Device Classification System.
         *
         * @return A welcome message.
         */
        return "Welcome to Device Classification System, Please Provide Your Device specs";
    }

    @PostMapping("api/predict")
    public String predict(@RequestParam Long id) {
        /**
         * Predict the price of a device based on its specifications.
         *
         * @param id The ID of the device to predict its price.
         * @return A string indicating the success or failure of setting the price range for the device.
         */
        String url = apiUrl + "/predict/" + id;
        String result = restTemplate.postForObject(url, null, String.class);

        // Parse the JSON response to extract the price range
        try {
            JsonNode jsonNode = objectMapper.readTree(result);
            int price = jsonNode.get("price").get(0).asInt();
            // Set the price range in your entity or return it as needed
            // For example, if you have a Device entity
            Device device = new Device();
            device.setId(id.toString());
            device.setPrice_range(String.valueOf(price));

            // Save the device or return a success message
            // Example: deviceRepository.save(device);
            return "Price range of the device corresponding to the given id  " + id + " has been set successfully and predicted as :  " + price + " \nNote : the ranges are : \n0 (low cost) \n1 (medium cost) \n2 (high cost) \n3 (very high cost)";

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to set price range";
        }
    }

    @GetMapping("/api/devices")
    public List<Map<String, Object>> getDevices() {
        /**
         * Retrieve all devices from the database.
         *
         * @return A list of devices.
         */
        String query = "SELECT * FROM devices";
        return jdbcTemplate.queryForList(query);
    }

    @PostMapping("/api/devices")
    public String getRecord(@RequestParam String id) {
        /**
         * Retrieve a specific device record from the database.
         *
         * @param id The ID of the device to retrieve.
         * @return A JSON string representing the device record.
         */
        String query = "SELECT * FROM devices WHERE id = ?";
        Map<String, Object> device = jdbcTemplate.queryForMap(query, id);
        if (!device.isEmpty()) {
            // Construct JSON manually
            return "{"
                    + "\"id\":\"" + device.get("id") + "\","
                    + "\"battery_power\":" + device.get("battery_power") + ","
                    + "\"blue\":" + device.get("blue") + ","
                    + "\"clock_speed\":" + device.get("clock_speed") + ","
                    + "\"dual_sim\":" + device.get("dual_sim") + ","
                    + "\"fc\":" + device.get("fc") + ","
                    + "\"four_g\":" + device.get("four_g") + ","
                    + "\"int_memory\":" + device.get("int_memory") + ","
                    + "\"m_dep\":" + device.get("m_dep") + ","
                    + "\"mobile_wt\":" + device.get("mobile_wt") + ","
                    + "\"n_cores\":" + device.get("n_cores") + ","
                    + "\"pc\":" + device.get("pc") + ","
                    + "\"px_height\":" + device.get("px_height") + ","
                    + "\"px_width\":" + device.get("px_width") + ","
                    + "\"ram\":" + device.get("ram") + ","
                    + "\"sc_h\":" + device.get("sc_h") + ","
                    + "\"sc_w\":" + device.get("sc_w") + ","
                    + "\"talk_time\":" + device.get("talk_time") + ","
                    + "\"three_g\":" + device.get("three_g") + ","
                    + "\"touch_screen\":" + device.get("touch_screen") + ","
                    + "\"wifi\":" + device.get("wifi") + ","
                    + "}";
        } else {
            return "Record not found";
        }
    }

    @PostMapping("/api/device")
    public String addDevice(@RequestBody Device device) {
        /**
         * Add a new device record to the database.
         *
         * @param device The device object to add.
         * @return A string indicating the success or failure of adding the device.
         */
        String query = "INSERT INTO devices (id, battery_power, blue, clock_speed, dual_sim, fc, four_g, int_memory, m_dep, mobile_wt, n_cores, pc, px_height, px_width, ram, sc_h, sc_w, talk_time, three_g, touch_screen, wifi) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
                device.getId(),
                device.getBattery_power(),
                device.getBlue(),
                device.getClock_speed(),
                device.getDual_sim(),
                device.getFc(),
                device.getFour_g(),
                device.getInt_memory(),
                device.getM_dep(),
                device.getMobile_wt(),
                device.getN_cores(),
                device.getPc(),
                device.getPx_height(),
                device.getPx_width(),
                device.getRam(),
                device.getSc_h(),
                device.getSc_w(),
                device.getTalk_time(),
                device.getThree_g(),
                device.getTouch_screen(),
                device.getWifi(),
        };
        try {
            jdbcTemplate.update(query, params);
            return "Device added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add device";
        }
    }

}
