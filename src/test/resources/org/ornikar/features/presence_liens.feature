@presence_liens
Feature: Verification presence des liens


  Background: Eliminer cookies et chatbot
    Given Je me débarasse des cookies et chatbot

  Scenario: Presence liens "code de la route", "Permis de conduire", "Assurance auto"  et BTN Connexion

    Given L element "lien_code_route" est present
    Then L element "lien_code_route" est clickable
    Given L element "lien_assurance_auto" est present
    Then L element "lien_assurance_auto" est clickable
    Given L element "btn_connexion" est present
    Then L element "btn_connexion" est clickable