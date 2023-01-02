package clone_default;

//Cloneable을 안받으면 에러가 발생할 수 있다.
public class PhoneNumber implements Cloneable {

    private final String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("010-2290-9244");

        PhoneNumber clone = phoneNumber.clone();

        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("clone = " + clone);
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new AssertionError();  // 일어날 수 없는 일이다.
        }
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
            "number='" + number + '\'' +
            '}';
    }
}
