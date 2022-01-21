package data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateCredentials {

  public String emailAddressGenerator(){
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZqazwsxedcrfvtgbyhnujmiklop1234567890";
    StringBuilder email = new StringBuilder();
    Random rnd = new Random();
    while (email.length() < 15) { // length of the random string.
      int index = (int) (rnd.nextFloat() * chars.length());
      email.append(chars.charAt(index));
    }
    String emailAddress = email.toString() + "@gmail.com";
    return emailAddress;
  }

  public void enterCredentialsInTxtFile(String emailAddress) throws IOException {
    File file = new File("Emails.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);

    pw.println("Email address: " + emailAddress);
    pw.close();
  }

  public String pastDate(){
    LocalDate startDate = LocalDate.of(1990, 1, 1); //start date
    long start = startDate.toEpochDay();

    LocalDate endDate = LocalDate.now(); //end date
    long end = endDate.toEpochDay();

    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
    String date = LocalDate.ofEpochDay(randomEpochDay).toString();
    return date;
  }

  public String genderPicker() {
    Random rand = new Random();
    List<String> givenList = Arrays.asList("MALE", "FEMALE");
    int randomIndex = rand.nextInt(givenList.size());
    String randomElement = givenList.get(randomIndex);
    return randomElement;
  }
}

