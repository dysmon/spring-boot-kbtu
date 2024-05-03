package com.example.ordermonolithapplication;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;


public class PostEndpointSimulation extends Simulation {
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .acceptHeader("application/json")
            .userAgentHeader("Gatling");

    private ScenarioBuilder scn = scenario("Post Endpoint Test")
            .exec(http("POST Request")
                    .post("/orders/")
                    .body(StringBody("test"))
                    .asJson()
                    .check(status().is(200)));

    public PostEndpointSimulation() {
        setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(10).during(10)
                ).protocols(httpProtocol)
        );
    }

}
