package hooks;

import io.cucumber.java.Before;

import static base_url.MedunnaBaseUrl.setup;

public class Hooks {

    

    @Before //Bu anotasyonu Cucumber'dan import etmeyi unutma. (Cünkü bu proje Cucumber projesi)
    public void beforeApi(){
        setup(); /*
        Bu method'u olusturdugumuz yerin basina @Before anotasyonunu yaziyorduk. Fakat @Before'u buraya yazdigimiz icin
        o method'u calistirmak icin buraya yazip import ettik. Extend yapma import yap böylelikle daha kalici cözüm olur.
        */
        //Testi calistrdigimizda spec objesinin null gelmemesi icin setup() methodunun calistirilmasi gerekir.
        //Cucumber' da her testten once calistirmak istedigimiz methodlari Hooks class' i icesine ekleriz

        //Hooks class'ini farkli bir package da olusturmak istersek Runner class'indaki glue parametresine bu
        //  package'i tanimlamamiz gerekir.
        //Runner'a hooks eklemeyi unutma. Olusturdugumuz Hooks classini glue kisminda tanimlamamiz gerekir
    }
}
