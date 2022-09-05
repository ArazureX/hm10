package hm12;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new FirstCat("Забияка"),new SecondCat("Изольда"),new ThirdCat("Бегемот"),
                new FourthCat("Гудини"),new FifthCat("Базилио"),new SixthCat("Несквик")};
        FreshCatFarchFactory factory = new FreshCatFarchFactory();
        factory.Factory(cats);
    }

}
