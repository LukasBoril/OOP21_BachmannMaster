package ch.zhaw.homework.le06.Autogarage;

public class TestParkingGarage {

    public static void main(String[] args) {
        ParkingGarage p = new ParkingGarage(5);
        System.out.println(p.getNrOfFreeParkingLots());
        Car c1 = new Car("c1",p);
        Car c2 = new Car("c2",p);
        Car c3 = new Car("c3",p);
        Car c4 = new Car("c4",p);
        Car c5 = new Car("c5",p);
        Car c6 = new Car("c6",p);

        p.enter(c1);
        p.enter(c2);
        assert p.getNrOfFreeParkingLots()==3;
        p.leave(c1);
        p.leave(c2);

        p.enter(c1);
        p.enter(c2);
        p.enter(c3);
        p.enter(c4);
        p.enter(c5);
        p.enter(c6);
        System.out.println(p.getNrOfFreeParkingLots());
        assert (p.getNrOfFreeParkingLots()==0);
        p.leave(c1);
        p.leave(c2);
        System.out.println(p.getNrOfFreeParkingLots());
        assert (p.getNrOfFreeParkingLots()==2);

    }


}
