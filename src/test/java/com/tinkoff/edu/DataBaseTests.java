package com.tinkoff.edu;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.*;

import java.sql.*;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class DataBaseTests {
  private static Connection connection;
  private static final String countryName = "IR";
  private int createdCountryId;
  private int uniqueCountryId;


  @BeforeAll
  public static void setUpAuth() {
    PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    authScheme.setUserName("admin");
    authScheme.setPassword("admin");
    RestAssured.authentication = authScheme;
  }

  @BeforeAll
  public static void setUpErrorLogging() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @BeforeAll
  public static void connect() throws SQLException {
    connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost/app-db",
        "app-db-admin",
        "P@ssw0rd"
    );
  }

  @BeforeEach
  public void createCountryBeforeTests() throws SQLException {
    int biggestId = -1;
    Statement sqlSelect = connection.createStatement();
    ResultSet resultSet = sqlSelect.executeQuery("SELECT * FROM country order by id DESC limit 1");
    if (resultSet.next()) {
      biggestId = resultSet.getInt(1);
    }
    createdCountryId = biggestId + 1;

    PreparedStatement sqlInsert = connection.prepareStatement(
        "INSERT INTO country(id, country_name) VALUES(?,?)"
    );
    sqlInsert.setInt(1, createdCountryId);
    sqlInsert.setString(2, countryName);
    sqlInsert.executeUpdate();
  }

  @AfterEach
  public void deleteCountryAfterTests() throws SQLException {
    PreparedStatement sqlDeleteCreatedCountry = connection.prepareStatement(
        "DELETE FROM country WHERE id =?"
    );
    sqlDeleteCreatedCountry.setInt(1, createdCountryId);
    sqlDeleteCreatedCountry.executeUpdate();

    PreparedStatement sqlDeleteUniqueCountry = connection.prepareStatement(
        "DELETE FROM country WHERE id =?"
    );
    sqlDeleteUniqueCountry.setInt(1, uniqueCountryId);
    sqlDeleteUniqueCountry.executeUpdate();
  }

  @AfterAll
  public static void disconnect() throws SQLException {
    connection.close();

  }

  @Test
  @DisplayName("Get country by id")
  public void getCountryById() {
    when()
        .get("/api/countries/" + createdCountryId)
        .then()
        .statusCode(200)
        .body("id", not(empty()),
            "countryName", is(countryName));
  }

}
