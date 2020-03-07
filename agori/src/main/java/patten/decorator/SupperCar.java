package patten.decorator;

public class SupperCar extends CarDecorator {

    public SupperCar(Car car) {
        super(car);
    }

    @Override
    public String drive() {
        System.out.println("this is supper car " + super.drive());
        return "supper";
    }
}
