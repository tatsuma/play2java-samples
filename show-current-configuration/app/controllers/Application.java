package controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
    public static Result index() {

        Map<String, Object> map = play.Play.application().configuration().asMap();
        map.put("MaxMemory", Runtime.getRuntime().maxMemory());
        map.put("TotalMemory", Runtime.getRuntime().totalMemory());
        map.put("FreeMemory", Runtime.getRuntime().freeMemory());
        map.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = mapper.getJsonFactory().createJsonGenerator(writer);
        } catch (IOException e) {
            play.Logger.error("", e);
        }

        jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
        try {
            mapper.writeValue(jsonGenerator, map);
        } catch (JsonGenerationException e) {
            play.Logger.error("", e);
        } catch (JsonMappingException e) {
            play.Logger.error("", e);
        } catch (IOException e) {
            play.Logger.error("", e);
        }
        return ok(writer.toString());  
    }
}
