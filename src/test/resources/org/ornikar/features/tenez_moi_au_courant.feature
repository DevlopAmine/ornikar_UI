@Au_courant
Feature: Cas de test pour le formulaire Tenez moi au courant

  Background: Eliminer cookies et chatbot
    Given Je me débarasse des cookies et chatbot

  Scenario: Saisie formulaire Tenez moi au courant

    Given Je clique sur l element "btn_tenez_au_courant"
    And J attends 1 secondes
    And Je vais sur le frame "iframe_google"
    When Je remplis le champ "input_dateAssurance_jour" avec le texte "1"
    When Je remplis le champ "input_dateAssurance_mois" avec le texte "1"
    When Je remplis le champ "input_dateAssurance_annee" avec le texte "2024"
    And Je clique sur l element "btn_Ok_google"
    Given Je remplis le champ "input_prenom" avec le texte "toto"
    And Je clique sur l element "btn_Ok_google2"
    Given Je remplis le champ "input_nom" avec le texte "tati"
    And Je clique sur l element "btn_Ok_google2"
    Given Je remplis le champ "input_email" avec le texte "email@mail.com"
    And Je clique sur l element "btn_envoyer"
    Then Je quitte le frame
