package ch.zhaw.homework.le06.Autogarage;



public class ParkingGarage {


    private final Car[] parkplaetze;

    public ParkingGarage(int nrOfParkingLots)
    {
        parkplaetze = new Car[nrOfParkingLots];
    }

    public int getNrOfFreeParkingLots()
    {
        int freeLotCounter = 0;
        for (Car c : parkplaetze)
        {
            if (c==null) {
                freeLotCounter++;
            }
        }
        return freeLotCounter;
    }

    synchronized public boolean enter(Car car)
    {
        if (getNrOfFreeParkingLots()>0)
        {
            for (int i=0 ; i<parkplaetze.length ; i++)
            {
                if (parkplaetze[i]==null)
                {
                    parkplaetze[i] = car;
                    printInfoEnter(car);
                    return true;
                }
            }
        }
        else {
            System.out.println("The garage is full. Thus, car " + car.getCarName() + " had to leave again");

        }
        return false;
    }

    synchronized public void leave(Car car)
    {
        for (int i=0 ; i<parkplaetze.length ; i++)
        {
            if (parkplaetze[i]==car) {
                parkplaetze[i]=null;
                printInfoLeave(car);
                return;
            }
        }
        System.out.println("This car " + car.getCarName() + " is not in the parking lot");
    }

    private void printInfoEnter(Car car)
    {
        System.out.println("The car " + car.getCarName() + " has entered the garage.");
    }

    private void printInfoLeave(Car car)
    {
        System.out.println("The car " + car.getCarName() + " has left the garage.");
    }
}
