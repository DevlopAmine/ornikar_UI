@homepage
Feature: Test de la homePage


  Background: Eliminer cookies et chatbot
    Given Je me débarasse des cookies et chatbot

  Scenario: Test divers
    Given Je suis sur la page assurance-auto
    When Je verifie la presence des 3 bonnes raisons
    When Je verifie la presence des garanties indispensables

