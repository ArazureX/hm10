package hm10;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger =new Exchanger<>();
        Exchanger<Integer> exchanger2 =new Exchanger<>();
        FirstBox firstBox = new FirstBox(100);
        SecondBox secondBox = new SecondBox();
        new Loader(exchanger,firstBox);
        new Transporter(exchanger,exchanger2);
        new Unloader(exchanger2,secondBox);
    }

}
