Feature: SearchByImdbFeature

  Scenario: başarıyla film değerlerinin getirilmesi

    Given "Harry Potter" değeri ile searchBy isteği oluşturulur
    When SearchByImdb servisine istek gönderilir
    Then Title alanının "Harry Potter and the Sorcerer's Stone" olduğu görülür
    Then Year alanının "2001" olduğu görülür
    Then Released alanının "16 Nov 2001" olduğu görülür

  Scenario: olmayan film değeriyle film getirilmesi

    Given "fsdfsd" değeri ile searchBy isteği oluşturulur
    When SearchByImdb servisine istek gönderilir
    Then ImdbTitle alanının "" olduğu görülür