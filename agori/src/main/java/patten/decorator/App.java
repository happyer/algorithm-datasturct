package patten.decorator;

public class App {


    public static void main(String[] args) {
        Car car = new BaseCar();
        CarDecorator carDecorator = new BmwCar(car);
        carDecorator.drive();

        //this is base car upgrade to audi then upgrade to super car
        CarDecorator carDecorator1 = new SupperCar(new AudiCar(car));
        carDecorator1.drive();

    }
}
