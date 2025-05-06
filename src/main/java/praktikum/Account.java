package praktikum;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss(String name) {
        if (name.length() < 3 || name.length() > 19) {
            System.out.println("Неправильное количество символов");
            return false;
        } else if (name.startsWith(" ") || name.endsWith(" ")){
            System.out.println("Не должно быть пробела в начале или в конце");
            return false;
        } else if (!name.contains(" ")){
            System.out.println("Строка должна содержать хотя бы один пробел");
            return false;
        } else if (name.lastIndexOf(" ") != name.indexOf(" ")) {
            System.out.println("В строке не должно быть более двух пробелов");
            return false;
        } else {
            System.out.println(name);
            return true;
        }
        /*&& !name.endsWith(" ") && !name.contains("  ") && name.lastIndexOf(" ") == name.indexOf(" ") && name.contains(" "))
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

    }
}
