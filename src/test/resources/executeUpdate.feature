Feature: executeUpdate Testleri

Background: Database ile baglanti olusturur.
  * Database baglantisi olusturulur.

  # "users" tablosunda sonran bir onceki harfi e olan
  # "username"lerin "mobile" numarasini update ediniz
  @UsersTablosuUpdate
  Scenario: Update test
  * (users) SQL Query'si hazirlanir ve calistirilir.
  * (users) sonuclar islenir
  * (users) database baglantisi sonlandirilir.

    @deviceTokenInsert
    Scenario: device_tokens tablosuna veri ekleme testi.
      * insert sorgusu hazirlanir ve calistirilir.
      * sonuclari islenir.
      * (users) database baglantisi sonlandirilir.