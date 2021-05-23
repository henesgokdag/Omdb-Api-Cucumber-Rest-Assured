Feature: SearchFeature

  Scenario: Başarıyla Film Değerlerinin Getirilmesi

    Given "Harry Potter" değeri ile istek oluşturulur
    When Search servisine istek gönderilir
    Then Title değerinin "Harry Potter and the Sorcerer's Stone" olduğu görülür

  Scenario: Olmayan Film değeriyle film getirilmesi

    Given "shjfjhdsfdj" değeri ile istek oluşturulur
    When Search servisine istek gönderilir
    Then Title değerinin "" olduğu görülür
