
class Counter{
    int counter = 1;

    public synchronized void increment(){
        counter++;
        System.out.println(counter);
    }

    public int getCounter(){
        return counter;
    }
}


public class Main {
    static void main() throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(()-> {
            for(int i = 0;i<10;i++){
                counter.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i = 0;i<10;i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
//        t2.join();
//        Thread.sleep(1);
        System.out.println("Count:" + counter.getCounter());
    }
}
