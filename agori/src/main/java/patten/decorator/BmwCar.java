package patten.decorator;

public class BmwCar extends CarDecorator {

    public BmwCar(Car car) {
        super(car);
    }

    @Override
    public String drive() {
        System.out.println(" this bmw car is " + super.drive());
        return "bmw";
    }
}
