package patten.decorator;

public class AudiCar extends CarDecorator {

    public AudiCar(Car car) {
        super(car);
    }

    @Override
    public String drive() {
        System.out.println("this audi car " + super.drive());
        return "audi";
    }
}
