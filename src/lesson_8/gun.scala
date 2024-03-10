package lesson_8

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class ShoppingSimulation extends Simulation {

  val httpConf = http.baseUrl("https://example.com")

  val scn = scenario("Shopping Scenario")
    .exec(http("Get Token")
      .post("/api/token")
      .formParam("username", "your_username")
      .formParam("password", "your_password")
      .check(jsonPath("$.token").saveAs("authToken"))
    )
    .pause(1.seconds)
    .exec(http("Search Product")
      .get("/api/products")
      .queryParam("query", "example_product")
      .headers(Map("Authorization" -> "Bearer ${authToken}"))
      .check(jsonPath("$.productId").saveAs("productId"))
    )
    .pause(2.seconds)
    .exec(http("Add to Cart")
      .post("/api/cart")
      .formParam("productId", "${productId}")
      .formParam("quantity", "1")
      .headers(Map("Authorization" -> "Bearer ${authToken}"))
    )
    .pause(1.seconds)
    .exec(http("Checkout")
      .post("/api/checkout")
      .formParam("cartId", "your_cart_id")
      .formParam("paymentMethod", "credit_card")
      .headers(Map("Authorization" -> "Bearer ${authToken}"))
      .check(status.is(200))
    )

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpConf)
}
