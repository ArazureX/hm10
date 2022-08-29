package hm10;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;


public class Transporter implements Runnable {
    private Exchanger<Integer> exchanger;
    private Exchanger<Integer> exchanger2;
    FirstBox firstBox;
    private int transportedItems = 0;
    private boolean isTransporterActive = true;

    public Transporter(Exchanger<Integer> exchanger, Exchanger<Integer> exchanger2) {
        this.exchanger = exchanger;
        this.exchanger2 = exchanger2;
        new Thread(this).start();
    }


    @Override
    public void run() {
        while (isTransporterActive) {
            try {
                transportedItems = exchanger.exchange(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Transporter start working");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                transportedItems = exchanger2.exchange(transportedItems);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Transporter Arrived to Unloader");
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Transporter Arrived to loader");
        }

    }
}
