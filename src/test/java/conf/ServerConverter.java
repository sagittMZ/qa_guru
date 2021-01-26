package conf;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class ServerConverter implements Converter<Server> {

    @Override
    public Server convert(Method method, String input){
        final String[] splitted = input.split(":");
        return new Server(splitted[0], Integer.parseInt(splitted[1]));
    }
}
