package patten.decorator;


/**
 * 在原来的 基础上,进行一个添加行为,可以认为是一种增加
 * 比如我们在喝奶茶的时候,他有个一个基础版本的奶茶,然后你可以添加各种材料
 * 比如珍珠,红豆什么的...
 */
public abstract class CarDecorator implements Car {

    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }


    @Override
    public String drive() {
        return car.drive();
    }
}
