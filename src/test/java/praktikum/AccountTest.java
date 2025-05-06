package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;


    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "color = {0}")
    public static Object[][] data(){
        return new Object[][]{
                {"Тимоти Шаламе", true},//верное имя
                {"ТимотиШаламе", false},//хотябы один пробел
                {" ТимотиШаламе", false},//Не должно быть пробела в начале или в конце
                {"Ти", false},//Неправильное количество символов
                {"Тимоти  Шаламе", false},//В строке не должно быть более двух пробелов
        };
    }

    @Test
    @DisplayName("Тест на проверку валидности имени")
    @Description("Тест: можно ли напечатать строку на карте. Например, «Тимоти Шаламе» — можно, а «ТимотейШевроле» — нет.")
    public void printNameTest(){
        var account = new Account(name);
        boolean actual = account.checkNameToEmboss(name);
        assertEquals(expected, actual);
    }
}
