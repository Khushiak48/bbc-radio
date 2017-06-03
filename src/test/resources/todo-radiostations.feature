##############################################################################
#
#@Author - Khushboo Taneja khushiak48@gmail.com
#
##############################################################################
Feature: Radio Stations Nav Drawers
  AS A user
  I WANT to see more content associated with navigation links
  So THAT I can easily find what I am looking for

  Background: List of steps run before each of the scenarios
    Given I can see the radio nav

  @Staions @ScenarioAssignment @todo
  Scenario: Availability of all stations in station panel
    When I select Stations in the radio nav
    Then I can see the following stations in below order(First national stations after that nation stations)
      | radio1            |  1 |
      | 1xtra             |  2 |
      | radio2            |  3 |
      | radio3            |  4 |
      | radio4            |  5 |
      | radio4extra       |  6 |
      | 5live             |  7 |
      | 5livesportsextra  |  8 |
      | 6music            |  9 |
      | asiannetwork      | 10 |
      | worldserviceradio | 11 |
      | radioscotland     | 12 |
      | radionangaidheal  | 13 |
      | radioulster       | 14 |
      | radiofoyle        | 15 |
      | radiowales        | 16 |
      | radiocymru        | 17 |
    When I select the all stations button
    Then I am on the stations page
    And I close the browser

  @Staions @ScenarioAssignment @todo
  Scenario Outline: Selecting the networks from stations drawer
    When I select <stationName> in the radio nav
    Then I can see <currentURL>
    And I can see <logo>
      | stationName       | currentURL                                                 | logo                                  |
      | radio1            | http://www.bbc.co.uk/radio1                                | bbc_radio_one logo                    |
      | 1xtra             | http://www.bbc.co.uk/1xtra                                 | bbc_1xtra logo                        |
      | radio2            | http://www.bbc.co.uk/radio2                                | bbc_radio_two logo                    |
      | radio3            | http://www.bbc.co.uk/radio3                                | bbc_radio_three logo                  |
      | radio4            | http://www.bbc.co.uk/radio4                                | bbc_radio_fourfm logo                 |
      | radio4extra       | http://www.bbc.co.uk/radio4extra bbc_radio_four_extra logo | bbc_radio_four_extra logo             |
      | 5live             | http://www.bbc.co.uk/5live                                 | bbc_radio_five_live logo              |
      | 5livesportsextra  | http://www.bbc.co.uk/5livesportsextra                      | bbc_radio_five_live_sports_extra logo |
      | 6music            | http://www.bbc.co.uk/6music                                | bbc_6music logo                       |
      | asiannetwork      | http://www.bbc.co.uk/asiannetwork                          | bbc_asian_network logo                |
      | worldserviceradio | http://www.bbc.co.uk/worldserviceradio                     | bbc_world_service logo                |
      | radioscotland     | http://www.bbc.co.uk/radioscotland                         | bbc_radio_scotland_fm logo            |
      | radionangaidheal  | http://www.bbc.co.uk/radionangaidheal                      | bbc_radio_nan_gaidheal logo           |
      | radioulster       | http://www.bbc.co.uk/radioulster                           | bbc_radio_ulster log                  |
      | radiofoyle        | http://www.bbc.co.uk/radiofoyle                            | bbc_radio_foyle logo                  |
      | radiowales        | http://www.bbc.co.uk/radiowales                            | bbc_radio_wales_fm logo               |
      | radiocymru        | http://www.bbc.co.uk/radiocymru                            | bbc_radio_cymru logo                  |
    And I close the browser

  @Staions @ScenarioAssignment @todo @iplayerlogo
  Scenario: Selecting the iPlayer radio logo
    When I click on iplayer radio logo
    Then I can see Radio homepage
    And I close the browser
