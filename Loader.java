package hm10;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
    private Exchanger<Integer> exchanger;
    FirstBox firstBox;
    public boolean isLoaderActive= true ;
    private int itemsToTransporter = 6;

    public Loader(Exchanger<Integer> exchanger,FirstBox firstBox) {
        this.exchanger = exchanger;
        this.firstBox = firstBox;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (isLoaderActive) {
            try {
                exchanger.exchange(itemsToTransporter);
                System.out.println("Loader start working");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            firstBox.setItemsInFirstBox(firstBox.getItemsInFirstBox() -itemsToTransporter);
            System.out.println("Loaded items to Transporter Items in First Box: "+ firstBox.getItemsInFirstBox());
        }
    }
}
