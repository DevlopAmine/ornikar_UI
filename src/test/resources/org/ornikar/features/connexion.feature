@connexion
Feature: Tester la connexion


  Background: Eliminer cookies et chatbot
    Given Je me débarasse des cookies et chatbot

  Scenario: Cas de Test avec identifiants invalides

    Given Je clique sur l element "btn_connexion"
    And J attends 1 secondes
    And Je verifie la presence du modal Je me connecte à
    And Je saisis les identifiants amine@gm.com,123456 et je soumets
    Then Le champ "error_connexion" a le texte "Votre email ou votre mot de passe est incorrect."