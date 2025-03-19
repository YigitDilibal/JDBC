Feature:

  # Database içindeki "deposits" toblosunda "amount" değeri
  # 100$ ile 500$ arasında olan user_id’leri doğrulayınız

  Background:
    * Database ile baglanti kurulur.

  @deposits
  Scenario: Deposits tablosundan amount degerine gore user_id dogrulama


    * SQL Query'si hazirlanir.
    * Databaseden sonuclar dogrulanir.
    * Database baglantisi kapatilir.


    # Database icindeki "cron_schedules" tablosunda ilk 2 kaydin
    # "name" bilgisini dogrulayiniz.

    Scenario: cron_schedules tablosundan name bilgisi dogrulama


      * Database ile baglanti kurulur.
      * cron_schedules SQL Query'si hazirlanir.
      * cron_schedules Databaseden sonuclar dogrulanir.
      * Database baglantisi kapatilir.





