package com.weatherforecast;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/WeatherForecast". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/WeatherForecast
     * 2. curl "{your host}/api/WeatherForecast?name=HTTP%20Query"
     */
    @FunctionName("WeatherForecast")
    public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS)
        HttpRequestMessage<Optional<String>> request,
        final ExecutionContext context)
        {
            context.getLogger().info("Java HTTP trigger processed a request.");
            
            // Parse query parameter
            String location = request.getQueryParameters().get("location");

            if (location == null) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a location in the query string").build();
            } else {
                return request.createResponseBuilder(HttpStatus.OK).body("It's always sunny in " + location).build();
            }
    }
}
