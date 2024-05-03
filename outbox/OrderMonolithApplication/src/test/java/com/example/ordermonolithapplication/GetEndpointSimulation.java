package com.example.ordermonolithapplication;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class GetEndpointSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080") // Replace with your base URL
            .acceptHeader("application/json")
            .userAgentHeader("Gatling");

    ScenarioBuilder scn = scenario("Get Endpoint Test")
            .exec(http("GET Request")
                    .get("/orders") // Replace with your GET endpoint
                    .check(status().is(200)));

    public GetEndpointSimulation() {
        this.setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(10).during(10) // Ramp up from 1 to 10 users in 10 seconds
                ).protocols(httpProtocol)
        );
    }
}
