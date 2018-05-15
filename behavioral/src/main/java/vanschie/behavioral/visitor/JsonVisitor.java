package vanschie.behavioral.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonVisitor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String convert(TestClass testClass) throws JsonProcessingException {
        return objectMapper.writeValueAsString(testClass);

    }
}
