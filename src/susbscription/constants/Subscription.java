package susbscription.constants;


import java.time.LocalDate;
import java.time.Period;

public class Subscription {
    private Period duration;
    private LocalDate startDate;
    private Period subcriptionPeriod;
    private String creditCardNumber;
    private String phoneNumber;
    private String eMail;
    //добавить поле "квитанция об оплате"


    public Subscription(String creditCardNumber, String phoneNumber, SubscriptionDuration duration) {
        this.startDate = LocalDate.now();// установка текущей даты как начало подписки
        this.subcriptionPeriod = Period.ofMonths(duration.getMonths());// установка периода подписки
        this.creditCardNumber = creditCardNumber;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }


    public LocalDate getEndDate() { //получение даты окончания подписки
        return startDate.plus(subcriptionPeriod);}
    public boolean isCreditCardValid() {
        return creditCardNumber != null && creditCardNumber.matches("\\d{16}");} //проверка на 16 цифр

    public boolean isPhoneNumberValid() {
        return phoneNumber != null && phoneNumber.matches("\\+\\d{10,15}");} //проверка на международный формат номера

    @Override
    public String toString() {
        return "Subscription: " +
        "\nStart date: " + startDate +
                "\nEnd date: " + getEndDate() +
                "\nPhone number: " + phoneNumber +
                "\nCredit card: " + (isCreditCardValid() ? "is valid" : "not valid" );
    }

    public static void main(String[] args) {
        // выбираем на 6 мес.
        Subscription subscription = new Subscription("5536 5555 4444 8951", "+7 *** *** ** **", SubscriptionDuration.SIX_MONTHS_6);
        System.out.println(subscription);

        if(subscription.isCreditCardValid() && subscription.isPhoneNumberValid()) {
            System.out.println("Subscription success !");
        } else {
            System.out.println("Error: check the card number or phone number are correct" );
        }
    }
    //отправить квитанцию об оплате на почту
}
