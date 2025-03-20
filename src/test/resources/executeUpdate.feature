Feature: executeUpdate Testleri

Background: Database ile baglanti olusturur.
  * Database baglantisi olusturulur.

  # "users" tablosunda sonran bir onceki harfi e olan
  # "username"lerin "mobile" numarasini update ediniz
  Scenario: Update test
  * (users) SQL Query'si hazirlanir ve calistirilir.
  * (users) sonuclar islenir
  * (users) database baglantisi sonlandirilir.