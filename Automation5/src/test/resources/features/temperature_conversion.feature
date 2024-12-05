Feature: Temperature Conversion Service
  As a user
  I want to convert temperatures between Celsius and Fahrenheit
  So that I can understand the temperature in different units

  @TemperatureConversion
  Scenario Outline: Convert Celsius to Fahrenheit
    Given the Temperature Conversion service is available
    When the user sends a request to convert Celsius to Fahrenheit with "<celsius>"
    Then I should receive the temperature in Fahrenheit "<fahrenheit>"

    Examples:
      | celsius | fahrenheit |
      | 0       | 32         |
      | 100     | 212        |
      | -40     | -40        |
      | 37      | 98.6       |
