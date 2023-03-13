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

    Given L element "lien_permis_conduire" est clickable
    When Je me positionne sur l element "lien_permis_conduire"
    Then L element "sous_lien_permisB" est visible
    When Je me positionne sur l element "lien_permis_conduire"
    Then L element "sous_lien_conduiteAccomp" est visible
    When Je me positionne sur l element "lien_permis_conduire"
    Then L element "sous_lien_conduiteALACarte" est visible
    When Je me positionne sur l element "lien_permis_conduire"
    Then L element "sous_lien_FinanceCPF" est visible

    #je verifie que je tombe sur la page PermisB
    Given Je me positionne sur l element "lien_permis_conduire"
    When Je clique sur l element "sous_lien_permisB"
    Then L element "txt_votre_permis" est visible
    And Je retourne en arrière

    #je verifie que je tombe sur la page conduite accompagnee
    Given Je me positionne sur l element "lien_permis_conduire"
    When Je clique sur l element "sous_lien_conduiteAccomp"
    Then L element "txt_conduite_accompagnee" est visible
    And Je retourne en arrière

    #je verifie que je tombe sur la page Conduite à la carte
    Given Je me positionne sur l element "lien_permis_conduire"
    When Je clique sur l element "sous_lien_conduiteALACarte"
    Then L element "btn_1ere_heure" est clickable
    And Je retourne en arrière

    #je verifie que je tombe sur la page Financement CPF
    Given Je me positionne sur l element "lien_permis_conduire"
    When Je clique sur l element "sous_lien_FinanceCPF"
    Then L element "btn_infos_CPF" est clickable
    And Je retourne en arrière