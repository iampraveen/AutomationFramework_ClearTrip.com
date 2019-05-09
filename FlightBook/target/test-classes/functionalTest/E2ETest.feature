#Author: Praveen Jaiswal

Feature: End to end Ticket booking
  Scenario Outline: Test end to end ticket booking functionality which comprises flight search, apply filter, selection and payment gateway
    Given I am on clearTrip homepage
    When I enter "<source>" and "<destination>"
    And I select "Round trip" journey type
    And I enter "<depart>" and "<return>" date interval from today
    And I add number of "<adult>" and "<child>" passenger
    And I click on search flights
    Then I see flight list
    When I choose non-stop flight
    And I apply price and departure time filter
    And I click on Book button
    Then I land on checkout page
    When I check accept terms
    And I click on book button
    And I enter mail ID
    And I click on continue button
    Then I enter passenger detail
    When I click on continue payment
    And I choose payment gateway
    Then I enter UPI ID
    And I make payment

    Examples: 
      | source  				| destination | depart  		|return						|adult	|child|
			|	New Delhi				|	Bangalore		|14						|		15						|		1		|		1	|