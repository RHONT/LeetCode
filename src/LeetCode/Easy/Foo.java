package LeetCode.Easy;

class Foo {


    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("first");
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("second");
        }
    };

    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            System.out.println("third");
        }
    };

    Thread thread1 = new Thread(r1);

    Thread thread2 = new Thread(r2);

    Thread thread3 = new Thread(r3);

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.third(foo.thread3);
        foo.first(foo.thread1);
        foo.second(foo.thread2);
        
    }

    public Foo() throws InterruptedException {

        this.thread1.setPriority(Thread.MAX_PRIORITY);
        this.thread2.setPriority(Thread.NORM_PRIORITY);
        this.thread3.setPriority(Thread.MIN_PRIORITY);


    }

//    public Runnable printFirst() {
//        return new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("first");
//            }
//        };
//    }
//
//    public Runnable printSecond() {
//        return new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("second");
//            }
//        };
//
//    }
//
//    public Runnable printThird() {
//        return new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("third");
//            }
//        };
//
//    }


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
