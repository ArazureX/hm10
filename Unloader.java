package hm10;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {
    private Exchanger<Integer> exchanger2;
    SecondBox secondBox;
    private boolean isUnloaderActive = true;
    private int deliveredItems = 0;
    public Unloader(Exchanger<Integer> exchanger, SecondBox secondBox) {
        this.exchanger2 = exchanger;
        this.secondBox= secondBox;
        new Thread(this).start();
    }
    @Override
    public void run() {
        while ((isUnloaderActive)&&(secondBox.getItemsInSecondBox()<=100)) {
            try {
                deliveredItems= exchanger2.exchange(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            secondBox.setItemsInSecondBox(secondBox.getItemsInSecondBox()+deliveredItems);
            System.out.println("Items Loaded to second Box, items in Second Box: " + secondBox.getItemsInSecondBox());

        }
    }
}
