Feature:

  # Database içindeki "deposits" toblosunda "amount" değeri
  # 100$ ile 500$ arasında olan user_id’leri doğrulayınız

  @deposits
  Scenario: Deposits tablosundan amount degerine gore user_id dogrulama

    * Database ile baglanti kurulur.
    * SQL Query'si hazirlanir.
    * Databaseden sonuclar dogrulanir.
    * Database baglantisi kapatilir.








