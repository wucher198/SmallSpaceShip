package pl.myjava.smallspaceship.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by anonim on 28.01.17.
 */
public enum ApplicationArguments {
    H("-h", "Context help for application", ""),
    P("-p", "Defie file with parameters", "-p /home/user/game.props");

    private final static Map<String, ApplicationArguments> byParameter = new HashMap<>();

    static {
        Arrays.stream(ApplicationArguments.values()).forEach(value -> {
            byParameter.put(value.getParameter(), value);
        });
    }

    private String parameter;
    private String description;
    private String example;

    ApplicationArguments(String parameter, String description, String example) {
        this.parameter = parameter;
        this.description = description;
        this.example = example;
    }

    public String getParameter() {
        return parameter;
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }

    public static Optional<ApplicationArguments> byParemeter(String parameter) {
        return Optional.ofNullable(byParameter.get(parameter));
    }
}
